/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Ventas;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.text.*;
import java.util.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author tm_galli
 */
//Gestionar descuento
public class Gestion_Descuento extends javax.swing.JFrame {
    //Declaracion de variables
    private String valorDescuentoOriginal;
    private Date fechaInicioOriginal;
    private Date fechaFinalOriginal;

    //Constructor
    public Gestion_Descuento() {
        initComponents();
        Modulo_Ventas.CrudDescuento objetoDescuento = new Modulo_Ventas.CrudDescuento();
        objetoDescuento.MostrarDescuentos(TablaDescuentos);
        JTextField_ID.setEnabled(false);
        ((AbstractDocument) JTextField_Descuento.getDocument()).addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { validarCampos(); }
            public void removeUpdate(DocumentEvent e) { validarCampos(); }
            public void changedUpdate(DocumentEvent e) { validarCampos(); }
        });

        Btn_Guardar.setEnabled(false);
        Btn_Modificar.setEnabled(false);
        Btn_Eliminar.setEnabled(false);
        datechooser_FechaInicio.getDateEditor().setEnabled(false);
        datechooser_FechaFinal.getDateEditor().setEnabled(false);
        datechooser_FechaInicio.setMinSelectableDate(new Date());

        // Prevenir que la Fecha Final sea igual a la Fecha de Inicio
        datechooser_FechaFinal.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    Date fechaInicio = datechooser_FechaInicio.getDate();
                    Date fechaFinal = datechooser_FechaFinal.getDate();
                    if (fechaInicio != null && fechaFinal != null && fechaInicio.equals(fechaFinal)) {
                        JOptionPane.showMessageDialog(null, "La fecha final no puede ser igual a la fecha de inicio.");
                        datechooser_FechaFinal.setDate(null); // Limpiar la fecha final
                    }
                }
            }
        });
        
        // Limitar JTextField_ID a solo dos dígitos numéricos
        ((AbstractDocument) JTextField_Descuento.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("[0-9]{1,2}")) { // Solo permitir números de hasta dos dígitos
                    if (fb.getDocument().getLength() + string.length() <= 2) {
                        super.insertString(fb, offset, string, attr);
                    }
                }
        }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[0-9]{1,2}")) { // Solo permitir números de hasta dos dígitos
                    if (fb.getDocument().getLength() + text.length() - length <= 2) {
                        super.replace(fb, offset, length, text, attrs);
                    }
                }
            }
        });
        datechooser_FechaFinal.setEnabled(false);
        ((JTextField) datechooser_FechaFinal.getDateEditor().getUiComponent()).setEnabled(false);  // Desactivar el campo de texto
        // Listener para habilitar el datechooser_FechaFinal cuando se seleccione una fecha en datechooser_FechaInicio
        datechooser_FechaInicio.getDateEditor().addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                // Verifica si se ha seleccionado una fecha en datechooser_FechaInicio
                if (datechooser_FechaInicio.getDate() != null) {
                    // Habilitar datechooser_FechaFinal y su botón
                    datechooser_FechaFinal.setEnabled(true);
                    ((JTextField) datechooser_FechaFinal.getDateEditor().getUiComponent()).setEnabled(true);  // Habilitar el campo de texto
                } else {
                    // Si no se seleccionó una fecha de inicio, desactivar datechooser_FechaFinal
                    datechooser_FechaFinal.setEnabled(false);
                    datechooser_FechaFinal.setDate(null); // Restablecer la fecha final
                    ((JTextField) datechooser_FechaFinal.getDateEditor().getUiComponent()).setEnabled(false);  // Desactivar el campo de texto
                }
            }
        });

        // Listener para validar que la fecha final no sea menor o igual a la fecha inicial
        datechooser_FechaFinal.getDateEditor().addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                // Verificar que ambas fechas estén seleccionadas
                if (datechooser_FechaFinal.getDate() != null && datechooser_FechaInicio.getDate() != null) {
                    Date fechaInicio = datechooser_FechaInicio.getDate();
                    Date fechaFinal = datechooser_FechaFinal.getDate();

                    // Compara si la fecha final es menor o igual a la fecha de inicio
                    if (fechaFinal.compareTo(fechaInicio) <= 0) {
                        JOptionPane.showMessageDialog(null, "La fecha final no puede ser menor que la fecha inicial.", "Error", JOptionPane.ERROR_MESSAGE);
                        datechooser_FechaFinal.setDate(null); // Limpiar la fecha final si es inválida
                    }
                }
            }
        });
        datechooser_FechaInicio.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                // Verifica que el cambio sea en la fecha y no en otra propiedad
                if (evt.getPropertyName().equals("date")) {
                    validarCampos();
                }
            }
        });

        // Para Fecha de Fin
        datechooser_FechaFinal.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                // Verifica que el cambio sea en la fecha y no en otra propiedad
                if (evt.getPropertyName().equals("date")) {
                    validarCampos();
                }
            }
        });
        TablaDescuentos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Obtener el índice de la fila seleccionada
                    int row = TablaDescuentos.getSelectedRow();

                    if (row != -1) {
                        // Obtener el descuento de la fila seleccionada (por ejemplo, de la primera columna)
                        String descuentoSeleccionado = TablaDescuentos.getValueAt(row, 0).toString();

                        // Poner el valor en el JTextField_Descuento
                        JTextField_Descuento.setText(descuentoSeleccionado);
                    }
                }
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDescuentos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        JTextField_ID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JTextField_Descuento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        datechooser_FechaInicio = new com.toedter.calendar.JDateChooser();
        datechooser_FechaFinal = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        Btn_Guardar = new javax.swing.JButton();
        Btn_Modificar = new javax.swing.JButton();
        Btn_Eliminar = new javax.swing.JButton();
        Btn_Aplicar = new javax.swing.JButton();
        Volver_Btn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(47, 94, 141));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TablaDescuentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaDescuentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDescuentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDescuentos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(240, 60, 603, 475);

        jPanel2.setBackground(new java.awt.Color(47, 94, 141));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("   ID ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Descuento");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("%");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Fecha Inicio");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Fecha Final");

        Btn_Guardar.setText("Agregar Descuento");
        Btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_GuardarActionPerformed(evt);
            }
        });

        Btn_Modificar.setText("Modificar Descuento");
        Btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ModificarActionPerformed(evt);
            }
        });

        Btn_Eliminar.setText("Eliminar Descuento");
        Btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EliminarActionPerformed(evt);
            }
        });

        Btn_Aplicar.setText("Aplicar Descuento");
        Btn_Aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AplicarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(datechooser_FechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(datechooser_FechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JTextField_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Btn_Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_Modificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_Eliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_Aplicar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextField_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datechooser_FechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datechooser_FechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(Btn_Guardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_Modificar)
                .addGap(25, 25, 25)
                .addComponent(Btn_Eliminar)
                .addGap(18, 18, 18)
                .addComponent(Btn_Aplicar)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 60, 229, 475);

        Volver_Btn.setText("<----");
        Volver_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Volver_BtnActionPerformed(evt);
            }
        });
        getContentPane().add(Volver_Btn);
        Volver_Btn.setBounds(10, 11, 57, 23);

        jPanel3.setBackground(new java.awt.Color(31, 50, 69));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Gestion de Descuento");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(jLabel1)
                .addContainerGap(365, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 870, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Método que valida los campos y habilita los botones según las condiciones
    private void validarCampos() {
        // Verificar si el campo de descuento tiene texto
        boolean descuentoValido = !JTextField_Descuento.getText().isEmpty();

        // Verificar si las fechas son válidas (por ejemplo, no vacías y que la fecha de fin sea posterior a la de inicio)
        boolean fechasValidas = (datechooser_FechaInicio.getDate() != null) && (datechooser_FechaFinal.getDate() != null)
                && !datechooser_FechaFinal.getDate().before(datechooser_FechaInicio.getDate());

        // Si el campo de descuento no está vacío y las fechas son válidas, habilitar los botones
        if (descuentoValido && fechasValidas) {
            Btn_Guardar.setEnabled(true);
        } else {
            Btn_Guardar.setEnabled(false);
        }

        // Si ya existe un descuento seleccionado, habilitar los botones de Modificar y Eliminar
        if (TablaDescuentos.getSelectionModel().isSelectionEmpty()) {
        // No hay fila seleccionada
        } else {
        // Hay una fila seleccionada
        Btn_Modificar.setEnabled(true);
        Btn_Eliminar.setEnabled(true);
        }
    }
    
    //Boton Guardar
    private void Btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_GuardarActionPerformed
         Modulo_Ventas.CrudDescuento objetoDescuento = new Modulo_Ventas.CrudDescuento();
        // Verificar si ya existe el descuento con el mismo porcentaje y fechas
        if (objetoDescuento.existeDescuento(JTextField_Descuento , datechooser_FechaInicio, datechooser_FechaFinal)) {
            JOptionPane.showMessageDialog(null, "El descuento con este porcentaje, fecha inicial y final ya existe.");

            // Limpiar el JTextField y los JDateChooser si ya existe el descuento
            JTextField_Descuento.setText("");  // Limpiar el JTextField
            datechooser_FechaInicio.setDate(null);  // Limpiar la fecha de inicio
            datechooser_FechaFinal.setDate(null);  // Limpiar la fecha final

        } else {
            // Si el descuento no existe, agregar el nuevo descuento
            objetoDescuento.AgregarDescuento(JTextField_Descuento, datechooser_FechaInicio, datechooser_FechaFinal);
            objetoDescuento.MostrarDescuentos(TablaDescuentos);
        }
        TablaDescuentos.clearSelection();
        
        JTextField_ID.setText("");
        JTextField_Descuento.setText("");
        datechooser_FechaFinal.setDate(null);
        datechooser_FechaInicio.setDate(null);
                
    }//GEN-LAST:event_Btn_GuardarActionPerformed
    
    //Boton Modificar
    private void Btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ModificarActionPerformed
        Modulo_Ventas.CrudDescuento objetoDescuento = new Modulo_Ventas.CrudDescuento();
        // Verificar si hay cambios en los valores
        boolean hayCambios = false;

        if (!JTextField_Descuento.getText().equals(valorDescuentoOriginal)) {
            hayCambios = true;
        }
        if (datechooser_FechaInicio.getDate() != null && !datechooser_FechaInicio.getDate().equals(fechaInicioOriginal)) {
            hayCambios = true;
        }
        if (datechooser_FechaFinal.getDate() != null && !datechooser_FechaFinal.getDate().equals(fechaFinalOriginal)) {
            hayCambios = true;
        }

        if (hayCambios) {
           objetoDescuento.ModificarDescuento(JTextField_ID,JTextField_Descuento,datechooser_FechaInicio, datechooser_FechaFinal);
           objetoDescuento.MostrarDescuentos(TablaDescuentos);
            JOptionPane.showMessageDialog(null, "Descuento modificado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se ha realizado ningún cambio para modificar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        TablaDescuentos.clearSelection();
        JTextField_ID.setText("");
        JTextField_Descuento.setText("");
        datechooser_FechaFinal.setDate(null);
        datechooser_FechaInicio.setDate(null);
    }//GEN-LAST:event_Btn_ModificarActionPerformed
    
    //Boton Eliminar
    private void Btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EliminarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(
        null,
        "¿Estás seguro de que deseas eliminar este descuento?",
        "Confirmar eliminación",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.WARNING_MESSAGE
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                Modulo_Ventas.CrudDescuento objetoDescuento = new Modulo_Ventas.CrudDescuento();
                objetoDescuento.EliminarDescuento(JTextField_ID);
                objetoDescuento.MostrarDescuentos(TablaDescuentos);
            } catch (Exception e) {
                System.err.println("Error al eliminar el descuento: " + e.getMessage());
            }
        } else {
            // Si el usuario selecciona "No", no se realiza ninguna acción.
            JOptionPane.showMessageDialog(null, "Eliminación cancelada.", "Acción cancelada", JOptionPane.INFORMATION_MESSAGE);
        }
        TablaDescuentos.clearSelection();
        JTextField_ID.setText("");
        
        JTextField_Descuento.setText("");
        datechooser_FechaFinal.setDate(null);
        datechooser_FechaInicio.setDate(null);
    }//GEN-LAST:event_Btn_EliminarActionPerformed
    
    //Boton Volver
    private void Volver_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Volver_BtnActionPerformed
        Pantalla_Ventas vV= new Pantalla_Ventas();
        this.setVisible(false);
        vV.setVisible(true);
        vV.setLocationRelativeTo(null);
        //vV.setSize(400,440);
    }//GEN-LAST:event_Volver_BtnActionPerformed
    
    //Boton ir a pantalla Aplicar Descuento
    private void Btn_AplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AplicarActionPerformed
        Pantalla_AplicarDescuento vAD = new Pantalla_AplicarDescuento();
        this.setVisible(false);
        vAD.setSize(1240,650);
        vAD.setLocationRelativeTo(null);
        vAD.setVisible(true);
    }//GEN-LAST:event_Btn_AplicarActionPerformed

    //Boton seleccionar descuento
    private void TablaDescuentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDescuentosMouseClicked
        Modulo_Ventas.CrudDescuento objetoDescuento = new Modulo_Ventas.CrudDescuento();
        objetoDescuento.SeleccionarDescuentos(TablaDescuentos, JTextField_ID, JTextField_Descuento, datechooser_FechaInicio, datechooser_FechaFinal);
        int filaSeleccionada = TablaDescuentos.getSelectedRow();
        if (filaSeleccionada >= 0) {
            objetoDescuento.SeleccionarDescuentos(TablaDescuentos, JTextField_ID, JTextField_Descuento, datechooser_FechaInicio, datechooser_FechaFinal);
            
            // Guardar los valores originales para validación de cambios
            valorDescuentoOriginal = JTextField_Descuento.getText();
            fechaInicioOriginal = datechooser_FechaInicio.getDate();
            fechaFinalOriginal = datechooser_FechaFinal.getDate();
        }
        

        // Habilitar el botón de modificar solo si la tabla tiene un descuento seleccionado
        Btn_Modificar.setEnabled(true);
        Btn_Eliminar.setEnabled(true);
    }//GEN-LAST:event_TablaDescuentosMouseClicked
    
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
            java.util.logging.Logger.getLogger(Gestion_Descuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion_Descuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion_Descuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion_Descuento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion_Descuento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Aplicar;
    private javax.swing.JButton Btn_Eliminar;
    private javax.swing.JButton Btn_Guardar;
    private javax.swing.JButton Btn_Modificar;
    private javax.swing.JTextField JTextField_Descuento;
    private javax.swing.JTextField JTextField_ID;
    private javax.swing.JTable TablaDescuentos;
    private javax.swing.JButton Volver_Btn;
    private com.toedter.calendar.JDateChooser datechooser_FechaFinal;
    private com.toedter.calendar.JDateChooser datechooser_FechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
