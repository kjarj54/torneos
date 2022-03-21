/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tarea.util;
import cr.ac.una.tarea.util.VentanaJFrame;
/**
 *
 * @author kevin
 */
public class VistaCamara {
    private VentanaJFrame vista = null;
    
    public void iniciarCam(){
        vista = new VentanaJFrame();
        vista.runVentanaJFrame(vista);
    }
}
