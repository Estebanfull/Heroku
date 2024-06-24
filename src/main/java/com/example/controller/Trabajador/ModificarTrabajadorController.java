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
package com.example.controller.Trabajador;


import com.example.model.TrabajadorModel;
import com.example.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/trabajadores")
public class ModificarTrabajadorController {

    @Autowired
    private TrabajadorService trabajadorService;

    @GetMapping("/{id_trabajador}")
    public ResponseEntity<?> buscarTrabajadorPorId(@PathVariable("id_trabajador") Long id) {
        try {
            // Buscar el trabajador por ID
            Optional<TrabajadorModel> trabajador = trabajadorService.findById(id);
            if (trabajador.isPresent()) {
                // Retornar el trabajador encontrado en una respuesta exitosa
                return ResponseEntity.ok().body(trabajador.get());
            } else {
                // Retornar una respuesta con error si el trabajador no existe
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Manejar errores y retornar una respuesta adecuada
            return ResponseEntity.status(500).body(new MensajeRespuesta("Ocurrió un error al buscar el trabajador por ID."));
        }
    }

    @PutMapping("/{id_trabajador}")
    public ResponseEntity<?> modificarTrabajador(@PathVariable("id_trabajador") Long id, @RequestBody TrabajadorModel trabajadorActualizado) {
        try {
            // Verificar si el trabajador existe
            Optional<TrabajadorModel> trabajadorOptional = trabajadorService.findById(id);
            if (trabajadorOptional.isPresent()) {
                // Obtener el trabajador existente
                TrabajadorModel trabajadorExistente = trabajadorOptional.get();
                // Actualizar los campos del trabajador existente con los datos recibidos
                trabajadorExistente.setNombre(trabajadorActualizado.getNombre());
                trabajadorExistente.setTelefono(trabajadorActualizado.getTelefono());
                trabajadorExistente.setCorreoElectronico(trabajadorActualizado.getCorreoElectronico());
                trabajadorExistente.setClave(trabajadorActualizado.getClave());

                // Guardar el trabajador actualizado en la base de datos
                trabajadorService.saveTrabajador(trabajadorExistente);
                // Retornar una respuesta exitosa con un mensaje
                return ResponseEntity.ok().body(new MensajeRespuesta("Trabajador modificado exitosamente."));
            } else {
                // Retornar una respuesta con error si el trabajador no existe
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Manejar errores y retornar una respuesta adecuada
            return ResponseEntity.status(500).body(new MensajeRespuesta("Ocurrió un error al modificar el trabajador."));
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
