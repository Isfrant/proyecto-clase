/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.edu.poo.mundo;


/**
 *
 * @author garci
 */
public class Prestamo {
     private int idPrestamo;
    private int idUsuario;
    private String libro;
    private String fechaPrestamo;
    private String fechaEsperadaDevolucion;
    private String fechaRealDevolucion;

    public Prestamo() {
    }

    public Prestamo(int idPrestamo, int idUsuario, String libro,String fechaPrestamo, String fechaEsperadaDevolucion, String fechaRealDevolucion) {
        this.idPrestamo = idPrestamo;
        this.idUsuario = idUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEsperadaDevolucion = fechaEsperadaDevolucion;
        this.fechaRealDevolucion = fechaRealDevolucion;
        this.libro=libro;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaEsperadaDevolucion() {
        return fechaEsperadaDevolucion;
    }

    public void setFechaEsperadaDevolucion(String fechaEsperadaDevolucion) {
        this.fechaEsperadaDevolucion = fechaEsperadaDevolucion;
    }

    public String getFechaRealDevolucion() {
        return fechaRealDevolucion;
    }

    public void setFechaRealDevolucion(String fechaRealDevolucion) {
        this.fechaRealDevolucion = fechaRealDevolucion;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }
    
    
    
}
