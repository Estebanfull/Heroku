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
import com.example.model.ProveedorModel;
import com.example.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorioProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Método para obtener un proveedor por su ID
    public Optional<ProveedorModel> buscarPorId(Long id) {
        return proveedorRepository.findByIdProveedor(id);
    }

    public List<ProveedorModel> mostrarTodos() {
        return proveedorRepository.findAll();
    }
}
