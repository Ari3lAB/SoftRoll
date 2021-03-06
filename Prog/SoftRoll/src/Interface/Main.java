/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.ImageIcon;

/**
 *
 * @author Ariel AB
 */
public class Main extends javax.swing.JFrame {

    public static ImageIcon img = new ImageIcon("C:/Users/Ariel AB/Desktop/Proyecto ROLL ROLL/SoftRoll/Prog/SoftRoll/src/images/icono.png");

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        this.setTitle("SoftRoll");
        this.setIconImage(img.getImage());
        this.setExtendedState(Ordenes.MAXIMIZED_BOTH);
        Login log = new Login();
        log.setVisible(true);
        log.setAlwaysOnTop(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuExit = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        reporteVentas = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuOrdenes = new javax.swing.JMenuItem();
        jMenuProductos = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rollroll.png"))); // NOI18N

        jMenu1.setText("Archivo");

        jMenuExit.setText("Salir");
        jMenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuExitActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuExit);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("Ventas");

        jMenuItem2.setText("Ordenes Activas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuItem3.setText("Caja");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuBar1.add(jMenu5);

        jMenu2.setText("Reportes");

        reporteVentas.setText("Reporte de ventas");
        reporteVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteVentasActionPerformed(evt);
            }
        });
        jMenu2.add(reporteVentas);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("Consultas");

        jMenuOrdenes.setText("Ordenes");
        jMenuOrdenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOrdenesActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuOrdenes);

        jMenuProductos.setText("Productos");
        jMenuProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProductosActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuProductos);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(416, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(430, 430, 430))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reporteVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteVentasActionPerformed
        ReporteVentas rv = new ReporteVentas();
        rv.setVisible(true);
    }//GEN-LAST:event_reporteVentasActionPerformed

    private void jMenuOrdenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuOrdenesActionPerformed
        ConsultaOrdenes ro = new ConsultaOrdenes();
        ro.setVisible(true);

    }//GEN-LAST:event_jMenuOrdenesActionPerformed

    private void jMenuProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProductosActionPerformed
        ConsultaProductos cp = new ConsultaProductos();
        cp.setVisible(true);
    }//GEN-LAST:event_jMenuProductosActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Ordenes or = new Ordenes();
        or.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuExitActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        AdministrarCaja ac = new AdministrarCaja();
        ac.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuExit;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuOrdenes;
    private javax.swing.JMenuItem jMenuProductos;
    private javax.swing.JMenuItem reporteVentas;
    // End of variables declaration//GEN-END:variables
}
