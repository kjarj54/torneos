/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.controller;

import com.jfoenix.controls.JFXButton;
import cr.ac.una.tarea.util.FlowController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class PrincipalViewController extends Controller implements Initializable {

    @FXML
    private BorderPane root;
    @FXML
    private JFXButton btnRegistroDeporte;
    @FXML
    private JFXButton btnRegistroEquipo;
    @FXML
    private JFXButton btnCrearTorneo;
    @FXML
    private JFXButton btnSalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @Override
    public void initialize() {
        
    }

    /**
     * Boton para registrar un deporte.
     */
    @FXML
    private void onActionBtnRegistroDeporte(ActionEvent event) {
        FlowController.getInstance().goView("SecondView");
    }
    /**
     * Boton para registrar un equipo.
     */
    @FXML
    private void onActionBtnRegistroEquipo(ActionEvent event) {
        FlowController.getInstance().goView("RegistroEquipoView");
    }
    /**
     * Boton para crear un torneo.
     */
    @FXML
    private void onActionBtnCrearTorneo(ActionEvent event) {
        
        FlowController.getInstance().goView("CrearTorneoView");
    }
    /**
     * Boton para salir de la aplicacion.
     */
    @FXML
    private void onActionBtnSalir(ActionEvent event) {
        ((Stage) btnSalir.getScene().getWindow()).close();
    }

    
}
