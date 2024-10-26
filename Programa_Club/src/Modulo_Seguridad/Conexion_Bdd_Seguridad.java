/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Seguridad;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
/**
 *
 * @author PC
 */
public class Conexion_Bdd_Seguridad {
    private String Nom_z;
    private int id_z;
    private String[] vector;
    public Connection Conectar() {
        Connection miConexion = null; // Inicializa la conexión como nula
        try {
            // Asegúrate de que la URL esté correctamente formateada
            String url = "jdbc:mysql://bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb";
            String user = "uwwqerjcglxxweor"; // Nombre de usuario
            String password = "vWobxeLnCiH11WTJg6N"; // Contraseña

            // Intenta establecer la conexión
            miConexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
        return miConexion; // Retorna la conexión (puede ser nula si hubo un error)
    }

    
    //Este es un metodo que podemos usar para cualquier tabla
   
    
    public ArrayList Select_socios(){
        try{
            ArrayList<String> array = new ArrayList<String>();
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            String query="SELECT s.IDUsuario, u.Nombre_usuario FROM Usuario u,Socio s WHERE (u.IDUsuario=s.IDUsuario) and s.IDUsuario NOT IN (SELECT ID_Usuario FROM Socios_Suspendidos);";
            Statement  sele = miConexion.createStatement();
            ResultSet result=sele.executeQuery(query);
            while(result.next()){
                String Item=result.getInt("IDUsuario") + "-------" + result.getString("Nombre_usuario");
                array.add(Item);
                System.out.println("hola");
            }
            
            miConexion.close();
            return array;
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            return null;    
        }
        
    }
    //Metodo usado por los de seguridad
    public ArrayList Select_unique_socio(int id){
        try{
            ArrayList<String> array = new ArrayList<String>();
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            String str="SELECT * FROM Usuario u WHERE u.IDUsuario=?";
            PreparedStatement  query=miConexion.prepareStatement(str);
            query.setInt(1,id);
            ResultSet result = query.executeQuery();
            
            while(result.next()){
                String Id="ID DE USUARIO/SOCIO=" + result.getInt("IDUsuario");
                array.add(Id);
                String Nombre="NOMBRE DE SOCIO=" + result.getString("Nombre_usuario");
                array.add(Nombre);
                String Contra="CONTRASEÑA=" + result.getString("Contraseña");
                array.add(Contra);
                String Direccion="DIRECCION=" + result.getString("Direccion");
                array.add(Direccion);
                String Email="EMAIL=" + result.getString("Email");
                array.add(Email);
            }
            
            miConexion.close();
            return array;
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            return null;
        }
        
       
   }
    //--- ZONA DE SEGURIDAD ---//
    public ArrayList Select_Zona_de_Seguridad(){
        try{
            //vector=new [2];
            ArrayList<String> array = new ArrayList<String>();
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            String query="SELECT ID,Nombre,Tamaño,Descripcion FROM Zona_de_Seguridad;";
            Statement  sele = miConexion.createStatement();
            ResultSet result=sele.executeQuery(query);
            while(result.next()){
                String Item=result.getInt("ID") + "-" + result.getString("Nombre");//+ "-" + result.getString("Tamaño")+ "-" + result.getString("Descripcion");
                array.add(Item);
                //vector[0]=getString(result.getInt("ID"));

            }
            
            miConexion.close();
            return array;
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            return null;    
        }
        
    }
   public ArrayList Select_unique_zona(int id){
        try{
            ArrayList<String> array = new ArrayList<String>();
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            String str="SELECT * FROM Zona_de_Seguridad WHERE ID=?";
            PreparedStatement  query=miConexion.prepareStatement(str);
            query.setInt(1,id);
            ResultSet result = query.executeQuery();
            
            while(result.next()){
                String Id="ID DE LA ZONA=" + result.getInt("ID");
                array.add(Id);
                String Nombre="NOMBRE DE LA ZONA=" + result.getString("Nombre");
                array.add(Nombre);
                String Tamaño="TAMAÑO=" + result.getString("Tamaño");
                array.add(Tamaño);
                String Descripcion="DESCRIPCION=" + result.getString("Descripcion");
                array.add(Descripcion);
            }
            
            miConexion.close();
            return array;
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            return null;
        }
        
       
   }
   
   
    public Boolean Insert_Zona_Seguridad(String Nombre, String Tamaño, String Descripcion){
        try{
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            PreparedStatement sele= miConexion.prepareStatement("INSERT INTO Zona_de_Seguridad (Nombre, Tamaño, Descripcion) VALUES (?,?,?)");

            
            sele.setString(1,Nombre);
            sele.setString(2,Tamaño);
            sele.setString(3,Descripcion);
            

            sele.executeUpdate();

            miConexion.close();
            return(true);

        }catch(Exception e){
            System.out.println("No funca");

            e.printStackTrace();
            return(false);

        }
    }
    public Boolean Delete_Zona_Seguridad(int id_Zona){
        try{
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            PreparedStatement sele= miConexion.prepareStatement("DELETE FROM Zona_de_Seguridad WHERE ID=?");

            
            sele.setInt(1,id_Zona);
            

            sele.executeUpdate();

            miConexion.close();
            return(true);

        }catch(Exception e){
            System.out.println("No funca");

            e.printStackTrace();
            return(false);

        }
    }
    public Boolean Modificar_Zona_Seguridad(int id_Zona, String Nombre, String Tamaño, String Descripcion){
        try{
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            PreparedStatement sele= miConexion.prepareStatement("UPDATE Zona_de_Seguridad SET Nombre=?, Tamaño=?, Descripcion=? WHERE ID=?");

            
            sele.setString(1,Nombre);
            sele.setString(2,Tamaño);
            sele.setString(3,Descripcion);
            sele.setInt(4,id_Zona);
            

            sele.executeUpdate();

            miConexion.close();
            return(true);

        }catch(Exception e){
            System.out.println("No funca");

            e.printStackTrace();
            return(false);

        }
    }
    
    public ArrayList Select_Guardias(){
        try{
            ArrayList<String> array = new ArrayList<String>();
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            String query="SELECT e.idempleado, e.nombre, c.cargos FROM Empleado e, Cargo c WHERE e.idcargo=c.idcargo;";//necesito mas datos en la base de datos
            Statement  sele = miConexion.createStatement();
            ResultSet result=sele.executeQuery(query);
            while(result.next()){
                String Item=result.getInt("idempleado") + "-" + result.getString("nombre")+ "-" + result.getString("cargos");
                array.add(Item);
            }
            
            miConexion.close();
            return array;
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            return null;    
        }
        
    }
    
    public Boolean Insert_socio_mal(int Id ,String Razon, int Tiempo, Date sqlDate){
        try{
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            PreparedStatement sele= miConexion.prepareStatement("INSERT INTO Socios_Suspendidos (ID_Usuario, Tiempo_Suspendido, razon, Fecha) VALUES (?,?,?,?)");
            if (Tiempo!=0){
                sele.setInt(1,Id);
                sele.setInt(2, Tiempo);
                sele.setString(3,Razon);
                sele.setDate(4,sqlDate);

                sele.executeUpdate();

                PreparedStatement sele2= miConexion.prepareStatement("CREATE EVENT borrar_registro ON SCHEDULE AT CURRENT_TIMESTAMP + INTERVAL ? DAY DO DELETE FROM Socios_Suspendidos WHERE ID_Usuario = ?");
                sele2.setInt(1,Tiempo);
                sele2.setInt(1,Id);
                sele2.execute();
                miConexion.close();
                return(true);
            }else{
                sele.setInt(1,Id);
                sele.setInt(2, 999999999);
                sele.setString(3,Razon);
                sele.setDate(4,sqlDate);

                sele.executeUpdate();
                 miConexion.close();
                return(true);
                
            }
            
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            return(false);
            
        }
    }
    
    public ArrayList Select_s_s(){
        try{
            ArrayList<String> array = new ArrayList<String>();
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            String query="SELECT * FROM Socios_Suspendidos";//necesito mas datos en la base de datos
            Statement  sele = miConexion.createStatement();
            ResultSet result=sele.executeQuery(query);
            while(result.next()){
                String Item=result.getInt("ID") + "-" + result.getInt("ID_Usuario")+ "-" + result.getInt("Tiempo_Suspendido") + "-" + result.getString("razon")+ "-" + result.getDate("Fecha");
                array.add(Item);
            }
            
            miConexion.close();
            return array;
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            return null;    
        }
        
    }
    
    public void Insert_Tipo_equipamiento(String Nombre, int Precio, String Descripcion,String link,byte[] ByteImagen){
        
        try{
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            PreparedStatement sele= miConexion.prepareStatement("INSERT INTO Tipo_Equipamiento(Nombre, Precio, Descripcion, Link,ByteImagen) VALUES (?,?,?,?,?)");
            sele.setString(1, Nombre);
            sele.setInt(2, Precio);
            sele.setString(3, Descripcion);
            sele.setString(4, link);
            sele.setBytes(5, ByteImagen);
            sele.executeUpdate();
            miConexion.close();
            
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
        }
  
    }
    
    public ArrayList Select_Equipo(){
        try{
            ArrayList<String> resultados = new ArrayList<String>();
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            PreparedStatement sele = miConexion.prepareStatement("SELECT * FROM Tipo_Equipamiento");
            ResultSet resul=sele.executeQuery();
             while(resul.next()){
                String Item=resul.getInt("Tipo_Id") + " / " + resul.getString("Nombre")+ " / " + resul.getString("Precio");
                resultados.add(Item);
                System.out.println(Item);
            }
            
            miConexion.close();
            return resultados;
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            return null;
        }
    }
    
    public void Delete_tipo_equipo(int Id){
        try{
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            PreparedStatement sele= miConexion.prepareStatement("DELETE FROM Tipo_Equipamiento WHERE Tipo_Id=?");
            sele.setInt(1, Id);
            sele.executeUpdate();
            miConexion.close();
            
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            
        }
    }
    
    public ArrayList Select_Equipo_con_Imagen(int id){
        try{
            ArrayList<String> array = new ArrayList<String>();
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            String str="SELECT * FROM Tipo_Equipamiento WHERE Tipo_Id=?";
            PreparedStatement  query=miConexion.prepareStatement(str);
            query.setInt(1,id);
            ResultSet result = query.executeQuery();
            
            while(result.next()){
                String Id="ID DE Equipamiento=" + result.getInt("Tipo_Id");
                array.add(Id);
                String Nombre="NOMBRE DE Equipamiento=" + result.getString("Nombre");
                array.add(Nombre);
                String Desc="Descripcion=" + result.getString("Descripcion");
                array.add(Desc);
                String Precio="PRECIO=" + result.getInt("Precio");
                array.add(Precio);
                String Link="LINK=" + result.getString("Link");
                array.add(Link);
                byte[] ByteImagen= result.getBytes("ByteImagen");
                if(ByteImagen!=null){
                    String imagen=Base64.getEncoder().encodeToString(ByteImagen);
                    array.add(imagen);
                }else{
                    array.add(null);
                }
            }
            
            miConexion.close();
            return array;
        
        }catch(Exception e){
            return null;
        }
        
    }
    
    public void Insert_equipamiento(String Nombre,int cant, int id){
        try{
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            for(int i=0;i<cant;i++){
                PreparedStatement sele= miConexion.prepareStatement("INSERT INTO Equipamiento(Nombre, Tipo_id) VALUES (?,?)");
                sele.setString(1,Nombre);
                sele.setInt(2, id);
                sele.executeUpdate();
            }
            miConexion.close();
            
        }catch(Exception e){
             System.out.println("No funca");
            
            e.printStackTrace();
        }

    }
    
    
    
}
