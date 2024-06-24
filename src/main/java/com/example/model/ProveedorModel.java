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

import jakarta.persistence.*;

/**
 *
 * @author Esteban_Rey
 * 
 */
@Entity
@Table(name = "proveedor")
public class ProveedorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private long idProveedor;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "correo_electronico", length = 100)
    private String correoElectronico;

    @Column(name = "tipo_de_servicio", length = 100)
    private String tipoDeServicio;

    // Getters y Setters
    public long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(long idProveedor) {
        this.idProveedor = idProveedor;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTipoDeServicio() {
        return tipoDeServicio;
    }

    public void setTipoDeServicio(String tipoDeServicio) {
        this.tipoDeServicio = tipoDeServicio;
    }

    }


