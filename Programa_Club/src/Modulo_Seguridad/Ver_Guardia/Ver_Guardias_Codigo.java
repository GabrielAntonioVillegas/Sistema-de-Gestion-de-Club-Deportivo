/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Seguridad.Ver_Guardia;
import Modulo_Seguridad.Conexion_Bdd_Seguridad;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class Ver_Guardias_Codigo {
    //Crea la conexion con la bdd
    Conexion_Bdd_Seguridad conexion= new Conexion_Bdd_Seguridad();
    
    public Ver_Guardias_Codigo(){

    }

    //Agrega todos los guardias a un DefaultListModel
    public DefaultListModel mostrar(DefaultListModel modelo){
        //Le da datos al modelo
        modelo.removeAllElements();
        ArrayList array=conexion.Select_Guardias();
        for (int i=0; i<array.size(); i++){
            modelo.addElement(array.get(i));
        }
        return modelo;
        
    }
    

}
