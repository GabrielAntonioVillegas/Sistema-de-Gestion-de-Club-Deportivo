/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Ventas;

/**
 *
 * @author gabrielv170
 */
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import Modulo_Ventas.ConexionBDD;
import javax.swing.JOptionPane;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import com.mysql.cj.jdbc.CallableStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

//CRUD Descuento
public class CrudDescuento {
    //Declaracion de variables a usar
    private int codigoID;
    private int porcentaje;
    private Date fecha_inicialidad;
    private Date fecha_finalidad;
    //GETTERS Y SETTERS===========================================================
    public int getCodigoID() {
        return codigoID;
    }

    public void setCodigoID(int codigoID) {
        this.codigoID = codigoID;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Date getFecha_inicialidad() {
        return fecha_inicialidad;
    }

    public void setFecha_inicialidad(Date fecha_inicialidad) {
        this.fecha_inicialidad = fecha_inicialidad;
    }

    public Date getFecha_finalidad() {
        return fecha_finalidad;
    }

    public void setFecha_finalidad(Date fecha_finalidad) {
        this.fecha_finalidad = fecha_finalidad;
    }
    //METODOS PARA LA VENTANA GESTION DE DESCUENTO+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Verifica si existe producto con nombres
    public boolean existeDescuento(JTextField paramCantidadDescuento, JDateChooser paramFechaInicio, JDateChooser paramFechaFinal) {
        ConexionBDD objetoConexion = new ConexionBDD();
        String consulta = "SELECT COUNT(*) AS total FROM Descuento WHERE CantidadDescuento = ? AND Fecha_Inicio = ? AND Fecha_Final = ?;";

        try (PreparedStatement ps = objetoConexion.Conectar().prepareStatement(consulta)) {
            // Obtener valores desde los parámetros
            int cantidadDescuento = Integer.parseInt(paramCantidadDescuento.getText());
            java.util.Date fechaInicio = paramFechaInicio.getDate();
            java.util.Date fechaFinal = paramFechaFinal.getDate();

            // Validar que las fechas no sean nulas
            if (fechaInicio == null || fechaFinal == null) {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione fechas válidas.");
                return false;
            }

            // Convertir fechas a formato SQL
            java.sql.Date sqlFechaInicio = new java.sql.Date(fechaInicio.getTime());
            java.sql.Date sqlFechaFinal = new java.sql.Date(fechaFinal.getTime());

            // Configurar parámetros de la consulta
            ps.setInt(1, cantidadDescuento);
            ps.setDate(2, sqlFechaInicio);
            ps.setDate(3, sqlFechaFinal);

            // Ejecutar consulta
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getInt("total") > 0) {
                return true; // Existe un descuento con los mismos valores
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia del descuento: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad de descuento inválida: " + e.getMessage());
        } finally {
            objetoConexion.cerrarConexion();
        }
        return false; // No se encontró un descuento coincidente
    }

    //METODO AGREGAR DECUENTO============================================================================
    public void AgregarDescuento(JTextField paramPorcentaje, JDateChooser paramFechaInicio, JDateChooser paramFechaFinal){
        ConexionBDD objetoConexion = new ConexionBDD();
        String consulta = "INSERT INTO Descuento(CantidadDescuento,Fecha_Inicio,Fecha_Final) VALUES(?,?,?);";
        try{
            CallableStatement cs = (CallableStatement) objetoConexion.Conectar().prepareCall(consulta);
            cs.setInt(1, Integer.parseInt(paramPorcentaje.getText()));
            
            Date fechaSeleccionada = paramFechaInicio.getDate();
            java.sql.Date fechaSQL = new java.sql.Date(fechaSeleccionada.getTime());
            cs.setDate(2, fechaSQL);
                    
            Date fechaSeleccionada2 = paramFechaFinal.getDate();
            java.sql.Date fechaSQL2 = new java.sql.Date(fechaSeleccionada2.getTime());
            cs.setDate(3, fechaSQL2);
            
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se guardó el descuento correctamente");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error, error: " + e.toString());
        }finally{
            objetoConexion.cerrarConexion();
        }
    }
    //METODO MOSTRAR LOS DESCUENTOS======================================================================
    public void MostrarDescuentos(JTable tablaTotalDescuentos){
        ConexionBDD objetoConexion = new ConexionBDD();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql="";
        modelo.addColumn("ID");
        modelo.addColumn("Porcentaje");
        modelo.addColumn("Fecha Inicio");
        modelo.addColumn("Fecha Final");
        
        tablaTotalDescuentos.setModel(modelo);
        
        sql="SELECT * FROM Descuento";
        
        try {
            Statement st= objetoConexion.Conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String id = rs.getString("DescuentoID");
                String porcentaje=rs.getString("CantidadDescuento") + "%";
                 
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
                java.sql.Date fechaSQL = rs.getDate("Fecha_Inicio");
                String nuevaFechaInicio = sdf.format(fechaSQL);
                 
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyy");
                java.sql.Date fechaSQL2 = rs.getDate("Fecha_Final");
                String nuevaFechaFinal = sdf2.format(fechaSQL2);
                 
                modelo.addRow(new Object[]{id,porcentaje,nuevaFechaInicio,nuevaFechaFinal});
            }
            tablaTotalDescuentos.setModel(modelo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al mostrar usuarios, error: " + e.toString());
        }finally{
            objetoConexion.cerrarConexion();
        }
        
        
        
    }
    //METODO SELECCIONAR DESCUENTOS======================================================================
    public void SeleccionarDescuentos(JTable totalDescuentos, JTextField id, JTextField descuento, JDateChooser fechaInicio, JDateChooser fechaFinal) {
        int fila = totalDescuentos.getSelectedRow();
        if (fila >= 0) {
            id.setText(totalDescuentos.getValueAt(fila, 0).toString());

            // Obtener el valor del descuento y eliminar el símbolo '%'
            String descuentoTexto = totalDescuentos.getValueAt(fila, 1).toString(); 
            if (descuentoTexto.endsWith("%")) {
                descuentoTexto = descuentoTexto.substring(0, descuentoTexto.length() - 1); // Elimina el '%'
            }
            descuento.setText(descuentoTexto.trim()); // Asigna solo el número

            String fechaString = totalDescuentos.getValueAt(fila, 2).toString();
            String fechaString2 = totalDescuentos.getValueAt(fila, 3).toString();
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaDate = sdf.parse(fechaString);
                Date fechaDate2 = sdf.parse(fechaString2);

                fechaInicio.setDate(fechaDate);
                fechaFinal.setDate(fechaDate2);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al seleccionar, error: " + e.toString());
            }
        }
    }

    //METODO MODIFICAR DESCUENTO=========================================================================
    public void ModificarDescuento(JTextField paramid,JTextField paramPorcentaje, JDateChooser paramFechaInicio, JDateChooser paramFechaFinal){
        ConexionBDD objetoConexion = new ConexionBDD();
        String consulta = "UPDATE Descuento SET CantidadDescuento=?,Fecha_Inicio=?,Fecha_Final=? WHERE DescuentoID=?;";
        try{
            CallableStatement cs = (CallableStatement) objetoConexion.Conectar().prepareCall(consulta);
            cs.setString(1,paramPorcentaje.getText());
            
            Date fechaSeleccionada = paramFechaInicio.getDate();
            java.sql.Date fechaSQL = new java.sql.Date(fechaSeleccionada.getTime());
            cs.setDate(2, fechaSQL);
                    
            Date fechaSeleccionada2 = paramFechaFinal.getDate();
            java.sql.Date fechaSQL2 = new java.sql.Date(fechaSeleccionada2.getTime());
            cs.setDate(3, fechaSQL2);
            
            cs.setInt(4,Integer.parseInt(paramid.getText()));
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se modifico correctamente");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error, error: " + e.toString());
        }finally{
            objetoConexion.cerrarConexion();
        }
    }
    //METODO PARA ELIMINAR DESCUENTO=====================================================================
    public void EliminarDescuento(JTextField id) {
        ConexionBDD objetoConexion = new ConexionBDD();

        String consulta1 = "DELETE FROM DescuentoProductos WHERE DescuentoID=?;";
        String consulta2 = "DELETE FROM Descuento WHERE DescuentoID=?;";

        try {
            // Eliminar en DescuentosProductos
            CallableStatement cs1 = (CallableStatement) objetoConexion.Conectar().prepareCall(consulta1);
            cs1.setInt(1, Integer.parseInt(id.getText()));
            cs1.execute();

            // Eliminar en Descuento
            CallableStatement cs2 = (CallableStatement) objetoConexion.Conectar().prepareCall(consulta2);
            cs2.setInt(1, Integer.parseInt(id.getText()));
            cs2.execute();

            JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar, error: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }

    //METODOS PARA LA VENTANA APLICAR DESCUENTO++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    //METODO SELECCIONAR DESCUENTOS PARA SER APLICADOS A PRODUCTOS=======================================
    public void Seleccionar_AplicarDescuento(JTable totalDescuentos, JTextField descuentoID, JTextField descuento, JTextField producto){
        int fila= totalDescuentos.getSelectedRow();
        if(fila>=0){
            descuentoID.setText(totalDescuentos.getValueAt(fila,0).toString());
            descuento.setText(totalDescuentos.getValueAt(fila,1).toString());
            producto.setText(totalDescuentos.getValueAt(fila,3).toString());
            }
    }
    
    //Seleccionar Descuento
    public void Seleccionar_Descuento(JTable totalDescuentos, JTextField descuentoID, JTextField descuento) {
    int fila = totalDescuentos.getSelectedRow();
    if(fila >= 0) {
        descuentoID.setText(totalDescuentos.getValueAt(fila, 0).toString());
        descuento.setText(totalDescuentos.getValueAt(fila, 1).toString());
    }
    }
    
    //Seleccionar Producto
    public void Seleccionar_Producto(JTable totalDescuentos, JTextField productosID, JTextField productos){
            int fila= totalDescuentos.getSelectedRow();
            if(fila>=0){
                productosID.setText(totalDescuentos.getValueAt(fila,0).toString());
                productos.setText(totalDescuentos.getValueAt(fila,1).toString());
            }
    }
    
    //Seleccionar Mostrar Descuentos Aplicados
    public void MostrarDescuentosAplicados(JTable tablaDescuentosAplicados) {
        ConexionBDD objetoConexion = new ConexionBDD();
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("DescuentoID");
        modelo.addColumn("ProductoID"); 
        modelo.addColumn("Porcentaje");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio Final");
        tablaDescuentosAplicados.setModel(modelo);
        String sql = "SELECT DescuentoProductos.DescuentoID, DescuentoProductos.ProductoID, Descuento.CantidadDescuento, " +
                     "Productos.Nombre, DescuentoProductos.PrecioFinal " +
                     "FROM DescuentoProductos " +
                     "INNER JOIN Descuento ON DescuentoProductos.DescuentoID = Descuento.DescuentoID " +
                     "INNER JOIN Productos ON DescuentoProductos.ProductoID = Productos.ProductoID;";
        try {
            Statement st = objetoConexion.Conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Agregar filas con todos los datos, incluyendo ProductoID
            while (rs.next()) {
                String descuentoID = rs.getString("DescuentoID");
                String productoID = rs.getString("ProductoID");
                String porcentaje = rs.getString("CantidadDescuento") + "%";
                String nombreProducto = rs.getString("Nombre");
                String precioFinal = rs.getString("PrecioFinal");

                modelo.addRow(new Object[] {descuentoID, productoID, porcentaje, nombreProducto, precioFinal});
            }

            tablaDescuentosAplicados.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar descuentos: " + e.toString());
            System.out.println(e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }
 
    //METODOS APLICAR DESCUENTO A LOS PRODUCTOS===========================================================
    public void AplicacionDelDescuento(JTextField descuentoID, JTextField productoID){
        ConexionBDD objetoConexion = new ConexionBDD();
        String consulta="INSERT INTO DescuentoProductos(DescuentoID, ProductoID, PrecioFinal) "
                + "VALUES (?,?,(SELECT Precio - (Precio * (SELECT CantidadDescuento / 100 "
                + "FROM Descuento WHERE DescuentoID = ?))FROM Productos WHERE ProductoID = ?));";
        try{
            CallableStatement cs = (CallableStatement) objetoConexion.Conectar().prepareCall(consulta);
            cs.setInt(1, Integer.parseInt(descuentoID.getText()));
            cs.setInt(2, Integer.parseInt(productoID.getText()));
            cs.setInt(3, Integer.parseInt(descuentoID.getText()));
            cs.setInt(4, Integer.parseInt(productoID.getText()));
            
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se aplico el descuento correctamente");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error, error: " + e.toString());
        }finally{
            objetoConexion.cerrarConexion();
        } 
    }
    
    //Mostrar productos
    public void MostrarProductos(JTable paramTablaProductos) {
        ConexionBDD objetoConexion = new ConexionBDD();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql="";
        modelo.addColumn("ID");
        modelo.addColumn("Nombres");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Categoría");
        paramTablaProductos.setModel(modelo);
        sql = "SELECT Productos.ProductoID, Productos.Nombre, Productos.Stock, Productos.Precio, Categorias.NombreCategoria "
               + "FROM Productos "
               + "INNER JOIN Categorias ON Productos.CategoriaID = Categorias.CategoriaID "
               + "WHERE Productos.ProductoID NOT IN (SELECT ProductoID FROM DescuentoProductos);";
        try {
            Statement st;
            st = objetoConexion.Conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("ProductoID");
                String nombres = rs.getString("Nombre");
                String stocks = rs.getString("Stock");
                String precios = rs.getString("Precio");
                String categoria = rs.getString("NombreCategoria");
                modelo.addRow(new Object[]{id,nombres,precios,stocks,categoria});
            }
            paramTablaProductos.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar correctamente los registros, error: " + e.getMessage());
        }finally{
            objetoConexion.cerrarConexion();
        }
    }
    
    //METODO ELIMINAR DESCUENTO A PRODUCTOS==============================================================
    public void EliminarDescuentoAplicado(JTextField descuentoID, JTextField productoID) {
        ConexionBDD objetoConexion = new ConexionBDD();
        String consulta = "DELETE FROM DescuentoProductos WHERE DescuentoID = ? AND ProductoID = ?";

        try {
            PreparedStatement ps = objetoConexion.Conectar().prepareStatement(consulta);
            ps.setInt(1, Integer.parseInt(descuentoID.getText()));
            ps.setInt(2, Integer.parseInt(productoID.getText()));

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Descuento eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el descuento aplicado para el producto seleccionado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el descuento: " + e.toString());
            System.out.println(e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }
}