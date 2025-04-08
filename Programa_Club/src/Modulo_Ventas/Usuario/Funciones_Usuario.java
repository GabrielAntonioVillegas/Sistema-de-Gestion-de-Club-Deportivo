 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Ventas.Usuario;
import Modulo_Ventas.ConexionBDD;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.JComboBox;
/**
 *
 * @author thiag
 */
public class Funciones_Usuario {
    private Date fecha;
    private String Nombre_Producto;
    private double Precio;
    private int CategoriaID;
    private int IDPedido;
    private int codigo;
    private String productoID;
    
    public String getNombre_Producto() {
        return Nombre_Producto;
    }

    public void setNombre_Producto(String Nombre_Producto) {
        this.Nombre_Producto = Nombre_Producto;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getCategoriaID() {
        return CategoriaID;
    }

    public void setCategoriaID(int CategoriaID) {
        this.CategoriaID = CategoriaID;
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

    public int getIDPedido() {
        return IDPedido;
    }

    public void setIDPedido(int IDPedido) {
        this.IDPedido = IDPedido;
    }

    // Método para mostrar los reembolsos en la tabla
    public void MostrarProductos(JTable paramTablaProductos) {
        ConexionBDD objetoConexion = new ConexionBDD();
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<>(modelo);
        paramTablaProductos.setRowSorter(ordenarTabla);

        // Agregar las columnas
        modelo.addColumn("ProductoID"); // Esta columna se va a ocultar
        modelo.addColumn("Nombre");
        modelo.addColumn("Stock");
        modelo.addColumn("Precio");
        modelo.addColumn("Categoria");

        paramTablaProductos.setModel(modelo);

        // Consulta SQL para obtener información de Producto
        String sql = "SELECT p.ProductoID, p.Nombre, p.Stock, c.NombreCategoria, COALESCE(CASE WHEN CURDATE() BETWEEN d.Fecha_Inicio AND d.Fecha_Final THEN dp.PrecioFinal ELSE p.Precio END, p.Precio) AS PrecioFinal FROM Productos p LEFT JOIN DescuentoProductos dp ON p.ProductoID = dp.ProductoID LEFT JOIN Descuento d ON dp.DescuentoID = d.DescuentoID LEFT JOIN Categorias c ON p.CategoriaID = c.CategoriaID WHERE p.Estado = 1;";


        String[] datos = new String[5];

        try {
            Statement st = objetoConexion.Conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("ProductoID");
                datos[1] = rs.getString("Nombre");
                datos[2] = rs.getString("Stock");
                datos[3] = rs.getString("PrecioFinal");
                datos[4] = rs.getString("NombreCategoria");

                modelo.addRow(datos);
        }

        // Ocultar la columna ProductoID
        paramTablaProductos.getColumnModel().getColumn(0).setMinWidth(0);
        paramTablaProductos.getColumnModel().getColumn(0).setMaxWidth(0);
        paramTablaProductos.getColumnModel().getColumn(0).setWidth(0);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar correctamente los registros, error: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
}

    public void SeleccionarProducto(JTable paramTablaProductos, JTextField paramID, JTextField paramNombreProducto, JTextField paramPrecioProducto, JTextField paramCategoria) {
    try {
        int fila = paramTablaProductos.getSelectedRow();

        // Verificar que haya una fila seleccionada
        if (fila >= 0) {
            // Almacenar el ProductoID en el JTextField (columna 0)
            paramID.setText(paramTablaProductos.getValueAt(fila, 0).toString()); // ProductoID
            
            // Almacenar otros datos en los JTextFields correspondientes
            paramNombreProducto.setText(paramTablaProductos.getValueAt(fila, 1).toString()); // Nombre
            paramPrecioProducto.setText(paramTablaProductos.getValueAt(fila, 3).toString()); // Precio
            paramCategoria.setText(paramTablaProductos.getValueAt(fila, 4).toString()); // NombreCategoria
            
            // Actualiza el productoID en una variable (por ejemplo, una variable de clase)
            productoID = paramTablaProductos.getValueAt(fila, 0).toString(); // Asegúrate de que esta línea esté presente
        } else {
            JOptionPane.showMessageDialog(null, "Fila no encontrada.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.getMessage());
    }
}
    
    protected int obtenerStockProducto(int idProducto) {
    int stock = 0; // Variable para almacenar el stock del producto
    ConexionBDD objetoConexion = new ConexionBDD(); // Conexión a la base de datos

    // Consulta SQL para obtener el stock del producto
    String sql = "SELECT Stock FROM Productos WHERE ProductoID = ?";

    try {
        PreparedStatement pst = objetoConexion.Conectar().prepareStatement(sql);
        pst.setInt(1, idProducto); // Establecer el ID del producto en la consulta
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            stock = rs.getInt("Stock"); // Obtener el stock del resultado
            System.out.println("Llamando a obtenerStockProducto con idProducto: " + idProducto);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener el stock del producto: " + e.getMessage());
    } finally {
        objetoConexion.cerrarConexion(); // Cerrar la conexión
    }

    return stock; // Retornar el stock obtenido
}
    
    //Funciones para la ventana Ventana_FormaEntrega==============================================
    public void MostrarDatos(String usuarioID, JTextField direccion_usuario, JTextField direccion_club, JTextField precioEnvio) {
        ConexionBDD objetoConexion = new ConexionBDD();
        String sql  = "SELECT Direccion FROM Usuario WHERE IDUsuario = ?";
        String sql2 = "SELECT Direccion FROM Estadio LIMIT 1;";
        String sql3 = "SELECT PrecioEnvio FROM Envio WHERE Activo=1";
        try {
            //Mostrar direccion del usuario
            CallableStatement st = (CallableStatement) objetoConexion.Conectar().prepareCall(sql);
            st.setString(1, usuarioID);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                String direccionUser = rs.getString("Direccion");

                if (direccionUser != null) {
                    direccion_usuario.setText(direccionUser);
                } else {
                    direccion_usuario.setText("Dirección no disponible.");
                }
            } else {
                direccion_usuario.setText("Usuario no encontrado.");
            }
            //Mostrar direccion del club
            CallableStatement st2 = (CallableStatement) objetoConexion.Conectar().prepareCall(sql2);
            ResultSet rs2 = st2.executeQuery();
            if(rs2.next()){
                String direccionClub = rs2.getString("Direccion");
                if(direccionClub != null){
                    direccion_club.setText(direccionClub);
                }else{
                    direccion_usuario.setText("Dirección no disponible.");
                }
            }
            //Mostrar Precio del envio
            CallableStatement st3 = (CallableStatement) objetoConexion.Conectar().prepareCall(sql3);
            ResultSet rs3 = st3.executeQuery();
            if(rs3.next()){
                String precio = rs3.getString("PrecioEnvio");
                if(precio != null){
                    precioEnvio.setText(precio);
                }else{
                    precioEnvio.setText("El precio de envio no está disponible.");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar la dirección, error: " + e.toString());
            System.out.println("Error al mostrar la dirección, error: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }
    
    //Metodo CALCULAR EL TOTAL A PAGAR VENTANA FINALIZARCOMPRA===================================
    public String TotalPagar(int cantidad, String precio, String envio) {
        float totalidad = Float.parseFloat(precio) * cantidad + Float.parseFloat(envio);
        return String.valueOf(totalidad);
    }
    //Metodo PARA FINALIZAR COMPRA===============================================================
    
    //public void GuardarTarjeta(String usuarioID, String tipoTarjeta, String nombreTitular, String codigoSeguridad, String numerin){}
    public boolean GuardarPedido(String usuarioID, String productoID, String fecha, int cantidad, String formaEntrega, String envioID){
        String pedidoID = "";
        ConexionBDD objetoConexion = new ConexionBDD();
        String consulta = "INSERT INTO Pedido(IDUsuario, Fecha) VALUES (?, ?);";
        String consulta2 = "INSERT INTO DetallePedido(PedidoID, ProductoID, Cantidad, FormaEntrega, EnvioID) VALUES (?, ?, ?, ?, ?);";

        try {
            
            PreparedStatement ps = objetoConexion.Conectar().prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, Integer.parseInt(usuarioID));
            ps.setString(2, fecha);
            ps.executeUpdate();

           
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pedidoID = rs.getString(1);  
            }

            CallableStatement csDetalle = objetoConexion.Conectar().prepareCall(consulta2);
            csDetalle.setInt(1, Integer.parseInt(pedidoID)); 
            csDetalle.setInt(2, Integer.parseInt(productoID));
            csDetalle.setInt(3, cantidad);
            csDetalle.setString(4, formaEntrega);
            if(envioID.equals("-")){
                csDetalle.setNull(5, java.sql.Types.INTEGER); 
            }else{
                csDetalle.setInt(5,Integer.parseInt(envioID));
            }
            csDetalle.executeUpdate();

            
            JOptionPane.showMessageDialog(null, "Se guardó el pedido correctamente con ID: " + pedidoID);
            JOptionPane.showMessageDialog(null, "Tiene 30 dias para decidir reembolsar.");
            
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.toString());
            return false;
        } finally {
            objetoConexion.cerrarConexion();
        }
        
    }

    /*public boolean GuardarDinero(JTextField textField_TotalPagar){
        ConexionBDD objetoConexion = new ConexionBDD();
        String consulta1 = "INSERT INTO Cobros(Monto, fk_medio, motivo) VALUES (?, 4,'Venta de Producto');";
        String consulta2 = "INSERT INTO Movimientos(fk_cuenta, descripcion) VALUES (2, 'Pago con Tarjeta');";
        
        try{
            CallableStatement cs = objetoConexion.Conectar().prepareCall(consulta1);
            cs.setFloat(1, Float.parseFloat(textField_TotalPagar.getText()));
            cs.executeUpdate();
            
            CallableStatement cs2 = objetoConexion.Conectar().prepareCall(consulta2);
            cs2.executeUpdate();
            
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.toString());
            return false;
        }finally{
            objetoConexion.cerrarConexion();
        }
    }*/
    
    public boolean GuardarDinero(JTextField textField_TotalPagar) {
        ConexionBDD objetoConexion = new ConexionBDD();
        String consultaIDCobros = "SELECT MAX(id_cobro) + 1 AS NextID FROM Cobros;";
        String consultaIDMovimientos = "SELECT MAX(id_movimiento) + 1 AS NextID FROM Movimientos;";
        String consulta1 = "INSERT INTO Cobros(id_cobro, Monto, fk_medio, motivo) VALUES (?, ?, 4, 'Venta de Producto');";
        String consulta2 = "INSERT INTO Movimientos(id_movimiento, fk_cuenta, descripcion) VALUES (?, 2, 'Pago con Tarjeta');";

        try {
            // Obtener el próximo ID para Cobros
            CallableStatement csIDCobros = objetoConexion.Conectar().prepareCall(consultaIDCobros);
            ResultSet rsCobros = csIDCobros.executeQuery();
            int nextIDCobros = rsCobros.next() ? rsCobros.getInt("NextID") : 1;

            // Insertar en Cobros
            CallableStatement csCobros = objetoConexion.Conectar().prepareCall(consulta1);
            csCobros.setInt(1, nextIDCobros); // Usar el siguiente ID
            csCobros.setFloat(2, Float.parseFloat(textField_TotalPagar.getText())); // Monto
            csCobros.executeUpdate();

            // Obtener el próximo ID para Movimientos
            CallableStatement csIDMovimientos = objetoConexion.Conectar().prepareCall(consultaIDMovimientos);
            ResultSet rsMovimientos = csIDMovimientos.executeQuery();
            int nextIDMovimientos = rsMovimientos.next() ? rsMovimientos.getInt("NextID") : 1;

            // Insertar en Movimientos
            CallableStatement csMovimientos = objetoConexion.Conectar().prepareCall(consulta2);
            csMovimientos.setInt(1, nextIDMovimientos); // Usar el siguiente ID
            csMovimientos.executeUpdate();

            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.toString());
            return false;
        } finally {
            objetoConexion.cerrarConexion();
        }
    }
    
    

    
}




