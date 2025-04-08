package Modulo_Ventas;

import ModuloUsuarios1.InicioAdmin;
import programa_club.Main;
import Modulo_Ventas.Gestion_Productos;
import Modulo_Ventas.Gestion_Categorias;
import Modulo_Ventas.Gestion_Descuento;
import Modulo_Ventas.Gestion_Reembolso;
import Modulo_Ventas.VerificarBotonMenu;
import Modulo_Ventas.Usuario.Ingreso_Usuario;
import Modulo_Ventas.Gestion_Pedidos;

//Gestionar menu
public class Pantalla_Ventas extends javax.swing.JFrame {
    //Declaracion de variables
    private final VerificarBotonMenu consultasBDD = new VerificarBotonMenu();
    private int IDAdministrador = 0;
    public Pantalla_Ventas() {
        
        initComponents();
        verificarBotones();
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Volver = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Btn_Gestionar_Categoria = new javax.swing.JButton();
        Btn_Gestionar_Productos = new javax.swing.JButton();
        Btn_Gestionar_Descuento = new javax.swing.JButton();
        Btn_Gestionar_VentaProductos = new javax.swing.JButton();
        Btn_Gestionar_Pedidos = new javax.swing.JButton();
        Btn_Gestionar_Reembolso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 50, 69));
        jPanel1.setPreferredSize(new java.awt.Dimension(390, 400));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText(" Gestion de Ventas");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(140, 20, 130, 17);

        Volver.setText("<--");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        jPanel1.add(Volver);
        Volver.setBounds(10, 17, 62, 23);

        jPanel2.setBackground(new java.awt.Color(47, 94, 141));

        Btn_Gestionar_Categoria.setText("Gestionar Categoria");
        Btn_Gestionar_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Gestionar_CategoriaActionPerformed(evt);
            }
        });

        Btn_Gestionar_Productos.setText("Gestionar Productos");
        Btn_Gestionar_Productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Gestionar_ProductosActionPerformed(evt);
            }
        });

        Btn_Gestionar_Descuento.setText("Gestionar Descuentos");
        Btn_Gestionar_Descuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Gestionar_DescuentoActionPerformed(evt);
            }
        });

        Btn_Gestionar_VentaProductos.setText("Gestion Venta de Productos");
        Btn_Gestionar_VentaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Gestionar_VentaProductosActionPerformed(evt);
            }
        });

        Btn_Gestionar_Pedidos.setText("Gestionar Pedidos");
        Btn_Gestionar_Pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Gestionar_PedidosActionPerformed(evt);
            }
        });

        Btn_Gestionar_Reembolso.setText("Gestionar Reembolso");
        Btn_Gestionar_Reembolso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Gestionar_ReembolsoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btn_Gestionar_Categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_Gestionar_Pedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_Gestionar_Reembolso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_Gestionar_VentaProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Gestionar_Descuento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_Gestionar_Productos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(97, 97, 97))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(Btn_Gestionar_Categoria)
                .addGap(17, 17, 17)
                .addComponent(Btn_Gestionar_Productos)
                .addGap(17, 17, 17)
                .addComponent(Btn_Gestionar_Descuento)
                .addGap(17, 17, 17)
                .addComponent(Btn_Gestionar_VentaProductos)
                .addGap(17, 17, 17)
                .addComponent(Btn_Gestionar_Pedidos)
                .addGap(17, 17, 17)
                .addComponent(Btn_Gestionar_Reembolso)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 60, 400, 340);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, 400, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Verificar botones
    private void verificarBotones() {
        Btn_Gestionar_Categoria.setEnabled(true);
        Btn_Gestionar_Productos.setEnabled(consultasBDD.existeCategoria());
        boolean hayProductos = consultasBDD.existeProducto();
        Btn_Gestionar_Descuento.setEnabled(hayProductos);
        Btn_Gestionar_VentaProductos.setEnabled(hayProductos);        
        boolean hayPedidos = consultasBDD.existePedido();
        Btn_Gestionar_Pedidos.setEnabled(hayPedidos);
        boolean hayReembolsos = consultasBDD.existeReembolso();
        Btn_Gestionar_Reembolso.setEnabled(hayReembolsos);
    }
    
    //Boton gestionar
    private void Btn_Gestionar_VentaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Gestionar_VentaProductosActionPerformed
        Gestion_VentaProductos vGVP = new Gestion_VentaProductos();
        this.setVisible(false);
        vGVP.setSize(1250,590);
        vGVP.setLocationRelativeTo(null);
        vGVP.setVisible(true);
    }//GEN-LAST:event_Btn_Gestionar_VentaProductosActionPerformed

    //Boton volver al menu principal
    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        InicioAdmin inicioadmin = new InicioAdmin(IDAdministrador);
        inicioadmin.setVisible(true);
        dispose();
    }//GEN-LAST:event_VolverActionPerformed

    //Boton ingresar al gestion de productos
    private void Btn_Gestionar_ProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Gestionar_ProductosActionPerformed
        // TODO add your handling code here:
        Gestion_Productos  vP = new Gestion_Productos();
        this.setVisible(false);
        //vP.setSize(930,530);
        vP.setLocationRelativeTo(null); 
        vP.setVisible(true);
        
    }//GEN-LAST:event_Btn_Gestionar_ProductosActionPerformed

    //Boton ingresar al gestion de descuentos
    private void Btn_Gestionar_DescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Gestionar_DescuentoActionPerformed
        Gestion_Descuento  vD = new Gestion_Descuento();
        this.setVisible(false);
        vD.setSize(855,570);
        vD.setLocationRelativeTo(null);
        vD.setVisible(true); 

    }//GEN-LAST:event_Btn_Gestionar_DescuentoActionPerformed

    //Boton ingresar al gestion de categorias
    private void Btn_Gestionar_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Gestionar_CategoriaActionPerformed
        // TODO add your handling code here:
        Gestion_Categorias  vC = new Gestion_Categorias();
        this.setVisible(false);
        //vC.setSize(770,560);
        vC.setLocationRelativeTo(null);
        vC.setVisible(true); 
    }//GEN-LAST:event_Btn_Gestionar_CategoriaActionPerformed

    //Boton de gestionar reembolsos
    private void Btn_Gestionar_ReembolsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Gestionar_ReembolsoActionPerformed
        Gestion_Reembolso  vR = new Gestion_Reembolso();
        this.setVisible(false);
        //vR.setSize(500,640);
        vR.setLocationRelativeTo(null);
        vR.setVisible(true);
    }//GEN-LAST:event_Btn_Gestionar_ReembolsoActionPerformed

    //Boton gestionar pedidos
    private void Btn_Gestionar_PedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Gestionar_PedidosActionPerformed
        Gestion_Pedidos  vP = new Gestion_Pedidos();
        this.setVisible(false);
        //vP.setSize(530,440);
        vP.setLocationRelativeTo(null);
        vP.setVisible(true);
    }//GEN-LAST:event_Btn_Gestionar_PedidosActionPerformed

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
            java.util.logging.Logger.getLogger(Pantalla_Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla_Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla_Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla_Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla_Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Gestionar_Categoria;
    private javax.swing.JButton Btn_Gestionar_Descuento;
    private javax.swing.JButton Btn_Gestionar_Pedidos;
    private javax.swing.JButton Btn_Gestionar_Productos;
    private javax.swing.JButton Btn_Gestionar_Reembolso;
    private javax.swing.JButton Btn_Gestionar_VentaProductos;
    private javax.swing.JButton Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
