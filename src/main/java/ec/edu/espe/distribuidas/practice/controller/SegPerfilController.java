/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.practice.controller;

import ec.edu.espe.distribuidas.practice.dto.SegPerfilRQ;
import ec.edu.espe.distribuidas.practice.service.SegPerfilService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Javp_
 */
@Slf4j
@RestController
@RequestMapping("/api/perfil")
public class SegPerfilController {

    private final SegPerfilService service;

    public SegPerfilController(SegPerfilService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity crearImpuesto(@RequestBody SegPerfilRQ segPerfilRQ) {
        try {
            log.info("Va a crear el perfil con la siguiente informacion: {}", segPerfilRQ);
            this.service.createPerfil(segPerfilRQ);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Ocurrio un error al crear el perfil. {} - retorna badrequest", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

}
