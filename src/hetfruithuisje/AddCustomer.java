/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hetfruithuisje;

import java.awt.*;
import java.sql.*;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AddCustomer extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    /**
     * Creates new form AddCustomer
     */
    public AddCustomer() {
        initComponents();
        txt_Cnr.setEnabled(false);
        conn = db.java_db();

        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLCnr = new javax.swing.JLabel();
        jLCname = new javax.swing.JLabel();
        jLCstreet = new javax.swing.JLabel();
        jLChousenr = new javax.swing.JLabel();
        jLKzip = new javax.swing.JLabel();
        jLKcity = new javax.swing.JLabel();
        txt_Cnr = new javax.swing.JTextField();
        txt_Cname = new javax.swing.JTextField();
        txt_Cstreet = new javax.swing.JTextField();
        txt_Chousenr = new javax.swing.JTextField();
        txt_Czip = new javax.swing.JTextField();
        txt_Ccity = new javax.swing.JTextField();
        jBtnCsave = new javax.swing.JButton();
        jLSearch = new javax.swing.JLabel();
        txt_Csearch = new javax.swing.JTextField();
        jBtnDelete = new javax.swing.JButton();
        jBtnClear = new javax.swing.JButton();
        jBtnUpdate = new javax.swing.JButton();
        jLCpass = new javax.swing.JLabel();
        txt_Cpass = new javax.swing.JTextField();
        jLEmail = new javax.swing.JLabel();
        txt_Cemail = new javax.swing.JTextField();
        jTitlePage = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        jLCnr.setForeground(new java.awt.Color(255, 255, 255));
        jLCnr.setText("Klantnr:");
        jLCnr.setLocation(new java.awt.Point(140, 150));
        getContentPane().add(jLCnr);
        jLCnr.setBounds(150, 150, 49, 16);

        jLCname.setForeground(new java.awt.Color(255, 255, 255));
        jLCname.setText("Naam:");
        jLCname.setLocation(new java.awt.Point(150, 300));
        getContentPane().add(jLCname);
        jLCname.setBounds(160, 300, 40, 16);

        jLCstreet.setForeground(new java.awt.Color(255, 255, 255));
        jLCstreet.setText("Straat:");
        jLCstreet.setLocation(new java.awt.Point(153, 350));
        getContentPane().add(jLCstreet);
        jLCstreet.setBounds(160, 350, 40, 16);

        jLChousenr.setForeground(new java.awt.Color(255, 255, 255));
        jLChousenr.setText("Huisnummer:");
        getContentPane().add(jLChousenr);
        jLChousenr.setBounds(110, 400, 85, 16);

        jLKzip.setForeground(new java.awt.Color(255, 255, 255));
        jLKzip.setText("Postcode:");
        jLKzip.setLocation(new java.awt.Point(135, 450));
        getContentPane().add(jLKzip);
        jLKzip.setBounds(130, 450, 61, 16);

        jLKcity.setForeground(new java.awt.Color(255, 255, 255));
        jLKcity.setText("Woonplaats:");
        getContentPane().add(jLKcity);
        jLKcity.setBounds(120, 500, 77, 16);

        txt_Cnr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CnrActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Cnr);
        txt_Cnr.setBounds(200, 130, 220, 50);
        getContentPane().add(txt_Cname);
        txt_Cname.setBounds(200, 280, 220, 50);
        getContentPane().add(txt_Cstreet);
        txt_Cstreet.setBounds(200, 330, 220, 50);
        getContentPane().add(txt_Chousenr);
        txt_Chousenr.setBounds(200, 380, 220, 50);
        getContentPane().add(txt_Czip);
        txt_Czip.setBounds(200, 430, 220, 50);
        getContentPane().add(txt_Ccity);
        txt_Ccity.setBounds(200, 480, 220, 50);

        jBtnCsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hetfruithuisje/images/Icons/Save-icon.png"))); // NOI18N
        jBtnCsave.setText("Klant opslaan");
        jBtnCsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCsaveActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnCsave);
        jBtnCsave.setBounds(440, 230, 221, 45);

        jLSearch.setForeground(new java.awt.Color(255, 255, 255));
        jLSearch.setText("Klant zoeken:");
        jLSearch.setLocation(new java.awt.Point(105, 100));
        getContentPane().add(jLSearch);
        jLSearch.setBounds(110, 100, 85, 16);

        txt_Csearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CsearchKeyReleased(evt);
            }
        });
        getContentPane().add(txt_Csearch);
        txt_Csearch.setBounds(200, 90, 462, 40);

        jBtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hetfruithuisje/images/Icons/delete_16x16.gif"))); // NOI18N
        jBtnDelete.setText("Klant verwijderen");
        jBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnDelete);
        jBtnDelete.setBounds(440, 340, 221, 45);

        jBtnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hetfruithuisje/images/Icons/erase-128.png"))); // NOI18N
        jBtnClear.setText("Alle velden leegmaken");
        jBtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClearActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnClear);
        jBtnClear.setBounds(440, 390, 221, 45);

        jBtnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hetfruithuisje/images/Icons/update icon.png"))); // NOI18N
        jBtnUpdate.setText("Klant update");
        jBtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnUpdate);
        jBtnUpdate.setBounds(440, 280, 221, 45);

        jLCpass.setForeground(new java.awt.Color(255, 255, 255));
        jLCpass.setText("Wachtwoord:");
        jLCpass.setLocation(new java.awt.Point(110, 250));
        getContentPane().add(jLCpass);
        jLCpass.setBounds(120, 250, 81, 16);

        txt_Cpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_CpassMouseClicked(evt);
            }
        });
        getContentPane().add(txt_Cpass);
        txt_Cpass.setBounds(200, 230, 220, 50);

        jLEmail.setForeground(new java.awt.Color(255, 255, 255));
        jLEmail.setText("E-mailadres:");
        jLEmail.setLocation(new java.awt.Point(110, 200));
        getContentPane().add(jLEmail);
        jLEmail.setBounds(120, 200, 80, 16);
        getContentPane().add(txt_Cemail);
        txt_Cemail.setBounds(200, 180, 220, 50);

        jTitlePage.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jTitlePage.setForeground(new java.awt.Color(102, 153, 255));
        jTitlePage.setText("Klant toevoegen");
        getContentPane().add(jTitlePage);
        jTitlePage.setBounds(277, 32, 280, 43);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hetfruithuisje/images/bg.png"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, -30, 860, 690);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCsaveActionPerformed
        
        HomePage j = new HomePage();
        j.setVisible(true);
        this.dispose();
        
        try {
        
            String sql = "INSERT INTO klant (email, pass, naam, straat, huisnummer, postcode, woonplaats) VALUES (?,?,?,?,?,?,?)";
            
            pst = conn.prepareStatement(sql);
            
            if (txt_Cemail.getText().equals("") && txt_Cpass.getText().equals("") && txt_Cname.getText().equals("") && txt_Cstreet.getText().equals("") && txt_Chousenr.getText().equals("") && txt_Czip.getText().equals("") && txt_Ccity.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Vul alle velden in");
            } else {
                pst.setString(1, txt_Cemail.getText());
                pst.setString(2, txt_Cpass.getText());
                pst.setString(3, txt_Cname.getText());
                pst.setString(4, txt_Cstreet.getText());
                pst.setString(5, txt_Chousenr.getText());
                pst.setString(6, txt_Czip.getText());
                pst.setString(7, txt_Ccity.getText());
                
                pst.execute();
                JOptionPane.showMessageDialog(null, "Klant succesvol opgeslagen");
            }
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            
            try {
                rs.close();
                pst.close();
            } catch(Exception e) {
                
            }
            
        }
        
    }//GEN-LAST:event_jBtnCsaveActionPerformed

    private void txt_CsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CsearchKeyReleased
        
        try {
            String sql = "SELECT * FROM klant WHERE klantnr=?";
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_Csearch.getText());
            rs = pst.executeQuery();
            
            if(rs.next()){
                txt_Cnr.setText(rs.getString("klantnr"));
                
                String add1 = rs.getString("email");
                txt_Cemail.setText(add1);
                String add2 = rs.getString("pass");
                txt_Cpass.setText(add2);
                String add3 = rs.getString("naam");
                txt_Cname.setText(add3);
                String add4 = rs.getString("straat");
                txt_Cstreet.setText(add4);
                String add5 = rs.getString("huisnummer");
                txt_Chousenr.setText(add5);
                String add6 = rs.getString("postcode");
                txt_Czip.setText(add6);
                String add7 = rs.getString("woonplaats");
                txt_Ccity.setText(add7);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                
            }
        }
        
    }//GEN-LAST:event_txt_CsearchKeyReleased

    private void txt_CnrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CnrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CnrActionPerformed

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed
        
        try {
            String sql = "DELETE FROM klant WHERE klantnr=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_Cnr.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Klant verwijderd!");
            
            txt_Ccity.setText("");
            txt_Cemail.setText("");
            txt_Cpass.setText("");
            txt_Chousenr.setText("");
            txt_Cname.setText("");
            txt_Cnr.setText("");
            txt_Csearch.setText("");
            txt_Cstreet.setText("");
            txt_Czip.setText("");
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                
            }
        }
        
    }//GEN-LAST:event_jBtnDeleteActionPerformed

    private void jBtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClearActionPerformed
        
        txt_Ccity.setText("");
        txt_Chousenr.setText("");
        txt_Cemail.setText("");
        txt_Cpass.setText("");
        txt_Cname.setText("");
        txt_Cnr.setText("");
        txt_Csearch.setText("");
        txt_Cstreet.setText("");
        txt_Czip.setText("");
        
    }//GEN-LAST:event_jBtnClearActionPerformed

    private void jBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnUpdateActionPerformed
        
        try {
            String val1 = txt_Cnr.getText();
            String val2 = txt_Cemail.getText();
            String val3 = txt_Cpass.getText();
            String val4 = txt_Cname.getText();
            String val5 = txt_Cstreet.getText();
            String val6 = txt_Chousenr.getText();
            String val7 = txt_Czip.getText();
            String val8 = txt_Ccity.getText();

            String sql = "UPDATE klant SET klantnr = '"+val1+"', "
                    + "email = '"+val2+"', "
                    + "pass = '"+val3+"', "
                    + "naam = '"+val4+"', "
                    + "straat = '"+val5+"', "
                    + "huisnummer = '"+val6+"', "
                    + "postcode = '"+val7+"', "
                    + "woonplaats = '"+val8+"' ";

            pst = conn.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Klant succesvol gewijzigd");
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                
            }
        }
        
    }//GEN-LAST:event_jBtnUpdateActionPerformed

    private void txt_CpassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CpassMouseClicked
        Random ran = new Random();
        int top = 6;
        char data = ' ';
        String dat = "";

        for (int i=0; i<=top; i++) {
          data = (char)(ran.nextInt(25)+97);
          dat = data + dat;
        }
        txt_Cpass.setText(dat);
    }//GEN-LAST:event_txt_CpassMouseClicked

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
            java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton jBtnClear;
    private javax.swing.JButton jBtnCsave;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnUpdate;
    private javax.swing.JLabel jLChousenr;
    private javax.swing.JLabel jLCname;
    private javax.swing.JLabel jLCnr;
    private javax.swing.JLabel jLCpass;
    private javax.swing.JLabel jLCstreet;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLKcity;
    private javax.swing.JLabel jLKzip;
    private javax.swing.JLabel jLSearch;
    private javax.swing.JLabel jTitlePage;
    private javax.swing.JTextField txt_Ccity;
    private javax.swing.JTextField txt_Cemail;
    private javax.swing.JTextField txt_Chousenr;
    private javax.swing.JTextField txt_Cname;
    private javax.swing.JTextField txt_Cnr;
    private javax.swing.JTextField txt_Cpass;
    private javax.swing.JTextField txt_Csearch;
    private javax.swing.JTextField txt_Cstreet;
    private javax.swing.JTextField txt_Czip;
    // End of variables declaration//GEN-END:variables
}
