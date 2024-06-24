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
@RequestMapping("/api/usuarios")
public class ModificarUsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable("id") Long id) {
        try {
            // Buscar el usuario por ID
            Optional<UsuarioModel> usuario = usuarioService.findById(id);
            if (usuario.isPresent()) {
                // Retornar el usuario encontrado en una respuesta exitosa
                return ResponseEntity.ok().body(usuario.get());
            } else {
                // Retornar una respuesta con error si el usuario no existe
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Manejar errores y retornar una respuesta adecuada
            return ResponseEntity.status(500).body(new MensajeRespuesta("Ocurrió un error al buscar el usuario por ID."));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarUsuario(@PathVariable("id") Long id, @RequestBody UsuarioModel usuarioActualizado) {
        try {
            // Verificar si el usuario existe
            Optional<UsuarioModel> usuarioOptional = usuarioService.findById(id);
            if (usuarioOptional.isPresent()) {
                // Obtener el usuario existente
                UsuarioModel usuarioExistente = usuarioOptional.get();
                // Actualizar los campos del usuario existente con los datos recibidos
                usuarioExistente.setNombre(usuarioActualizado.getNombre());
                usuarioExistente.setTelefono(usuarioActualizado.getTelefono());
                usuarioExistente.setCorreoElectronico(usuarioActualizado.getCorreoElectronico());
                usuarioExistente.setDireccion(usuarioActualizado.getDireccion());
                usuarioExistente.setTipoDeAsistencia(usuarioActualizado.getTipoDeAsistencia());
                usuarioExistente.setClave(usuarioActualizado.getClave());
                // Guardar el usuario actualizado en la base de datos
                usuarioService.saveUsuario(usuarioExistente);
                // Retornar una respuesta exitosa con un mensaje
                return ResponseEntity.ok().body(new MensajeRespuesta("Usuario modificado exitosamente."));
            } else {
                // Retornar una respuesta con error si el usuario no existe
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Manejar errores y retornar una respuesta adecuada
            return ResponseEntity.status(500).body(new MensajeRespuesta("Ocurrió un error al modificar el usuario."));
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

