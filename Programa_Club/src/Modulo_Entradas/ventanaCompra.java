/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Entradas;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONException;

/**
 *
 * @author Agustín Salinas
 */
public class ventanaCompra extends javax.swing.JFrame {
    BDD.DBConexion conexion = new BDD.DBConexion();
    private int usuarioID;
    private int eventoID;
    private JToggleButton[][] matAsientos;
    private JSONArray jsonAsientos;
    ArrayList<String> arrMiembros = new ArrayList<>();
    ArrayList<Integer> arrDescs = new ArrayList<>();
    ArrayList<Double> arrPrecios = new ArrayList<>();
    /**
     * Creates new form ventanaCompra
     */
    public ventanaCompra(int usuarioID, int eventoID) {
        initComponents();
        this.usuarioID = usuarioID;
        this.eventoID = eventoID;
        
        setChecks();
        
        cargarSectores();
        cmbSectores.setSelectedIndex(0);
        //cmbSectores.setSelectedIndex(0);
        String itemSeleccionado = (String) cmbSectores.getSelectedItem();
            
            // Dividir la cadena usando "_" como delimitador
        int value = Integer.parseInt(itemSeleccionado.split("|")[0].trim());
        String select=(String)cmbSectores.getSelectedItem();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        pnlEntradas = new javax.swing.JPanel();
        pnlGrupo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEntradas = new javax.swing.JTable();
        pnlAsientos = new javax.swing.JPanel();
        cmbSectores = new javax.swing.JComboBox<>();
        btnComprar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlGrupo.setBorder(javax.swing.BorderFactory.createTitledBorder("Grupo de cancha"));

        javax.swing.GroupLayout pnlGrupoLayout = new javax.swing.GroupLayout(pnlGrupo);
        pnlGrupo.setLayout(pnlGrupoLayout);
        pnlGrupoLayout.setHorizontalGroup(
            pnlGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlGrupoLayout.setVerticalGroup(
            pnlGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
        );

        tblEntradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Sector", "Fila", "Asiento", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEntradas.setToolTipText("Entradas");
        tblEntradas.setFocusable(false);
        tblEntradas.setRowHeight(19);
        tblEntradas.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(tblEntradas);
        if (tblEntradas.getColumnModel().getColumnCount() > 0) {
            tblEntradas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblEntradas.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblEntradas.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        pnlAsientos.setBorder(javax.swing.BorderFactory.createTitledBorder("Asientos disponibles"));

        javax.swing.GroupLayout pnlAsientosLayout = new javax.swing.GroupLayout(pnlAsientos);
        pnlAsientos.setLayout(pnlAsientosLayout);
        pnlAsientosLayout.setHorizontalGroup(
            pnlAsientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlAsientosLayout.setVerticalGroup(
            pnlAsientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        cmbSectores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSectoresItemStateChanged(evt);
            }
        });
        cmbSectores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSectoresActionPerformed(evt);
            }
        });

        btnComprar.setText("COMPRAR");
        btnComprar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnComprarMouseClicked(evt);
            }
        });
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("TOTAL:");

        txtTotal.setText("0");
        txtTotal.setEnabled(false);

        btnCancelar.setText("CANCELAR");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEntradasLayout = new javax.swing.GroupLayout(pnlEntradas);
        pnlEntradas.setLayout(pnlEntradasLayout);
        pnlEntradasLayout.setHorizontalGroup(
            pnlEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEntradasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAsientos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEntradasLayout.createSequentialGroup()
                        .addComponent(pnlGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEntradasLayout.createSequentialGroup()
                        .addGap(0, 532, Short.MAX_VALUE)
                        .addComponent(btnCancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEntradasLayout.createSequentialGroup()
                        .addComponent(cmbSectores, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnComprar)))
                .addContainerGap())
        );
        pnlEntradasLayout.setVerticalGroup(
            pnlEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEntradasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnlGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlEntradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSectores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComprar)
                    .addComponent(jLabel1)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlAsientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSectoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSectoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSectoresActionPerformed

    private void cmbSectoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSectoresItemStateChanged
        if (evt.getSource()==cmbSectores) {
            String select=(String)cmbSectores.getSelectedItem();
            DefaultTableModel modelo = (DefaultTableModel) tblEntradas.getModel();
            modelo.setRowCount(1);
            modelo.setValueAt(null, 0, 1);
            modelo.setValueAt(null, 0, 2);
            modelo.setValueAt(null, 0, 3);
            modelo.setValueAt(null, 0, 4);
            
            try{String consulta = "SELECT Asientos FROM Sector_Evento WHERE IdSector=? AND IdEvento=?;";

                PreparedStatement ps = conexion.Conectar().prepareStatement(consulta);
                System.out.println(select.split("|")[0].trim());
                ps.setInt(1, Integer.parseInt(select.split("|")[0].trim()));
                ps.setInt(2, eventoID);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    String jsonData = rs.getString("Asientos");
                    jsonAsientos = new JSONArray(jsonData);
                    
                    for(int f = 0; f<jsonAsientos.length(); f++){
                        for(int c = 0; c<jsonAsientos.getJSONArray(0).length(); c++){
                            matAsientos[f][c]=new JToggleButton();
                            matAsientos[f][c].setBounds(f*40 +5, c*40 +5, 40, 40);
                            matAsientos[f][c].setText("");
                            if(jsonAsientos.getJSONArray(f).getInt(c) == 0 && matAsientos[f][c].isEnabled()){
                                matAsientos[f][c].setEnabled(false);}
                            
                            final int fila = f;  // Usamos 'final' para que esté disponible dentro de la clase anónima
                            final int columna = c;  // Usamos 'final' también para columna
                            matAsientos[f][c].addItemListener(new ItemListener() {
                                    @Override
                                    public void itemStateChanged(ItemEvent e) {
                                    if(e.getStateChange() == ItemEvent.SELECTED){
                                        try{
                                            String consulta = "SELECT solicitarAsiento(?,?,?,?) AS libre;";

                                            PreparedStatement ps = conexion.Conectar().prepareStatement(consulta);
                                            ps.setInt(1, fila);
                                            ps.setInt(2, columna);
                                            String sect =select.split("|")[0].trim();
                                            ps.setInt(3, Integer.parseInt(sect));
                                            ps.setInt(4, eventoID);
                                            ResultSet rs = ps.executeQuery();
                                            if(rs.next()){
                                                boolean libre= rs.getBoolean("libre");
                                                DefaultTableModel modelo = (DefaultTableModel) tblEntradas.getModel();
                                                if(libre){
                                                    jsonAsientos.getJSONArray(fila).put(columna,2);
                                                    for (int r = 0; r < modelo.getRowCount(); r++) {
                                                        Object asiento = modelo.getValueAt(r, 3);
                                                        if (asiento == null) {
                                                            String item = (String) cmbSectores.getSelectedItem();
                                                            modelo.setValueAt(item.split("| ")[1], r, 1);
                                                            modelo.setValueAt(fila, r, 2);
                                                            modelo.setValueAt(columna, r, 3);
                                                            int descuento = arrDescs.get(arrMiembros.indexOf(modelo.getValueAt(r, 0)));
                                                            double coste = arrPrecios.get(cmbSectores.getSelectedIndex());
                                                            modelo.setValueAt(coste-((descuento*coste)/100), r, 4);
                                                            txtTotal.setText(String.valueOf(Double.parseDouble(txtTotal.getText()) + (coste-((descuento*coste)/100))));
                                                            JOptionPane.showMessageDialog(null, "Se le ha aplicado un descuento del: "+String.valueOf(descuento)+'%');
                                                            break;
                                                        }}
                                                }else{
                                                    JOptionPane.showMessageDialog(null, "El asiento ya está ocupado");
                                                    jsonAsientos.getJSONArray(fila).put(columna,0);
                                                }
                                                uptBotones();
                                            }
                                        }catch(Exception e2){
                                            JOptionPane.showMessageDialog(null, "Error al conusltar asiento: "+e2.toString());
                                        }finally{
                                            conexion.Desconectar();
                                        }
                                    }else{
                                        try{
                                            String consulta = "CALL liberarAsiento(?,?,?,?);";

                                            PreparedStatement ps = conexion.Conectar().prepareStatement(consulta);
                                            ps.setInt(1, fila);
                                            ps.setInt(2, columna);
                                            String item = (String) cmbSectores.getSelectedItem();
                                            ps.setInt(3, Integer.parseInt(item.split("| ")[0].trim()));
                                            ps.setInt(4, eventoID);
                                            ps.executeUpdate();
                                            
                                            DefaultTableModel modelo = (DefaultTableModel) tblEntradas.getModel();
                                            for (int r = 0; r < modelo.getRowCount(); r++) {
                                                Object fil = modelo.getValueAt(r, 2);
                                                Object asiento = modelo.getValueAt(r, 3);
                                                if (asiento!=null && (Integer)asiento == columna && (Integer)fil == fila) {
                                                    modelo.setValueAt(null, r, 1);
                                                    modelo.setValueAt(null, r, 2);
                                                    modelo.setValueAt(null, r, 3);
                                                    modelo.setValueAt(null, r, 4);
                                                    break;
                                                }
                                            }
                                            uptBotones();
                                        }catch(Exception e2){
                                            JOptionPane.showMessageDialog(null, "Error al conusltar asiento: "+e2.toString());
                                        }finally{
                                            conexion.Desconectar();
                                        }
                                    }}
                                });
                            if(jsonAsientos.getJSONArray(f).getInt(c) == 0){
                                matAsientos[f][c].setEnabled(false);
                            }
                            pnlAsientos.add(matAsientos[f][c]);
                        }
                    }
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al consultar asientos: "+e.toString());
            }finally{
                conexion.Desconectar();
            }
        }
    }//GEN-LAST:event_cmbSectoresItemStateChanged

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnComprarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprarMouseClicked
        boolean espacio = false;
        DefaultTableModel modelo = (DefaultTableModel) tblEntradas.getModel();
        for (int f = 0; f < modelo.getRowCount(); f++) {
            Object asiento = modelo.getValueAt(f, 3);
            if (asiento == null) {
                espacio = true;
                break;}
        }
        if(espacio == false){
        //this.setEnabled(false);
        /*ventanaTarjeta wPago = new ventanaTarjeta(tblEntradas);
        wPago.setLocationRelativeTo(null);
        wPago.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // Solo cierra la ventanaTarjeta
        wPago.setVisible(true);
        wPago.toFront();  // Mueve la ventana secundaria al frente
        wPago.requestFocus();*/
            dialogTarjeta dialog = new dialogTarjeta(ventanaCompra.this,true,tblEntradas,cmbSectores,txtTotal,usuarioID,eventoID);
            dialog.setVisible(true);
        }else{
           JOptionPane.showMessageDialog(null, "Falta completar entradas"); 
        }
    }//GEN-LAST:event_btnComprarMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        DefaultTableModel modelo = (DefaultTableModel) tblEntradas.getModel();
        for (int f = 0; f < modelo.getRowCount(); f++) {
            Object celda = modelo.getValueAt(f, 3);
            if (celda != null) {
                try{
                    String consulta = "CALL liberarAsiento(?,?,?,?);";

                    PreparedStatement ps = conexion.Conectar().prepareStatement(consulta);
                    ps.setInt(1, (Integer) modelo.getValueAt(f, 2));
                    ps.setInt(2, (Integer) modelo.getValueAt(f, 3));
                    String item = (String) cmbSectores.getSelectedItem();
                    System.out.println(item.split("|")[0].trim());
                    ps.setInt(3, Integer.valueOf(item.split("| ")[0].trim()));
                    ps.setInt(4, 1);
                    ps.executeUpdate();
                }catch(Exception e2){
                    JOptionPane.showMessageDialog(null, "Error al liberar asiento: "+e2.toString());
                }finally{
                    conexion.Desconectar();}
            }
        }
        Principal principal = new Principal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
        principal.setSize(900,520);
        principal.setResizable(false);
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    /**
     * @param args the command line arguments
     */
    private void setChecks(){
        try{
            int ejeY =5;
            String consulta = "SELECT U.IDUsuario, U.Nombre_usuario, SS.ID, C.CompraID, M.Descuento " +
                        "FROM Usuario U INNER JOIN Grupo G ON U.IDUsuario=G.IDUsuario " +
                        "LEFT JOIN Compra C ON U.IDUsuario = C.IDUsuario AND C.IdEvento = ? " +
                        "LEFT JOIN Socio S ON U.IDUsuario=S.IDUsuario " +
                        "LEFT JOIN Socios_Suspendidos SS ON S.IDUsuario=SS.ID_Usuario " +
                        "LEFT JOIN Membresia M ON S.IDMembresia=M.IDMembresia " +
                        "WHERE G.GrupoID=(SELECT GrupoID FROM Grupo WHERE IDUsuario=?);";
            
            PreparedStatement ps = conexion.Conectar().prepareStatement(consulta);
            ps.setInt(1, eventoID);
            ps.setInt(2, usuarioID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                String nombreUsuario= rs.getString("Nombre_usuario");
                int compra= rs.getInt("CompraID");
                int suspendido= rs.getInt("ID");
                
                JCheckBox box = new JCheckBox(nombreUsuario);
                box.setBounds(10,ejeY+38,130,23);
                
                if(!rs.wasNull() || compra!=0){
                    box.setEnabled(false);
                }else{
                    int Descuento= rs.getInt("Descuento");
                    int Id= rs.getInt("IDUsuario");
                    if(Id==usuarioID){
                        box.setText(nombreUsuario+"(Tú)");
                        box.setBounds(10,20,130,23);
                        box.setSelected(true);
                        box.setEnabled(false);
                        DefaultTableModel modelo = (DefaultTableModel) tblEntradas.getModel();
                        modelo.addRow(new Object[]{nombreUsuario,null,null,null,null});
                        arrMiembros.add(nombreUsuario);
                        arrDescs.add(0,Descuento);
                    }else{
                        box.addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            DefaultTableModel modelo = (DefaultTableModel) tblEntradas.getModel();
                            
                            if(e.getStateChange() == ItemEvent.SELECTED){
                                modelo.addRow(new Object[]{nombreUsuario,null,null,null,null});
                            }else{
                                for (int r = 0; r < modelo.getRowCount(); r++) {
                                    if(modelo.getValueAt(r, 0)==nombreUsuario){
                                        modelo.removeRow(r);}}
                            }
                            uptBotones();
                        }
                    });
                        arrMiembros.add(nombreUsuario);
                        arrDescs.add(Descuento);
                        ejeY+=23;
                    }
                }
                pnlGrupo.add(box);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al conusltar grupo: "+e.toString());
        }finally{
            conexion.Desconectar();
            System.out.println("checkslistos");
        }
    }
    
    private void cargarSectores(){
        try{
                String consulta = "SELECT S.idSector, S.NombreSector, SE.Precio FROM Sector S " +
                        "INNER JOIN Sector_Evento SE ON SE.IdSector=S.IdSector WHERE SE.IdEvento=?;";

                PreparedStatement ps = conexion.Conectar().prepareStatement(consulta);
                ps.setInt(1, eventoID);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int id= rs.getInt("idSector");
                    String nombre= rs.getString("NombreSector");
                    double precio= rs.getDouble("Precio");

                    arrPrecios.add(precio);
                    cmbSectores.addItem(String.format("%" + 3 + "s",String.valueOf(id))+"| "+nombre);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al conusltar sectores: "+e.toString());
            }finally{
                conexion.Desconectar();
                
            //String select=(String)cmbSectores.getSelectedItem();
            System.out.println("sectoreslistos");
            }
    }
    
    private void uptBotones(){
        try{boolean espacio = false;
            DefaultTableModel modelo = (DefaultTableModel) tblEntradas.getModel();
            for (int f = 0; f < modelo.getRowCount(); f++) {
                Object celda = modelo.getValueAt(f, 3);
                if (celda == null) {
                    espacio = true;
                    break;
                }
            }
            for(int f = 0; f<jsonAsientos.length(); f++){
                for(int c = 0; c<jsonAsientos.getJSONArray(0).length(); c++){
                    if(espacio==false && jsonAsientos.getJSONArray(f).getInt(c) != 2){
                        matAsientos[f][c].setEnabled(false);}
                    if(jsonAsientos.getJSONArray(f).getInt(c) == 0 && matAsientos[f][c].isEnabled()){
                        matAsientos[f][c].setEnabled(false);}
                    if(jsonAsientos.getJSONArray(f).getInt(c) == 1 && !matAsientos[f][c].isEnabled()){
                        matAsientos[f][c].setEnabled(true);}
                }
            }
        }catch(JSONException e){
            JOptionPane.showMessageDialog(null, "Error de json: "+e.toString());
        }
    }
    
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
            java.util.logging.Logger.getLogger(ventanaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanaCompra(9,1).setVisible(true);
            }
        });
    }
    public JTable getTable() {
        return tblEntradas;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnComprar;
    protected javax.swing.JComboBox<String> cmbSectores;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlAsientos;
    private javax.swing.JPanel pnlEntradas;
    private javax.swing.JPanel pnlGrupo;
    protected javax.swing.JTable tblEntradas;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
