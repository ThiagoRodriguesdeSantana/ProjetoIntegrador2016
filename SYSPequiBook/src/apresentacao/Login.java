/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import entidade.EAcesso;
import entidade.EPerfilUsuario;
import entidade.StatusPerfil;
import entidade.StatusRelacionamento;
import java.awt.Color;
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

        SetControle();
        
       

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        lblExcecao = new java.awt.Label();
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Logo pequena login.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        jLabel1.setText("E-mail");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(923, 11, -1, -1));

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtEmail.setToolTipText("Digite seu e-mail");
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(923, 32, 160, 30));

        jLabel3.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        jLabel3.setText("Senha");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 11, -1, -1));

        txtSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSenha.setToolTipText("Digite sua senha");
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        jPanel1.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 32, 150, 30));

        btnEntrar.setBackground(new java.awt.Color(153, 153, 153));
        btnEntrar.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 30, 100, 30));

        lblExcecao.setForeground(new java.awt.Color(255, 0, 0));
        lblExcecao.setText("label1");
        jPanel1.add(lblExcecao, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 390, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1380, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/PequiBook  Logo 1.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 310, 570, 400));

        jLabel5.setFont(new java.awt.Font("Candara", 1, 27)); // NOI18N
        jLabel5.setText("Cadastra-se e tenha a oportunidade");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 450, 40));

        jLabel6.setFont(new java.awt.Font("Candara", 1, 27)); // NOI18N
        jLabel6.setText("de encontrar seus amigos e");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 350, 80));

        jLabel7.setFont(new java.awt.Font("Candara", 1, 27)); // NOI18N
        jLabel7.setText("fazer novas amizades!");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 260, 60));

        jLabel8.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel8.setText("Senha");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 400, 80, 20));

        txtTelefone.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        txtTelefone.setToolTipText("Digite seu telefone");
        getContentPane().add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 360, 210, 30));

        txtNome1.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        txtNome1.setToolTipText("Digite seu nome completo");
        getContentPane().add(txtNome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 240, 210, 30));

        jLabel9.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel9.setText("Nome");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 220, 60, 20));

        txtEmail1.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        txtEmail1.setToolTipText("Digite seu E-mail");
        getContentPane().add(txtEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 300, 210, 30));

        jLabel10.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel10.setText("Email");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 280, 60, 20));

        jLabel11.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel11.setText("Telefone");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 340, 80, 20));

        txtSenhaCadastro.setToolTipText("Digite sua Senha");
        getContentPane().add(txtSenhaCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 420, 210, 30));

        btnCadastrar.setBackground(new java.awt.Color(0, 153, 51));
        btnCadastrar.setFont(new java.awt.Font("Candara", 1, 21)); // NOI18N
        btnCadastrar.setText("Cadastre-se");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 470, 140, 60));

        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/bg_4.jpg"))); // NOI18N
        getContentPane().add(Imagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed

        try {

            CadastrarUsuario();
            LimparCAmpos();
            
            lblExcecao.setVisible(true);
            lblExcecao.setForeground(Color.GREEN);
            lblExcecao.setText("Voçe já pode acessar sua conta!");

        } catch (Exception e) {

            lblExcecao.setVisible(true);
            lblExcecao.setText(e.getMessage());
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed

        try {
            Logar();

        } catch (Exception e) {

            lblExcecao.setText(e.getMessage());
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

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
    private java.awt.Label lblExcecao;
    private javax.swing.JTextField txtEmail;
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

    private void SetControle() {

        lblExcecao.setVisible(false);

    }

    private void Logar() throws Exception {

        NAcesso nAcesso = new NAcesso();

        EAcesso acesso = new EAcesso();
        acesso.setEmail(txtEmail.getText());
        acesso.setSenha(txtSenha.getText());

        Principal principal = new Principal(nAcesso.Logar(acesso));
        principal.setVisible(true);
        this.dispose();
    }
}
