/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.practice.controller;

import ec.edu.espe.distribuidas.practice.dto.SegPerfilRQ;
import ec.edu.espe.distribuidas.practice.dto.SegUsuarioPerfilRQ;
import ec.edu.espe.distribuidas.practice.dto.SegUsuarioRQ;
import ec.edu.espe.distribuidas.practice.dto.SegUsuarioRS;
import ec.edu.espe.distribuidas.practice.model.SegUsuario;
import ec.edu.espe.distribuidas.practice.model.SegUsuarioPerfil;
import ec.edu.espe.distribuidas.practice.service.SegUsuarioService;
import ec.edu.espe.distribuidas.practice.transform.SegUsuarioRSTransform;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Javp_
 */
@Slf4j
@RestController
@RequestMapping("/api/usuario")
public class SegUsuarioController {

    private final SegUsuarioService service;

    public SegUsuarioController(SegUsuarioService service) {
        this.service = service;
    }

    @GetMapping(value = "{identificacion}")
    public ResponseEntity obtenerUsuarioByID(@PathVariable("identificacion") String identificacion) {
        SegUsuario usuario = this.service.listarUsuarioByID(identificacion);
        if (usuario != null) {
            SegUsuarioRS segUsuarioRS = SegUsuarioRSTransform.buildUsuario(usuario);
            return ResponseEntity.ok(segUsuarioRS);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public ResponseEntity crearUsuario(@RequestBody SegUsuarioRQ segUsuarioRQ) {
        try {
            log.info("Va a crear el usuario con la siguiente informacion: {}", segUsuarioRQ);
            this.service.createUsuario(segUsuarioRQ);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Ocurrio un error al crear el usuario. {} - retorna badrequest", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping
    public ResponseEntity agregarPerfilAUsuario(@RequestBody SegUsuarioPerfilRQ request) {
        try {
            List<SegUsuarioPerfil> perfiles = new ArrayList<>();
            for (SegPerfilRQ perfilRQ : request.getPerfiles()) {
                SegUsuarioPerfil sup = new SegUsuarioPerfil();
                sup.setNombre(perfilRQ.getNombre());
                sup.setEstado(perfilRQ.getEstado());
                sup.setPorOmision("Y");
                perfiles.add(sup);
            }
//            su.setPerfiles(perfiles);
            log.info("Va a crear el usuario con la siguiente informacion: {}", perfiles);
            this.service.agregarPerfiles(request.getIdentificacion(), perfiles);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            log.error("Ocurrio un error al crear el usuario. {} - retorna badrequest", ex.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
