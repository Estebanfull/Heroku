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
public class DirectorioUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    
    // Método para obtener un usuario por su ID
    public Optional<UsuarioModel> buscarPorId(Long id) {
        return usuarioRepository.findByIdUsuario(id);
    }

    public List<UsuarioModel> buscarPorCorreoElectronico(String correoElectronico) {
        return (List<UsuarioModel>) usuarioRepository.findByCorreoElectronico(correoElectronico);
    }

    public List<UsuarioModel> mostrarTodos() {
        return usuarioRepository.findAll();
    }
}
