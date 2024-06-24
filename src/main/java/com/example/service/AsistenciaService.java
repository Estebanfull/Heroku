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


import com.example.model.AsistenciaModel;
import com.example.repository.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    // Método para obtener todas las asistencias
    public List<AsistenciaModel> getAllAsistencias() {
        return asistenciaRepository.findAll();
    }

    // Método para obtener una asistencia por su ID
    public Optional<AsistenciaModel> getAsistenciaById(Long id) {
        return asistenciaRepository.findById(id);
    }

    // Método para guardar una asistencia
    public AsistenciaModel saveAsistencia(AsistenciaModel asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    // Método para eliminar una asistencia por su ID
    public void deleteAsistencia(Long id) {
        asistenciaRepository.deleteById(id);
    }

    // Método para verificar si una asistencia existe por su ID
    public boolean existsById(Long id) {
        return asistenciaRepository.existsById(id);
    }

    // Método para buscar una asistencia por su ID
    public Optional<AsistenciaModel> findById(Long id) {
        return asistenciaRepository.findById(id);
    }
    public void eliminarAsistenciaPorId(Long id) {
        asistenciaRepository.deleteById(id);
    }
}
