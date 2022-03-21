/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.service;

import cr.ac.una.tarea.model.DeporteDto;
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
 * Indica donde sucedio los errrores en el deporte
 * 
 */
public class DeporteService {
    
    public Respuesta getDeporte(String nom){
        try{
            DeporteDto deporte = new DeporteDto();
            return new Respuesta(true,"","","Deporte",deporte);
        }catch(Exception ex){
            Logger.getLogger(DeporteService.class.getName()).log(Level.SEVERE,"Error obteniendo el deporte ["+nom+"]",ex);
            return new Respuesta(false,"Error obteniendo el deporte.","getDeporte"+ex.getMessage());
        }
    }
    
    public Respuesta eliminarDeporte(String nom){
        try{
            return new Respuesta(true,"","");
        }catch(Exception ex){
            Logger.getLogger(DeporteService.class.getName()).log(Level.SEVERE,"Error eliminando el deporte.", ex);
            return new Respuesta(false,"Error eliminanado el deporte","eliminarDeporte"+ex.getMessage());
        }
    }
    
    public Respuesta guardarDeporte(DeporteDto deporte){
        try{
            return new Respuesta(true,"","","Equipo", new DeporteDto());
        }catch(Exception ex){
            Logger.getLogger(DeporteService.class.getName()).log(Level.SEVERE,"Error guardando el equipo.", ex);
            return new Respuesta(false,"Error guardando el deporte","guardarDeporte"+ex.getMessage());
        }        
    }
    public Respuesta getDeporte(String nom,String dep){
        try{
            List<DeporteDto> deporte = new ArrayList<>();
            return new Respuesta(true,"","","Equipo", deporte);
        }catch(Exception ex){
            Logger.getLogger(DeporteService.class.getName()).log(Level.SEVERE,"Error obteniendo el equipo.", ex);
            return new Respuesta(false,"Error obteniendo el deporte","getDeporte"+ex.getMessage());
        }        
    }
}
