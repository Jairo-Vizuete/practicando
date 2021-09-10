/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.practice.dao;

import ec.edu.espe.distribuidas.practice.model.SegUsuario;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Javp_
 */
public interface SegUsuarioRepository extends MongoRepository<SegUsuario, String>{
    SegUsuario findByIdentificacion(String identificacion);
    
}
