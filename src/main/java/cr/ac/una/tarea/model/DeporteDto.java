/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author kevin
 * Se crean los setter y getter del deporte 
 */
public class DeporteDto {
    public SimpleStringProperty nDeporte;
    private Boolean modificado;
    
    public DeporteDto(){
        this.modificado = false;
        this.nDeporte = new SimpleStringProperty();
    }

    public String getnDeporte() {
        return nDeporte.get();
    }

    public void setnDeporte(String nDeporte) {
        this.nDeporte.set(nDeporte);
    }

    public Boolean getModificado() {
        return modificado;
    }

    public void setModificado(Boolean modificado) {
        this.modificado = modificado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeporteDto{nDeporte=").append(nDeporte);
        sb.append('}');
        return sb.toString();
    }
    

}

