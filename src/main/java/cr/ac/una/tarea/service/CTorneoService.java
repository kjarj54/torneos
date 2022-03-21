/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.service;

import cr.ac.una.tarea.model.CTorneoDto;
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
 * Indica donde sucedio los errrores en el torneo
 * 
 */
public class CTorneoService {
    
    public Respuesta getCTorneo(String nom){
        try{
            CTorneoDto ctorneo = new CTorneoDto();
            return new Respuesta(true,"","","CTorneo",ctorneo);
        }catch(Exception ex){
            Logger.getLogger(CTorneoService.class.getName()).log(Level.SEVERE,"Error obteniendo el equipo ["+nom+"]",ex);
            return new Respuesta(false,"Error obteniendo el equipo","getCTorneo"+ex.getMessage());
        }
        
    }

    public Respuesta guardarCTorneo(CTorneoDto ctorneo){
        try{
            return new Respuesta(true,"","","CTorneo",new CTorneoDto());
        }catch(Exception ex){
            Logger.getLogger(CTorneoService.class.getName()).log(Level.SEVERE,"Error guardando el torneo",ex);
            return new Respuesta(false,"Error guardando el TORNEO","guardar TORNEO"+ex.getMessage());
        }
    }
    
    public Respuesta getCTorneo(String nom,String dep){
        try{
            List<CTorneoDto> ctorneo = new ArrayList<>();
            return new Respuesta(true,"","","TORNEO",ctorneo);
        }catch(Exception ex){
            Logger.getLogger(CTorneoService.class.getName()).log(Level.SEVERE,"Obteniendo el TORNEO",ex);
            return new Respuesta(false,"Error obteniendo el TORNEO","getCTorneo"+ex.getMessage());
        }
    }
}
