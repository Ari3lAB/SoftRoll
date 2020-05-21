/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Control.ControlOrden;
import DAO.Producto;
import static Interface.Main.img;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alan Acatictla M. & Ariel AB
 */
public class ConsultaProductos extends javax.swing.JFrame {

    DefaultTableModel model;
    ControlOrden control;
    ArrayList<Producto> list;

    /**
     * Creates new form GenerarReportes
     */
    public ConsultaProductos() {
        initComponents();
        this.setIconImage(img.getImage());
        this.setLocationRelativeTo(null);
        control = ControlOrden.getInstance();

        this.model = (DefaultTableModel) tablaConsulta.getModel();
        this.setVisible(true);
        updateTable();

    }

    public void updateTable() {
        model.setRowCount(0);
        list = control.ObtenerProductos();
        if (list.isEmpty()) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Sin ordenes en periodo", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
        Object rowData[] = new Object[4];

        for (Producto producto : list) {
            rowData[0] = producto.getId();
            rowData[1] = producto.getNombre();
            rowData[2] = producto.getPrecio();
            rowData[3] = producto.getNombreCategoria();
            model.addRow(rowData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaConsulta = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1400, 700));
        getContentPane().setLayout(null);

        panel.setPreferredSize(new java.awt.Dimension(1400, 600));

        tablaConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Precio", "Categoría"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane2.setViewportView(tablaConsulta);
        if (tablaConsulta.getColumnModel().getColumnCount() > 0) {
            tablaConsulta.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1039, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1354, 1354, 1354))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        getContentPane().add(panel);
        panel.setBounds(200, 0, 1050, 600);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon.png"))); // NOI18N
        jButton3.setPreferredSize(new java.awt.Dimension(80, 30));
        getContentPane().add(jButton3);
        jButton3.setBounds(10, 230, 190, 80);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("PRODUCTOS");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 320, 103, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
//            java.util.logging.Logger.getLogger(GenerarReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GenerarReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GenerarReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GenerarReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GenerarReportes().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tablaConsulta;
    // End of variables declaration//GEN-END:variables
}
