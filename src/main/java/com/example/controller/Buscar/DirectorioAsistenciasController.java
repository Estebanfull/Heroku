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
package com.example.controller.Buscar;

/**
 *
 * @author Esteban_Rey
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.model.AsistenciaModel;
import com.example.service.DirectorioAsistenciaService;

import java.util.List;
import java.util.Optional;

@RestController
public class DirectorioAsistenciasController {

    @Autowired
    private DirectorioAsistenciaService directorioAsistenciaService;

    @GetMapping("/api/buscarAsistencia")
    public ResponseEntity<?> buscarAsistencia(@RequestParam("idAsistencia") Long idAsistencia) {
        try {
            Optional<AsistenciaModel> asistencia = directorioAsistenciaService.buscarPorId(idAsistencia);
            if (asistencia.isPresent()) {
                return ResponseEntity.ok().body(asistencia.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No se encontró ninguna asistencia con el ID: " + idAsistencia);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error al buscar la asistencia por ID.");
        }
    }

    @GetMapping("/api/buscarTodasAsistencias")
    public ResponseEntity<?> buscarTodasAsistencias() {
        try {
            List<AsistenciaModel> asistencias = directorioAsistenciaService.mostrarTodos();
            return ResponseEntity.ok(asistencias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error al buscar asistencias. Por favor, inténtalo de nuevo.");
        }
    }
}
