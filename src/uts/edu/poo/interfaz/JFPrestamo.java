/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uts.edu.poo.interfaz;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
 
import uts.edu.poo.controlador.PrestamoDAO;
import uts.edu.poo.mundo.Prestamo;


/**
 *
 * @author fabian
 */
public class JFPrestamo extends javax.swing.JFrame {
    
    

    /**
     * Creates new form Prestamo
     */
    public JFPrestamo() {
        initComponents();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    
    //LIMPIAR TABLA
    private void limpiar(){
        txtIdPrestamo.setText("");
        txtIdUsuario.setText("");
        txtFechaPrestamo.setText("");
        txtFechaEsperada.setText("");
        txtFechaReal.setText("");
        txtLibro.setText("");
    }
         
   //REFRESCAR TABLA 
    private void refrescarTabla() {
    PrestamoDAO dao = new PrestamoDAO();
    List<Prestamo> lista = dao.listar();
    
    DefaultTableModel modelo = (DefaultTableModel) tlbPrestamos.getModel();
    modelo.setRowCount(0); // limpia la tabla

    for (Prestamo p : lista) {
        modelo.addRow(new Object[]{
            p.getIdPrestamo(),
            p.getIdUsuario(),
            p.getFechaPrestamo(),
            p.getFechaEsperadaDevolucion(),
            p.getFechaRealDevolucion(),
            p.getLibro()
        
        });
    }}
    //AGREGAR
   private void agregarPrestamo(){
     Prestamo p = new Prestamo();
     
    p.setIdPrestamo(Integer.parseInt(txtIdPrestamo.getText()));
    p.setIdUsuario(Integer.parseInt(txtIdUsuario.getText()));
    p.setFechaPrestamo (txtFechaPrestamo.getText());
    p.setFechaEsperadaDevolucion(txtFechaEsperada.getText());
    p.setFechaRealDevolucion(txtFechaReal.getText());
    p.setLibro(txtLibro.getText());
    
    PrestamoDAO dao = new PrestamoDAO();
    dao.insertar(p);
    limpiar();
    refrescarTabla();
        
    }
   
  //MOSTRAR 
      private void listarPrestamos() {
    PrestamoDAO dao = new PrestamoDAO();
    List<Prestamo> lista = dao.listar();

    DefaultTableModel modelo = (DefaultTableModel) tlbPrestamos.getModel();
    modelo.setRowCount(0); 

    for (Prestamo p : lista) {
        modelo.addRow(new Object[]{
            p.getIdPrestamo(),
            p.getIdUsuario(),
            p.getFechaPrestamo(),
            p.getFechaEsperadaDevolucion(),
            p.getFechaRealDevolucion(),
            p.getLibro()
 
          
        });
    }
}
   //LLENAR FORMULARIO
    public void llenarFormulario (){
   int fila = tlbPrestamos.getSelectedRow();
   if (fila ==-1){
       JOptionPane.showMessageDialog(null, "Debe seleciionar una fila...");
   }else {
       int idPrestamo = Integer.parseInt((String) tlbPrestamos.getValueAt(fila, 0).toString());
       int idUsuario = Integer.parseInt((String) tlbPrestamos.getValueAt(fila, 1).toString());
       String fechaPrestamo = tlbPrestamos.getValueAt(fila, 2).toString();
       String fechaEsperada =  tlbPrestamos.getValueAt(fila, 3).toString();
       String fechaReal = tlbPrestamos.getValueAt(fila, 4).toString();
       String libro = tlbPrestamos.getValueAt(fila, 5).toString();
       
       txtIdPrestamo.setText(""+idPrestamo);
       txtIdUsuario.setText(""+ idUsuario);
       txtFechaPrestamo.setText(fechaPrestamo);
       txtFechaEsperada.setText(fechaEsperada);
       txtFechaReal.setText(fechaReal);
       txtLibro.setText(libro);
    
   } 
 }
    //ACTUALIZAR
        public void Actualizar(){
     if (txtIdPrestamo.getText().equals("")){
         JOptionPane.showMessageDialog(null, "No se identifica el id ");
     }else {
         int idPrestamo =Integer.parseInt( txtIdPrestamo.getText());
         int idUsuario = Integer.parseInt( txtIdUsuario.getText());
         String fechaPrestamo = txtFechaPrestamo.getText();
         String fechaEsperada = txtFechaEsperada.getText();
         String fechaReal = txtFechaReal.getText();
         String libro = txtLibro.getText();
         
         Prestamo p = new Prestamo();
         PrestamoDAO dao = new PrestamoDAO(); 
         
         
        p.setIdPrestamo(idPrestamo);
        p.setIdUsuario(idUsuario);
        p.setFechaPrestamo(fechaPrestamo);
        p.setFechaEsperadaDevolucion(fechaEsperada);
        p.setFechaRealDevolucion(fechaReal);
        p.setLibro(libro);
        
        int r= dao.Actualizar(p);
        if (r==1){
            JOptionPane.showMessageDialog(null, "Usuario actualizado con exito");
        }else
            JOptionPane.showMessageDialog(null, "error");
     }
     limpiar();
     refrescarTabla();
 }
        
  //ELIMINAR
   private void eliminar(){
     int fila = tlbPrestamos.getSelectedRow();
     if (fila == -1){
         JOptionPane.showMessageDialog(null, "Debe seleccionar una fila!!");
     }else {
         int idPrestamo = Integer.parseInt((String)
                 tlbPrestamos.getValueAt(fila, 0).toString());
          PrestamoDAO dao = new PrestamoDAO(); 
         dao.eliminar(idPrestamo);
         System.out.println("El id del prestamo eliminado es" + idPrestamo);
         JOptionPane.showMessageDialog(null, "Prestamo eliminado");
                 
     }
     refrescarTabla();
     limpiar();
 }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdPrestamo = new javax.swing.JTextField();
        txtIdUsuario = new javax.swing.JTextField();
        txtFechaPrestamo = new javax.swing.JTextField();
        txtFechaEsperada = new javax.swing.JTextField();
        txtFechaReal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        label6 = new javax.swing.JLabel();
        txtLibro = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tlbPrestamos = new javax.swing.JTable();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Prestamos"));

        jLabel1.setText("ID prestamo:");

        jLabel2.setText("ID usuario:");

        jLabel4.setText("Fecha del prestamo:");

        jLabel5.setText("Fecha esperada de devolucion:");

        jLabel6.setText("Fecha real de devolucion:");

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add_icon-icons.com_74155.png"))); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/3844437-hamburger-list-menu-more-navigation_110311.png"))); // NOI18N
        jButton2.setText("Listar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/twocirclingarrows1_120592.png"))); // NOI18N
        jButton3.setText("Actualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancel_cross_delete_remove_icon_131554.png"))); // NOI18N
        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        label6.setText("Libro:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(txtFechaPrestamo)
                            .addComponent(txtIdPrestamo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLibro, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(txtFechaEsperada)
                            .addComponent(txtFechaReal, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))))
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtIdPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaEsperada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtFechaReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label6)
                    .addComponent(txtLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de prestamos"));

        tlbPrestamos.setBackground(new java.awt.Color(204, 204, 255));
        tlbPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Prestamo", "ID Usuario", "Fecha Prestamo", "Fecha esperada devolucion", "Fecha real devolucion", "Libro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tlbPrestamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tlbPrestamosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tlbPrestamos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        agregarPrestamo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        listarPrestamos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Actualizar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        eliminar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tlbPrestamosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlbPrestamosMouseClicked
        // TODO add your handling code here:
        llenarFormulario();
    }//GEN-LAST:event_tlbPrestamosMouseClicked

    /**
     * @param args the command line arguments
     */
public static void main(String args[]) {
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (Exception ex) {
        java.util.logging.Logger.getLogger(JFPrestamo.class.getName())
                .log(java.util.logging.Level.SEVERE, null, ex);
    }

    java.awt.EventQueue.invokeLater(() -> {
        new JFPrestamo().setVisible(true);
    });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel label6;
    private javax.swing.JTable tlbPrestamos;
    private javax.swing.JTextField txtFechaEsperada;
    private javax.swing.JTextField txtFechaPrestamo;
    private javax.swing.JTextField txtFechaReal;
    private javax.swing.JTextField txtIdPrestamo;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtLibro;
    // End of variables declaration//GEN-END:variables
}
