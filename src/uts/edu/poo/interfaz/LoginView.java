/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.edu.poo.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author garci
 */

public class LoginView extends JFrame{
    //Atributos
    private JTextField txtUsuario;
    private JPasswordField txtClave;
    private JButton btnAcceder;
    private JButton btnSalir;

    public LoginView() {
        initComponents();
        this.setLocationRelativeTo(null); // Centrar la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        setTitle("Acceso al Sistema");
        setSize(400, 300);
        setLayout(new BorderLayout(10, 10));

        // Panel principal con un borde de padding
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPrincipal.setBackground(new Color(255, 242, 198));
        

        // Título
        JLabel lblTitulo = new JLabel("INICIO DE SESIÓN", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblTitulo.setForeground(new Color(226, 133, 46)); // Azul
        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);

        // Panel de formulario
        JPanel panelForm = new JPanel(new GridLayout(2, 2, 10, 10));
        panelForm.setBackground(new Color(255, 242, 198));
        
        txtUsuario = new JTextField(15);
        txtClave = new JPasswordField(15);
        
        panelForm.add(new JLabel("Usuario:", SwingConstants.RIGHT));
        panelForm.add(txtUsuario);
        panelForm.add(new JLabel("Contraseña:", SwingConstants.RIGHT));
        panelForm.add(txtClave);

        panelPrincipal.add(panelForm, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 0));
        panelBotones.setBackground(new Color (255, 242, 198));
        
        btnAcceder = new JButton("ACCEDER");
        btnAcceder.setActionCommand("LOGIN_ACCEDER");
        btnAcceder.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnAcceder.setBackground(new Color(101, 140, 88)); // Verde
        btnAcceder.setForeground(Color.WHITE);
        
        btnSalir = new JButton("SALIR");
        btnSalir.setActionCommand("LOGIN_SALIR");
        btnSalir.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnSalir.setBackground(new Color(140, 16, 7)); // Rojo
        btnSalir.setForeground(Color.WHITE);
        
        panelBotones.add(btnAcceder);
        panelBotones.add(btnSalir);
        
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal, BorderLayout.CENTER);
        pack();
    }
    
    // --- Métodos de Interacción ---

    public void agregarLoginListener(ActionListener listener) {
        btnAcceder.addActionListener(listener);
        btnSalir.addActionListener(listener);
        
        // Acción de salir directo
        btnSalir.addActionListener(e -> System.exit(0));
    }
    
    public String getUsuario() {
        return txtUsuario.getText().trim();
    }
    
    public String getClave() {
        return new String(txtClave.getPassword()).trim();
    }
    
    public void limpiarCampos() {
        txtUsuario.setText("");
        txtClave.setText("");
        txtUsuario.requestFocus();
    }
}
    