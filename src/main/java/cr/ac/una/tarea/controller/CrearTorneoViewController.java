/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import cr.ac.una.tarea.model.CTorneoDto;
import cr.ac.una.tarea.service.CTorneoService;
import cr.ac.una.tarea.util.FlowController;
import cr.ac.una.tarea.util.Formato;
import cr.ac.una.tarea.util.Mensaje;
import cr.ac.una.tarea.util.Respuesta;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class CrearTorneoViewController extends Controller implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnIniciarTorneo;
    @FXML
    private JFXTextField txtNtorneo;
    @FXML
    private JFXTextField txtDuracion;
    @FXML
    private JFXTextField txtCEquipos;
    
    private CTorneoDto ctorneoDto;
    List<Node> requisitos = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtNtorneo.setTextFormatter(Formato.getInstance().maxLengthFormat(20));
        txtDuracion.setTextFormatter(Formato.getInstance().integerFormat());
        txtCEquipos.setTextFormatter(Formato.getInstance().integerFormat());
        ctorneoDto = new CTorneoDto();
        nuevoTorneo();
        indicarRequeridos();
        
    }    

    @Override
    public void initialize() {
        
    }
    /**
     * Indica que el campo no este vacio.
     */
    public void indicarRequeridos(){
        requisitos.clear();
        requisitos.addAll(Arrays.asList(txtNtorneo,txtCEquipos,txtDuracion));
    }
    /**
     * Revisa que las casillas necesarias no enten vacias 
     */
    public String validarRequeridos(){
        Boolean validos = true;
        String invalidos = "";
        for (Node node : requisitos) {
            if (node instanceof JFXTextField && !((JFXTextField) node).validate()) {
                if (validos) {
                    invalidos += ((JFXTextField) node).getPromptText();
                } else {
                    invalidos += "," + ((JFXTextField) node).getPromptText();
                }
                validos = false;
            }
        }
        if (validos) {
            return "";
        } else {
            return "Campos requeridos o con problemas de formato [" + invalidos + "].";
        }
        
    }
    
    /**
     * .
     */
    public void bindCTorneo(Boolean nuevo){
        if(!nuevo){
            txtNtorneo.textProperty().bind(ctorneoDto.nTorneo);            
        }
        txtCEquipos.textProperty().bindBidirectional(ctorneoDto.cEquipos);
        txtDuracion.textProperty().bindBidirectional(ctorneoDto.Duracion);
    }
    /**
     * Initializes the controller class.
     */
    private void unbindCTorneo(){
        txtNtorneo.textProperty().unbind();
        txtCEquipos.textProperty().unbindBidirectional(ctorneoDto.cEquipos);
        txtNtorneo.textProperty().unbindBidirectional(ctorneoDto.Duracion);
    }
    /**
     *Crea y limpia las casillas del torneo.
     */    
    private void nuevoTorneo(){
        unbindCTorneo();
        ctorneoDto = new CTorneoDto();
        bindCTorneo(true);
        txtNtorneo.clear();
        txtNtorneo.requestFocus();
    }
    /**
     * Se carga el torneo y revisa que existe el torneo.
     */        
    private void cargarTorneo(String nom){
        CTorneoService service = new CTorneoService();
        Respuesta respuesta = service.getCTorneo(nom);
        if(respuesta.getEstado()){
            unbindCTorneo();
            ctorneoDto = (CTorneoDto) respuesta.getResultado("Torneo");
            bindCTorneo(false);
            validarRequeridos();
        }else{
            new Mensaje().showModal(Alert.AlertType.ERROR,"Cargar Torneo ",getStage(),respuesta.getMensaje());
        }
    }    
     
    /**
     * Boton para iniciar el torneo y que se abra la interfaz.
     */

    @FXML
    private void onActionBtnIniciarTorneo(ActionEvent event) {  
        FlowController.getInstance().goViewInWindow("PartidoView");
        ((Stage) btnIniciarTorneo.getScene().getWindow()).close();
    }
    
}
