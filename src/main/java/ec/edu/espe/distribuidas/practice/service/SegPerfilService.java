/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.practice.service;

import ec.edu.espe.distribuidas.practice.dao.SegPerfilRepository;
import ec.edu.espe.distribuidas.practice.dto.SegPerfilRQ;
import ec.edu.espe.distribuidas.practice.model.SegPerfil;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author Javp_
 */
@Service
@Slf4j
public class SegPerfilService {

    private final SegPerfilRepository repo;

    public SegPerfilService(SegPerfilRepository repo) {
        this.repo = repo;
    }

    public void createPerfil(SegPerfilRQ segPerfilRQ) {
        SegPerfil segPerfil = new SegPerfil();
        segPerfil.setNombre(segPerfilRQ.getNombre());
        segPerfil.setEstado(segPerfilRQ.getEstado());
        this.repo.save(segPerfil);
    }
}
