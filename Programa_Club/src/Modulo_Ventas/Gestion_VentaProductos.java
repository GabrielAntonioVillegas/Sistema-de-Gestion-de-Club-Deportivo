/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Ventas;

import javax.swing.JOptionPane;

/**
 *
 * @author tm_galli
 */
//Gestion Venta de Producto
public class Gestion_VentaProductos extends javax.swing.JFrame {
    //Constructor
    public Gestion_VentaProductos() {
        initComponents();
        Modulo_Ventas.CrudVentaProductos objetoVentaProductos = new Modulo_Ventas.CrudVentaProductos();
        objetoVentaProductos.MostrarProductos(Tabla_productosVenta);
        objetoVentaProductos.MostrarProductosNoDisponibles(Tabla_Productos);
        JTextField_IDProducto.setEnabled(false);
        JTextField_ProductoNombre.setEnabled(false);
        Btn_Guardar.setEnabled(false);
        Btn_Eliminar.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_volver = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_productosVenta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla_Productos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        JTextField_ProductoNombre = new javax.swing.JTextField();
        Btn_Guardar = new javax.swing.JButton();
        Btn_Eliminar = new javax.swing.JButton();
        JTextField_IDProducto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btn_volver.setText("<-----");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });
        getContentPane().add(btn_volver);
        btn_volver.setBounds(10, 11, 61, 23);

        jPanel3.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(31, 50, 69));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("GESTION DE VENTA DE PRODUCTOS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(532, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(450, 450, 450))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4);
        jPanel4.setBounds(0, 0, 1240, 40);

        jPanel1.setBackground(new java.awt.Color(47, 94, 141));

        Tabla_productosVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla_productosVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_productosVentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_productosVenta);

        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("PRODUCTOS A LA VENTA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(383, 383, 383))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(jPanel1);
        jPanel1.setBounds(330, 50, 910, 500);

        jPanel2.setBackground(new java.awt.Color(47, 94, 141));

        Tabla_Productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tabla_Productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_ProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabla_Productos);

        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText(" PRODUCTOS NO EN VENTA");

        Btn_Guardar.setText("PONER A LA VENTA");
        Btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_GuardarActionPerformed(evt);
            }
        });

        Btn_Eliminar.setText("QUITAR DE LA VENTA");
        Btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EliminarActionPerformed(evt);
            }
        });

        jButton1.setText("DEFINIR PRECIO DE ENVIO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btn_Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(JTextField_IDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTextField_ProductoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(92, 92, 92))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextField_ProductoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextField_IDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Btn_Guardar)
                .addGap(18, 18, 18)
                .addComponent(Btn_Eliminar)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel2);
        jPanel2.setBounds(0, 50, 320, 500);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 1240, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Boton volver al menu
    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        Pantalla_Ventas vV= new Pantalla_Ventas();
        this.setVisible(false);
        vV.setLocationRelativeTo(null);
        vV.setVisible(true);
        //vV.setSize(400,440);
    }//GEN-LAST:event_btn_volverActionPerformed
    
    //Seleccionar producto
    private void Tabla_ProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_ProductosMouseClicked
        Btn_Guardar.setEnabled(true);
        Btn_Eliminar.setEnabled(false);  // Desactivar el botón Eliminar
        Modulo_Ventas.CrudVentaProductos objetoVentaProductos = new Modulo_Ventas.CrudVentaProductos();
        objetoVentaProductos.SeleccionarProductos(Tabla_Productos, JTextField_IDProducto, JTextField_ProductoNombre);
    }//GEN-LAST:event_Tabla_ProductosMouseClicked
    
    //Boton Guardar
    private void Btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_GuardarActionPerformed
        Modulo_Ventas.CrudVentaProductos objetoVentaProductos = new Modulo_Ventas.CrudVentaProductos();
        objetoVentaProductos.PonerProductosVenta(JTextField_IDProducto);
        Btn_Guardar.setEnabled(false);
        Tabla_Productos.clearSelection();
        Tabla_Productos.clearSelection();
        Tabla_productosVenta.clearSelection();
        objetoVentaProductos.MostrarProductos(Tabla_productosVenta);
        objetoVentaProductos.MostrarProductosNoDisponibles(Tabla_Productos);

    }//GEN-LAST:event_Btn_GuardarActionPerformed
    
    //Boton Eliminar
    private void Btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EliminarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(
        null,
        "¿Estás seguro de que deseas eliminar este producto en venta?",
        "Confirmar eliminación",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.WARNING_MESSAGE
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                Modulo_Ventas.CrudVentaProductos objetoVentaProductos = new Modulo_Ventas.CrudVentaProductos();
                objetoVentaProductos.EliminarDescuentoProducto(JTextField_IDProducto);
                Btn_Eliminar.setEnabled(false);
                objetoVentaProductos.MostrarProductos(Tabla_productosVenta);
                objetoVentaProductos.MostrarProductosNoDisponibles(Tabla_Productos);
            } catch (Exception e) {
                System.err.println("Error al eliminar el producto de la venta: " + e.getMessage());
            }
        } else {
            // Si el usuario selecciona "No", no se realiza ninguna acción.
            JOptionPane.showMessageDialog(null, "Eliminación cancelada.", "Acción cancelada", JOptionPane.INFORMATION_MESSAGE);
        }
        Tabla_Productos.clearSelection();
        Tabla_productosVenta.clearSelection();
    }//GEN-LAST:event_Btn_EliminarActionPerformed
    
    //Seleccionar productos en venta
    private void Tabla_productosVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_productosVentaMouseClicked
        Btn_Eliminar.setEnabled(true);
        Btn_Guardar.setEnabled(false);  // Desactivar el botón Guardar
        Modulo_Ventas.CrudVentaProductos objetoVentaProductos = new Modulo_Ventas.CrudVentaProductos();
        objetoVentaProductos.SeleccionarProductos(Tabla_productosVenta, JTextField_IDProducto, JTextField_ProductoNombre);
    }//GEN-LAST:event_Tabla_productosVentaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Ventana_PrecioEnvio ventanita = new Ventana_PrecioEnvio();
        this.setVisible(false);
        ventanita.setVisible(true);
        ventanita.setLocationRelativeTo(null);
        ventanita.setSize(520,520);
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Gestion_VentaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion_VentaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion_VentaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion_VentaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion_VentaProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Eliminar;
    private javax.swing.JButton Btn_Guardar;
    private javax.swing.JTextField JTextField_IDProducto;
    private javax.swing.JTextField JTextField_ProductoNombre;
    private javax.swing.JTable Tabla_Productos;
    private javax.swing.JTable Tabla_productosVenta;
    private javax.swing.JButton btn_volver;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
