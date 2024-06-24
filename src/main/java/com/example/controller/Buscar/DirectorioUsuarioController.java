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

import com.example.model.UsuarioModel;
import com.example.service.DirectorioUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DirectorioUsuarioController {

    @Autowired
    private DirectorioUsuarioService directorioActivoService;

    @GetMapping("/api/buscar")
    public ResponseEntity<?> buscar(@RequestParam("idUsuario") Long idUsuario) {
        try {
            Optional<UsuarioModel> usuario = directorioActivoService.buscarPorId(idUsuario);
            if (usuario.isPresent()) {
                return ResponseEntity.ok().body(usuario.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No se encontró ningún usuario con el ID: " + idUsuario);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error al buscar el usuario por ID.");
        }
    }

    @GetMapping("/api/buscarTodos")
    public ResponseEntity<?> buscarTodos() {
        try {
            List<UsuarioModel> usuarios = directorioActivoService.mostrarTodos();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error al buscar usuarios. Por favor, inténtalo de nuevo.");
        }
    }
}
