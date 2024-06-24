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
package com.example.model;

/**
 *
 * @author Esteban_Rey
 */

import jakarta.persistence.*;

@Entity
@Table(name = "tecnico")
public class TecnicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tecnico")
    private long idTecnico;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "especialidad", length = 100)
    private String especialidad;

    // Getters y Setters
    public long getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(long idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

  
    }

