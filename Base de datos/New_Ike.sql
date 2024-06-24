CREATE DATABASE Bd_Ike;
USE Bd_Ike;

-- Tabla Usuario
CREATE TABLE Usuario (
    ID_USUARIO INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    tipo_de_asistencia VARCHAR(100),
    clave VARCHAR(50) NOT NULL
);

-- Tabla Trabajador
CREATE TABLE  Trabajador (
    ID_TRABAJADOR INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL
  
);

-- Tabla Proveedor
CREATE TABLE  Proveedor (
    ID_PROVEEDOR INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    numero VARCHAR(20) NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL,
    tipo_de_servicio VARCHAR(100) NOT NULL
);

-- Tabla Técnico de Asistencia
CREATE TABLE  Tecnico_Asistencia (
    ID_TECNICO INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    especialidad VARCHAR(100) NOT NULL
);

-- Tabla Asistencia
CREATE TABLE  Asistencia (
    ID_ASISTENCIA INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    descripcion TEXT,
    estado_de_asistencia VARCHAR(50) NOT NULL,
    ID_USUARIO INT,
    ID_TECNICO INT,
    ID_PROVEEDOR INT,
    FOREIGN KEY (ID_USUARIO) REFERENCES Usuario(ID_USUARIO),
    FOREIGN KEY (ID_TECNICO) REFERENCES Tecnico_Asistencia(ID_TECNICO),
    FOREIGN KEY (ID_PROVEEDOR) REFERENCES Proveedor(ID_PROVEEDOR)
);



