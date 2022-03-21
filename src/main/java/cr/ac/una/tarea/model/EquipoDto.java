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
 * Se crean los setter y getter del equipo
 */
public class EquipoDto {
    public SimpleStringProperty nEquipo;
    public ObjectProperty<String> listaDeporte; 
    private Boolean modificado;
    
    
    public EquipoDto(){
        this.modificado = false;
        this.nEquipo = new SimpleStringProperty();
        this.listaDeporte = new SimpleObjectProperty();
    }

    public String getnEquipo() {
        return nEquipo.get();
    }

    public void setnEquipo(String nEquipo) {
        this.nEquipo.set(nEquipo);
    }

    public String getListaDeporte() {
        return listaDeporte.get();
    }

    public void setListaDeporte(String listaDeporte) {
        this.listaDeporte.set(listaDeporte);
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
        sb.append("EquipoDto{nEquipo=").append(nEquipo);
        sb.append(", listaDeporte=").append(listaDeporte);
        sb.append('}');
        return sb.toString();
    }
    
    
}
