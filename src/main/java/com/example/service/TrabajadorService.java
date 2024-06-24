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



import com.example.model.TrabajadorModel;
import com.example.repository.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajadorService {

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    public List<TrabajadorModel> getAllTrabajadores() {
        return (List<TrabajadorModel>) trabajadorRepository.findAll();
    }

    public Optional<TrabajadorModel> getTrabajadorById(Long id) {
        return trabajadorRepository.findById(id);
    }

    public TrabajadorModel saveTrabajador(TrabajadorModel trabajador) {
        Optional<TrabajadorModel> existingTrabajador = trabajadorRepository.findById(trabajador.getIdTrabajador());
        if (existingTrabajador.isPresent()) {
            TrabajadorModel updatedTrabajador = existingTrabajador.get();
            updatedTrabajador.setNombre(trabajador.getNombre());
            updatedTrabajador.setTelefono(trabajador.getTelefono());
            updatedTrabajador.setCorreoElectronico(trabajador.getCorreoElectronico());
            updatedTrabajador.setClave(trabajador.getClave());
            return trabajadorRepository.save(updatedTrabajador);
        } else {
            return trabajadorRepository.save(trabajador);
        }
    }

    public void deleteTrabajador(Long id) {
        trabajadorRepository.deleteById(id);
    }

    public TrabajadorModel getTrabajadorByCorreoYClave(String correo, String clave) {
        if (correo == null || clave == null) {
            return null;
        }
        return trabajadorRepository.findByCorreoElectronicoAndClave(correo, clave);
    }

    public TrabajadorModel getTrabajadorByCorreo(String correo) {
        if (correo == null) {
            return null;
        }
        return trabajadorRepository.findByCorreoElectronico(correo);
    }

    public boolean existsById(Long id) {
        return trabajadorRepository.existsById(id);
    }

    public Optional<TrabajadorModel> findById(Long id) {
        return trabajadorRepository.findById(id);
    }

    public TrabajadorModel getTrabajadorByClave(String clave) {
        if (clave == null) {
            return null;
        }
        return trabajadorRepository.findByClave(clave);
    }
}
