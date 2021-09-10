/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.practice.dao;

import ec.edu.espe.distribuidas.practice.model.SegPerfil;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Javp_
 */
public interface SegPerfilRepository extends MongoRepository<SegPerfil, String> {

    List<SegPerfil> findByEstado(String estado);

    @Override
    Optional<SegPerfil> findById(String id);
}
