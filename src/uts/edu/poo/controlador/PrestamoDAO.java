/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.edu.poo.controlador;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import uts.edu.poo.mundo.Prestamo;
import uts.edu.poo.mundo.Usuario;
import uts.edu.poo.mundo.Conexion;



/**
 *
 * @author garci
 */
public class PrestamoDAO {
    private Connection conexion;

    public PrestamoDAO() {
        conexion = new Conexion().establecerConexion();
    }
    
    public void insertar(Prestamo p) {
        String sql = "INSERT INTO Prestamo(idPrestamo, idUsuario, fechaPrestamo, fechaEsperadaDevolucion, fechaRealDevolucion, libro) VALUES(?,?,?,?,?,?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, p.getIdPrestamo());
            ps.setInt(2, p.getIdUsuario());
            ps.setString(3,  p.getFechaPrestamo());
            ps.setString(4 ,p.getFechaEsperadaDevolucion());
            ps.setString(5,  p.getFechaRealDevolucion());
            ps.setString(6, p.getLibro());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario agregado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar usuario: " + e.getMessage());
        }
    }
    
       //Listar
        public List<Prestamo> listar() {
        List<Prestamo> lista = new ArrayList<>();
        String sql = "SELECT * FROM Prestamo";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Prestamo p = new Prestamo();
                p.setIdPrestamo(rs.getInt("idPrestamo"));
                p.setIdUsuario(rs.getInt("idUsuario"));
                p.setFechaPrestamo(rs.getString("fechaPrestamo"));
                p.setFechaEsperadaDevolucion(rs.getString("fechaEsperadaDevolucion"));
                p.setFechaRealDevolucion(rs.getString("fechaRealDevolucion"));
                p.setLibro(rs.getString("libro"));
                
                lista.add(p);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar usuarios: " + e.getMessage());
        }
        return lista;
    }
        
        
 
        
  //Actualizar
   public int Actualizar(Prestamo p) {
      int r = 0;
    String sql = "UPDATE Prestamo SET  idUsuario=?, fechaPrestamo=?, fechaEsperadaDevolucion=?, fechaRealDevolucion=?, libro=? WHERE idPrestamo=?";

    try (PreparedStatement ps = conexion.prepareStatement(sql)) {

       
        ps.setInt(1, p.getIdUsuario());
        ps.setString(2, p.getFechaPrestamo());
        ps.setString(3, p.getFechaEsperadaDevolucion());
        ps.setString(4, p.getFechaRealDevolucion());
        ps.setString(5,p.getLibro());
        ps.setInt(6, p.getIdPrestamo());

        r=ps.executeUpdate();
        if(r==1){
            return 1;
        }else{
            return 0;}

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar el prestamo: " + e.getMessage());
    }

    return r;
   
} 
       
 //BORRAR
    public int eliminar(int idPrestamo) {
    int r = 0;
    String sql = "DELETE FROM Prestamo WHERE idPrestamo = ?";
    try (PreparedStatement ps = conexion.prepareStatement(sql)) {
    ps.setInt(1, idPrestamo);
    ps.executeUpdate();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar préstamo: " + e.getMessage());
        e.printStackTrace();
    }

    return r;
}
    
}
