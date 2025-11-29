/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.edu.poo.mundo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement; 
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author garci
 */
public class Conexion {
    
    private static Connection conectar = null;
    
    String bd = "gestionBiblioteca.db";
    String cadena = "jdbc:sqlite:" + System.getProperty("user.dir")+"/"+bd;
    
    
    public Connection establecerConexion(){
      
        if (conectar == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                conectar = DriverManager.getConnection(cadena);
                JOptionPane.showMessageDialog(null,"Se conecto correctamente");
                 try (Statement st = conectar.createStatement()) {
                    st.execute("PRAGMA foreign_keys = ON;");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "NO se conectó correctamente, error: " + e.toString());
            }
        }
        return conectar;
    }
    public void cerrarConexion(){
        try {
            if (conectar != null){
                conectar.close(); 
                JOptionPane.showMessageDialog(null,"Se desconecto correctamente" );
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"NO se desconecto correctamente, error:" + e.toString());
        }
    }
 
}
    

