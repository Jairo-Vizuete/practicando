/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.practice.transform;

import ec.edu.espe.distribuidas.practice.dto.SegUsuarioRS;
import ec.edu.espe.distribuidas.practice.model.SegUsuario;

/**
 *
 * @author Javp_
 */
public class SegUsuarioRSTransform {
    
    public static SegUsuarioRS buildUsuario(SegUsuario usuario) {
        return SegUsuarioRS.builder()
                .nombre(usuario.getNombre())
                .identificacion(usuario.getIdentificacion())
                .email(usuario.getEmail())
                .build();
    }
    
}
