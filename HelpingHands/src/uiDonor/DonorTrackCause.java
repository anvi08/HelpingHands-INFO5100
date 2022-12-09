/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package uiDonor;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.causes.Cause;
import model.causes.CauseDirectory;
import profile.Receiver.Receiver;
import profile.Receiver.ReceiverDirectory;
import profile.donor.Donor;
import profile.donor.DonorDirectory;

/**
 *
 * @author abhis
 */
public class DonorTrackCause extends javax.swing.JPanel {

    /**
     * Creates new form DonorTrackCause
     */
    CauseDirectory causeDirectory;
    Cause cause;    
    private String loggedInUser;    
    DonorDirectory donorDirectory;
    Donor donor;    
    private int donorID;  
    
    public DonorTrackCause(int donorID) throws SQLException {
        initComponents();
        this.donorID = donorID;
        this.donorDirectory = new DonorDirectory(donor);
        popDonorTrackingTable(donorDirectory.popDonorTrackingTable(donorID));
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
        tblCause = new javax.swing.JTable();
        btnTrackCause = new javax.swing.JButton();

        tblCause.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NGO Organisation", "Cause Name", "Cause Description", "Receiving Category", "Country"
            }
        ));
        jScrollPane1.setViewportView(tblCause);

        btnTrackCause.setText("Track ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTrackCause)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTrackCause)
                .addContainerGap(70, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void popDonorTrackingTable(ArrayList<Cause> donorTable) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        DefaultTableModel model = (DefaultTableModel)tblCause.getModel();
        model.setRowCount(0);
        for(Cause cause: donorTable){
            Object[] row = new Object[6];
            row[0] = cause;
            row[1] = cause.getCauseName();
            row[2] = cause.getCauseDesc();
            row[3] = cause.getRecCategory();
            row[4] = cause.getCountry();                                     
            model.addRow(row);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTrackCause;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCause;
    // End of variables declaration//GEN-END:variables
}