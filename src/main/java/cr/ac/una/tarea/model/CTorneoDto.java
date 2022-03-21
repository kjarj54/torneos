/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author kevin
 * Se crean los setter y getter
 */
public class CTorneoDto {
    public SimpleStringProperty nTorneo;
    public SimpleStringProperty Duracion;
    public SimpleStringProperty cEquipos;
    public ObjectProperty<String> listaDeporte; 
    private Boolean modificado;
    
    
    public CTorneoDto(){
        this.modificado = false;
        this.nTorneo = new SimpleStringProperty();
        this.Duracion = new SimpleStringProperty();
        this.cEquipos = new SimpleStringProperty();
        this.listaDeporte = new SimpleObjectProperty();
    }

    public String getnTorneo() {
        return nTorneo.get();
    }

    public void setnTorneo(String nTorneo) {
        this.nTorneo.set(nTorneo);
    }

    public Long getDuracion() {
        if(Duracion.get() != null && !Duracion.get().isEmpty()){
            return Long.valueOf(Duracion.get());
        }else{
            return null;
        }  
    }

    public void setDuracion(Long Duracion) {
        this.Duracion.setValue(Duracion.toString());
    }

    public Long getcEquipos() {
        if(cEquipos.get() != null && !cEquipos.get().isEmpty()){
            return Long.valueOf(cEquipos.get());
        }else{
            return null;
        } 
    }

    public void setcEquipos(Long cEquipos) {
        this.cEquipos.setValue(cEquipos.toString());
    }

    public ObjectProperty<String> getListaDeporte() {
        return listaDeporte;
    }

    public void setListaDeporte(ObjectProperty<String> listaDeporte) {
        this.listaDeporte = listaDeporte;
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
        sb.append("CTorneoDto{nTorneo=").append(nTorneo);
        sb.append(", Duracion=").append(Duracion);
        sb.append(", cEquipos=").append(cEquipos);
        sb.append(", listaDeporte=").append(listaDeporte);
        sb.append('}');
        return sb.toString();
    }
    

}
