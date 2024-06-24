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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Endpoint para obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioModel>> getAllUsuarios() {
        List<UsuarioModel> usuarios = usuarioService.getAllUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    // Endpoint para obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> getUsuarioById(@PathVariable("id") Long id) {
        Optional<UsuarioModel> usuario = usuarioService.getUsuarioById(id);
        return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<UsuarioModel> createUsuario(@RequestBody UsuarioModel usuario) {
        UsuarioModel nuevoUsuario = usuarioService.saveUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    // Endpoint para eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable("id") Long id) {
        usuarioService.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
