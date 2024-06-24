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
package com.example.controller.Tecnico;

/**
 *
 * @author Esteban_Rey
 */
import com.example.model.TecnicoModel;
import com.example.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/eliminartecnicos")
public class EliminarTecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    // Buscar técnico por ID
    @GetMapping
    public ResponseEntity<?> buscarTecnicoId(@RequestParam("idTecnico") Long idTecnico) {
        try {
            Optional<TecnicoModel> tecnico = tecnicoService.getTecnicoById(idTecnico);
            if (tecnico.isPresent()) {
                return ResponseEntity.ok().body(tecnico.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new MensajeRespuesta("Ocurrió un error al buscar el técnico por ID."));
        }
    }

    // Eliminar técnico por ID
    @DeleteMapping
    public ResponseEntity<String> eliminarTecnico(@RequestParam("idTecnico") Long idTecnico) {
        try {
            if (!tecnicoService.existsById(idTecnico)) {
                return new ResponseEntity<>("Técnico no encontrado", HttpStatus.NOT_FOUND);
            }
            tecnicoService.deleteTecnico(idTecnico);
            return new ResponseEntity<>("Técnico eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el técnico", HttpStatus.INTERNAL_SERVER_ERROR);
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
