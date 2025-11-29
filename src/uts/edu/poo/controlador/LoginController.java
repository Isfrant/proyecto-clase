
package uts.edu.poo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import uts.edu.poo.interfaz.LoginView;
import uts.edu.poo.interfaz.Principal;
import uts.edu.poo.mundo.Bibliotecario;

/**
 *
 * @author garci
 */

    public class LoginController implements ActionListener{

    //Atributos
    private final LoginView view;
    private final BibliotecarioDAO bibliotecarioDAO;

    public LoginController(LoginView view, BibliotecarioDAO bibliotecarioDAO ) {
        this.view = view;
        this.bibliotecarioDAO = bibliotecarioDAO;
        
        this.view.agregarLoginListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        if (comando.equals("LOGIN_ACCEDER")) {
            String usuario = view.getUsuario();
            String clave = view.getClave();
            
            Bibliotecario bibliotecarioAutenticado = bibliotecarioDAO.validarCredenciales(usuario, clave);
            
            if (bibliotecarioAutenticado != null) {
                view.dispose(); // Cerrar la ventana de Login
                iniciarMenuPrincipal(bibliotecarioAutenticado);
            } else {
                JOptionPane.showMessageDialog(view, "Credenciales incorrectas.\nUsuario de prueba: admin | Clave: 123", "Error de Autenticación", JOptionPane.ERROR_MESSAGE);
                view.limpiarCampos();
            }
        }
    }

    /**
     * Instancia y muestra la vista del menú principal.
     */
    private void iniciarMenuPrincipal(Bibliotecario bibliotecarioAutenticado) {
    Principal principal = new Principal();
    principal.setVisible(true);
}
    
}
