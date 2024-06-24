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
package com.example.controller.Proveedor;

/**
 *
 * @author Esteban_Rey
 */


import com.example.model.ProveedorModel;
import com.example.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proveedores")
public class CrearProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @PostMapping
    public ResponseEntity<?> crearProveedor(@RequestBody ProveedorModel nuevoProveedor) {
        try {
            // Guardar el nuevo proveedor en la base de datos
            ProveedorModel proveedorGuardado = proveedorService.saveProveedor(nuevoProveedor);
            // Retornar una respuesta exitosa con un mensaje
            return ResponseEntity.ok().body(new MensajeRespuesta("Proveedor creado exitosamente."));
        } catch (Exception e) {
            // Manejar errores y retornar una respuesta adecuada
            return ResponseEntity.status(500).body(new MensajeRespuesta("Ocurrió un error al crear el proveedor."));
        }
    }

    // Clase interna para encapsular el mensaje de respuesta
    public static class MensajeRespuesta {
        private String message;

        public MensajeRespuesta(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
