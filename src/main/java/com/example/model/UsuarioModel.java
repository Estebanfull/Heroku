package com.example.model;


import jakarta.persistence.*;


@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "correo_electronico", length = 100)
    private String correoElectronico;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Column(name = "tipo_de_asistencia", length = 100)
    private String tipoDeAsistencia;

    @Column(name = "clave", length = 50)
    private String clave;

    // Getters y Setters
    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoDeAsistencia() {
        return tipoDeAsistencia;
    }

    public void setTipoDeAsistencia(String tipoDeAsistencia) {
        this.tipoDeAsistencia = tipoDeAsistencia;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }


  
    }
