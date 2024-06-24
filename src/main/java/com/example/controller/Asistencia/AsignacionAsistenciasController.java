/*
 * Copyright 2024 Esteban_Rey.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.controller.Asistencia;

/**
 *
 * @author Esteban_Rey
 */


import com.example.model.AsistenciaModel;
import com.example.model.TecnicoModel;
import com.example.model.ProveedorModel;
import com.example.repository.AsistenciaRepository;
import com.example.repository.TecnicoRepository;
import com.example.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AsignacionAsistenciasController {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Endpoint para obtener todos los proveedores
    @GetMapping("/buscarTodosProveedoresAsistencia")
    public List<ProveedorModel> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    // Endpoint para obtener todos los técnicos
    @GetMapping("/buscarTodosTecnicosAsistencia")
    public List<TecnicoModel> getAllTecnicos() {
        return tecnicoRepository.findAll();
    }

    // Endpoint para asignar un proveedor y técnico a una asistencia
    @PostMapping("/asignarProveedorTecnicoAsistencia")
    public ResponseEntity<String> asignarProveedorTecnicoAsistencia(
            @RequestParam Long idAsistencia,
            @RequestParam String nombreProveedor,
            @RequestParam String nombreTecnico) {
        
                    System.out.println("idAsistencia recibido: " + idAsistencia);
                    System.out.println("nombreProveedor recibido: " + nombreProveedor);
                    System.out.println("nombreTecnico recibido: " + nombreTecnico);

        Optional<AsistenciaModel> asistenciaOpt = asistenciaRepository.findById(idAsistencia);
        Optional<ProveedorModel> proveedorOpt = proveedorRepository.findByNombre(nombreProveedor);
        Optional<TecnicoModel> tecnicoOpt = tecnicoRepository.findByNombre(nombreTecnico);

        if (asistenciaOpt.isPresent() && proveedorOpt.isPresent() && tecnicoOpt.isPresent()) {
            AsistenciaModel asistencia = asistenciaOpt.get();
            asistencia.setIdProveedor(proveedorOpt.get().getIdProveedor());
            asistencia.setIdTecnico(tecnicoOpt.get().getIdTecnico());
            asistenciaRepository.save(asistencia);

            return ResponseEntity.ok("Proveedor y técnico asignados correctamente.");
        } else {
            return ResponseEntity.badRequest().body("Error al asignar proveedor y técnico. Verifique los datos proporcionados.");
        }
    }
}
