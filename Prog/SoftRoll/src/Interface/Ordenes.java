package Interface;

import Control.FachadaControl;
import java.util.ArrayList;
import DAO.Orden;
import static Interface.Main.img;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ariel AB
 */
public class Ordenes extends javax.swing.JFrame {

    FachadaControl control;
    ArrayList ordenesActivas;
    int idOrden;
    DefaultTableModel model;

    /**
     * Creates new form Ordenes
     */
    public Ordenes() {
        initComponents();
        this.setTitle("Ordenes Activas");
        this.setIconImage(img.getImage());
        this.setLocationRelativeTo(null);
        //this.setExtendedState(Ordenes.MAXIMIZED_BOTH);        
        control = FachadaControl.getInstance();
        ordenesActivas = control.OrdenesActivas();
        this.model = (DefaultTableModel) jTableOrdenesActivas.getModel();
        updateTable();
    }

    public void updateTable() {
        model.setRowCount(0);
        ArrayList<Orden> list = control.OrdenesActivas();
        Object rowData[] = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getId();
            rowData[1] = list.get(i).getNombreCliente();
            rowData[2] = list.get(i).getFecha();
            rowData[3] = list.get(i).getEstado();
            model.addRow(rowData);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOrdenesActivas = new javax.swing.JTable();
        jButtonNuevaOrden = new javax.swing.JButton();
        jButtonCancelarOrden = new javax.swing.JButton();
        jButtonCobrar = new javax.swing.JButton();
        jButtonCerrar = new javax.swing.JButton();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTableOrdenesActivas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Hora", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableOrdenesActivas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOrdenesActivasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableOrdenesActivas);
        if (jTableOrdenesActivas.getColumnModel().getColumnCount() > 0) {
            jTableOrdenesActivas.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jButtonNuevaOrden.setText("Nueva Orden");
        jButtonNuevaOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevaOrdenActionPerformed(evt);
            }
        });

        jButtonCancelarOrden.setText("Cancelar Orden");
        jButtonCancelarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarOrdenActionPerformed(evt);
            }
        });

        jButtonCobrar.setText("Cobrar");
        jButtonCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCobrarActionPerformed(evt);
            }
        });

        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 846, Short.MAX_VALUE)
                        .addComponent(jButtonCancelarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonNuevaOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNuevaOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNuevaOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevaOrdenActionPerformed
        NuevaOrden nOrd = new NuevaOrden();
        nOrd.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonNuevaOrdenActionPerformed

    private void jButtonCancelarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarOrdenActionPerformed
        control.CancelarOrden(idOrden);
        updateTable();

    }//GEN-LAST:event_jButtonCancelarOrdenActionPerformed

    private void jTableOrdenesActivasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOrdenesActivasMouseClicked
        int ordenSeleccionada = jTableOrdenesActivas.getSelectedRow();
        idOrden = (int) model.getValueAt(ordenSeleccionada, 0);
    }//GEN-LAST:event_jTableOrdenesActivasMouseClicked

    private void jButtonCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCobrarActionPerformed
        FrameVenta fVent = new FrameVenta(idOrden);
        fVent.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonCobrarActionPerformed


    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButtonCerrarActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Ordenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Ordenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Ordenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Ordenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Ordenes().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelarOrden;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonCobrar;
    private javax.swing.JButton jButtonNuevaOrden;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableOrdenesActivas;
    // End of variables declaration//GEN-END:variables
}
