/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.controller;

import com.jfoenix.controls.JFXButton;
import cr.ac.una.tarea.util.KTimer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class EncuentrosViewController extends Controller implements Initializable {

    
    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnFinalizarPartido;
    @FXML
    private Label LabelTimes;
    @FXML
    private JFXButton btnIniciarP;
    @FXML
    private JFXButton btnParar;

    KTimer ktimer ;
    @FXML
    private ImageView imageView;
    
    
    /**
     * Initializes the controller class.
     * inicializar los vars
     */
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
//       ktimer = new KTimer();
//       LabelTimes = new Label(ktimer.getSspTime().get());
//       ktimer.getSspTime().addListener(new InvalidationListener() { 
//
//     @Override 
//     public void invalidated(Observable observable) { 
//      LabelTimes.setText(ktimer.getSspTime().get()); 
//     } 
//    });
//       
       
    }    

    @Override
    public void initialize() {
   
    }
    
    /**
     * Botones para iniciar los encuentro y finalizar.
     */

    @FXML
    private void onActionBtnFinializarPartido(ActionEvent event) {
        ((Stage) btnFinalizarPartido.getScene().getWindow()).close();   
    }

    @FXML
    private void onActionBtnIniciarP(ActionEvent event) {
        //ktimer.startTimer(ktimer.getTime());
    }

    @FXML
    private void onActionBtnParar(ActionEvent event) {
        ktimer.stopTimer(0);  
    }
    
    
    /**
     * Mover la imagen del balon.
     */
    @FXML
    private void handlerDragOver(DragEvent event) {
        if(event.getDragboard().hasFiles()){
            event.acceptTransferModes(TransferMode.ANY);
        }  
    }

    @FXML
    private void handlerDrop(DragEvent event) throws FileNotFoundException {
        List<File> files = event.getDragboard().getFiles();
        Image img = new Image(new FileInputStream(files.get(0)));
        imageView.setImage(img);
        
    }
    

    

}
