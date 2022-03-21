package cr.ac.una.tarea.util;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class VentanaJFrame extends javax.swing.JFrame {
    
        private static VentanaJFrame window = null;
        private Executor executor = Executors.newSingleThreadExecutor();
        private AtomicBoolean initialized = new AtomicBoolean(false);
        private Webcam webcam = null;
        private WebcamPanel panel = null;

    public VentanaJFrame() {
    }
     
    public void initVentanaJFrame() {
        initComponents();
        //se crea una instancia de webcam
        webcam = Webcam.getDefault();
        webcam.setViewSize(webcam.getViewSizes()[0]);
        
        //se crea un panel para la imagen
        panel = new WebcamPanel(webcam, false);
        panel.setPreferredSize(webcam.getViewSize());
        panel.setOpaque(true);
        panel.setBackground(Color.BLUE);
        //establecer el tamaño y ubicacion del panel
        panel.setBounds(0, 0, 400, 300);
        jPanelCamara.add(panel);
        
        if(initialized.compareAndSet(false, true)){
            executor.execute(new Runnable(){
                @Override
                public void run() {
                   panel.start();
      
                }
            });
        }
    }
    
    public void runVentanaJFrame(VentanaJFrame window){
        this.window = window;
        initVentanaJFrame();
        window.setVisible(true);
    }
    
    public void cerrar(){
        webcam.close();
        panel.removeAll();
        jPanelCamara.removeAll();
        window.dispose();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCamara = new javax.swing.JPanel();
        btnTomarFoto = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnTomarFoto.setText("Tomar foto");
        btnTomarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTomarFotoActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCamaraLayout = new javax.swing.GroupLayout(jPanelCamara);
        jPanelCamara.setLayout(jPanelCamaraLayout);
        jPanelCamaraLayout.setHorizontalGroup(
            jPanelCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCamaraLayout.createSequentialGroup()
                .addContainerGap(402, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCamaraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnTomarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelCamaraLayout.setVerticalGroup(
            jPanelCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCamaraLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnSalir)
                .addGap(18, 18, 18)
                .addComponent(btnTomarFoto)
                .addContainerGap(220, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelCamara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCamara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTomarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTomarFotoActionPerformed
        try {
            BufferedImage image = webcam.getImage();
            //nombre y formato de la imagen de salida
            
            ImageIO.write(image, "PNG", new File("D:/carpeta U/Primer semestre 2021/Programacion II/Practicas/Tarea Progra/Tarea/src/main/resources/cr/ac/una/tarea/resources/ImagenNueva.PNG"));
            
            //RegistroEquipoViewController.FotoCamara(File.class);
        } catch (IOException ex) {
            Logger.getLogger(VentanaJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTomarFotoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        window.cerrar();
    }//GEN-LAST:event_btnSalirActionPerformed
    
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTomarFoto;
    private javax.swing.JPanel jPanelCamara;
    // End of variables declaration//GEN-END:variables
}
