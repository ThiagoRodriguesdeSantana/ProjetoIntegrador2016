/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import entidade.EPerfilUsuario;
import entidade.StatusPerfil;
import entidade.StatusRelacionamento;
import negocio.NAcesso;

/**
 *
 * @author Eduardo
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }
    
    

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        txtNome1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEmail1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtSenhaCadastro = new javax.swing.JPasswordField();
        btnCadastrar = new javax.swing.JButton();
        Imagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Logo pequena login.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        jLabel1.setText("E-mail");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(923, 11, -1, -1));

        jTextField1.setToolTipText("Digite seu e-mail");
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(923, 32, 139, 27));

        jLabel3.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        jLabel3.setText("Senha");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 11, -1, -1));

        txtSenha.setToolTipText("Digite sua senha");
        jPanel1.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 32, 139, 23));

        btnEntrar.setBackground(new java.awt.Color(153, 153, 153));
        btnEntrar.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        btnEntrar.setText("Entrar");
        jPanel1.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 33, -1, -1));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-10, 0, 1380, 70);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/PequiBook  Logo 1.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(-50, 310, 570, 400);

        jLabel5.setFont(new java.awt.Font("Candara", 1, 27)); // NOI18N
        jLabel5.setText("Cadastra-se e tenha a oportunidade");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 200, 450, 40);

        jLabel6.setFont(new java.awt.Font("Candara", 1, 27)); // NOI18N
        jLabel6.setText("de encontrar seus amigos e");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(90, 210, 350, 80);

        jLabel7.setFont(new java.awt.Font("Candara", 1, 27)); // NOI18N
        jLabel7.setText("fazer novas amizades!");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(120, 250, 260, 60);

        jLabel8.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel8.setText("Senha");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(950, 420, 80, 20);

        txtTelefone.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        txtTelefone.setToolTipText("Digite seu telefone");
        getContentPane().add(txtTelefone);
        txtTelefone.setBounds(950, 380, 210, 30);

        txtNome1.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        txtNome1.setToolTipText("Digite seu nome completo");
        getContentPane().add(txtNome1);
        txtNome1.setBounds(950, 260, 210, 30);

        jLabel9.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel9.setText("Nome");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(950, 240, 60, 20);

        txtEmail1.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        txtEmail1.setToolTipText("Digite seu E-mail");
        getContentPane().add(txtEmail1);
        txtEmail1.setBounds(950, 320, 210, 30);

        jLabel10.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel10.setText("Email");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(950, 300, 60, 20);

        jLabel11.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel11.setText("Telefone");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(950, 360, 80, 20);

        txtSenhaCadastro.setToolTipText("Digite sua Senha");
        getContentPane().add(txtSenhaCadastro);
        txtSenhaCadastro.setBounds(950, 440, 210, 30);

        btnCadastrar.setBackground(new java.awt.Color(0, 153, 51));
        btnCadastrar.setFont(new java.awt.Font("Candara", 1, 21)); // NOI18N
        btnCadastrar.setText("Cadastre-se");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar);
        btnCadastrar.setBounds(1020, 490, 140, 60);

        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/bg_4.jpg"))); // NOI18N
        getContentPane().add(Imagem);
        Imagem.setBounds(0, 10, 1370, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
      
        try {
            
            CadastrarUsuario();
            LimparCAmpos();
            
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

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
    private javax.swing.JLabel Imagem;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtNome1;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JPasswordField txtSenhaCadastro;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

    private void CadastrarUsuario() throws Exception {
       
          EPerfilUsuario perfilUsuario = new EPerfilUsuario();
        NAcesso nAcesso = new NAcesso();

        perfilUsuario.getAcesso().setEmail(txtEmail1.getText());
        perfilUsuario.getAcesso().setSenha(txtSenhaCadastro.getText());

        perfilUsuario.setNome(txtNome1.getText());
        perfilUsuario.setTelefone(txtTelefone.getText());
        perfilUsuario.setStatusPerfil(StatusPerfil.Privado);
        perfilUsuario.setStatusLogin(true);
        perfilUsuario.setStatusRelacionamento(StatusRelacionamento.Nenhum);

        nAcesso.Salvar(perfilUsuario);

    }

    private void LimparCAmpos() {
        
        txtEmail1.setText("");
    	txtSenhaCadastro.setText("");
    	txtNome1.setText("");
    	txtTelefone.setText("");
    }
}
