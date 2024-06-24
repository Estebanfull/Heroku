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


import com.example.model.UsuarioModel;
import com.example.service.UsuarioService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eliminarusuarios")
public class EliminarUsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Buscar usuario por ID
    @GetMapping
    public ResponseEntity<?> buscarUsuarioId(@RequestParam("idUsuario") Long idUsuario) {
        try {
            Optional<UsuarioModel> usuario = usuarioService.getUsuarioById(idUsuario);
            if (usuario.isPresent()) {
                return ResponseEntity.ok().body(usuario.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new MensajeRespuesta("Ocurrió un error al buscar el usuario por ID."));
        }
    }

    // Eliminar usuario por ID
    @DeleteMapping
    public ResponseEntity<String> eliminarUsuario(@RequestParam("idUsuario") Long idUsuario) {
        try {
            if (!usuarioService.existsById(idUsuario)) {
                return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
            }
            usuarioService.deleteUsuario(idUsuario);
            return new ResponseEntity<>("Usuario eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    static class MensajeRespuesta {
        private String mensaje;

        public MensajeRespuesta(String mensaje) {
            this.mensaje = mensaje;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }
    }
}
