/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.practice.service;

import ec.edu.espe.distribuidas.practice.dao.SegUsuarioRepository;
import ec.edu.espe.distribuidas.practice.dto.SegUsuarioRQ;
import ec.edu.espe.distribuidas.practice.model.SegUsuario;
import ec.edu.espe.distribuidas.practice.model.SegUsuarioPerfil;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author Javp_
 */
@Service
@Slf4j
public class SegUsuarioService {

    private final SegUsuarioRepository repo;

    public SegUsuarioService(SegUsuarioRepository repo) {
        this.repo = repo;
    }

    public SegUsuario listarUsuarioByID(String identificacion) {
        return this.repo.findByIdentificacion(identificacion);
    }
    

    public void createUsuario(SegUsuarioRQ segUsuarioRQ) {
        SegUsuario segUsuario = new SegUsuario();
        segUsuario.setNombre(segUsuarioRQ.getNombre());
        segUsuario.setIdentificacion(segUsuarioRQ.getIdentificacion());
        segUsuario.setEmail(segUsuarioRQ.getEmail());
        segUsuario.setEstado("ACT");
        segUsuario.setNroIntentosFallidos(3);
        segUsuario.setFechaUltimaSesion(segUsuarioRQ.getFechaUltimaSesion());
        segUsuario.setPerfiles(segUsuarioRQ.getPerfiles());
        this.repo.save(segUsuario);
    }
    
    public void agregarPerfiles(String id, List<SegUsuarioPerfil> segUsuarioPerfil) {
        SegUsuario segUsuario = this.repo.findByIdentificacion(id);
        segUsuario.setPerfiles((List<SegUsuarioPerfil>) segUsuarioPerfil);
        this.repo.save(segUsuario);
    }
}
