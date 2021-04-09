/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.views;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import ni.edu.uni.programacion.controllers.PnlVehicleShowController;
import ni.edu.uni.programacion.views.panels.PnlShow;

/**
 *
 * @author JADPA26
 */
public class IFrmVehicle extends javax.swing.JInternalFrame {
    PnlShow pnlShow;
    PnlVehicleShowController pnlShowController;
    
    /**
     * Creates new form IFrmVehicle
     */
    public IFrmVehicle() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlButton = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        pnlTable = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("View Vehicle");

        pnlButton.setBackground(new java.awt.Color(255, 204, 204));

        btnNew.setBackground(new java.awt.Color(255, 255, 255));
        btnNew.setForeground(new java.awt.Color(0, 0, 0));
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        pnlButton.add(btnNew);

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdate.setText("Update");
        pnlButton.add(btnUpdate);

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setForeground(new java.awt.Color(0, 0, 0));
        btnDelete.setText("Delete");
        pnlButton.add(btnDelete);

        getContentPane().add(pnlButton, java.awt.BorderLayout.PAGE_END);

        pnlTable.setBackground(new java.awt.Color(153, 204, 255));
        pnlTable.setLayout(new java.awt.BorderLayout());

        try {
            pnlShow=new PnlShow();
            pnlShowController = new PnlVehicleShowController(pnlShow);
        } catch (IOException ex) {
            Logger.getLogger(FrmVehicles.class.getName()).log(Level.SEVERE, null, ex);
        }

        addComponent(pnlShow);
        getContentPane().add(pnlTable, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleName("View Vehicle");

        setBounds(0, 0, 400, 300);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewActionPerformed
    
    private void addComponent(JComponent component) {
        pnlTable.removeAll();
        pnlTable.add(component, BorderLayout.CENTER);
        pnlTable.repaint();
        this.validate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlTable;
    // End of variables declaration//GEN-END:variables
}
