package Modulo_Ventas;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.sql.*;

//Ver reembolsos
public class Ver_Reembolso {
    //Declaracion de variables a usar
    private Date fecha;
    private double monto;
    private String motivo;
    private int Estado;
    private int IDPedido;
    private int codigo;

    // Getters y setters
    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getIDPedido() {
        return IDPedido;
    }

    public void setIDPedido(int IDPedido) {
        this.IDPedido = IDPedido;
    }
    //Metodos
    // Método para mostrar los reembolsos en la tabla
    public void MostrarReembolsos(JTable paramTablaTotalReembolso) {
        ConexionBDD objetoConexion = new ConexionBDD();
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<>(modelo);
        paramTablaTotalReembolso.setRowSorter(OrdenarTabla);

        // Agregar todas las columnas al modelo
        modelo.addColumn("IDReembolso");
        modelo.addColumn("IDPedido");
        modelo.addColumn("NombreProducto"); // Nueva columna para el nombre del producto
        modelo.addColumn("FechaReembolso");
        modelo.addColumn("Motivo");
        modelo.addColumn("Estado");

        paramTablaTotalReembolso.setModel(modelo);

        // Query para obtener los datos
        String sql = "SELECT rp.IDReembolso, rp.IDPedido, p.Nombre AS NombreProducto, " +
                     "rp.FechaReembolso, rp.Motivo, rp.Estado " +
                     "FROM Reembolso_Pedido rp " +
                     "INNER JOIN Pedido ped ON rp.IDPedido = ped.PedidoID " +
                     "INNER JOIN DetallePedido dp ON ped.PedidoID = dp.PedidoID " +
                     "INNER JOIN Productos p ON dp.ProductoID = p.ProductoID;";

        String[] datos = new String[6]; // Ajustar el tamaño del array

        try {
            Statement st = objetoConexion.Conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                datos[0] = rs.getString("IDReembolso");         // ID del reembolso
                datos[1] = rs.getString("IDPedido");           // ID del pedido
                datos[2] = rs.getString("NombreProducto");     // Nombre del producto
                datos[3] = rs.getString("FechaReembolso");     // Fecha del reembolso
                datos[4] = rs.getString("Motivo");             // Motivo del reembolso

                // Convertir el estado en texto legible
                int estado = rs.getInt("Estado");
                datos[5] = (estado == 0) ? "No reembolsado" : "Reembolsado";

                modelo.addRow(datos);
            }
            paramTablaTotalReembolso.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar correctamente los registros, error: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }


    // Método para seleccionar el reembolso y obtener su ID
    public void SeleccionarReembolso(JTable paramTablaReembolso, JTextField paramID) {
        try {
            int fila = paramTablaReembolso.getSelectedRow();
            if (fila >= 0) {
                paramID.setText(paramTablaReembolso.getValueAt(fila, 0).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no encontrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error:" + e.toString());
        }
    }

    // Método para alternar el estado de reembolso y actualizar el stock
    public void ModificarEstadoReembolso(JTextField paramID) {
        setCodigo(Integer.parseInt(paramID.getText())); // ID del reembolso
        ConexionBDD objetoConexion = new ConexionBDD();
        String consulta = "UPDATE Reembolso_Pedido SET Estado = ? WHERE IDReembolso = ?";

        // Obtener el estado actual para alternarlo
        int nuevoEstado = (obtenerEstadoActual(getCodigo()) == 0) ? 1 : 0;

        try {
            // Alternar estado de reembolso
            PreparedStatement ps = objetoConexion.Conectar().prepareStatement(consulta);
            ps.setInt(1, nuevoEstado); // Nuevo estado (0 o 1)
            ps.setInt(2, getCodigo()); // ID del reembolso a modificar
            ps.executeUpdate();

            // Si el nuevo estado es 1 (reembolsado), recuperar stock
            if (nuevoEstado == 1) {
                actualizarStock(getCodigo(), true); // Recuperar stock
            } else { 
                actualizarStock(getCodigo(), false); // Descontar stock
            }

            JOptionPane.showMessageDialog(null, "Estado y stock actualizados exitosamente");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el estado: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }

    
    //Eliminar reembolso
    public void EliminarReembolso(JTextField paramID){
        //Declarar parametros
        setCodigo(Integer.parseInt(paramID.getText()));
        ConexionBDD objetoConexion= new ConexionBDD();
        //Consulta SQL
        String consulta="DELETE FROM Reembolso_Pedido WHERE IDReembolso=?;";
        try{
            //Conectar BDD
            CallableStatement cs= objetoConexion.Conectar().prepareCall(consulta);
            //Adquirir parametros
            cs.setInt(1, getCodigo());
            //Ejecutar
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se eliminó correctamente el reembolso");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se eliminó correctamente el registro, error:"+ e.toString())  ;
        }finally{
            objetoConexion.cerrarConexion();
        }
    }

    // Método auxiliar para obtener el estado actual del reembolso
    private int obtenerEstadoActual(int reembolsoID) {
        ConexionBDD objetoConexion = new ConexionBDD();
        String consulta = "SELECT Estado FROM Reembolso_Pedido WHERE IDReembolso = ?";
        int estadoActual = 0;

        try {
            PreparedStatement ps = objetoConexion.Conectar().prepareStatement(consulta);
            ps.setInt(1, reembolsoID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                estadoActual = rs.getInt("Estado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar el estado actual: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }

        return estadoActual;
    }
    // Método para actualizar el stock según el estado del reembolso
    private void actualizarStock(int idReembolso, boolean incrementar) {
        ConexionBDD objetoConexion = new ConexionBDD();

        try {
            // Obtener el PedidoID y ProductoID del reembolso
            String consultaDetalle = 
            "SELECT dp.ProductoID, dp.Cantidad " +
            "FROM DetallePedido dp " +
            "JOIN Reembolso_Pedido rp ON dp.PedidoID = rp.IDPedido " +
            "WHERE rp.IDReembolso = ?";


            PreparedStatement ps = objetoConexion.Conectar().prepareStatement(consultaDetalle);
            ps.setInt(1, idReembolso);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int productoID = rs.getInt("ProductoID");
                int cantidad = rs.getInt("Cantidad");

                // Actualizar el stock de la tabla Productos
                String actualizarStock = "UPDATE Productos SET Stock = Stock " + (incrementar ? "+ ?" : "- ?") + " WHERE ProductoID = ?";
                PreparedStatement psUpdate = objetoConexion.Conectar().prepareStatement(actualizarStock);
                psUpdate.setInt(1, cantidad);
                psUpdate.setInt(2, productoID);
                psUpdate.executeUpdate();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el stock: " + e.toString());
            System.out.println(e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }
}
