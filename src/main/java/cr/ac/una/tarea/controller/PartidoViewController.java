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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class PartidoViewController extends Controller implements Initializable {

    @FXML
    private JFXButton btnVolverPrincipal;
    @FXML
    private JFXButton btn1y2;
    @FXML
    private JFXButton btn3y4;
    @FXML
    private JFXButton btn5y6;
    @FXML
    private JFXButton btn7y8;
    @FXML
    private JFXButton btnCuartos1;
    @FXML
    private JFXButton btnCuartos2;
    @FXML
    private JFXButton btnSemi1;
    @FXML
    private JFXButton btnFinal;
    @FXML
    private JFXButton btnSemi2;
    @FXML
    private JFXButton btnCuartos3;
    @FXML
    private JFXButton btnCuartos4;
    @FXML
    private JFXButton btn9y10;
    @FXML
    private JFXButton btn11y12;
    @FXML
    private JFXButton btn13y14;
    @FXML
    private JFXButton btn15y16;
    @FXML
    private AnchorPane root;



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
     * Botones para iniciar cada los encuentros.
     */
    @FXML
    private void onActionBtnVolverPrincipal(ActionEvent event) {
        FlowController.getInstance().goMain();
        ((Stage) btnVolverPrincipal.getScene().getWindow()).close();
    }

    @FXML
    private void onActionBtn1y2(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("EncuentrosView");
        //((Stage) btnVolverPrincipal.getScene().getWindow()).close();       
    }

    @FXML
    private void onActionBtn3y4(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("EncuentrosView");
         
    }

    @FXML
    private void onActionBtn5y6(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("EncuentrosView");
    }

    @FXML
    private void onActionBtn7y8(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("EncuentrosView");
    }

    @FXML
    private void onActionBtnCuartos1(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("EncuentrosView");
    }

    @FXML
    private void onActionBtnCuartos2(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("EncuentrosView");
    }

    @FXML
    private void onActionBtnSemi1(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("EncuentrosView");
    }

    @FXML
    private void onActionBtnFinal(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("EncuentrosView");
    }

    @FXML
    private void onActionBtnSemi2(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("EncuentrosView");
    }

    @FXML
    private void onActionBtnCuartos3(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("EncuentrosView");
    }

    @FXML
    private void onActionBtnCuartos4(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("EncuentrosView");
    }

    @FXML
    private void onActionBtn9y10(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("EncuentrosView");
    }

    @FXML
    private void onActionBtn11y12(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("EncuentrosView");
    }

    @FXML
    private void onActionBtn13y14(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("EncuentrosView");
    }

    @FXML
    private void onActionBtn15y16(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("EncuentrosView");
    }
    
}
