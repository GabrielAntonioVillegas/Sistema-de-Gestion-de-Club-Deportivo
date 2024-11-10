/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Ventas;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.Toolkit;

import Modulo_Ventas.CrudCategoria;
/**
 *
 * @author thiag
 */
//Gestionar Categorias
public class Gestion_Categorias extends javax.swing.JFrame {
    //Declaracion de variables
    private String nombreOriginalCategoria = "";

    //Constructor
    public Gestion_Categorias() {
        initComponents();
        CrudCategoria objetoCategoria = new CrudCategoria();
        objetoCategoria.MostrarCategorias(TablaCategorias);
        this.setLocationRelativeTo(null);
        JTextField_IDCategoria.setEnabled(false);
        ((AbstractDocument) JTextField_nombreCategoria.getDocument()).setDocumentFilter(new LimitDocumentFilter(16));
        ((AbstractDocument) JTextField_nombreCategoria.getDocument()).setDocumentFilter(new LetrasSoloFilter());
        Btn_Guardar.setEnabled(false); // Deshabilitar inicialmente el botón Guardar
        Btn_Mod.setEnabled(false);
        Btn_Eliminar.setEnabled(false);
        JTextField_nombreCategoria.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                toggleGuardarButton();
                toggleModificarButton();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                toggleGuardarButton();
                toggleModificarButton();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                toggleGuardarButton();
                toggleModificarButton();
            }
        });
        
    }
    // Clase interna para limitar la longitud de JTextField
    private class LimitDocumentFilter extends DocumentFilter {
        private final int maxCharacters;

        public LimitDocumentFilter(int maxChars) {
            this.maxCharacters = maxChars;
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (fb.getDocument().getLength() + string.length() <= maxCharacters) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attr) throws BadLocationException {
            if (fb.getDocument().getLength() - length + string.length() <= maxCharacters) {
                super.replace(fb, offset, length, string, attr);
            }
        }
    }
    // Clase interna para restringir solo letras de JTextField
    public class LetrasSoloFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string.matches("[a-zA-Z]+")) {
                super.insertString(fb, offset, string, attr);
            } else {
                Toolkit.getDefaultToolkit().beep(); // Simplemente da una señal, no bloquea.
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text.matches("[a-zA-Z]+")) {
                super.replace(fb, offset, length, text, attrs);
            } else {
                Toolkit.getDefaultToolkit().beep(); // Simplemente da una señal.
            }
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Volver = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JTextField_nombreCategoria = new javax.swing.JTextField();
        Btn_Guardar = new javax.swing.JButton();
        Btn_Mod = new javax.swing.JButton();
        JTextField_IDCategoria = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Btn_Eliminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCategorias = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Volver.setText("<--");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Categoria"));

        jLabel2.setText("Nombre");

        JTextField_nombreCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextField_nombreCategoriaActionPerformed(evt);
            }
        });

        Btn_Guardar.setText("Guardar Categoria");
        Btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_GuardarActionPerformed(evt);
            }
        });

        Btn_Mod.setText("Modificar Categoria");
        Btn_Mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ModActionPerformed(evt);
            }
        });

        JTextField_IDCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextField_IDCategoriaActionPerformed(evt);
            }
        });

        jLabel3.setText("ID");

        Btn_Eliminar.setText("Eliminar Categoria");
        Btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_Mod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTextField_nombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextField_IDCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextField_IDCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextField_nombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(73, 73, 73)
                .addComponent(Btn_Guardar)
                .addGap(18, 18, 18)
                .addComponent(Btn_Mod)
                .addGap(18, 18, 18)
                .addComponent(Btn_Eliminar)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista Categorias"));

        TablaCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaCategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaCategorias);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        jLabel1.setText("Gestion de Categoria");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Volver)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Método que habilita o deshabilita el botón Guardar
    private void toggleGuardarButton() {
        Btn_Guardar.setEnabled(!JTextField_nombreCategoria.getText().trim().isEmpty());
    }
    
    // Método que habilita o deshabilita los botones Modificar y Eliminar
    private void toggleModificarButton() {
        boolean categoriaSeleccionada = !JTextField_IDCategoria.getText().trim().isEmpty();
        boolean nombreNoVacio = !JTextField_nombreCategoria.getText().trim().isEmpty();
        boolean nombreModificado = !JTextField_nombreCategoria.getText().equals(nombreOriginalCategoria);
        Btn_Mod.setEnabled(categoriaSeleccionada && nombreNoVacio && nombreModificado);
    }
    
    // Habilitar el botón Eliminar solo si hay una categoría seleccionada
    private void toggleEliminarButton() {
        Btn_Eliminar.setEnabled(!JTextField_IDCategoria.getText().trim().isEmpty());
    }

    //Volver al menu
    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        Pantalla_Ventas vV= new Pantalla_Ventas();
        this.setVisible(false);
        vV.setSize(500,500);
        vV.setLocationRelativeTo(null);
        vV.setVisible(true);
    }//GEN-LAST:event_VolverActionPerformed

    private void JTextField_nombreCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextField_nombreCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextField_nombreCategoriaActionPerformed
    
    //Boton modificar
    private void Btn_ModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ModActionPerformed
        CrudCategoria objetoCategoria = new CrudCategoria();
        try {
            objetoCategoria.ModificarCategoria(JTextField_IDCategoria, JTextField_nombreCategoria);
            objetoCategoria.MostrarCategorias(TablaCategorias);
            objetoCategoria.LimpiarCampos(JTextField_IDCategoria, JTextField_nombreCategoria);
            nombreOriginalCategoria = ""; // Restablecer el nombre original
            toggleModificarButton(); // Actualizar el estado de los botones
            toggleEliminarButton();
        } catch (Exception e) {
            System.err.println("Error al modificar categoría: " + e.getMessage());
        }
        TablaCategorias.clearSelection();
    }//GEN-LAST:event_Btn_ModActionPerformed

    //Boton Guardar
    private void Btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_GuardarActionPerformed
         CrudCategoria objetoCategoria = new CrudCategoria();
        try {
            // Validar que el campo de nombre no esté vacío
            if (JTextField_nombreCategoria.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre de la categoría no puede estar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
        
            objetoCategoria.InsertarCategoria(JTextField_nombreCategoria);
            objetoCategoria.MostrarCategorias(TablaCategorias);
            objetoCategoria.LimpiarCampos(JTextField_IDCategoria, JTextField_nombreCategoria);
            JTextField_nombreCategoria.setText("");
            nombreOriginalCategoria = ""; 
            toggleModificarButton();
            toggleEliminarButton();
            JOptionPane.showMessageDialog(this, "Categoría guardada exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar la categoría: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error al guardar categoría: " + e.getMessage());
            e.printStackTrace(); 
        }
        TablaCategorias.clearSelection();
    }//GEN-LAST:event_Btn_GuardarActionPerformed

    //Selecionar producto
    private void TablaCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCategoriasMouseClicked
        CrudCategoria objetoCategoria = new CrudCategoria();
        objetoCategoria.SeleccionarCategoria(TablaCategorias, JTextField_IDCategoria, JTextField_nombreCategoria);
        nombreOriginalCategoria = JTextField_nombreCategoria.getText();
        toggleModificarButton();
        toggleEliminarButton();
    }//GEN-LAST:event_TablaCategoriasMouseClicked

    private void JTextField_IDCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextField_IDCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextField_IDCategoriaActionPerformed
    
    //Boton Eliminar
    private void Btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EliminarActionPerformed
        CrudCategoria objetoCategoria = new CrudCategoria();
        try {
            objetoCategoria.EliminarCategoria(JTextField_IDCategoria);
            objetoCategoria.LimpiarCampos(JTextField_IDCategoria, JTextField_nombreCategoria);
            objetoCategoria.MostrarCategorias(TablaCategorias);
            nombreOriginalCategoria = ""; // Restablecer el nombre original
            toggleModificarButton(); // Actualizar el estado de los botones
            toggleEliminarButton();
        } catch (Exception e) {
            System.err.println("Error al eliminar categoría: " + e.getMessage());
        }
        TablaCategorias.clearSelection();
    }//GEN-LAST:event_Btn_EliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gestion_Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion_Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion_Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion_Categorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion_Categorias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Eliminar;
    private javax.swing.JButton Btn_Guardar;
    private javax.swing.JButton Btn_Mod;
    private javax.swing.JTextField JTextField_IDCategoria;
    private javax.swing.JTextField JTextField_nombreCategoria;
    private javax.swing.JTable TablaCategorias;
    private javax.swing.JButton Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
