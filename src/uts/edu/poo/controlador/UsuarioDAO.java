/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.edu.poo.controlador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import uts.edu.poo.mundo.Conexion;
import uts.edu.poo.mundo.Usuario;


/**
 *
 * @author garci
 */
public class UsuarioDAO {


   
    private Connection conexion;

    public UsuarioDAO() {
        conexion = new Conexion().establecerConexion();
    }

    // CREAR
    public void insertar(Usuario u) {
        String sql = "INSERT INTO Usuario(idUsuario, nombre, apellido, email, telefono, direccion) VALUES(?,?,?,?,?,?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, u.getIdUsuario());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getApellido());
            ps.setString(4, u.getEmail());
            ps.setString(5, u.getTelefono());
            ps.setString(6, u.getDireccion());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario agregado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar usuario: " + e.getMessage());
        }
    }

    //LISTAR
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getString("idUsuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setEmail(rs.getString("email"));
                u.setTelefono(rs.getString("telefono"));
                u.setDireccion(rs.getString("direccion"));
                
                lista.add(u);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar usuarios: " + e.getMessage());
        }
        return lista;
    }

    //ACTUALIZAR
  public int Actualizar(Usuario u) {
      int r = 0;
    String sql = "UPDATE Usuario SET nombre=?, apellido=?, email=?, telefono=?, direccion=? WHERE idUsuario=?";

    try (PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setString(1, u.getNombre());
        ps.setString(2, u.getApellido());
        ps.setString(3, u.getEmail());
        ps.setString(4, u.getTelefono());
        ps.setString(5, u.getDireccion());
        ps.setString(6, u.getIdUsuario());

        r=ps.executeUpdate();
        if(r==1){
            return 1;
        }else{
            return 0;}

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar usuario: " + e.getMessage());
    }

    return r;
   
}




    //BORRAR
    public int eliminar(int idUsuario) {
        int r=0;
        String sql = "DELETE FROM Usuario WHERE idUsuario=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e.getMessage());
        }
        return r;
    }
}


    

