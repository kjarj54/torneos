/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.service;

import cr.ac.una.tarea.model.EquipoDto;
import cr.ac.una.tarea.util.Respuesta;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */

/**
 *
 * Indica donde sucedio los errrores en el equipo
 * 
 */
public class EquipoService {

    public Respuesta getEquipo(String nom){
        try{
            EquipoDto equipo = new EquipoDto();
            return new Respuesta(true,"","","Equipo",equipo);
        }catch(Exception ex){
            Logger.getLogger(EquipoService.class.getName()).log(Level.SEVERE,"Error obteniendo el equipo ["+nom+"]",ex);
            return new Respuesta(false,"Error obteniendo el equipo.","getEquipo"+ex.getMessage());
        }
    }
    
    public Respuesta eliminarEquipo(String nom){
        try{
            return new Respuesta(true,"","");
        }catch(Exception ex){
            Logger.getLogger(EquipoService.class.getName()).log(Level.SEVERE,"Error eliminando el equipo.", ex);
            return new Respuesta(false,"Error eliminanado el equipo","eliminarEquipo"+ex.getMessage());
        }
    }
    
    public Respuesta guardarEquipo(EquipoDto equipo){
        try{
            return new Respuesta(true,"","","Equipo", new EquipoDto());
        }catch(Exception ex){
            Logger.getLogger(EquipoService.class.getName()).log(Level.SEVERE,"Error guardando el equipo.", ex);
            return new Respuesta(false,"Error guardando el equipo","guardarEquipo"+ex.getMessage());
        }        
    }
    public Respuesta getEquipo(String nom,String dep){
        try{
            List<EquipoDto> equipo = new ArrayList<>();
            return new Respuesta(true,"","","Equipo", equipo);
        }catch(Exception ex){
            Logger.getLogger(EquipoService.class.getName()).log(Level.SEVERE,"Error obteniendo el equipo.", ex);
            return new Respuesta(false,"Error obteniendo el equipo","getEquipo"+ex.getMessage());
        }        
    }
    
}
