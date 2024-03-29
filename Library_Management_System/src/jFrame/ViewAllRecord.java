/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jFrame;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Soumya
 */
public class ViewAllRecord extends javax.swing.JFrame {

    /**
     * Creates new form ViewAllRecord
     */
    
    Color mouseEnterColor = new Color(255,51,51);
    Color mouseExitColor = new Color(0,102,102);
    Color backEnterColor = new Color(102,153,0);
    Color backExitColor = new Color(0,102,102);
    
    DefaultTableModel model;

    public ViewAllRecord() {
        initComponents();
        setIssueBookDetailsToTable();
    }

    public void setIssueBookDetailsToTable() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from issue_book_details");

            while (rs.next()) {
                String id = rs.getString("id");
                String bookName = rs.getString("book_name");
                String StudentName = rs.getString("student_name");
                String issueDate = rs.getString("issue_date");
                String dueDate = rs.getString("due_date");
                String status = rs.getString("status");

                Object[] obj = {id, bookName, StudentName, issueDate, dueDate, status};
                model = (DefaultTableModel) tbl_issuebookDetails.getModel();
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_issuebookDetails.getModel();
        model.setRowCount(0);
    }

    //to fetch the record using date field
    public void search() {
        java.util.Date uFromDate = date_fromDate.getDatoFecha();
        java.util.Date uToDate = date_toDate.getDatoFecha();
        long l1 = uFromDate.getTime();
        long l2 = uToDate.getTime();

        java.sql.Date fromDate = new java.sql.Date(l1);
        java.sql.Date toDate = new java.sql.Date(l2);
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where issue_date Between ? and ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, fromDate);
            pst.setDate(2, toDate);

            ResultSet rs = pst.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "No Record Found");
            }
            while (rs.next()) {
                String id = rs.getString("id");
                String bookName = rs.getString("book_name");
                String StudentName = rs.getString("student_name");
                String issueDate = rs.getString("issue_date");
                String dueDate = rs.getString("due_date");
                String status = rs.getString("status");

                Object[] obj = {id, bookName, StudentName, issueDate, dueDate, status};
                model = (DefaultTableModel) tbl_issuebookDetails.getModel();
                model.addRow(obj);
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        date_toDate = new rojeru_san.componentes.RSDateChooser();
        jLabel11 = new javax.swing.JLabel();
        date_fromDate = new rojeru_san.componentes.RSDateChooser();
        jLabel13 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        panel_table = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_issuebookDetails = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(102, 102, 0));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, 38));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 50));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel2.setText("  View All Records");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 340, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 430, 5));

        date_toDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_toDate.setColorForeground(new java.awt.Color(0, 0, 0));
        date_toDate.setColorSelForeground(new java.awt.Color(255, 51, 51));
        date_toDate.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 17)); // NOI18N
        date_toDate.setPlaceholder("Select Due Date");
        jPanel1.add(date_toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 240, 360, -1));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Issue Date :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 120, 20));

        date_fromDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_fromDate.setColorForeground(new java.awt.Color(0, 0, 0));
        date_fromDate.setColorSelForeground(new java.awt.Color(255, 51, 51));
        date_fromDate.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 17)); // NOI18N
        date_fromDate.setPlaceholder("Select Issue Date");
        jPanel1.add(date_fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 360, -1));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Due Date :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 120, 20));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("Search");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 220, 200, 80));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonRectangle1.setText("Reset");
        rSMaterialButtonRectangle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonRectangle1MouseClicked(evt);
            }
        });
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 230, 110, 60));

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("X");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 40));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 0, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 320));

        panel_table.setBackground(new java.awt.Color(255, 255, 255));
        panel_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_issuebookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        tbl_issuebookDetails.setColorBackgoundHead(new java.awt.Color(0, 102, 102));
        tbl_issuebookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_issuebookDetails.setRowHeight(40);
        tbl_issuebookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_issuebookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_issuebookDetails);

        panel_table.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 928, 390));

        getContentPane().add(panel_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 1500, 480));

        setSize(new java.awt.Dimension(1500, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void tbl_issuebookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_issuebookDetailsMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tbl_issuebookDetailsMouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        // TODO add your handling code here:
        if(date_fromDate.getDatoFecha() != null && date_toDate.getDatoFecha() != null){
            clearTable();
            search();
        }
        else{
            JOptionPane.showMessageDialog(this, "Please insert date to search");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonRectangle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1MouseClicked
        // TODO add your handling code here:
        clearTable();
        setIssueBookDetailsToTable();
        
    }//GEN-LAST:event_rSMaterialButtonRectangle1MouseClicked

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        // TODO add your handling code here:
        jPanel7.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        // TODO add your handling code here:
        jPanel7.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel14MouseExited

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        jPanel2.setBackground(backEnterColor);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        jPanel2.setBackground(backExitColor);
    }//GEN-LAST:event_jLabel1MouseExited

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
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAllRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_fromDate;
    private rojeru_san.componentes.RSDateChooser date_toDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel_table;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojeru_san.complementos.RSTableMetro tbl_issuebookDetails;
    // End of variables declaration//GEN-END:variables
}
