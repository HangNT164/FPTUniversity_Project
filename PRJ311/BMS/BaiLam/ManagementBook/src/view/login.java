/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bo.UsersBo;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import util.Validate;
import util.FormController;

/**
 *
 * @author HangNT
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    private final Locale locale;

    private void updateGui(Locale loc) {
        String url = "resource/languages";
        ResourceBundle rb = ResourceBundle.getBundle(url, loc);
        // de doc
        String loginAccountForm = rb.getString("login.laf");
        String loginNow = rb.getString("login.loginnow");
        String username = rb.getString("login.username");
        String click = rb.getString("login.clickhere");
        String seePass = rb.getString("login.seepassword");
        String login = rb.getString("login.login");
        String newUsers = rb.getString("login.newusers");
        String resgister = rb.getString("login.Register");
        String forgotPass = rb.getString("login.forgotPassword");
        String title = rb.getString("login");
        // update
        jLabelLoginNow.setText(loginNow);
        jLabelLoginAccountForm.setText(loginAccountForm);
        jCheckBookSeePassword.setText(seePass);
        btnLogin.setText(login);
        jlbForgotPass.setText(click);
        jLabel4.setText(forgotPass);
        jLabel3.setText(newUsers);
        jlbResisterNow.setText(resgister);
        txtUserName.setText(username);
        this.setTitle(title);
    }

    public login(Locale locale) {
        initComponents();
        this.locale = locale;
        updateGui(locale);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("E:\\Form 3-Summer 2019\\Desktop Java Applications(PRJ311)\\JavaSwingOfDuy\\02-Assigment\\BMS\\BaiLam\\ManagementBook\\img\\banner.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jLabelLoginNow = new javax.swing.JLabel();
        jLabelLoginAccountForm = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jlbForgotPass = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlbResisterNow = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jCheckBookSeePassword = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jLabelLoginNow.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabelLoginNow.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLoginNow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLoginNow.setText("login now");

        jLabelLoginAccountForm.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabelLoginAccountForm.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLoginAccountForm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLoginAccountForm.setText("Login Account Form");

        txtUserName.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        txtUserName.setText("UserName");
        txtUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserNameMouseClicked(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("New Users?");

        jlbForgotPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbForgotPass.setForeground(new java.awt.Color(0, 255, 0));
        jlbForgotPass.setText("CLick here");
        jlbForgotPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Forgot password?");

        jlbResisterNow.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbResisterNow.setForeground(new java.awt.Color(0, 255, 0));
        jlbResisterNow.setText("Register now ?");
        jlbResisterNow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbResisterNow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbResisterNowMouseClicked(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnLogin.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        btnLogin.setText("LOGIN");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jCheckBookSeePassword.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jCheckBookSeePassword.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBookSeePassword.setText("See Password");
        jCheckBookSeePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBookSeePasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabelLoginAccountForm, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(jLabelLoginNow, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(372, 372, 372)
                        .addComponent(btnLogin))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBookSeePassword)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jlbForgotPass)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlbResisterNow))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                                    .addComponent(jLabel3))
                                .addComponent(txtPassword)
                                .addComponent(txtUserName)))))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelLoginAccountForm, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabelLoginNow)
                .addGap(40, 40, 40)
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jCheckBookSeePassword)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlbForgotPass))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jlbResisterNow)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnLogin)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jlbResisterNowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbResisterNowMouseClicked
        // TODO add your handling code here:
        FormController.show(new SignUp(this.locale));
        this.dispose();
    }//GEN-LAST:event_jlbResisterNowMouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String name = new Validate().getName(txtUserName);
        String password = txtPassword.getText();
        String mess = new UsersBo().signInAccount(name, password);
        JOptionPane.showMessageDialog(this, mess, "Message ", JOptionPane.PLAIN_MESSAGE);
        if (mess.equalsIgnoreCase("Login Successfull!!")) {
            String username = "";
            if (locale == new Locale("en", "US")) {
                username = "Wellcome " + name.toUpperCase();
            } else {
                username = "Xin chào " + name.toUpperCase();
            }
            FormController.show(new Home(username, locale));
            this.dispose();
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserNameMouseClicked
        // TODO add your handling code here:
        txtUserName.setText("");
    }//GEN-LAST:event_txtUserNameMouseClicked

    private void jCheckBookSeePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBookSeePasswordActionPerformed
        // TODO add your handling code here:
        if (jCheckBookSeePassword.isSelected()) {
            txtPassword.setEchoChar((char) 0);
        } else {
            txtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBookSeePasswordActionPerformed

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
//            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> {
//            new login().setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox jCheckBookSeePassword;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelLoginAccountForm;
    private javax.swing.JLabel jLabelLoginNow;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlbForgotPass;
    private javax.swing.JLabel jlbResisterNow;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
