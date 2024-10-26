/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Seguridad.Comprar_equip;
import Modulo_Seguridad.Conexion_Bdd_Seguridad;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author HP OMEN
 */
public class Mod_equip_codigo {
    
    Conexion_Bdd_Seguridad conexion = new Conexion_Bdd_Seguridad();
    
    public DefaultListModel Cargar_datos(DefaultListModel modelo){
        modelo.removeAllElements();
        ArrayList array_carga= conexion.Select_Equipo();
        for (int i=0; i<array_carga.size(); i++){
            modelo.addElement(array_carga.get(i));
        }
        return modelo;
    }
    
    public void Insert(String Nombre, int Precio, String Descripcion,String link,byte[] ByteImage){
        conexion.Insert_Tipo_equipamiento(Nombre, Precio, Descripcion,link,ByteImage);
    }
    
    public void Delete(String itemSeleccionado){
        String[] separado=itemSeleccionado.split(" / ");
        JOptionPane.showMessageDialog(null, "Seleccionaste: " + separado);
        int id=Integer.parseInt(separado[0]);
        conexion.Delete_tipo_equipo(id);
        
    }
    
    public byte[] Crear_file() throws IOException{
        JFileChooser file_imagen= new JFileChooser();
        
        file_imagen.setDialogTitle("Seleccionar imagen");

        // Filtro para que solo aparezcan archivos de imagen
        file_imagen.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png"));

        int result = file_imagen.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File Imagen= file_imagen.getSelectedFile();
            byte[] imageBytes =convertirImagenAByte(Imagen);
            return imageBytes;
        }
        return null;
    }
    public byte[] convertirImagenAByte(File Imagen) throws IOException{
        try (FileInputStream fis = new FileInputStream(Imagen);
               ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
            
    }
    }
  }
