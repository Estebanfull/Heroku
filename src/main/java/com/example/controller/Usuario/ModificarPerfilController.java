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
package com.example.controller.Usuario;

/**
 *
 * @author Esteban_Rey
 */

import com.example.model.UsuarioModel;
import com.example.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/perfil")
public class ModificarPerfilController {

    @Autowired
    private UsuarioService perfilService;

    @GetMapping("/{clave}")
    public ResponseEntity<?> buscarPerfilPorClave(@PathVariable("clave") String clave) {
        try {
            // Buscar el perfil por clave
            Optional<UsuarioModel> perfil = perfilService.findByClave(clave);
            if (perfil.isPresent()) {
                // Retornar el perfil encontrado en una respuesta exitosa
                return ResponseEntity.ok().body(perfil.get());
            } else {
                // Retornar una respuesta con error si el perfil no existe
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Manejar errores y retornar una respuesta adecuada
            return ResponseEntity.status(500).body(new MensajeRespuesta("Ocurrió un error al buscar el perfil por clave."));
        }
    }

    @PutMapping("/{clave}")
    public ResponseEntity<?> modificarPerfil(@PathVariable("clave") String clave, @RequestBody UsuarioModel perfilActualizado) {
        try {
            // Verificar si el perfil existe
            Optional<UsuarioModel> perfilOptional = perfilService.findByClave(clave);
            if (perfilOptional.isPresent()) {
                // Obtener el perfil existente
                UsuarioModel perfilExistente = perfilOptional.get();
                // Actualizar los campos del perfil existente con los datos recibidos
                perfilExistente.setNombre(perfilActualizado.getNombre());
                perfilExistente.setTelefono(perfilActualizado.getTelefono());
                // Guardar el perfil actualizado en la base de datos
                perfilService.saveUsuario(perfilExistente);
                // Retornar una respuesta exitosa con un mensaje
                return ResponseEntity.ok().body(new MensajeRespuesta("Perfil modificado exitosamente."));
            } else {
                // Retornar una respuesta con error si el perfil no existe
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Manejar errores y retornar una respuesta adecuada
            return ResponseEntity.status(500).body(new MensajeRespuesta("Ocurrió un error al modificar el perfil."));
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
