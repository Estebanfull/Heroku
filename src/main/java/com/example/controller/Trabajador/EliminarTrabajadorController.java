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
package com.example.controller.Trabajador;
/**
 *
 * @author Esteban_Rey
 */
import com.example.model.TrabajadorModel;
import com.example.service.TrabajadorService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eliminartrabajadores")
public class EliminarTrabajadorController {

    @Autowired
    private TrabajadorService trabajadorService;

    // Buscar trabajador por ID
    @GetMapping
    public ResponseEntity<?> buscarTrabajadorId(@RequestParam("idTrabajador") Long idTrabajador) {
        try {
            Optional<TrabajadorModel> trabajador = trabajadorService.getTrabajadorById(idTrabajador);
            if (trabajador.isPresent()) {
                return ResponseEntity.ok().body(trabajador.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new MensajeRespuesta("Ocurrió un error al buscar el trabajador por ID."));
        }
    }

    // Eliminar trabajador por ID
    @DeleteMapping
    public ResponseEntity<String> eliminarTrabajador(@RequestParam("idTrabajador") Long idTrabajador) {
        try {
            if (!trabajadorService.existsById(idTrabajador)) {
                return new ResponseEntity<>("Trabajador no encontrado", HttpStatus.NOT_FOUND);
            }
            trabajadorService.deleteTrabajador(idTrabajador);
            return new ResponseEntity<>("Trabajador eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el trabajador", HttpStatus.INTERNAL_SERVER_ERROR);
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
