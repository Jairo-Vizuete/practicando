/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.practice.model;

import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Javp_
 */
@Data
@Document(collection = "seg_usuarios")
public class SegUsuario {

    @Id
    private String id;
    private String nombre;
    private String identificacion;
    private String email;
    private String estado;
    private Integer nroIntentosFallidos;
    private Date fechaUltimaSesion;
    private List<SegUsuarioPerfil> perfiles;
    
}
