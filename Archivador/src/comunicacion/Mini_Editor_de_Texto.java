
package comunicacion;

import comunicacion.IArchivador;
import comunicacion.PArchivador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Mini_Editor_de_Texto extends javax.swing.JFrame {

    IArchivador archivador=PArchivador.obtenerArchivador();
    JFileChooser seleccion = new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    
    public Mini_Editor_de_Texto() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void ComprimirTxt(){

        String NOMBRE_TXT = "";
        String NOMBRE_ARCHIVOS_ZIP = "";
        try {
            if (seleccion.showDialog(null, "Seleccionar") == JFileChooser.APPROVE_OPTION) {
                NOMBRE_TXT = seleccion.getSelectedFile().getAbsolutePath();
            }
            if (seleccion.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
                NOMBRE_ARCHIVOS_ZIP = seleccion.getSelectedFile().getAbsolutePath();
            }
            
            if (!NOMBRE_ARCHIVOS_ZIP.endsWith("zip")) {
                NOMBRE_ARCHIVOS_ZIP+=".zip";
            }
            FileOutputStream fos = new FileOutputStream(NOMBRE_ARCHIVOS_ZIP);
            ZipOutputStream zos = new JarOutputStream(fos);
            
            File archivoLenguajes = new File(NOMBRE_TXT);
            FileInputStream fis = new FileInputStream(archivoLenguajes);
            
            ZipEntry ze = new JarEntry(archivoLenguajes.getName());
            zos.putNextEntry(ze);
            
            byte[] bytxt = new byte[1024];
            int longitud;
            
            while ((longitud = fis.read(bytxt)) >= 0) {                
                zos.write(bytxt, 0 , longitud);
            }
            
            zos.close();
            fis.close();
            fos.close();
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error:"+e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TextAreaEditor = new javax.swing.JTextArea();
        BtnCargar = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        BtnComprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextAreaEditor.setColumns(20);
        TextAreaEditor.setRows(5);
        jScrollPane1.setViewportView(TextAreaEditor);

        BtnCargar.setText("Cargar");
        BtnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCargarActionPerformed(evt);
            }
        });

        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        BtnComprimir.setText("Comprimir");
        BtnComprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnComprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnComprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnCargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnCargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnComprimir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCargarActionPerformed
        if (seleccion.showDialog(null, "Abrir txt") == JFileChooser.APPROVE_OPTION) {
            archivo=seleccion.getSelectedFile();
            TextAreaEditor.setText(archivador.cargar(archivo.getAbsolutePath()));
        }
    }//GEN-LAST:event_BtnCargarActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        if (seleccion.showDialog(null, "Guardar txt") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccion.getSelectedFile();
            String doc = TextAreaEditor.getText();
            archivador.guardar(archivo.getAbsolutePath() + ".txt", doc);
        }
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnComprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnComprimirActionPerformed
        ComprimirTxt();
    }//GEN-LAST:event_BtnComprimirActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mini_Editor_de_Texto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCargar;
    private javax.swing.JButton BtnComprimir;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JTextArea TextAreaEditor;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
