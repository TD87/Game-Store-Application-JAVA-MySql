import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tejas
 */
public class Platforms_View extends javax.swing.JFrame {

    /**
     * Creates new form platform_database
     */
    public Platforms_View() {
        initComponents();
        platformdb.getTableHeader().setFont(new java.awt.Font("Calibri", 1, 14));
        this.setTitle("Game Store - View All Platforms");
        this.getContentPane().setBackground(Color.BLACK);
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
        platformdb = new javax.swing.JTable();
        displaybtn = new javax.swing.JButton();
        returnbtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        platformdb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Platform Type", "Xbox One", "PS4", "PC"
            }
        ));
        jScrollPane1.setViewportView(platformdb);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 900, -1));

        displaybtn.setBackground(new java.awt.Color(204, 0, 0));
        displaybtn.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        displaybtn.setForeground(new java.awt.Color(255, 255, 255));
        displaybtn.setText("Display All Platform Types");
        displaybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displaybtnActionPerformed(evt);
            }
        });
        getContentPane().add(displaybtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 330, 50));

        returnbtn.setBackground(new java.awt.Color(204, 0, 0));
        returnbtn.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        returnbtn.setForeground(new java.awt.Color(255, 255, 255));
        returnbtn.setText("Return To Main Menu");
        returnbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnbtnActionPerformed(evt);
            }
        });
        getContentPane().add(returnbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 470, 330, 50));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 550, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void clear()
    {
        try {
            DefaultTableModel model = (DefaultTableModel) platformdb.getModel();
            model.setRowCount(0);
        } catch (Exception ex) {
        }
    }
    private void displaybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displaybtnActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) platformdb.getModel();
            model.setRowCount(0);
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/ipproject","root","oakridge");
            Statement stmt = con.createStatement();
            String query = "Select Platform_Type, Xbox_One, PS4, "
                    + "PC from platforms;";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String platform = rs.getString("Platform_Type");
                String xbone = rs.getString("Xbox_one");
                String ps4 = rs.getString("PS4");
                String pc = rs.getString("PC");
                model.addRow(new Object[] {platform, xbone, ps4, pc});
            }  rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in connectivity");
        }
    }//GEN-LAST:event_displaybtnActionPerformed

    private void returnbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbtnActionPerformed
        if (DBApplication.mainScreen == null)
            DBApplication.mainScreen = new Main_Menu();   
        
        DBApplication.mainScreen.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_returnbtnActionPerformed

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
            java.util.logging.Logger.getLogger(Platforms_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Platforms_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Platforms_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Platforms_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Platforms_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton displaybtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable platformdb;
    private javax.swing.JButton returnbtn;
    // End of variables declaration//GEN-END:variables
}
