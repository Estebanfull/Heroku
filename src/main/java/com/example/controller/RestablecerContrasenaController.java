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

import com.example.model.TrabajadorModel;
import com.example.model.UsuarioModel;
import com.example.service.TrabajadorService;
import com.example.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RestablecerContrasenaController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TrabajadorService trabajadorService;

  @PostMapping("/api/usuarios/restablecer-contrasena")
public ResponseEntity<String> restablecerContrasena(@RequestBody Map<String, String> request) {
    String correoElectronico = request.get("correoElectronico");
    
    // Buscar el correo en la tabla de usuarios
    UsuarioModel usuarioEncontrado = usuarioService.getUsuarioByCorreo(correoElectronico);
    
    // Buscar el correo en la tabla de trabajadores si no se encontró en usuarios
    TrabajadorModel trabajadorEncontrado = trabajadorService.getTrabajadorByCorreo(correoElectronico);

    // Si el correo se encuentra en alguna de las tablas, devolver un mensaje de éxito
    if (usuarioEncontrado != null || trabajadorEncontrado != null) {
        // Aquí iría la lógica para enviar el correo de restablecimiento
        // Por simplicidad, solo devolvemos un mensaje de éxito
        return ResponseEntity.ok("Se ha enviado un correo para restablecer su contraseña.");
    } else {
        // Si el correo no se encuentra en ninguna de las tablas, devolver un mensaje de error
        return ResponseEntity.status(404).body("El correo electrónico no existe.");
    }
}
}