
package gestiondeeventos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseConnection {
    private Connection miConexion = null; // Inicializa la conexión como nula

    public Connection Conectar() {
        try {
            // Asegúrate de que la URL esté correctamente formateada
            String url = "jdbc:mysql://bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb";
            String user = "uwwqerjcglxxweor"; // Nombre de usuario
            String password = "vWobxeLnCiH11WTJg6N"; // Contraseña

            // Intenta establecer la conexión
            miConexion = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Se conectó correctamente a la BDD");        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se conectó correctamente a la BDD: " + e.toString());
        }
        return miConexion; // Retorna la conexión (puede ser nula si hubo un error)
    }

    public void cerrarConexion() {
        try {
            if (miConexion != null && !miConexion.isClosed()) {
                miConexion.close(); // Cierra la conexión
                JOptionPane.showMessageDialog(null, "Conexión cerrada");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cerrar la conexión: " + e.toString());
        }
    }
}