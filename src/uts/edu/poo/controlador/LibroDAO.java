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
import uts.edu.poo.mundo.Libro;


/**
 *
 * @author garci
 */
public class LibroDAO {
  
    private Connection conexion;

    public LibroDAO() {
        conexion = new Conexion().establecerConexion();
    }
    
      // CREAR
    public void insertar(Libro l) {
        String sql = "INSERT INTO Libro(idLibro, titulo, autor, anioPublicacion, editorial, categoria) VALUES(?,?,?,?,?,?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, l.getIdLibro());
            ps.setString(2, l.getTitulo());
            ps.setString(3, l.getAutor());
            ps.setInt(4,l.getAnioPublicacion());
            ps.setString(5, l.getEditorial());            
            ps.setString(6, l.getCategoria());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario agregado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar libro: " + e.getMessage());
        }
    }
    
    //Listar
    
        public List<Libro> listar() {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM Libro";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Libro l = new Libro();
                l.setIdLibro(rs.getInt("idLibro"));
                l.setTitulo(rs.getString("titulo"));
                l.setAutor(rs.getString("autor"));
                l.setAnioPublicacion(rs.getInt("anioPublicacion"));
                l.setEditorial(rs.getString("editorial"));
                l.setCategoria(rs.getString("categoria"));
                
                lista.add(l);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar usuarios: " + e.getMessage());
        }
        return lista;
    }
        
     //Actualizar
       public int Actualizar(Libro l) {
      int r = 0;
    String sql = "UPDATE Libro SET  titulo=?, autor=?, anioPublicacion=?, editorial=?, categoria=? WHERE idLibro=?";

    try (PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setString(1, l.getTitulo());
        ps.setString(2, l.getAutor());
        ps.setInt(3, l.getAnioPublicacion());
        ps.setString(4, l.getEditorial());
        ps.setString(5, l.getCategoria());
        ps.setInt(6, l.getIdLibro());

        r=ps.executeUpdate();
        if(r==1){
            return 1;
        }else{
            return 0;}

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar el libro: " + e.getMessage());
    }

    return r;
   
}  
       
       //BORRAR
    public int eliminar(int idLibro) {
        int r=0;
        String sql = "DELETE FROM Libro WHERE idLibro=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idLibro);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el libro: " + e.getMessage());
        }
        return r;
    }

    
}
