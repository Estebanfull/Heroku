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
package com.example.repository;

/**
 *
 * @author Esteban_Rey
 */


import com.example.model.TrabajadorModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorRepository extends JpaRepository<TrabajadorModel, Long> {
    TrabajadorModel findByCorreoElectronicoAndClave(String correoElectronico, String clave);

    public TrabajadorModel findByCorreoElectronico(String correoElectronico);

    public TrabajadorModel findByClave(String clave);

    public Optional<TrabajadorModel> findByIdTrabajador(Long id);

    public Optional<TrabajadorModel> findByNombre(String nombreTrabajador);
}
