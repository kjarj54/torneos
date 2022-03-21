/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.controller;

import cr.ac.una.tarea.util.VistaCamara;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import cr.ac.una.tarea.model.EquipoDto;
import cr.ac.una.tarea.service.EquipoService;
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
public class RegistroEquipoViewController extends Controller implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnBuscarImagenDeporte;
    @FXML
    private ImageView imgViewEquipo;
    @FXML
    private JFXButton btnTomarFoto;
    @FXML
    private JFXButton btnGuardar;
    @FXML
    private JFXButton btnEditarListaEquipos;
    @FXML
    private JFXButton btnEliminar;
    
    private EquipoDto equipoDto;
    List<Node> requisitos = new ArrayList<>();
    @FXML
    private JFXTextField txtNEquipo;
    @FXML
    private JFXButton btnCargarFoto;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtNEquipo.setTextFormatter(Formato.getInstance().maxLengthFormat(10));
        equipoDto= new EquipoDto();
        nuevoEquipo();
        indicarRequeridos();
        //this.root.set;
    }    

    @Override
    public void initialize() {
        
    }
     /**
     * Indica que el campo no este vacio.
     */
    public void indicarRequeridos(){
        requisitos.clear();
        requisitos.addAll(Arrays.asList(txtNEquipo));
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
    
    /**
     * .
     */
    public void bindEquipo(Boolean nuevo){
        if(!nuevo){
            txtNEquipo.textProperty().bind(equipoDto.nEquipo);
        }
    }
    
    /**
     * .
     */
    private void unbindEquipo(){
        txtNEquipo.textProperty().unbind();
    }
    
 
    private void nuevoEquipo(){
        unbindEquipo();
        equipoDto = new EquipoDto();
        bindEquipo(true);
        txtNEquipo.clear();
        txtNEquipo.requestFocus();
    }
   /**
     * carga el equipo o tira un mensaje de que no se gusardo el equipo.
     */
    private void cargarEquipo(String nom){
        EquipoService service = new EquipoService();
        Respuesta respuesta = service.getEquipo(nom);
        if(respuesta.getEstado()){
            unbindEquipo();
            equipoDto = (EquipoDto) respuesta.getResultado("Equipo");
            bindEquipo(false);
            validarRequeridos();
        }else{
            new Mensaje().showModal(Alert.AlertType.ERROR,"Cargar equipo ",getStage(),respuesta.getMensaje());
        }
    }
    /**
     *Boton para cargar una imagen desde los archivos.
     */
    @FXML
    private void onActionBtnBuscarImagenDeporte(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Busqueda Imagen");
        
        //Facilita la busqueda escogiendo que aparescan jpg, pgn
        fileChooser.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("All Images", "*.*"), new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
        
        //toma la imagen
        File imagFile = fileChooser.showOpenDialog(null);
        
        //comprueba y luego muestra la imagen
        if(imagFile != null){
            
          Image image = new Image("file:"+imagFile.getAbsolutePath());
          imgViewEquipo.setImage(image);
          
        }
    }
    /**
     * Mostrar imgen tomadad de camara en el imageView.
     */    
    public void FotoCamara(){
        File file = new File("src/main/resources/cr/ac/una/tarea/resources/ImagenNueva.PNG");
        Image imagen = new Image(file.toURI().toString());
        imgViewEquipo.setImage(imagen);
    }
    /**
     * Boton para tomar foto.
     */
    @FXML
    private void onActionBtnTomarFoto(ActionEvent event)throws InterruptedException {      
        VistaCamara vcam = new VistaCamara();
        vcam.iniciarCam();
    }
    /**
     * Boton para guardar y verificar si se guardo o no con un mensaje.
     */
    @FXML
    private void onActionBtnGuardar(ActionEvent event) {
        try{
            String invalidos = validarRequeridos();
            if(!invalidos.isEmpty()){
                new Mensaje().showModal(Alert.AlertType.ERROR,"Guardar Equipo",getStage(),invalidos);
            }else{
                EquipoService service = new EquipoService();
                Respuesta respuesta = service.guardarEquipo(equipoDto);
                if(!respuesta.getEstado()){
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar equipo",getStage(),respuesta.getMensaje());
                }else{
                    unbindEquipo();
                    equipoDto = (EquipoDto) respuesta.getResultado("Deporte");
                     bindEquipo(false);
                    new Mensaje().showModal(Alert.AlertType.INFORMATION,"Guardar equipo",getStage(), "Equipo actualizado correctamente.");
                }
            }
        }catch(Exception ex){
            Logger.getLogger(RegistroEquipoViewController.class.getName()).log(Level.SEVERE,"Error guardando el equipo.", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar equipo", getStage(),"Ocurrio un error guardando el equipo.");
        }         
        
    }
    /**
     * Boton para editar lista de los equipos.
     */
    @FXML
    private void onActionBtnEditarListaEquipos(ActionEvent event) {
    
    }
    /**
     * Boton para eliminar equipos y que de un mensaje de si se elimino o no.
     */
    @FXML
    private void onActionBtnEliminar(ActionEvent event) {
        try{
            if(equipoDto.getnEquipo()==null){
                new Mensaje().showModal(Alert.AlertType.ERROR, "Eliminar Equipo", getStage(), "Debe cargar el equipo que desea eliminar");
            }else{
                EquipoService service= new EquipoService();
                Respuesta respuesta =service.eliminarEquipo(equipoDto.getnEquipo());
                if(!respuesta.getEstado()){
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Elinar equipo", getStage(), respuesta.getMensaje());
                }else{
                    unbindEquipo();
                    equipoDto = (EquipoDto)respuesta.getResultado("Equipo");
                    bindEquipo(false);
                    new Mensaje().showModal(Alert.AlertType.ERROR,"Eliminar equipo",getStage(),"Equipo eliminado correctamente.");
                }
            }
        }catch(Exception ex){
            Logger.getLogger(RegistroEquipoViewController.class.getName()).log(Level.SEVERE,"Error eliminando el equipo",ex);
            new Mensaje().showModal(Alert.AlertType.ERROR,"Eliminar  equipo",getStage(),"Ocurrio un error eliminando el quipo");
        }    
    }
    /**
     * Boton para imprimir en el ImageView la imagen de la camara.
     */
    @FXML
    private void onActionBtnCargarFoto(ActionEvent event) {
        FotoCamara();
    }
    
}

