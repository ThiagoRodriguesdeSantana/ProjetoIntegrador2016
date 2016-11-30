/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import entidade.EAcesso;
import entidade.EAmizade;
import entidade.EPerfilUsuario;
import entidade.StatusDaSolicitacao;
import entidade.StatusPerfil;
import entidade.StatusRelacionamento;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import negocio.NAcesso;
import negocio.NAmizade;
import negocio.NMensagem;
import negocio.NPerfilUsuario;
import util.AtualizarTabela;

/**
 *
 * @author Eduardo
 */
public class Principal extends javax.swing.JFrame {

    private EPerfilUsuario _PerfilUsuario;
    private EAcesso _Acesso;
    private NAcesso _NAcesso = new NAcesso();
    private boolean _lbnEditarSenha = true;
    private boolean _pnlLogin = false;

    File imagem;

    public Principal() {

        initComponents();
        
        AtualizarTabela atualizarTabela = new AtualizarTabela(tblSolicitacoes);
        Thread thread = new Thread(atualizarTabela);
        thread.start();

    }

    public Principal(EPerfilUsuario perfilUsuario) throws SQLException {

        this();

        this._PerfilUsuario = perfilUsuario;

        lbNome.setText(_PerfilUsuario.getNome());
        preencherComboBox();
        ordenarSolicitacao();
        PreencheTabelaAmigosOnline();

        paneLogin.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnuAcessarPerfil = new javax.swing.JMenuItem();
        mnuCconversar = new javax.swing.JMenuItem();
        mnuSolicitarAmizade = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        mnuAceitarSolicitacao = new javax.swing.JMenuItem();
        mnuRejeitarSolicitacao = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPessoasOnline = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        btnAddPostagem = new javax.swing.JButton();
        btnRemoverPostagem = new javax.swing.JButton();
        txtListarUsuarios = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnAcessarPerfil = new javax.swing.JButton();
        btnFotos = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSolicitacoes = new javax.swing.JTable();
        paneLogin = new javax.swing.JPanel();
        btnFoto = new javax.swing.JButton();
        pnlFoto = new javax.swing.JPanel();
        lbFoto = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboRelacionamento = new javax.swing.JComboBox();
        cboStatusPerfil = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnAcesso = new javax.swing.JButton();
        pnlSenha = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        txtNovaSenha = new javax.swing.JPasswordField();
        btnAtualizar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        mnuAcessarPerfil.setText("Acessar Perfil");
        mnuAcessarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAcessarPerfilActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnuAcessarPerfil);
        mnuAcessarPerfil.getAccessibleContext().setAccessibleName("Acessar Perfil");

