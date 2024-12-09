/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Ventas;

/**
 *
 * @author tm_galli
 */
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import Modulo_Ventas.ConexionBDD;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JComboBox;

//CRUD Producto
public class CrudProducto {
    // Declaración de variables
    private int codigo;
    private String nombreProducto;
    private float precioProducto;
    private int stockProducto;
    private int idCategoria;
    JComboBox<CategoriaItem> comboCategorias = new JComboBox<>();
    
    //GET y SET para los parametros
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }
 
    public class CategoriaItem {
        private int idCategoria;
        private String nombreCategoria;

        public CategoriaItem(int idCategoria, String nombreCategoria) {
            this.idCategoria = idCategoria;
            this.nombreCategoria = nombreCategoria;
        }

        public int getIdCategoria() {
            return idCategoria;
        }

        @Override
        public String toString() {
            return nombreCategoria; // Este es el nombre que se mostrará en el JComboBox
        }
    }
    
    //Metodos
    //Obtener el valor de Nombre
    public String obtenerNombreOriginal(String idProducto) {
            return obtenerValorOriginal(idProducto, "Nombre");
    }

    //Obtener el valor de Precio
    public String obtenerPrecioOriginal(String idProducto) {
       return obtenerValorOriginal(idProducto, "Precio");
    }
    
    //Obtener el valor de Stock
    public String obtenerStockOriginal(String idProducto) {
        return obtenerValorOriginal(idProducto, "Stock");
    }
    
    //Verifica si existe producto con nombres
    public boolean existeProductoConNombreYCategoria(String nombreProducto, int idCategoria) {
        ConexionBDD objetoConexion = new ConexionBDD();
        String consulta = "SELECT COUNT(*) AS total FROM Productos WHERE Nombre = ? AND CategoriaID = ?;";
        try (PreparedStatement ps = objetoConexion.Conectar().prepareStatement(consulta)) {
            ps.setString(1, nombreProducto);
            ps.setInt(2, idCategoria);  // Usar el ID de la categoría
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getInt("total") > 0) {
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia del producto: " + e.getMessage());
        } finally {
            objetoConexion.cerrarConexion();
        }
        return false; 
    }    
    //Obtiene el valor de producto ID
    private String obtenerValorOriginal(String idProducto, String columna) {
        ConexionBDD objetoConexion = new ConexionBDD();
        String consulta = "SELECT " + columna + " FROM Productos WHERE ProductoID = ?;";

        try (PreparedStatement ps = objetoConexion.Conectar().prepareStatement(consulta)) {
            ps.setString(1, idProducto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(columna);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener " + columna + ": " + e.getMessage());
        } finally {
            objetoConexion.cerrarConexion();
        }
        return "";
    }

    // Insertar productos
    public void InsertarProducto(JTextField paramNombreProducto, JTextField paramStockProducto, JTextField paramPrecioProducto, JComboBox<CategoriaItem> comboBoxCategorias) {
        // Abrir conexión
        ConexionBDD objetoConexion = new ConexionBDD();
        String consulta = "INSERT INTO Productos (Nombre, Stock, Precio, CategoriaID,Estado) "
                + "VALUES (?, ?, ?, ?,0);";

        try {
            CallableStatement cs = objetoConexion.Conectar().prepareCall(consulta);
            cs.setString(1, paramNombreProducto.getText());
            cs.setInt(2, Integer.parseInt(paramStockProducto.getText()));
            cs.setFloat(3, Float.parseFloat(paramPrecioProducto.getText()));

            // Obtener el objeto CategoriaItem y su idCategoria
            CategoriaItem selectedItem = (CategoriaItem) comboBoxCategorias.getSelectedItem();
            if (selectedItem != null) {
                cs.setInt(4, selectedItem.getIdCategoria()); // Usar el ID correcto
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona una categoría válida.");
                return; // Salir del método si no hay selección válida
            }
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el producto");
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se insertó correctamente el producto, error: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al convertir los valores numéricos: " + e.getMessage());
        }
    }

    // Mostrar productos
    public void MostrarProductos(JTable paramTablaProductos) {
        ConexionBDD objetoConexion = new ConexionBDD();
        DefaultTableModel modelo = new DefaultTableModel();
   
        String sql="";
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Stock");
        modelo.addColumn("Precio");
        modelo.addColumn("Categoría");
        paramTablaProductos.setModel(modelo);
       
        sql="SELECT Productos.ProductoID,Productos.Nombre,Productos.Stock,Productos.Precio,"
                + "Categorias.NombreCategoria FROM Productos "
                + "INNER JOIN Categorias ON Productos.CategoriaID = Categorias.CategoriaID";

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

               
                modelo.addRow(new Object[]{id,nombres,stocks,precios,categoria});
            }
            paramTablaProductos.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar correctamente los registros, error: " + e.getMessage());
        }finally{
            objetoConexion.cerrarConexion();
        }
    }

    // Cargar categorías
    public void cargarProductos(JComboBox<CategoriaItem> comboCategorias) {
        ConexionBDD objetoConexion = new ConexionBDD();
        String consulta = "SELECT CategoriaID, NombreCategoria FROM Categorias;";
        Statement st;

        try {
            st = objetoConexion.Conectar().createStatement();
            ResultSet rs = st.executeQuery(consulta);
            comboCategorias.removeAllItems();

            while (rs.next()) {
                int idCategoria = rs.getInt("CategoriaID");
                String nombreCategoria = rs.getString("NombreCategoria");
                comboCategorias.addItem(new CategoriaItem(idCategoria, nombreCategoria)); // Añade un nuevo objeto CategoriaItem
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar categorías: " + e.getMessage());
        }finally{
            objetoConexion.cerrarConexion();
        }
    }


    // Seleccionar categoría
    public void SeleccionarCategoria(JComboBox<String> comboBoxCategorias, JTextField paramID, JTextField paramNombreCategoria) {
        try {
            String nombreCategoriaSeleccionada = (String) comboBoxCategorias.getSelectedItem();
            ConexionBDD objetoConexion = new ConexionBDD();
            String consulta = "SELECT ID FROM Categorias WHERE Nombre = ?;";

            PreparedStatement ps = objetoConexion.Conectar().prepareStatement(consulta);
            ps.setString(1, nombreCategoriaSeleccionada);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                paramID.setText(rs.getString("ID"));
                paramNombreCategoria.setText(nombreCategoriaSeleccionada);
            } else {
                JOptionPane.showMessageDialog(null, "Categoría no encontrada");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.getMessage());
        }
    }

    // Seleccionar producto
    public void SeleccionarProducto(JTable paramTablaProductos, JTextField paramID, JTextField paramNombreProducto, JTextField paramStockProducto, JTextField paramPrecioProducto,JComboBox<CategoriaItem> comboBoxCategorias) {
        try {
            int fila = paramTablaProductos.getSelectedRow();

            if (fila >= 0) {
                paramID.setText(paramTablaProductos.getValueAt(fila, 0).toString());
                paramNombreProducto.setText(paramTablaProductos.getValueAt(fila, 1).toString());
                paramStockProducto.setText(paramTablaProductos.getValueAt(fila, 2).toString());
                paramPrecioProducto.setText(paramTablaProductos.getValueAt(fila, 3).toString());

                String nombreCategoria = paramTablaProductos.getValueAt(fila, 4).toString();

                for (int i = 0; i < comboBoxCategorias.getItemCount(); i++) {
                    CategoriaItem item = comboBoxCategorias.getItemAt(i);
                    if (item.toString().equals(nombreCategoria)) {
                        comboBoxCategorias.setSelectedItem(item);
                        break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Fila no encontrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.getMessage());
        }
    }


    // Modificar
    public void ModificarProducto(JTextField paramID, JTextField paramNombreProducto, JTextField paramStockProducto, JTextField paramPrecioProducto, JComboBox<CategoriaItem> comboBoxCategorias) {

        ConexionBDD objetoConexion = new ConexionBDD();
        String consulta = "UPDATE Productos SET Nombre=?, Stock=?, Precio=?, CategoriaID=? WHERE ProductoID=?;";

        try {
            CallableStatement cs = objetoConexion.Conectar().prepareCall(consulta);

            // Asignar valores de los campos de texto
            cs.setString(1, paramNombreProducto.getText());  // Nombre del producto
            cs.setFloat(2, Float.parseFloat(paramPrecioProducto.getText())); // Precio
            cs.setInt(3, Integer.parseInt(paramStockProducto.getText())); // Stock


            // Obtener el ID de la categoría seleccionada del JComboBox
            CategoriaItem selectedCategory = (CategoriaItem) comboBoxCategorias.getSelectedItem();
            if (selectedCategory != null) {
                cs.setInt(4, selectedCategory.getIdCategoria()); // ID de la categoría
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecciona una categoría válida.");
                return; // Salir del método si no hay una categoría válida
            }

            // Asignar el ID del producto
            cs.setInt(5, Integer.parseInt(paramID.getText()));  // ID del producto

            // Ejecutar la actualización
            cs.executeUpdate();

            JOptionPane.showMessageDialog(null, "Modificación exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se modificó: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de los números: " + e.getMessage());
        }finally{
                objetoConexion.cerrarConexion();
        }
    }

    public void EliminarProducto(JTextField paramCodigo) {
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        ConexionBDD objetoConexion = new ConexionBDD();

        String consulta1 = "DELETE FROM DescuentoProductos WHERE ProductoID = ?;";
        String consulta2 = "DELETE FROM DetallePedido WHERE ProductoID = ?;";
        String consulta3 = "DELETE FROM Productos WHERE ProductoID = ?;";



        try (PreparedStatement ps1 = objetoConexion.Conectar().prepareStatement(consulta1);
             PreparedStatement ps2 = objetoConexion.Conectar().prepareStatement(consulta2);
             PreparedStatement ps3 = objetoConexion.Conectar().prepareStatement(consulta3)){

            ps1.setInt(1, getCodigo());
            ps1.executeUpdate();

            ps2.setInt(1, getCodigo());
            ps2.executeUpdate();
            
            ps3.setInt(1, getCodigo());
            ps3.executeUpdate();

            JOptionPane.showMessageDialog(null, "Se eliminó correctamente el registro");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se eliminó correctamente el registro, error: " + e.getMessage());
            System.out.println(e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }

   //Limpiar campos
    public void LimpiarCampos(JTextField paramID, JTextField paramNombreProducto, JTextField paramStockProducto, JTextField paramPrecioProducto, JComboBox<CategoriaItem> comboBoxCategorias) {
        paramID.setText("");
        paramNombreProducto.setText("");
        paramStockProducto.setText("");
        paramPrecioProducto.setText("");
       
    }
}