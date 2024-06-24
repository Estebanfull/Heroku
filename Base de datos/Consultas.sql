USE bd_ike;

INSERT INTO Usuario (nombre, telefono, correo_electronico, direccion, tipo_de_asistencia, clave) 
VALUES ('Ana Martínez', '3101111111', 'ana@example.com', 'Calle 789', 'CONDUCTOR ELEGIDO', 'claveabc');

INSERT INTO Usuario (nombre, telefono, correo_electronico, direccion, tipo_de_asistencia, clave) 
VALUES ('Carlos Rodríguez', '3112222222', 'carlos@example.com', 'Avenida 321', 'LEGAL', 'clavexyz');

INSERT INTO Usuario (nombre, telefono, correo_electronico, direccion, tipo_de_asistencia, clave) 
VALUES ('Laura Gómez', '3143333333', 'laura@example.com', 'Plaza Central', 'HOGAR', 'clave123xyz');

INSERT INTO Usuario (nombre, telefono, correo_electronico, direccion, tipo_de_asistencia, clave) 
VALUES ('Luis Hernández', '3014444444', 'luis@example.com', 'Calle 456', 'AUTOS', 'clave456abc');



SELECT * FROM Usuario;

-- Modificación de la tabla Trabajador para agregar la columna de contraseña
ALTER TABLE Trabajador
ADD COLUMN contrasena VARCHAR(255) NOT NULL;

-- Insertar tres trabajadores  Trabajador

SELECT * FROM Trabajador;

INSERT INTO trabajador (nombre, telefono, correo_electronico, contrasena) 
VALUES 
('Ana García', '555123456', 'ana@example.com', 'ana123'),
('Pedro López', '555987654', 'pedro@example.com', 'pedro123'),
('Laura Martínez', '555111222', 'laura@example.com', 'laura123'),
('Carlos Sánchez', '555333444', 'carlos@example.com', 'carlos123');



SELECT * FROM Tecnico_Asistencia;

INSERT INTO tecnico_asistencia (nombre, telefono, especialidad) 
VALUES 
('Técnico Hogar 1', '310550001', 'Reparaciones en el hogar'),
('Técnico Hogar 2', '310550022', 'Instalaciones eléctricas en el hogar'),
('Técnico Hogar 3', '310550003', 'Fontanería en el hogar'),
('Técnico Hogar 4', '310550004', 'Carpintería en el hogar'),
('Técnico Hogar 5', '310550005', 'Pintura en el hogar'),

('Técnico Ambulancia 1', '311550006', 'Atención de emergencias médicas'),
('Técnico Ambulancia 2', '311550007', 'Transporte de pacientes críticos'),
('Técnico Ambulancia 3', '311550008', 'Asistencia médica en el lugar'),
('Técnico Ambulancia 4', '311550009', 'Manejo de equipo de emergencia'),
('Técnico Ambulancia 5', '311550010', 'Soporte vital básico'),

('Técnico Autos 1', '320550011', 'Mecánica automotriz general'),
('Técnico Autos 2', '320550012', 'Electricidad automotriz'),
('Técnico Autos 3', '320550013', 'Chapistería y pintura automotriz'),
('Técnico Autos 4', '320550014', 'Diagnóstico y reparación de motores'),
('Técnico Autos 5', '320550015', 'Sistema de frenos y suspensión'),

('Técnico Conductor Elegido 1', '314550016', 'Servicio de conductor asignado'),
('Técnico Conductor Elegido 2', '314550017', 'Transporte seguro de pasajeros'),
('Técnico Conductor Elegido 3', '314550018', 'Conducción profesional y segura'),
('Técnico Conductor Elegido 4', '314550019', 'Asistencia de chofer en eventos'),
('Técnico Conductor Elegido 5', '314550020', 'Transporte de ejecutivos y VIP'),

('Técnico Legal 1', '301550021', 'Asesoría legal general'),
('Técnico Legal 2', '301550022', 'Representación legal en tribunales'),
('Técnico Legal 3', '301550023', 'Elaboración de documentos legales'),
('Técnico Legal 4', '301550024', 'Consultoría legal empresarial'),
('Técnico Legal 5', '301550024', 'Mediación y resolución de conflictos legales');



SELECT * FROM asistencia;

INSERT INTO asistencia (fecha, hora, descripcion, estado_de_asistencia, ID_USUARIO, ID_TECNICO, ID_PROVEEDOR) 
VALUES ('2024-05-04', '08:30:00', 'Asistencia en el hogar', 'HOGAR', 1, 1, 1);

INSERT INTO asistencia (fecha, hora, descripcion, estado_de_asistencia, ID_USUARIO, ID_TECNICO, ID_PROVEEDOR) 
VALUES ('2024-05-04', '10:00:00', 'Asistencia de ambulancia', 'AMBULANCIA', 2, 2, 2);

INSERT INTO asistencia (fecha, hora, descripcion, estado_de_asistencia, ID_USUARIO, ID_TECNICO, ID_PROVEEDOR) 
VALUES ('2024-05-04', '11:30:00', 'Asistencia para autos', 'AUTOS', 3, 3, 3);

INSERT INTO asistencia (fecha, hora, descripcion, estado_de_asistencia, ID_USUARIO, ID_TECNICO, ID_PROVEEDOR) 
VALUES ('2024-05-04', '13:00:00', 'Asistencia de conductor elegido', 'CONDUCTOR ELEGIDO', 4, 4, 4);

INSERT INTO asistencia (fecha, hora, descripcion, estado_de_asistencia, ID_USUARIO, ID_TECNICO, ID_PROVEEDOR) 
VALUES ('2024-05-04', '14:30:00', 'Asistencia legal', 'LEGAL', 5, 5, 5);




SELECT * FROM proveedor;

INSERT INTO proveedor (nombre, numero, correo_electronico, tipo_de_servicio) 
VALUES ('Proveedor de Servicios en el Hogar', '3105555555', 'proveedor1@example.com', 'HOGAR');

INSERT INTO proveedor (nombre, numero, correo_electronico, tipo_de_servicio) 
VALUES ('Proveedor de Ambulancias', '3116666666', 'proveedor2@example.com', 'AMBULANCIA');

INSERT INTO proveedor (nombre, numero, correo_electronico, tipo_de_servicio) 
VALUES ('Taller Mecánico de Autos', '3147777777', 'proveedor3@example.com', 'AUTOS');

INSERT INTO proveedor (nombre, numero, correo_electronico, tipo_de_servicio) 
VALUES ('Servicio de Conductores', '3018888888', 'proveedor4@example.com', 'CONDUCTOR ELEGIDO');

INSERT INTO proveedor (nombre, numero, correo_electronico, tipo_de_servicio) 
VALUES ('Despacho Legal', '3109999999', 'proveedor5@example.com', 'LEGAL');


SELECT * FROM Usuario;

SELECT * FROM trabajador;

SELECT * FROM proveedor;

SELECT * FROM tecnico_asistencia;

SELECT * FROM asistencia;
