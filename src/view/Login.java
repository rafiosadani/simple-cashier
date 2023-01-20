package view;

import java.sql.*;
import javax.swing.JOptionPane;
import model.Koneksi;
import model.UserLogin;

public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TxtUsername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtPassword = new javax.swing.JPasswordField();
        CheckPassword = new javax.swing.JCheckBox();
        BtnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(33, 158, 188));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login Page");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Username");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Password");

        CheckPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CheckPassword.setText("Show Password");
        CheckPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckPasswordActionPerformed(evt);
            }
        });

        BtnLogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnLogin.setText("LOGIN");
        BtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CheckPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtUsername, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CheckPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CheckPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckPasswordActionPerformed
        // TODO add your handling code here:
        if(CheckPassword.isSelected()) {
            TxtPassword.setEchoChar((char)0);
        } else {
            TxtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_CheckPasswordActionPerformed

    private void BtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLoginActionPerformed
        // TODO add your handling code here:
        String username = TxtUsername.getText();
        String password = TxtPassword.getText();
        int jmlh = UserLogin.cekUserLogin(username, password);
        
        if(username.isEmpty() && password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username dan Password harus diisi", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            TxtUsername.requestFocus();
        } else if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username tidak boleh kosong", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            TxtUsername.requestFocus();
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password tidak boleh kosong", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            TxtPassword.requestFocus();
        } else if (jmlh == 0) {
            JOptionPane.showMessageDialog(this, "Maaf, Username dan/atau Password yang anda masukkan salah", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            TxtUsername.setText("");
            TxtPassword.setText("");
            TxtUsername.requestFocus();
        } else {
            String kodePegawai = UserLogin.getPegawai(username, password);
            UserLogin.setKodePegawai(kodePegawai);
            try {
                Connection conn = Koneksi.koneksiDB();
                Statement stmt = conn.createStatement();
                String query = "SELECT username, password FROM pegawai WHERE username = '"+ username +"' AND password = '"+ password +"'";
                ResultSet rs = stmt.executeQuery(query);
                if(rs.next()) {
                    if(username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
                        this.setVisible(false);
                        JOptionPane.showMessageDialog(this, "Anda berhasil Login", "Pesan Berhasil", JOptionPane.INFORMATION_MESSAGE);
                        MenuUtama menuUtama = new MenuUtama();
                        menuUtama.setVisible(true);
//                        JOptionPane.showMessageDialog(this, "Anda berhasil Login", "Pesan Berhasil", JOptionPane.INFORMATION_MESSAGE);
                        TxtUsername.setText("");
                        TxtPassword.setText("");
                        TxtUsername.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(this, "Maaf, Username dan/atau Password yang anda masukkan salah", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                        TxtUsername.setText("");
                        TxtPassword.setText("");
                        TxtUsername.requestFocus();
                    }
                }
                stmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Connection Error : " + e.getMessage());
            }
        }
    }//GEN-LAST:event_BtnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnLogin;
    private javax.swing.JCheckBox CheckPassword;
    private javax.swing.JPasswordField TxtPassword;
    private javax.swing.JTextField TxtUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