        mnuCconversar.setMnemonic('E');
        mnuCconversar.setText("Enviar Mensagem");
        mnuCconversar.setActionCommand("");
        mnuCconversar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCconversarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnuCconversar);
        mnuCconversar.getAccessibleContext().setAccessibleName("Enviar Mensagem");

        mnuSolicitarAmizade.setText("Solicitar Amizade");
        mnuSolicitarAmizade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSolicitarAmizadeActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnuSolicitarAmizade);

        mnuAceitarSolicitacao.setText("Aceitar");
        mnuAceitarSolicitacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAceitarSolicitacaoActionPerformed(evt);
            }
        });
        jPopupMenu2.add(mnuAceitarSolicitacao);

        mnuRejeitarSolicitacao.setText("Rejeitar");
        mnuRejeitarSolicitacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRejeitarSolicitacaoActionPerformed(evt);
            }
        });
        jPopupMenu2.add(mnuRejeitarSolicitacao);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/logo pg inicial.png"))); // NOI18N

        lbNome.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        lbNome.setText("Eduardo Carvalho Roloff");
        lbNome.setToolTipText("");

        btnEntrar.setBackground(new java.awt.Color(255, 183, 0));
        btnEntrar.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        btnEntrar.setText("Sair");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 454, Short.MAX_VALUE)
                .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(302, 302, 302)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addContainerGap(461, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEntrar))
                .addGap(469, 469, 469))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 40));

        jPanel2.setBackground(new java.awt.Color(115, 115, 115));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/PequiBook logo pequena.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel12.setText("Pessoas Online");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        tblPessoasOnline.setBackground(new java.awt.Color(115, 115, 115));
        tblPessoasOnline.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        tblPessoasOnline.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPessoasOnline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblPessoasOnlineMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblPessoasOnline);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/2016-11-27 (2).png"))); // NOI18N

        btnAddPostagem.setBackground(new java.awt.Color(255, 183, 0));
        btnAddPostagem.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        btnAddPostagem.setText("Adicionar Postagem");
        btnAddPostagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPostagemActionPerformed(evt);
            }
        });

        btnRemoverPostagem.setBackground(new java.awt.Color(255, 183, 0));
        btnRemoverPostagem.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        btnRemoverPostagem.setText("Remover Postagem");

        txtListarUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtListarUsuariosKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtListarUsuarios)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAddPostagem)
                                    .addComponent(btnRemoverPostagem))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAddPostagem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemoverPostagem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtListarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 50, 250, 680));

        jPanel3.setBackground(new java.awt.Color(255, 183, 0));

        btnAcessarPerfil.setBackground(new java.awt.Color(115, 115, 115));
        btnAcessarPerfil.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        btnAcessarPerfil.setText("Acesse seu Perfil");
        btnAcessarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcessarPerfilActionPerformed(evt);
            }
        });

        btnFotos.setBackground(new java.awt.Color(115, 115, 115));
        btnFotos.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        btnFotos.setText("Fotos");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/PequiBook logo pequena.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel7.setText("Solicitações");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnFotos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAcessarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnAcessarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFotos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 250, 360));

        tblSolicitacoes.setBackground(new java.awt.Color(255, 183, 0));
        tblSolicitacoes.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        tblSolicitacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblSolicitacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblSolicitacoesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblSolicitacoes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 250, 320));

        btnFoto.setText("Alterar Foto");
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });

        pnlFoto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 51, 0)));

        javax.swing.GroupLayout pnlFotoLayout = new javax.swing.GroupLayout(pnlFoto);
        pnlFoto.setLayout(pnlFotoLayout);
        pnlFotoLayout.setHorizontalGroup(
            pnlFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlFotoLayout.setVerticalGroup(
            pnlFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel4.setForeground(new java.awt.Color(255, 153, 0));

        jLabel4.setText("Nome:");

        jLabel5.setText("Email");

        jLabel6.setText("Telefone");

        cboRelacionamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboStatusPerfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Status do Perfil");

        jLabel8.setText("Relacionamento");

        btnAcesso.setText("Redefinir Login");
        btnAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcessoActionPerformed(evt);
            }
        });

        pnlSenha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel9.setText("Digite sua senha");

        jLabel10.setText("Digite nova senha");

        javax.swing.GroupLayout pnlSenhaLayout = new javax.swing.GroupLayout(pnlSenha);
        pnlSenha.setLayout(pnlSenhaLayout);
        pnlSenhaLayout.setHorizontalGroup(
            pnlSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSenhaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlSenhaLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSenhaLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNovaSenha)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSenhaLayout.setVerticalGroup(
            pnlSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSenhaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cboRelacionamento, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboStatusPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                            .addComponent(txtEmail)
                            .addComponent(txtNome))))
                .addGap(31, 31, 31))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboRelacionamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboStatusPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(btnAcesso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paneLoginLayout = new javax.swing.GroupLayout(paneLogin);
        paneLogin.setLayout(paneLoginLayout);
        paneLoginLayout.setHorizontalGroup(
            paneLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );
        paneLoginLayout.setVerticalGroup(
            paneLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneLoginLayout.createSequentialGroup()
                        .addComponent(pnlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFoto))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(342, Short.MAX_VALUE))
        );

        getContentPane().add(paneLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 870, 680));

        jSeparator2.setForeground(new java.awt.Color(255, 153, 0));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 730, 1370, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcessarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcessarPerfilActionPerformed

        if (!_pnlLogin) {


            PreencherControles();

            paneLogin.setVisible(true);
            _pnlLogin = true;
            btnAcessarPerfil.setText("Sair do perfil");
        } else {

            paneLogin.setVisible(false);
            _pnlLogin = false;
            btnAcessarPerfil.setText("Acessar Perfil");
        }

    }//GEN-LAST:event_btnAcessarPerfilActionPerformed

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed

        imagem = SelecionarImagem();

        AbrirImagem(imagem);

    }//GEN-LAST:event_btnFotoActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed

        try {

            AtualizarPerfil();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcessoActionPerformed

        if (_lbnEditarSenha) {
            pnlSenha.setVisible(true);

            _lbnEditarSenha = false;
        } else {
            pnlSenha.setVisible(false);
            _lbnEditarSenha = true;
        }
    }//GEN-LAST:event_btnAcessoActionPerformed

    private void txtListarUsuariosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtListarUsuariosKeyPressed
        try {

            Pesquisar();

        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtListarUsuariosKeyPressed

    private void btnAddPostagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPostagemActionPerformed

    }//GEN-LAST:event_btnAddPostagemActionPerformed

    private void tblPessoasOnlineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPessoasOnlineMouseReleased

        int index = tblPessoasOnline.getSelectedRow();
        if (evt.isPopupTrigger()) {

            jPopupMenu1.show(evt.getComponent(), evt.getX(), index);
        }
    }//GEN-LAST:event_tblPessoasOnlineMouseReleased

    private void mnuAcessarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAcessarPerfilActionPerformed

        try {

            int linha = tblPessoasOnline.getSelectedRow();
            int codigo = Integer.parseInt((String) tblPessoasOnline.getValueAt(linha, 1));

            NPerfilUsuario nPerfilUsuario = new NPerfilUsuario();

            AcessarPerfil(nPerfilUsuario.BuscarUsuario(codigo));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_mnuAcessarPerfilActionPerformed

    private void mnuSolicitarAmizadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSolicitarAmizadeActionPerformed

        int linha = tblPessoasOnline.getSelectedRow();
        int codigo = Integer.parseInt((String) tblPessoasOnline.getValueAt(linha, 1));
        NAmizade amizade = new NAmizade();

        try {
            if (amizade.ConsultarAmizade(codigo) == 0) {

                EAmizade eAmizade = new EAmizade();

                eAmizade.setAmigo(codigo);
                eAmizade.setCodigoUsiario(_PerfilUsuario.getCodigo());
                eAmizade.setDaSolicitacao(StatusDaSolicitacao.Enviado);

                amizade.SolicitarAmizade(eAmizade);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuSolicitarAmizadeActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        
        try {
            PreencheTabelaAmigosOnline();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void tblSolicitacoesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSolicitacoesMouseReleased
        
          int index = tblSolicitacoes.getSelectedRow();
        if (evt.isPopupTrigger()) {

            jPopupMenu2.show(evt.getComponent(), evt.getX(), index);
        }
    }//GEN-LAST:event_tblSolicitacoesMouseReleased

    private void mnuAceitarSolicitacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAceitarSolicitacaoActionPerformed
        
        int linha = tblSolicitacoes.getSelectedRow();
            int codigo = Integer.parseInt((String) tblSolicitacoes.getValueAt(linha, 1));
        
            EAmizade amizade = new EAmizade();
            
            amizade.setAmigo(_PerfilUsuario.getCodigo());
            amizade.setCodigoUsiario(codigo);
            amizade.setDaSolicitacao(StatusDaSolicitacao.Aceito);   
            
           NAmizade nAmizade  =new NAmizade();
        try {
            nAmizade.AtualizarAmizade(amizade);
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        
        
        
    }//GEN-LAST:event_mnuAceitarSolicitacaoActionPerformed

    private void mnuRejeitarSolicitacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRejeitarSolicitacaoActionPerformed
        
        int linha = tblSolicitacoes.getSelectedRow();
            int codigo = Integer.parseInt((String) tblSolicitacoes.getValueAt(linha, 1));
        
            EAmizade amizade = new EAmizade();
            
            amizade.setAmigo(_PerfilUsuario.getCodigo());
            amizade.setCodigoUsiario(codigo);
            amizade.setDaSolicitacao(StatusDaSolicitacao.Rejeitado);   
            
           NAmizade nAmizade  =new NAmizade();
        try {
            nAmizade.AtualizarAmizade(amizade);
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_mnuRejeitarSolicitacaoActionPerformed

    private void mnuCconversarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCconversarActionPerformed
        
        NMensagem mensagem = new NMensagem();
        try {
            Mensagem mensagemT  = new Mensagem(mensagem.ListarMensagens());
            mensagemT.setVisible(true);
            
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_mnuCconversarActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcessarPerfil;
    private javax.swing.JButton btnAcesso;
    private javax.swing.JButton btnAddPostagem;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnFoto;
    private javax.swing.JButton btnFotos;
    private javax.swing.JButton btnRemoverPostagem;
    private javax.swing.JComboBox cboRelacionamento;
    private javax.swing.JComboBox cboStatusPerfil;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JLabel lbNome;
    private javax.swing.JMenuItem mnuAceitarSolicitacao;
    private javax.swing.JMenuItem mnuAcessarPerfil;
    private javax.swing.JMenuItem mnuCconversar;
    private javax.swing.JMenuItem mnuRejeitarSolicitacao;
    private javax.swing.JMenuItem mnuSolicitarAmizade;
    private javax.swing.JPanel paneLogin;
    private javax.swing.JPanel pnlFoto;
    private javax.swing.JPanel pnlSenha;
    private javax.swing.JTable tblPessoasOnline;
    private javax.swing.JTable tblSolicitacoes;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtListarUsuarios;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtNovaSenha;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

    private void PreencherControles() {

        try {

            NAcesso acesso = new NAcesso();

            if (!txtEmail.getText().isEmpty()) {
                _PerfilUsuario.getAcesso().setEmail(txtEmail.getText());
            }
            if (!txtNovaSenha.getText().isEmpty()) {
                _PerfilUsuario.getAcesso().setSenha(txtNovaSenha.getText());
            }

            EPerfilUsuario perfil = acesso.Logar(_PerfilUsuario.getAcesso());

            lbNome.setText(perfil.getNome());
            pnlSenha.setVisible(false);


            txtEmail.setText(_PerfilUsuario.getAcesso().getEmail());
            txtNome.setText(_PerfilUsuario.getNome());
            txtTelefone.setText(_PerfilUsuario.getTelefone());
            cboRelacionamento.setSelectedItem(_PerfilUsuario.getStatusRelacionamento());
            cboStatusPerfil.setSelectedItem(_PerfilUsuario.getStatusPerfil().ordinal());

            ImageIcon icon = new ImageIcon(_PerfilUsuario.getFoto());

            txtEmail.setText(perfil.getAcesso().getEmail());
            txtNome.setText(perfil.getNome());
            txtTelefone.setText(perfil.getTelefone());
            cboRelacionamento.setSelectedIndex(perfil.getIdStatusRelacionamento());
            cboStatusPerfil.setSelectedIndex(perfil.getIdStatusPerfil());


            icon.setImage(icon.getImage().getScaledInstance(pnlFoto.getWidth() - 5, pnlFoto.getHeight() - 5, 100));
            lbFoto.setIcon(icon);

            _PerfilUsuario = perfil;

        } catch (Exception e) {


            System.out.println(e.getMessage());
        }

    }

    private void AcessarPerfil(EPerfilUsuario usuario) {

        try {

            if (usuario.getIdStatusPerfil() == (StatusPerfil.Publico.ordinal() + 1)) {

                paneLogin.setVisible(true);
                lbNome.setText(usuario.getNome());

                btnAcesso.setEnabled(false);

                txtNome.setText(usuario.getNome());
                txtTelefone.setText(usuario.getTelefone());
                System.out.println(usuario.getIdStatusRelacionamento());
                cboRelacionamento.setSelectedIndex(usuario.getIdStatusRelacionamento());
                cboStatusPerfil.setSelectedIndex(usuario.getIdStatusPerfil());

                ImageIcon icon = new ImageIcon(_PerfilUsuario.getFoto());
                icon.setImage(icon.getImage().getScaledInstance(pnlFoto.getWidth() - 5, pnlFoto.getHeight() - 5, 100));
                lbFoto.setIcon(icon);

                _pnlLogin = true;
                btnAcessarPerfil.setText("Sair do perfil");

            } else {

                paneLogin.setVisible(true);

                lbNome.setText(usuario.getNome());

                btnAcesso.setEnabled(false);

                txtNome.setText(usuario.getNome());
                txtTelefone.setText("Privado");
                cboRelacionamento.setSelectedIndex(1);
                cboStatusPerfil.setSelectedIndex(1);

                ImageIcon icon = new ImageIcon(_PerfilUsuario.getFoto());
                icon.setImage(icon.getImage().getScaledInstance(pnlFoto.getWidth() - 5, pnlFoto.getHeight() - 5, 100));
                lbFoto.setIcon(icon);

                _pnlLogin = true;
                btnAcessarPerfil.setText("Sair do perfil");
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public File SelecionarImagem() {

        JFileChooser jbusca = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagens", "jpg", "png");
        jbusca.addChoosableFileFilter(filtro);
        jbusca.setAcceptAllFileFilterUsed(false);
        jbusca.setDialogType(JFileChooser.OPEN_DIALOG);
        jbusca.setCurrentDirectory(new File("/"));
        jbusca.showOpenDialog(this);

        return jbusca.getSelectedFile();

    }

    private byte[] PegaImagem() throws IOException {
        boolean isPng = false;

        if (imagem != null) {
            isPng = imagem.getName().endsWith("png");

            BufferedImage image = ImageIO.read(imagem);

            ByteArrayOutputStream out = new ByteArrayOutputStream();

            int type = BufferedImage.TYPE_INT_RGB;
            if (isPng) {
                type = BufferedImage.BITMASK;
            }

            BufferedImage novaImagem = new BufferedImage(pnlFoto.getWidth() - 5, pnlFoto.getHeight() - 5, type);
            Graphics2D g = novaImagem.createGraphics();
            g.setComposite(AlphaComposite.Src);
            g.drawImage(image, 0, 0, pnlFoto.getWidth() - 5, pnlFoto.getHeight() - 5, null);

            if (isPng) {
                ImageIO.write(novaImagem, "png", out);
            } else {
                ImageIO.write(novaImagem, "jpg", out);
            }
            out.flush();

            byte[] byteArray = out.toByteArray();
            out.close();

            return byteArray;

        }
        return null;
    }

    private void AtualizarPerfil() throws IOException, SQLException {

        _Acesso = new EAcesso();

        _Acesso.setCodigo(NAcesso.EPerfilUsuarioLogado.getAcesso().getCodigo());
        if (txtNovaSenha.getText().isEmpty()) {
            _Acesso.setSenha(NAcesso.EPerfilUsuarioLogado.getAcesso().getSenha());
        } else {
            _Acesso.setSenha(txtNovaSenha.getText());
        }

        _Acesso.setEmail(txtEmail.getText());
        _PerfilUsuario.setNome(txtNome.getText());
        _PerfilUsuario.setAcesso(_Acesso);
        _PerfilUsuario.setFoto(PegaImagem());
        _PerfilUsuario.setStatusPerfil((StatusPerfil) cboStatusPerfil.getSelectedItem());
        _PerfilUsuario.setStatusRelacionamento((StatusRelacionamento) cboRelacionamento.getSelectedItem());

        _NAcesso.EditarPerfil(_PerfilUsuario);

    }

    private void AbrirImagem(Object source) {

        if (source instanceof File) {
            ImageIcon ico = new ImageIcon(imagem.getAbsolutePath());
            ico.setImage(ico.getImage().getScaledInstance(pnlFoto.getWidth() - 5, pnlFoto.getHeight() - 5, 100));

            lbFoto.setIcon(ico);
        } else if (source instanceof byte[]) {

            ImageIcon icon = new ImageIcon(_PerfilUsuario.getFoto());
            icon.setImage(icon.getImage().getScaledInstance(pnlFoto.getWidth() - 10, pnlFoto.getHeight() - 10, 100));
            lbFoto.setIcon(icon);
        }
    }

    private void preencherComboBox() {

        PreencherComboRelacionamento();
        PreencherComboStatusPerfil();

    }

    private void PreencherComboRelacionamento() {

        cboRelacionamento.removeAllItems();
        cboRelacionamento.addItem(StatusRelacionamento.Casado);
        cboRelacionamento.addItem(StatusRelacionamento.Solteiro);
        cboRelacionamento.addItem(StatusRelacionamento.Divorciado);
        cboRelacionamento.addItem(StatusRelacionamento.Viuvo);
        cboRelacionamento.addItem(StatusRelacionamento.Nenhum);

    }

    private void PreencherComboStatusPerfil() {

        cboStatusPerfil.removeAllItems();

        cboStatusPerfil.addItem(StatusPerfil.Privado);
        cboStatusPerfil.addItem(StatusPerfil.Publico);
    }

    private void PreencheTabelaSolicitacao() throws SQLException {

        Vector<String> cabecalho = new Vector<>();

        cabecalho.add("Nome");

        cabecalho.add("ID");


        Vector detalhe = new Vector();

        NAmizade amizade = new NAmizade();

        List<EPerfilUsuario> list = amizade.ListarSolicitacoes();

        for (EPerfilUsuario item : list) {

            Vector<String> linha = new Vector<>();
            linha.add(item.getNome());


            linha.add(item.getCodigo() + "");


            detalhe.add(linha);

        }
        tblSolicitacoes.setModel(new DefaultTableModel(detalhe, cabecalho));

    }

    private void PreencheTabelaAmigosOnline() throws SQLException {

        NPerfilUsuario perfilUsuario = new NPerfilUsuario();

        
        
        Vector<String> cabecalho = new Vector<>();

        cabecalho.add("Nome");

        cabecalho.add("ID");

        Vector detalhe = new Vector();

        List<EPerfilUsuario> list = perfilUsuario.ListarUsuarioOnLine();

        for (EPerfilUsuario item : list) {

            Vector<String> linha = new Vector<>();
            linha.add(item.getNome());

            linha.add(item.getCodigo() + "");


            detalhe.add(linha);

        }
        tblPessoasOnline.setModel(new DefaultTableModel(detalhe, cabecalho));

    }

    private void Pesquisar() throws SQLException {

        EPerfilUsuario perfilUsuario = new EPerfilUsuario();

        if (!txtListarUsuarios.getText().isEmpty()) {
            perfilUsuario.setNome(txtListarUsuarios.getText());
            PreencheTabelaUsuarios(perfilUsuario.getNome());
        } else {
            PreencheTabelaAmigosOnline();
        }



    }

    private void PreencheTabelaUsuarios(String nome) throws SQLException {

        NPerfilUsuario perfilUsuario = new NPerfilUsuario();

        Vector<String> cabecalho = new Vector<>();

        cabecalho.add("Nome");
        cabecalho.add("ID");

        Vector detalhe = new Vector();

        List<EPerfilUsuario> list = perfilUsuario.ListarUsuarios(nome);

        for (EPerfilUsuario item : list) {

            Vector<String> linha = new Vector<>();
            linha.add(item.getNome());
            linha.add(item.getCodigo() + "");

            detalhe.add(linha);

        }
        tblPessoasOnline.setModel(new DefaultTableModel(detalhe, cabecalho));

    }

    public void ordenarSolicitacao() throws SQLException {

        NAmizade amizade = new NAmizade();

        List<EPerfilUsuario> list = amizade.ListarSolicitacoes();

        int cout = 0;

        EPerfilUsuario ePerfil[] = new EPerfilUsuario[list.size()];
        for (EPerfilUsuario ePerfilUsuario : list) {
            ePerfil[cout] = ePerfilUsuario;
            cout++;
        }

        for (int i = ePerfil.length - 1; i > 0; i--) {
            EPerfilUsuario aux;
            for (int j = 0; j < i; j++) {
                if (ePerfil[j].getNome().compareToIgnoreCase(ePerfil[j + 1].getNome()) > 0) {
                    aux = ePerfil[j];
                    ePerfil[j] = ePerfil[j + 1];
                    ePerfil[j + 1] = aux;
                }
            }
        }

        imprimirOrdenado(ePerfil);
    }

    private void imprimirOrdenado(EPerfilUsuario[] ePerfil) {
        //
        Vector<String> cabecalho = new Vector<>();

        cabecalho.add("Nome");
        cabecalho.add("ID");

        Vector detalhe = new Vector();

        for (EPerfilUsuario item : ePerfil) {

            Vector<String> linha = new Vector<>();
            linha.add(item.getNome());
            linha.add(item.getCodigo()+"");

            detalhe.add(linha);
        }
        tblSolicitacoes.setModel(new DefaultTableModel(detalhe, cabecalho));

    }

    
}
