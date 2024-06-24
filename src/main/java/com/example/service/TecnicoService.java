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


import com.example.model.TecnicoModel;
import com.example.repository.TecnicoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    // Método para obtener todos los técnicos
    public List<TecnicoModel> getAllTecnicos() {
        return tecnicoRepository.findAll();
    }

    // Método para obtener un técnico por su ID
    public Optional<TecnicoModel> getTecnicoById(Long id) {
        return tecnicoRepository.findById(id);
    }

    // Método para guardar un técnico
    public TecnicoModel saveTecnico(TecnicoModel tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    // Método para eliminar un técnico por su ID
    public void deleteTecnico(Long id) {
        tecnicoRepository.deleteById(id);
    }

    // Método para verificar si un técnico existe por su ID
    public boolean existsById(Long id) {
        return tecnicoRepository.existsById(id);
    }

    // Método para buscar un técnico por su ID
    public Optional<TecnicoModel> findById(Long id) {
        return tecnicoRepository.findById(id);
    }

    public TecnicoModel findByName(String nombreTecnico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
