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
package com.example.controller;

import com.example.model.TrabajadorModel;
import com.example.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginControllerTrabajador {

    private final TrabajadorService trabajadorService;

    @Autowired
    public LoginControllerTrabajador(TrabajadorService trabajadorService) {
        this.trabajadorService = trabajadorService;
    }

    @PostMapping("/api/login-trabajador")
    public String login(@RequestBody TrabajadorModel trabajador) {
        String correo = trabajador.getCorreoElectronico();
        String clave = trabajador.getClave();

        // Imprimir valores para depuración
        System.out.println("Correo proporcionado: " + correo);
        System.out.println("Clave proporcionada: " + clave);

        // Utilizamos el servicio para buscar el trabajador por correo y clave
        TrabajadorModel trabajadorEncontrado = trabajadorService.getTrabajadorByCorreoYClave(correo, clave);
        if (trabajadorEncontrado != null) {
            System.out.println("Credenciales válidas");
            return "Credenciales válidas";
        } else {
            System.out.println("Credenciales incorrectas");
            return "Credenciales incorrectas";
        }
    }
}
