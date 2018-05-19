/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ANURUDDHA
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    public static void restrict(String atype) {
        String a = atype;
        try {
            ResultSet rs = JDBC.getdata("SELECT * FROM account_type WHERE atype='" + a + "' ");
            if (rs.next()) {
                String invoice = rs.getString("invoice");
                String stock = rs.getString("stock");
                String expenses = rs.getString("expenses");
                String accounts = rs.getString("accounts");
                String option = rs.getString("option");
                if (invoice.equals("false")) {
                    Home.invoice.setEnabled(false);
                }
                if (stock.equals("false")) {
                    Home.stock.setEnabled(false);
                }
                if (expenses.equals("false")) {
                    Home.expenses.setEnabled(false);
                }
                if (accounts.equals("false")) {
                    Home.accounts.setEnabled(false);
                }
                if (option.equals("false")) {
                    Home.option.setEnabled(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        jTu = new javax.swing.JTextField();
        jTp = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 230));
        setMinimumSize(new java.awt.Dimension(400, 230));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(400, 230));
        getContentPane().setLayout(null);

        jTu.setBackground(new java.awt.Color(64, 64, 64));
        jTu.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTu.setForeground(new java.awt.Color(255, 255, 255));
        jTu.setText("Admin");
        jTu.setBorder(null);
        jTu.setOpaque(false);
        getContentPane().add(jTu);
        jTu.setBounds(57, 58, 310, 30);

        jTp.setBackground(new java.awt.Color(64, 64, 64));
        jTp.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTp.setForeground(new java.awt.Color(255, 255, 255));
        jTp.setText("123456789");
        jTp.setBorder(null);
        jTp.setOpaque(false);
        getContentPane().add(jTp);
        jTp.setBounds(57, 131, 310, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("LOGIN");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(270, 180, 110, 31);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login_4.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 230);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (jTu.getText().isEmpty() || jTp.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Some fields are empty", "Input error", JOptionPane.ERROR_MESSAGE);
            } else {
                String du = jTu.getText();
                String dp = new String(jTp.getPassword());
                String u = (jTu.getText().trim().toString());
                String p = Encrypt.NewEncrypt(new String(jTp.getPassword()));
                if (du.equals("Admin") && dp.equals("123456789")) {
                    String atype = "Admin";
                    MainFrame m = new MainFrame();
                    restrict(atype);
                    m.setSize(1366, 726);
                    m.setVisible(true);
                    this.dispose();
                } else {
                    try {
                        ResultSet rs = JDBC.getdata("SELECT * FROM user_accounts WHERE user_name='" + u + "' && password='" + p + "'");
                        if (rs.next()) {
                            String atype = null;
                            MainFrame m = new MainFrame();
                            ResultSet foratype = JDBC.getdata("SELECT account_type FROM user_accounts WHERE user_name='" + u + "' && password='" + p + "'");
                            while (foratype.next()) {
                                atype = foratype.getString("account_type");
                            }
                            restrict(atype);
                            m.setSize(1366, 726);
                            m.setVisible(true);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Username or password invalid", "Error inputs", JOptionPane.ERROR_MESSAGE);
                            jTu.setText("");
                            jTp.setText("");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
                if ("Windows".equals(info.getName())) {
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
                Login l = new Login();
                l.setSize(400, 200);//[401, 241]
                l.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jTp;
    private javax.swing.JTextField jTu;
    // End of variables declaration//GEN-END:variables
}
