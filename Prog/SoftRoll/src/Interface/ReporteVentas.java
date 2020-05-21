/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Control.ControlOrden;
import DAO.Orden;
import static Interface.Main.img;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alan Acatictla M. & Ariel AB
 */
public class ReporteVentas extends javax.swing.JFrame {

    DefaultTableModel model;
    ControlOrden control;
    DateTimeFormatter dtf;
    LocalDateTime now;
    ArrayList<Orden> list;

    /**
     * Creates new form GenerarReportes
     */
    public ReporteVentas() {
        initComponents();
        this.setTitle(Reporte de ventas);
        this.setIconImage(img.getImage());
        this.setLocationRelativeTo(null);
        control = ControlOrden.getInstance();

        dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        now = LocalDateTime.now();
        jTextFechaInicio.setText(dtf.format(now));
        jTextFechaFin.setText(dtf.format(now));

        this.model = (DefaultTableModel) tablaConsulta.getModel();
        this.setVisible(true);

    }

    public void updateTable(String fechaInicio, String fechaFin) {
        model.setRowCount(0);
        list = control.ObtenerOrdenesPagadas(fechaInicio, fechaFin);
        Object rowData[] = new Object[4];
        for (Orden orden : list) {
            rowData[0] = orden.getId();
            rowData[1] = orden.getNombreUsuario();
            rowData[2] = orden.getFecha();
            rowData[3] = orden.getPagoTotal();
            model.addRow(rowData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        generaConsulta = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jTextFechaInicio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFechaFin = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaConsulta = new javax.swing.JTable();
        generarReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1400, 700));
        getContentPane().setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/carrito-de-compras.png"))); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(80, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(0, 270, 190, 80);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("VENTAS");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 360, 70, 20);

        panel.setBackground(new java.awt.Color(255, 255, 255));

        generaConsulta.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        generaConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/descargar.png"))); // NOI18N
        generaConsulta.setText("Buscar");
        generaConsulta.setPreferredSize(new java.awt.Dimension(80, 30));
        generaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generaConsultaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("Periodo: Del ");

        jTextFechaInicio.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextFechaInicio.setText("AAAA-MM-DD");
        jTextFechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFechaInicioActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("a");

        jTextFechaFin.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextFechaFin.setText("AAAA-MM-DD");
        jTextFechaFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFechaFinActionPerformed(evt);
            }
        });

        tablaConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Vendedor", "Fecha", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
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

        generarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/interfaz.png"))); // NOI18N
        generarReporte.setText("GENERAR REPORTE");
        generarReporte.setPreferredSize(new java.awt.Dimension(80, 30));
        generarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(generaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(generarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 540, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)))
        );

        getContentPane().add(panel);
        panel.setBounds(200, 0, 1120, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void generarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarReporteActionPerformed
        FrameReporte frm = new FrameReporte(list);
        frm.setVisible(true);
    }//GEN-LAST:event_generarReporteActionPerformed

    private void jTextFechaFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFechaFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFechaFinActionPerformed

    private void jTextFechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFechaInicioActionPerformed

    private void generaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generaConsultaActionPerformed
        String fechaInicio = jTextFechaInicio.getText();
        String fechaFinal = jTextFechaFin.getText();
        updateTable(fechaInicio, fechaFinal);
    }//GEN-LAST:event_generaConsultaActionPerformed

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
    private javax.swing.JButton generaConsulta;
    private javax.swing.JButton generarReporte;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFechaFin;
    private javax.swing.JTextField jTextFechaInicio;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tablaConsulta;
    // End of variables declaration//GEN-END:variables
}
