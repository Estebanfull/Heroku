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
package com.example.service;

/**
 *
 * @author Esteban_Rey
 */


import com.example.model.UsuarioModel;
import com.example.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para obtener todos los usuarios
    public List<UsuarioModel> getAllUsuarios() {
        return (List<UsuarioModel>) usuarioRepository.findAll();
    }

    // Método para obtener un usuario por su ID
    public Optional<UsuarioModel> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    // Método para guardar un usuario
    public UsuarioModel saveUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    // Método para eliminar un usuario por su ID
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Método para obtener un usuario por su correo electrónico y clave
    public UsuarioModel getUsuarioByCorreoYClave(String correo, String clave) {
        if (correo == null || clave == null) {
            // Manejo del caso en el que correo o clave sean nulos
            return null;
        }
        // Utilizamos el método findByCorreoElectronicoAndClave del repositorio
        return usuarioRepository.findByCorreoElectronicoAndClave(correo, clave);
    }

    // Método para obtener un usuario por su correo electrónico
    public UsuarioModel getUsuarioByCorreo(String correo) {
        if (correo == null) {
            // Manejo del caso en el que el correo sea nulo
            return null;
        }
        // Utilizamos el método findByCorreoElectronico del repositorio
        return usuarioRepository.findByCorreoElectronico(correo);
    }

    // Método para verificar si un usuario existe por su ID
    public boolean existsById(Long id) {
        return usuarioRepository.existsById(id);
    }

    // Método para buscar un usuario por su ID
    public Optional<UsuarioModel> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    // Método para obtener un usuario por su clave
    public UsuarioModel getUsuarioByClave(String clave) {
        if (clave == null) {
            // Manejo del caso en el que la clave sea nula
            return null;
        }
        // Utilizamos el método findByClave del repositorio
        return usuarioRepository.findByClave(clave);
        
        
    }

 // Método para obtener un usuario por su clave
    public Optional<UsuarioModel> findByClave(String clave) {
        return Optional.ofNullable(usuarioRepository.findByClave(clave));
    }
    }

   

  


    