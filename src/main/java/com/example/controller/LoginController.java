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
package com.example.controller;

import com.example.model.UsuarioModel;
import com.example.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody UsuarioModel usuario) {
        String correo = usuario.getCorreoElectronico();
        String clave = usuario.getClave();

        // Utilizamos el servicio para buscar el usuario por correo y clave
        UsuarioModel usuarioEncontrado = usuarioService.getUsuarioByCorreoYClave(correo, clave);
        if (usuarioEncontrado != null) {
            // Devolver el usuario encontrado con código 200 OK
            return ResponseEntity.ok(new LoginResponse("Credenciales válidas", usuarioEncontrado.getIdUsuario()));
        } else {
            // Devolver un mensaje de error con código 401 Unauthorized (no autorizado)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }

    // Clase interna para manejar la respuesta de login
    public static class LoginResponse {
        private String message;
        private Long idUsuario;

        public LoginResponse(String message, Long idUsuario) {
            this.message = message;
            this.idUsuario = idUsuario;
        }

        // Getters y setters
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Long getIdUsuario() {
            return idUsuario;
        }

        public void setIdUsuario(Long idUsuario) {
            this.idUsuario = idUsuario;
        }
    }
}
