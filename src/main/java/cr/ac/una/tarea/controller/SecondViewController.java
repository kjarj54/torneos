/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import cr.ac.una.tarea.model.DeporteDto;
import cr.ac.una.tarea.service.DeporteService;
import cr.ac.una.tarea.util.Formato;
import cr.ac.una.tarea.util.Mensaje;
import cr.ac.una.tarea.util.Respuesta;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class SecondViewController extends Controller implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnBuscarImagen;
    @FXML
    private ImageView ivImagen;
    @FXML
    private JFXButton btnGuardar;
    @FXML
    private JFXButton btnEditar;
    @FXML
    private JFXButton btnEliminar;
    @FXML
    private JFXButton btnBuscarBD;
    @FXML
    private JFXTextField txtNDeporte;
    
    private DeporteDto deporteDto;
    List<Node> requisitos = new ArrayList<>();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtNDeporte.setTextFormatter(Formato.getInstance().maxLengthFormat(20));
        deporteDto = new DeporteDto();
        nuevoDeporte();
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
        requisitos.addAll(Arrays.asList(txtNDeporte));
    }
       /**
     * Revisa que las casillas necesarias no enten vacias.
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
    
    public void bindDeporte(Boolean nuevo){
        if(!nuevo){
            txtNDeporte.textProperty().bind(deporteDto.nDeporte);
        }
    }
    
    private void unbindDeporte(){
        txtNDeporte.textProperty().unbind();
    }
    
    private void nuevoDeporte(){
        unbindDeporte();
        deporteDto = new DeporteDto();
        bindDeporte(true);
        txtNDeporte.clear();
        txtNDeporte.requestFocus();
    }
     /**
     * carga el equipo o tira un mensaje de que no se gusardo el equipo.
     */
     
    private void cargarDeporte(String nom){
        DeporteService service = new DeporteService();
        Respuesta respuesta = service.getDeporte(nom);
        if(respuesta.getEstado()){
            unbindDeporte();
            deporteDto = (DeporteDto) respuesta.getResultado("Deporte");
            bindDeporte(false);
            validarRequeridos();
        }else{
            new Mensaje().showModal(Alert.AlertType.ERROR,"Cargar Deporte ",getStage(),respuesta.getMensaje());
        }
    }    
    
        
       /**
     *Boton para cargar una imagen desde los archivos.
     */ 
    @FXML
    private void onActionBuscarImagen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Busqueda Imagen");
        
        //Facilita la busqueda escogiendo que aparescan jpg, pgn
        fileChooser.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("All Images", "*.*"), new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
        
        //toma la imagen
        File imagFile = fileChooser.showOpenDialog(null);
        
        //comprueba y luego muestra la imagen
        if(imagFile != null){
            
          Image image = new Image("file:"+imagFile.getAbsolutePath());
          ivImagen.setImage(image);
          
        }
    }
         /**
     * Boton para guardar el deporte.
     */

    @FXML
    private void onActionBtnGuardar(ActionEvent event) {
        try{
            String invalidos = validarRequeridos();
            if(!invalidos.isEmpty()){
                new Mensaje().showModal(Alert.AlertType.ERROR,"Guardar Deporte",getStage(),invalidos);
            }else{
                DeporteService service = new DeporteService();
                Respuesta respuesta = service.guardarDeporte(deporteDto);
                if(!respuesta.getEstado()){
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar deporte",getStage(),respuesta.getMensaje());
                }else{
                    unbindDeporte();
                    deporteDto = (DeporteDto) respuesta.getResultado("Deporte");
                    bindDeporte(false);
                    new Mensaje().showModal(Alert.AlertType.INFORMATION,"Guardar deporte",getStage(), "Deporte actualizado correctamente.");
                }
            }
        }catch(Exception ex){
            Logger.getLogger(RegistroEquipoViewController.class.getName()).log(Level.SEVERE,"Error guardando el deporte.", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar deporte", getStage(),"Ocurrio un error guardando el deporte.");
        }        
    }
     /**
     * Boton para editar la lista de deportes.
     */
    @FXML
    private void onActionBtnEditar(ActionEvent event) {
        
    }
     /**
     * Boton para eliminar un deporte.
     */
    @FXML
    private void onActionBtnEliminar(ActionEvent event) {
        try{
            if(deporteDto.getnDeporte()==null){
                new Mensaje().showModal(Alert.AlertType.ERROR, "Eliminar Deporte", getStage(), "Debe cargar el equipo que desea eliminar");
            }else{
                DeporteService service= new DeporteService();
                Respuesta respuesta =service.eliminarDeporte(deporteDto.getnDeporte());
                if(!respuesta.getEstado()){
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Elinar deporte", getStage(), respuesta.getMensaje());
                }else{
                    unbindDeporte();
                    deporteDto = (DeporteDto)respuesta.getResultado("Deporte");
                    bindDeporte(false);
                    new Mensaje().showModal(Alert.AlertType.ERROR,"Eliminar deporte",getStage(),"Deporte eliminado correctamente.");
                }
            }
        }catch(Exception ex){
            Logger.getLogger(RegistroEquipoViewController.class.getName()).log(Level.SEVERE,"Error eliminando el equipo",ex);
            new Mensaje().showModal(Alert.AlertType.ERROR,"Eliminar  deporte",getStage(),"Ocurrio un error eliminando el deporte");
        }   
    }
     /**
     * Buscar un deporte.
     */
    @FXML
    private void onActionBtnBuscarBD(ActionEvent event) {
    }
    
}
