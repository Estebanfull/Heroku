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
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "asistencia")
public class AsistenciaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ASISTENCIA")
    private Long id;

    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Column(name = "ID_TECNICO")
    private Long idTecnico;

    @Column(name = "ID_PROVEEDOR")
    private Long idProveedor;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora")
    private LocalTime hora;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo_de_asistencia")
    private String tipoDeAsistencia;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Long idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoDeAsistencia() {
        return tipoDeAsistencia;
    }

    public void setTipoDeAsistencia(String tipoDeAsistencia) {
        this.tipoDeAsistencia = tipoDeAsistencia;
    }
}
