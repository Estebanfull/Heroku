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

import java.util.Optional;

@RestController
@RequestMapping("/api/proveedores")
public class ModificarProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProveedorPorId(@PathVariable Long id) {
        try {
            // Buscar el proveedor por ID
            Optional<ProveedorModel> proveedor = proveedorService.findById(id);
            if (proveedor.isPresent()) {
                // Retornar el proveedor encontrado en una respuesta exitosa
                return ResponseEntity.ok().body(proveedor.get());
            } else {
                // Retornar una respuesta con error si el proveedor no existe
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Manejar errores y retornar una respuesta adecuada
            return ResponseEntity.status(500).body(new MensajeRespuesta("Ocurrió un error al buscar el proveedor por ID."));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarProveedor(@PathVariable Long id, @RequestBody ProveedorModel proveedorActualizado) {
        try {
            // Verificar si el proveedor existe
            Optional<ProveedorModel> proveedorOptional = proveedorService.findById(id);
            if (proveedorOptional.isPresent()) {
                // Obtener el proveedor existente
                ProveedorModel proveedorExistente = proveedorOptional.get();
                // Actualizar los campos del proveedor existente con los datos recibidos
                proveedorExistente.setNombre(proveedorActualizado.getNombre());
                proveedorExistente.setTelefono(proveedorActualizado.getTelefono());
                proveedorExistente.setCorreoElectronico(proveedorActualizado.getCorreoElectronico());
                proveedorExistente.setTipoDeServicio(proveedorActualizado.getTipoDeServicio());
                
                // Guardar el proveedor actualizado en la base de datos
                proveedorService.saveProveedor(proveedorExistente);
                // Retornar una respuesta exitosa con un mensaje
                return ResponseEntity.ok().body(new MensajeRespuesta("Proveedor modificado exitosamente."));
            } else {
                // Retornar una respuesta con error si el proveedor no existe
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // Manejar errores y retornar una respuesta adecuada
            return ResponseEntity.status(500).body(new MensajeRespuesta("Ocurrió un error al modificar el proveedor."));
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
