/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.practice.dto;

import ec.edu.espe.distribuidas.practice.model.SegUsuarioPerfil;
import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Javp_
 */
@Data
@Builder
public class SegUsuarioRQ {

    private String nombre;
    private String identificacion;
    private String email;
    private Date fechaUltimaSesion;
    private List<SegUsuarioPerfil> perfiles;
}
