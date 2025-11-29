/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.edu.poo.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import uts.edu.poo.mundo.Bibliotecario;
import uts.edu.poo.mundo.Conexion;

/**
 *
 * @author garci
 */
public class BibliotecarioDAO {
    
        private final Conexion db; 

    public BibliotecarioDAO() {
        this.db = new Conexion(); 
    }
    
    /**
     * Valida las credenciales y verifica si el usuario es 'Administrador'.
     * @return Usuario si la autenticación es exitosa y es Administrador, null en caso contrario.
     */
    public Bibliotecario validarCredenciales(String nombreUsuario, String clave) {
        String SQL = "SELECT idUsuario, nombreUsuario, clave, correo FROM bibliotecario "
                + "WHERE nombreUsuario = ? AND clave = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = db.establecerConexion();
            if (conn != null) {
                ps = conn.prepareStatement(SQL);
                ps.setString(1, nombreUsuario);
                ps.setString(2, clave);
                rs = ps.executeQuery();

                if (rs.next()) {
                    Bibliotecario u = new Bibliotecario();
                    u.setId(rs.getInt("idUsuario"));
                    u.setNombreUsuario(rs.getString("nombreUsuario"));
                    u.setClave(rs.getString("clave"));
                    u.setCorreo(rs.getString("correo"));
                    return u; // Autenticación exitosa
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al validar credenciales: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
               
            } catch (SQLException e) {
            }
        }
        return null;
    }
    
     }