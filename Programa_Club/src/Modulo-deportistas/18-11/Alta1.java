/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

/**
 *
 * @author tm_galli
 */
public class Alta1 extends javax.swing.JFrame {

    /**
     * 
     */
    
    
    public Alta1() {
        initComponents();
        label_aviso.setVisible(false);
        label_aviso2.setVisible(false);
        label_aviso3.setVisible(false);
        label_aviso4.setVisible(false);
        label_aviso5.setVisible(false);
        label_aviso6.setVisible(false);
        
        txtNom.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent evt){
            
            if(txtNom.getText().length() >= 10){
                evt.consume();
            }
        
                
            }
        });
        
            txtApe.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent evt){
            
            if(txtApe.getText().length() >= 10){
                evt.consume();
            }
        
                
            }
        });
            txtGmail.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent evt){
            
            if(txtGmail.getText().length() >= 30){
                evt.consume();
            }
        
                
            }
        });
        
            
            
    }
          

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        label_aviso24 = new javax.swing.JLabel();
        label_aviso25 = new javax.swing.JLabel();
        label_aviso26 = new javax.swing.JLabel();
        label_aviso27 = new javax.swing.JLabel();
        label_aviso28 = new javax.swing.JLabel();
        label_aviso29 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnVolverABM1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtApe = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        btnAlta = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtGmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        label_aviso2 = new javax.swing.JLabel();
        label_aviso3 = new javax.swing.JLabel();
        label_aviso4 = new javax.swing.JLabel();
        label_aviso = new javax.swing.JLabel();
        label_aviso6 = new javax.swing.JLabel();
        label_aviso5 = new javax.swing.JLabel();

        jLabel9.setText("jLabel9");

        label_aviso24.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        label_aviso24.setForeground(new java.awt.Color(255, 0, 0));
        label_aviso24.setText("CAMPO OBLIGATORIO");

        label_aviso25.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        label_aviso25.setForeground(new java.awt.Color(255, 0, 0));
        label_aviso25.setText("CAMPO OBLIGATORIO");

        label_aviso26.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        label_aviso26.setForeground(new java.awt.Color(255, 0, 0));
        label_aviso26.setText("CAMPO OBLIGATORIO");

        label_aviso27.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        label_aviso27.setForeground(new java.awt.Color(255, 0, 0));
        label_aviso27.setText("CAMPO OBLIGATORIO");

        label_aviso28.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        label_aviso28.setForeground(new java.awt.Color(255, 0, 0));
        label_aviso28.setText("CAMPO OBLIGATORIO");

        label_aviso29.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        label_aviso29.setForeground(new java.awt.Color(255, 0, 0));
        label_aviso29.setText("MAIL INVALIDO (*)");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 50, 69));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(254, 254, 254));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Alta de deportista");

        jSeparator1.setForeground(new java.awt.Color(8, 6, 6));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Nombre:");

        txtNom.setFont(new java.awt.Font("Waree", 0, 14)); // NOI18N
        txtNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomActionPerformed(evt);
            }
        });
        txtNom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Apellido:");

        jTextField2.setFont(new java.awt.Font("Waree", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Club:");

        btnVolverABM1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnVolverABM1.setText("Volver");
        btnVolverABM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverABM1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Edad:");

        jComboBox1.setFont(new java.awt.Font("Waree", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(31, 50, 69));
        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("Estado:");

        txtApe.setFont(new java.awt.Font("Waree", 0, 14)); // NOI18N
        txtApe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApeActionPerformed(evt);
            }
        });
        txtApe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApeKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("Contacto:");

        jTextField5.setFont(new java.awt.Font("Waree", 0, 14)); // NOI18N
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        btnAlta.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnAlta.setText("Enviar");
        btnAlta.setMaximumSize(new java.awt.Dimension(50, 27));
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Waree", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Promesa", "Profesional" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jTextField6.setFont(new java.awt.Font("Waree", 0, 14)); // NOI18N
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setText("DNI:");

        txtGmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGmailActionPerformed(evt);
            }
        });
        txtGmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGmailKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGmailKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(254, 254, 254));
        jLabel10.setText("Mail:");

        label_aviso2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        label_aviso2.setForeground(new java.awt.Color(255, 0, 0));
        label_aviso2.setText("CAMPO OBLIGATORIO");

        label_aviso3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        label_aviso3.setForeground(new java.awt.Color(255, 0, 0));
        label_aviso3.setText("CAMPO OBLIGATORIO");

        label_aviso4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        label_aviso4.setForeground(new java.awt.Color(255, 0, 0));
        label_aviso4.setText("CAMPO OBLIGATORIO");

        label_aviso.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        label_aviso.setForeground(new java.awt.Color(255, 0, 0));
        label_aviso.setText("MAIL INVALIDO (*)");

        label_aviso6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        label_aviso6.setForeground(new java.awt.Color(255, 0, 0));
        label_aviso6.setText("CAMPO OBLIGATORIO");

        label_aviso5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        label_aviso5.setForeground(new java.awt.Color(255, 0, 0));
        label_aviso5.setText("CAMPO OBLIGATORIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVolverABM1)
                        .addGap(143, 143, 143)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label_aviso2))
                                .addComponent(txtNom, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label_aviso3))
                                .addComponent(jLabel5)
                                .addComponent(txtApe))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label_aviso4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_aviso))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(label_aviso5))
                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label_aviso6))
                                .addComponent(jComboBox2, 0, 241, Short.MAX_VALUE)
                                .addComponent(jTextField5)
                                .addComponent(txtGmail)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(btnVolverABM1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(label_aviso2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(label_aviso5)
                    .addComponent(label_aviso3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(label_aviso6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(label_aviso)
                    .addComponent(label_aviso4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtGmail)
                    .addComponent(jTextField6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverABM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverABM1ActionPerformed
        ABM newframe = new ABM();
        
        newframe.setVisible(true);
       
        this.dispose();
    }//GEN-LAST:event_btnVolverABM1ActionPerformed

    private void txtApeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApeActionPerformed

    private boolean validarCampos() {
    // Verifica si todos los campos obligatorios no están vacíos
    return !txtNom.getText().trim().isEmpty() && 
           !txtApe.getText().trim().isEmpty() &&
           !jTextField2.getText().trim().isEmpty() &&
           !jTextField5.getText().trim().isEmpty() &&
           !jTextField6.getText().trim().isEmpty() &&
           !txtGmail.getText().trim().isEmpty();
}
    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        if (!validarCampos()) {
        // Si hay algún campo vacío, muestra un mensaje de advertencia
        JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos obligatorios", "Error", JOptionPane.WARNING_MESSAGE);

        // Mostrar las etiquetas de aviso
        label_aviso.setVisible(true);
        label_aviso2.setVisible(true);
        label_aviso3.setVisible(true);
        label_aviso4.setVisible(true);
        label_aviso5.setVisible(true);
        label_aviso6.setVisible(true);

    } else if (!verificar_Mail(txtGmail.getText())) {  // Verifica si el correo es válido
        // Si el correo no es válido, muestra un mensaje de advertencia
        JOptionPane.showMessageDialog(null, "El correo electrónico debe ser de la forma 'usuario@dominio.com'", "Error", JOptionPane.WARNING_MESSAGE);
        
        // Muestra el aviso del correo inválido
        label_aviso.setVisible(true);  
        }else{
        
        int edad = Integer.parseInt((String) jComboBox1.getSelectedItem());
        String estado = (String) jComboBox2.getSelectedItem();

        // Validación adicional: si la edad es 10, el estado no puede ser "Profesional" y viceversa
        if (edad < 17 && "Profesional".equals(estado)) {
            JOptionPane.showMessageDialog(null, "No se puede seleccionar 'Profesional' para una edad de menor de 17 años.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (edad >=17 && "Promesa".equals(estado)) {
            JOptionPane.showMessageDialog(null, "No se puede seleccionar 'Promesa' para edades mayores a 17 años.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
            
            
            
            
        String nombre = txtNom.getText();
        String apellido = txtApe.getText();
        String club = jTextField2.getText();
        String contacto = jTextField5.getText();
        String dni = jTextField6.getText();
        String gmail = txtGmail.getText();

        // Conexión a la base de datos
        Connection connection = null;
        PreparedStatement preparedStatement = null;
    
        try {
            if (!dni.matches("\\d{8}")) {
                JOptionPane.showMessageDialog(null, "El DNI debe contener exactamente 8 dígitos.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!contacto.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(null, "El Contacto debe contener exactamente 10 dígitos.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
        // Aquí debes cargar el controlador JDBC y obtener la conexión
        connection = DriverManager.getConnection("jdbc:mysql://bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb", "uwwqerjcglxxweor", "vWobxeLnCiH11WTJg6N");
        String checkSql = "SELECT COUNT(*) AS total FROM Jugadores WHERE dni = ?";
        preparedStatement = connection.prepareStatement(checkSql);
        preparedStatement.setString(1, dni);
        ResultSet resultado = preparedStatement.executeQuery();
         if (resultado.next()) {
         int count = resultado.getInt("total");
            if (count > 0) {
            JOptionPane.showMessageDialog(null, "El DNI ingresado ya está registrado.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
            }
         }
         
        
        
        
        
        
        
        
        // Preparar la consulta SQL
        String sql = "INSERT INTO Jugadores (nombre, apellido, club, edad, estado, contacto, dni, gmail) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        
        // Establecer los valores de la consulta
        preparedStatement.setString(1, nombre);
        preparedStatement.setString(2, apellido);
        preparedStatement.setString(3, club);
        preparedStatement.setInt(4, edad);
        preparedStatement.setString(5, estado);
        preparedStatement.setString(6, contacto);
        preparedStatement.setString(7, dni);
        preparedStatement.setString(8, gmail);
        
        // Ejecutar la consulta
        int filasInsertadas = preparedStatement.executeUpdate();
        if (filasInsertadas > 0) {
            JOptionPane.showMessageDialog(this, "Datos insertados correctamente");
            
            MensajeAlta newframe = new MensajeAlta();

            newframe.setVisible(true);
        
            this.dispose();
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al insertar los datos: " + e.getMessage());
    } finally {
        // Cerrar la conexión y el PreparedStatement
        try {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
            label_aviso.setVisible(false);
            label_aviso2.setVisible(false);
            label_aviso3.setVisible(false);
            label_aviso4.setVisible(false);
            label_aviso5.setVisible(false);
            label_aviso6.setVisible(false);
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnAltaActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
       
        
  
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void txtNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomActionPerformed

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        if(jTextField6.getText().length() >= 8)
        {
            evt.consume();
        
        }
        
        
        char c = evt.getKeyChar();
        
        if(c<'0' || c>'9') evt.consume();
        
        
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        if(jTextField5.getText().length() >= 10)
        {
            evt.consume();
        
        }
        
            
        char c = evt.getKeyChar();
        
        if(c<'0' || c>'9') evt.consume();
        
        
    }//GEN-LAST:event_jTextField5KeyTyped

    private void txtNomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomKeyTyped
        
        
        char c = evt.getKeyChar();
        
        if((c<'a' || c>'z') && (c<'A') | c>'Z') evt.consume();
        
        
    }//GEN-LAST:event_txtNomKeyTyped

    private void txtApeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApeKeyTyped
        
        
        char c = evt.getKeyChar();
        
        if((c<'a' || c>'z') && (c<'A') | c>'Z') evt.consume();
        
        
    }//GEN-LAST:event_txtApeKeyTyped

    private void txtGmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGmailKeyPressed

    }//GEN-LAST:event_txtGmailKeyPressed
    public boolean verificar_Mail(String correo){
    // Ajuste en la regex para validar solo correos con @gmail.com
    Pattern patron = Pattern.compile("^[a-z0-9_+&*-]+(?:\\.[a-z0-9_+&*-]+)*@[a-z0-9-]+(?:\\.[a-z0-9-]+)*(?:\\.[a-z]{2,})$");
    
    Matcher mat = patron.matcher(correo);
    return mat.matches();  // Usa matches para validar toda la cadena // Usa matches para validar toda la cadena
}
    private void txtGmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGmailActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void txtGmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGmailKeyReleased
    if(verificar_Mail(txtGmail.getText())){
    
            label_aviso.setVisible(false);
        
    }else{
        
        label_aviso.setVisible(true);
    
    }        // TODO add your handling code here:
    }//GEN-LAST:event_txtGmailKeyReleased

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
            java.util.logging.Logger.getLogger(Alta1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alta1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alta1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alta1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Alta1().setVisible(true);
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnAlta2;
    private javax.swing.JButton btnAlta3;
    private javax.swing.JButton btnAlta4;
    private javax.swing.JButton btnVolverABM1;
    private javax.swing.JButton btnVolverABM3;
    private javax.swing.JButton btnVolverABM4;
    private javax.swing.JButton btnVolverABM5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel label_aviso;
    private javax.swing.JLabel label_aviso1;
    private javax.swing.JLabel label_aviso10;
    private javax.swing.JLabel label_aviso11;
    private javax.swing.JLabel label_aviso12;
    private javax.swing.JLabel label_aviso13;
    private javax.swing.JLabel label_aviso14;
    private javax.swing.JLabel label_aviso15;
    private javax.swing.JLabel label_aviso16;
    private javax.swing.JLabel label_aviso17;
    private javax.swing.JLabel label_aviso18;
    private javax.swing.JLabel label_aviso19;
    private javax.swing.JLabel label_aviso2;
    private javax.swing.JLabel label_aviso20;
    private javax.swing.JLabel label_aviso21;
    private javax.swing.JLabel label_aviso22;
    private javax.swing.JLabel label_aviso23;
    private javax.swing.JLabel label_aviso24;
    private javax.swing.JLabel label_aviso25;
    private javax.swing.JLabel label_aviso26;
    private javax.swing.JLabel label_aviso27;
    private javax.swing.JLabel label_aviso28;
    private javax.swing.JLabel label_aviso29;
    private javax.swing.JLabel label_aviso3;
    private javax.swing.JLabel label_aviso4;
    private javax.swing.JLabel label_aviso5;
    private javax.swing.JLabel label_aviso6;
    private javax.swing.JLabel label_aviso7;
    private javax.swing.JLabel label_aviso8;
    private javax.swing.JLabel label_aviso9;
    private javax.swing.JTextField txtApe;
    private javax.swing.JTextField txtApe2;
    private javax.swing.JTextField txtApe3;
    private javax.swing.JTextField txtApe4;
    private javax.swing.JTextField txtGmail;
    private javax.swing.JTextField txtGmail2;
    private javax.swing.JTextField txtGmail3;
    private javax.swing.JTextField txtGmail4;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtNom2;
    private javax.swing.JTextField txtNom3;
    private javax.swing.JTextField txtNom4;
    // End of variables declaration//GEN-END:variables
}
