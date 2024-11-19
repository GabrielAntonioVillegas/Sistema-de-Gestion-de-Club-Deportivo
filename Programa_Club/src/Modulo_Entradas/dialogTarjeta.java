/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Entradas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Agustín Salinas
 */
public class dialogTarjeta extends javax.swing.JDialog {
    BDD.DBConexion conexion = new BDD.DBConexion();
    private int usuarioID;
    private int eventoID;
    private JTable table;
    private JComboBox combo;
    private JTextField total;
    /**
     * Creates new form dialogTarjeta
     */
    public dialogTarjeta(java.awt.Frame parent, boolean modal, JTable table, JComboBox combo,JTextField total, int usuarioID, int eventoID) {
        super(parent, modal);
        this.usuarioID = usuarioID;
        this.eventoID = eventoID;
        this.table=table;
        this.combo=combo;
        this.total=total;
        setLocationRelativeTo(null);
        initComponents();
        System.out.println(spnVencimiento.getValue());
        Date value = (Date)spnVencimiento.getValue(); // Note code convention here
        String formattedValue = new SimpleDateFormat("MM/yyyy").format(value);
        System.out.println(formattedValue);
        cargarTarjetas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNumero = new javax.swing.JTextField();
        cmbTipo = new javax.swing.JComboBox<>();
        btnPagar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cmbTarjetas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spnVencimiento = new rsbuttom.SpinnerMonth();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Crédito", "Débito", "Virtual" }));

        btnPagar.setText("PAGAR");
        btnPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPagarMouseClicked(evt);
            }
        });

        btnCancel.setText("CANCELAR");
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel4.setText("Mes de vencimiento:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Mis tarjetas"));

        cmbTarjetas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTarjetasItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(cmbTarjetas, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbTarjetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setText("N° de tarjeta:");

        jLabel2.setText("Tipo:");

        jLabel3.setText("Código Seguridad:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCodigo)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(spnVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPagar)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPagarMouseClicked
        // TODO add your handling code here:
        try{
            if(txtNumero.getText().length()>19 || txtNumero.getText().length()<14){
                throw new Exception("Número de tarjeta inválido");
            }
            String consulta = "SELECT validarTarjeta(?,?,?,?,?,?) AS retorno;";
            
            PreparedStatement ps = conexion.Conectar().prepareStatement(consulta);
                ps.setInt(1, Integer.parseInt(txtNumero.getText()));
                ps.setInt(2, usuarioID);
                ps.setString(3, (String)cmbTipo.getSelectedItem());
                Date fechaSeleccionada = (Date) spnVencimiento.getValue();
                // Convertir a java.sql.Date para almacenar en MySQL
                java.sql.Date sqlDate = new java.sql.Date(fechaSeleccionada.getTime());
                ps.setDate(4, sqlDate);
                ps.setInt(5, Integer.valueOf(txtCodigo.getText()));
                ps.setDouble(6, Double.parseDouble(total.getText()));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String retorno = rs.getString("retorno");
                if(retorno.equals("1")){
                    try {
                        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
                        for (int f = 0; f < modelo.getRowCount(); f++) {
                            String consulta2 = "INSERT INTO Compra (IDUsuario,TarjetaID,IdSector,IdEvento,filaAsiento,Asiento,Coste,Fecha) VALUES (" +
                                        "(SELECT IDUsuario FROM Usuario WHERE Nombre_usuario =? LIMIT 1)," +
                                        "(SELECT TarjetaID FROM Tarjeta WHERE NumeroTarjeta =? LIMIT 1)," +
                                        "?,?,?,?,?,CURDATE());";

                            ps = conexion.getConexion().prepareStatement(consulta2);
                            ps.setInt(1, usuarioID);
                            ps.setInt(2, Integer.parseInt(txtNumero.getText()));
                            String item = (String) combo.getSelectedItem();
                            ps.setInt(3, Integer.valueOf(item.split("\\| ")[0].trim()));
                            ps.setInt(4, eventoID);
                            ps.setInt(5, (Integer) table.getValueAt(f, 2)-1);
                            ps.setInt(6, (Integer) table.getValueAt(f, 3)-1);
                            ps.setDouble(7, 0);
                            if(f==0){
                                ps.setDouble(7, Double.parseDouble(total.getText()));
                            }else{
                                String consultaNot = "INSERT INTO Notificacion (Asunto, Enunciado,IDUsuario) " +
                                                    "SELECT 'Has recibido una entrada', " +
                                                    "CONCAT('De: ', ?, ', al evento: ', E.nombreEvento), U.IDUsuario " +
                                                    "FROM Usuario U JOIN Evento E ON E.idEvento = ? " +
                                                    "WHERE U.Nombre_usuario = ?;";

                                PreparedStatement ps2 = conexion.getConexion().prepareStatement(consultaNot);
                                ps.setString(1, (String) table.getValueAt(0, 0));
                                ps.setInt(2, eventoID);
                                ps2.setString(3, (String) table.getValueAt(f, 0));
                                ps2.executeUpdate();
                            }
                            ps.executeUpdate();
                        }
                        String consulta3 = "UPDATE Cuenta SET saldo = saldo + ? WHERE id_cuenta = ?;";
                        ps = conexion.getConexion().prepareStatement(consulta3);
                        ps.setDouble(1, Double.parseDouble(total.getText()));
                        ps.setInt(2, 7);
                        ps.executeUpdate();
                        
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al comprar: " + e.toString());
                    }
                }else{
                    throw new Exception(retorno);
                }
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al consultar tarjeta: " + e.toString());
        } finally {
            conexion.Desconectar();
        }
    }//GEN-LAST:event_btnPagarMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void cmbTarjetasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTarjetasItemStateChanged
        if (evt.getSource()==cmbTarjetas) {
            String select=(String)cmbTarjetas.getSelectedItem();
            try{String consulta = "SELECT NumeroTarjeta, Tipo, Vencimiento FROM Tarjeta WHERE NumeroTarjeta=?;";

                PreparedStatement ps = conexion.Conectar().prepareStatement(consulta);
                ps.setInt(1, Integer.parseInt(select.split("\\| ")[0].trim()));
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    int numero = rs.getInt("NumeroTarjeta");
                    String tipo = rs.getString("Tipo");
                    txtNumero.setText(String.valueOf(numero));
                    cmbTipo.setSelectedItem(tipo);

                    java.sql.Date sqlDate = rs.getDate("Vencimiento");
                    // Convertirlo a Date de Java (java.util.Date)
                    Date vencimiento = new Date(sqlDate.getTime());
                    // Establecer el valor del JSpinner
                    spnVencimiento.setValue(vencimiento);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al consultar tarjetas: "+e.toString());
            }finally{
                conexion.Desconectar();
            }
        }
    }//GEN-LAST:event_cmbTarjetasItemStateChanged
    
    private void cargarTarjetas(){
        try{
            String consulta = "SELECT NumeroTarjeta, Tipo, Saldo FROM Tarjeta WHERE IDUsuario=?;";
            
            PreparedStatement ps = conexion.Conectar().prepareStatement(consulta);
            ps.setInt(1, 1);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int numero= rs.getInt("NumeroTarjeta");
                String tipo= rs.getString("Tipo");
                double saldo= rs.getDouble("Saldo");
                
                cmbTarjetas.addItem(String.format("%-"+19+"s",String.valueOf(numero))+"|"+String.format("%-" + 7 + "s",tipo)
                        +"| Saldo:"+String.valueOf(saldo));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al cargar tarjetas: "+e.toString());
        }finally{
            conexion.Desconectar();
        }
    }
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
            java.util.logging.Logger.getLogger(dialogTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dialogTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dialogTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dialogTarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dialogTarjeta dialog = new dialogTarjeta(new javax.swing.JFrame(), true, new JTable(),new JComboBox(), new JTextField(),9,1);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnPagar;
    private javax.swing.JComboBox<String> cmbTarjetas;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private rsbuttom.SpinnerMonth spnVencimiento;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
