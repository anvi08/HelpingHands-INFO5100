/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package uiDonor;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.causes.Cause;
import model.causes.CauseDirectory;
import model.causeticket.CauseTicket;
import model.causeticket.CauseTicketDirectory;
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
    CauseTicketDirectory causeTicketDirectory;
    CauseTicket causeTicket;        
    private String loggedInUser;    
    DonorDirectory donorDirectory;
    Donor donor;    
    private int donorID;  
    
    public DonorTrackCause(int donorID) throws SQLException {
        initComponents();
        this.donorID = donorID;
        this.donorDirectory = new DonorDirectory(donor);
        this.causeTicketDirectory = new CauseTicketDirectory(causeTicket);
        popDonorTrackingTable(donorDirectory.popDonorTrackingTable(donorID));
        System.out.println(donorID+" pop table  ");
        jProgressBar1.setVisible(false);
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
        txtTracker = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

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
        btnTrackCause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrackCauseActionPerformed(evt);
            }
        });

        jProgressBar1.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout txtTrackerLayout = new javax.swing.GroupLayout(txtTracker);
        txtTracker.setLayout(txtTrackerLayout);
        txtTrackerLayout.setHorizontalGroup(
            txtTrackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtTrackerLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(82, 82, 82)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        txtTrackerLayout.setVerticalGroup(
            txtTrackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtTrackerLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(txtTrackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTrackCause)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
            .addComponent(txtTracker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTrackCause)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTracker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrackCauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrackCauseActionPerformed
        // TODO add your handling code here:
        int SelectedRow = tblCause.getSelectedRow();
        if(SelectedRow<0){
            JOptionPane.showMessageDialog(this, "Please Select a row");
        }else{
            DefaultTableModel m2 = (DefaultTableModel)tblCause.getModel();
            Cause SelectedRecords = (Cause) m2.getValueAt(SelectedRow, 0);
            System.out.println("CAUSE IDDDDD "+SelectedRecords.getCauseId());
            JOptionPane.showMessageDialog(this,"The Exact location of your funds is given below");
            try {
                ArrayList<CauseTicket> trackCauses = causeTicketDirectory.trackCause(donorID);
                for(CauseTicket causetix : trackCauses){
                    if(causetix.getReceiverId()==SelectedRecords.getRecId()){
                        Date createdDate = causetix.getCreatedDate();
                        System.out.println(createdDate+"YOOOOOOOOOOOOOOOO");
                        Date moneyDonorCountry = causetix.getMoneyDonorCountry();
                        Date moneyReceiverCountry = causetix.getMoneyReceiverCountry();
                        Date moneyReceived = causetix.getMoneyReceived();
                        int MY_MINIMUM = 0;
                        int MY_MAXIMUM = 100;
                        jProgressBar1.setMinimum(MY_MINIMUM);
                        jProgressBar1.setMaximum(MY_MAXIMUM);
                        
                        if(createdDate!=null){
                            jProgressBar1.setValue(25);
                            jProgressBar1.setString("funds almost there");
                            jLabel1.setText("Your Funds were Initiated on "+ createdDate.toString()+" and will be tracked by the Bank authorities soon");
                        }
                        if(moneyDonorCountry!=null){
                            jProgressBar1.setValue(50);
                            jProgressBar1.setString("Your funds are almost there");
                            jLabel1.setText("Your Funds were Processed on  "+ createdDate.toString()+" and will be tracked by the Receiving Country Bank authorities soon");
                        }                        
                        if(moneyReceiverCountry!=null){
                            jProgressBar1.setValue(75);
                            jProgressBar1.setString("Your funds are almost there");
                            jLabel1.setText("Your Funds were processed by the bank on  "+ createdDate.toString()+" and will be in the hands of the benificiary soon");
                        }                        
                        if(moneyReceived!=null){
                            jProgressBar1.setValue(100);
                            jProgressBar1.setString("Your funds are almost there");
                            jLabel1.setText("Your Funds have reached the right people on "+ createdDate.toString()+" \n Thank you for using HelpingHands");
                        }                        

                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(DonorTrackCause.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }//GEN-LAST:event_btnTrackCauseActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCause;
    private javax.swing.JPanel txtTracker;
    // End of variables declaration//GEN-END:variables
}
