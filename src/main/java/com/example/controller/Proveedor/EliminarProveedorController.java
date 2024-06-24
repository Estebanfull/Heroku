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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/eliminarproveedores")
public class EliminarProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    // Buscar proveedor por ID
    @GetMapping
    public ResponseEntity<?> buscarProveedorId(@RequestParam("idProveedor") Long idProveedor) {
        try {
            Optional<ProveedorModel> proveedor = proveedorService.getProveedorById(idProveedor);
            if (proveedor.isPresent()) {
                return ResponseEntity.ok().body(proveedor.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new MensajeRespuesta("Ocurrió un error al buscar el proveedor por ID."));
        }
    }

    // Eliminar proveedor por ID
    @DeleteMapping
    public ResponseEntity<String> eliminarProveedor(@RequestParam("idProveedor") Long idProveedor) {
        try {
            if (!proveedorService.existsById(idProveedor)) {
                return new ResponseEntity<>("Proveedor no encontrado", HttpStatus.NOT_FOUND);
            }
            proveedorService.deleteProveedor(idProveedor);
            return new ResponseEntity<>("Proveedor eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    static class MensajeRespuesta {
        private String mensaje;

        public MensajeRespuesta(String mensaje) {
            this.mensaje = mensaje;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }
    }
}
