/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.edu.poo.main;

import uts.edu.poo.controlador.BibliotecarioDAO;
import uts.edu.poo.controlador.LoginController;
import uts.edu.poo.interfaz.LoginView;

/**
 *
 * @author garci
 */
public class Superior {
    
     public static void main(String[] args) {

        // --- 1. Inicialización de Componentes del Modelo (DAOs) ---
        // Se inicializan los DAOs, que son la interfaz del Modelo con la DB
         BibliotecarioDAO usuarioDAO = new BibliotecarioDAO();
        
        // --- 2. Inicialización de la Vista y el Controlador de Login ---
        LoginView loginView = new LoginView();
        // Inyectar todos los DAOs necesarios en el controlador de Login
        LoginController loginController = new LoginController(loginView, 
                                                              usuarioDAO); 

        // --- 3. Mostrar la ventana de Login ---
        loginView.setVisible(true);
        
    }
    
}
