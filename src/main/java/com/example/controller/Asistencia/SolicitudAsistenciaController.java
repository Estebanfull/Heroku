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
package com.example.controller.Asistencia;

/**
 *
 * @author Esteban_Rey
 */
import com.example.model.AsistenciaModel;
import com.example.service.AsistenciaService;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/asistencias")
public class SolicitudAsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    @PostMapping("/modificar")
    public ResponseEntity<?> solicitarAsistencia(@RequestBody AsistenciaModel nuevaAsistencia) {
        try {
            // Asignar fecha y hora actuales
            nuevaAsistencia.setFecha(LocalDate.now());
            nuevaAsistencia.setHora(LocalTime.now());
            
            // Guardar la solicitud de asistencia en la base de datos
            AsistenciaModel asistenciaGuardada = asistenciaService.saveAsistencia(nuevaAsistencia);
            
            // Retornar una respuesta exitosa con un mensaje
            return ResponseEntity.ok().body(new MensajeRespuesta("Asistencia solicitada exitosamente."));
        } catch (Exception e) {
            // Manejar errores y retornar una respuesta adecuada
            return ResponseEntity.status(500).body(new MensajeRespuesta("Ocurrió un error al solicitar la asistencia."));
        }
    }
@DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarAsistencia(@PathVariable Long id) {
        try {
            asistenciaService.eliminarAsistenciaPorId(id);
            return ResponseEntity.ok().body(new MensajeRespuesta("Asistencia eliminada exitosamente."));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new MensajeRespuesta("Ocurrió un error al eliminar la asistencia."));
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