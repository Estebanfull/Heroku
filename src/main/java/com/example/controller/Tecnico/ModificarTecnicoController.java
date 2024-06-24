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
package com.example.controller.Tecnico;

/**
 *
 * @author Esteban_Rey
 */
// src/main/java/com/tuempresa/controller/ModificarTecnicoController.java



import com.example.model.TecnicoModel;
import com.example.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/tecnicos")
public class ModificarTecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarTecnicoPorId(@PathVariable Long id) {
        try {
            // Buscar el técnico por ID
            Optional<TecnicoModel> tecnico = tecnicoService.findById(id);
            if (tecnico.isPresent()) {
                // Retornar el técnico encontrado en una respuesta exitosa
                return ResponseEntity.ok().body(tecnico.get());
            } else {
                // Retornar una respuesta con error si el técnico no existe
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Manejar errores y retornar una respuesta adecuada
            return ResponseEntity.status(500).body(new MensajeRespuesta("Ocurrió un error al buscar el técnico por ID."));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarTecnico(@PathVariable Long id, @RequestBody TecnicoModel tecnicoActualizado) {
        try {
            // Verificar si el técnico existe
            Optional<TecnicoModel> tecnicoOptional = tecnicoService.findById(id);
            if (tecnicoOptional.isPresent()) {
                // Obtener el técnico existente
                TecnicoModel tecnicoExistente = tecnicoOptional.get();
                // Actualizar los campos del técnico existente con los datos recibidos
                tecnicoExistente.setEspecialidad(tecnicoActualizado.getEspecialidad());
                tecnicoExistente.setNombre(tecnicoActualizado.getNombre());
                tecnicoExistente.setTelefono(tecnicoActualizado.getTelefono());
                // Guardar el técnico actualizado en la base de datos
                tecnicoService.saveTecnico(tecnicoExistente);
                // Retornar una respuesta exitosa con un mensaje
                return ResponseEntity.ok().body(new MensajeRespuesta("Técnico modificado exitosamente."));
            } else {
                // Retornar una respuesta con error si el técnico no existe
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Manejar errores y retornar una respuesta adecuada
            return ResponseEntity.status(500).body(new MensajeRespuesta("Ocurrió un error al modificar el técnico."));
        }
    }

    // Clase interna para encapsular el mensaje de respuesta
    public static class MensajeRespuesta {
        private String message;

        public MensajeRespuesta(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
