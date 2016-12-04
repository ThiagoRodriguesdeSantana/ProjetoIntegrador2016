/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import entidade.EAcesso;
import entidade.EAmizade;
import entidade.EMensagem;
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
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import negocio.NAcesso;
import negocio.NAmizade;
import negocio.NMensagem;
import negocio.NPerfilUsuario;
import persisrencia.PPerfilUsuario;
import util.AtualizarTabela;
import util.BuscarMensagens;

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

        AtualizarTabela atualizarTabela = new AtualizarTabela(tblSolicitacoes, tblMensagens, lblMensagens);
        Thread thread = new Thread(atualizarTabela);
        thread.start();

    }

    public Principal(EPerfilUsuario perfilUsuario) throws SQLException {

        this();

        this._PerfilUsuario = perfilUsuario;

        lbNome.setText(_PerfilUsuario.getNome());
        preencherComboBox();
        //ordenarSolicitacao();
        PreencheTabelaAmigosOnline();

        paneLogin2.setVisible(false);

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
        btnSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnAddPostagem = new javax.swing.JButton();
        btnRemoverPostagem = new javax.swing.JButton();
        txtListarUsuarios = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMensagens = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblMensagens = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPessoasOnline = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnFotos = new javax.swing.JButton();
        btnAcessarPerfil = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        paneLogin = new javax.swing.JPanel();
        paneLogin2 = new javax.swing.JPanel();
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
        pnlFoto = new javax.swing.JPanel();
        lbFoto = new javax.swing.JLabel();
        btnFoto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSolicitacoes = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        mnuAcessarPerfil.setText("Acessar Perfil");
        mnuAcessarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAcessarPerfilActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnuAcessarPerfil);

        mnuCconversar.setMnemonic('E');
        mnuCconversar.setText("Enviar Mensagem");
        mnuCconversar.setActionCommand("");
        mnuCconversar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCconversarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnuCconversar);

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

        btnSair.setBackground(new java.awt.Color(255, 183, 0));
        btnSair.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 445, Short.MAX_VALUE)
                .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(322, 322, 322)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNome)
                            .addComponent(btnSair))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 30));

        jPanel2.setBackground(new java.awt.Color(255, 183, 0));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/PequiBook logo pequena.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel12.setText("Pessoas Online");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(255, 183, 0));
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

        tblMensagens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblMensagens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMensagensMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblMensagens);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/PequiBook logo pequena.png"))); // NOI18N

        lblMensagens.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblMensagens.setText("Novas Mensagens");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensagens, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtListarUsuarios)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAddPostagem)
                                    .addComponent(btnRemoverPostagem)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMensagens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(txtListarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 40, 250, 690));

        jPanel3.setBackground(new java.awt.Color(255, 183, 0));

        btnFotos.setBackground(new java.awt.Color(115, 115, 115));
        btnFotos.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        btnFotos.setText("Fotos");

        btnAcessarPerfil.setBackground(new java.awt.Color(115, 115, 115));
        btnAcessarPerfil.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        btnAcessarPerfil.setText("Acesse seu Perfil");
        btnAcessarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcessarPerfilActionPerformed(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/PequiBook logo pequena.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel7.setText("Solicitações");

        paneLogin.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout paneLoginLayout = new javax.swing.GroupLayout(paneLogin);
        paneLogin.setLayout(paneLoginLayout);
        paneLoginLayout.setHorizontalGroup(
            paneLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        paneLoginLayout.setVerticalGroup(
            paneLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        paneLogin2.setBackground(new java.awt.Color(255, 183, 0));
        paneLogin2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        paneLogin2.setForeground(new java.awt.Color(255, 153, 0));

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jLabel4.setText("Nome:");

        jLabel5.setText("Email");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        txtTelefone.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        jLabel6.setText("Telefone");

        cboRelacionamento.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cboRelacionamento.setMaximumRowCount(10);
        cboRelacionamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboStatusPerfil.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        cboStatusPerfil.setMaximumRowCount(10);
        cboStatusPerfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Status do Perfil");

        jLabel8.setText("Relacionamento");

        btnAcesso.setText("Redefinir Login");
        btnAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcessoActionPerformed(evt);
            }
        });

        pnlSenha.setBackground(new java.awt.Color(115, 115, 115));
        pnlSenha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel9.setText("Digite sua senha");

        jLabel10.setText("Digite nova senha");

        txtSenha.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N

        txtNovaSenha.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        javax.swing.GroupLayout pnlSenhaLayout = new javax.swing.GroupLayout(pnlSenha);
        pnlSenha.setLayout(pnlSenhaLayout);
        pnlSenhaLayout.setHorizontalGroup(
            pnlSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSenhaLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(pnlSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSenhaLayout.createSequentialGroup()
                        .addGroup(pnlSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSenhaLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSenhaLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        pnlSenhaLayout.setVerticalGroup(
            pnlSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSenhaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        pnlFoto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 51, 0)));

        javax.swing.GroupLayout pnlFotoLayout = new javax.swing.GroupLayout(pnlFoto);
        pnlFoto.setLayout(pnlFotoLayout);
        pnlFotoLayout.setHorizontalGroup(
            pnlFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFotoLayout.createSequentialGroup()
                .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlFotoLayout.setVerticalGroup(
            pnlFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnFoto.setText("Alterar Foto");
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneLogin2Layout = new javax.swing.GroupLayout(paneLogin2);
        paneLogin2.setLayout(paneLogin2Layout);
        paneLogin2Layout.setHorizontalGroup(
            paneLogin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneLogin2Layout.createSequentialGroup()
                .addGroup(paneLogin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneLogin2Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(paneLogin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(paneLogin2Layout.createSequentialGroup()
                        .addComponent(pnlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(paneLogin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneLogin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addComponent(txtEmail)
                            .addComponent(txtTelefone)
                            .addGroup(paneLogin2Layout.createSequentialGroup()
                                .addComponent(btnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cboRelacionamento, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(paneLogin2Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboStatusPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneLogin2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        paneLogin2Layout.setVerticalGroup(
            paneLogin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneLogin2Layout.createSequentialGroup()
                .addGroup(paneLogin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneLogin2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(paneLogin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(pnlFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneLogin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(2, 2, 2)
                .addGroup(paneLogin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneLogin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboRelacionamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneLogin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboStatusPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(btnAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnFotos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(410, 410, 410)
                        .addComponent(paneLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(paneLogin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(btnAcessarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAcessarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paneLogin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFotos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 400, 570));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 400, 120));

        jSeparator2.setBackground(new java.awt.Color(255, 183, 0));
        jSeparator2.setForeground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 730, 1370, -1));

        jButton1.setText("jButton1");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 210, -1, 160));

        jButton2.setText("jButton2");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 370, -1, 160));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setText("jLabel16");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 630, 330));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 630, 310));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1370, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void mnuCconversarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCconversarActionPerformed

        NMensagem mensagem = new NMensagem();
        try {
            int linha = tblPessoasOnline.getSelectedRow();
            int codigo = Integer.parseInt((String) tblPessoasOnline.getValueAt(linha, 1));

            Mensagem mensagemT = new Mensagem(codigo);
            mensagemT.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_mnuCconversarActionPerformed

    private void mnuRejeitarSolicitacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRejeitarSolicitacaoActionPerformed

        int linha = tblSolicitacoes.getSelectedRow();
        int codigo = Integer.parseInt((String) tblSolicitacoes.getValueAt(linha, 1));

        EAmizade amizade = new EAmizade();

        amizade.setAmigo(_PerfilUsuario.getCodigo());
        amizade.setCodigoUsiario(codigo);
        amizade.setDaSolicitacao(StatusDaSolicitacao.Rejeitado);

        NAmizade nAmizade = new NAmizade();
        try {
            nAmizade.AtualizarAmizade(amizade);
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_mnuRejeitarSolicitacaoActionPerformed

    private void mnuAceitarSolicitacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAceitarSolicitacaoActionPerformed

        int linha = tblSolicitacoes.getSelectedRow();
        int codigo = Integer.parseInt((String) tblSolicitacoes.getValueAt(linha, 1));

        EAmizade amizade = new EAmizade();

        amizade.setAmigo(_PerfilUsuario.getCodigo());
        amizade.setCodigoUsiario(codigo);
        amizade.setDaSolicitacao(StatusDaSolicitacao.Aceito);

        NAmizade nAmizade = new NAmizade();
        try {
            nAmizade.AtualizarAmizade(amizade);
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

    }//GEN-LAST:event_mnuAceitarSolicitacaoActionPerformed

    private void tblMensagensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMensagensMouseClicked

        try {
            int linha = tblMensagens.getSelectedRow();
            int codigo = Integer.parseInt((String) tblMensagens.getValueAt(linha, 1));
            

            Mensagem mensagem = new Mensagem(codigo);
            mensagem.setVisible(true);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }//GEN-LAST:event_tblMensagensMouseClicked

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        
        NAcesso acesso = new NAcesso();
        try {
            int resposta = JOptionPane.showConfirmDialog(null,
                "Confirma a saída do Sistema?", "PequiBook",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            acesso.Deslogar();
            System.exit(0);
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnSairActionPerformed

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

    private void btnAcessarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcessarPerfilActionPerformed

        if (!_pnlLogin) {

            PreencherControles();

            PPerfilUsuario pPerfilUsuario = new PPerfilUsuario();
            // EPerfilUsuario ePerfil = pPerfilUsuario.buscarImagem(id);

            paneLogin2.setVisible(true);
            _pnlLogin = true;
            btnAcessarPerfil.setText("Sair do perfil");
        } else {

            paneLogin2.setVisible(false);
            _pnlLogin = false;
            btnAcessarPerfil.setText("Acessar Perfil");
        }
    }//GEN-LAST:event_btnAcessarPerfilActionPerformed

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
    private javax.swing.JButton btnFoto;
    private javax.swing.JButton btnFotos;
    private javax.swing.JButton btnRemoverPostagem;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox cboRelacionamento;
    private javax.swing.JComboBox cboStatusPerfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lblMensagens;
    private javax.swing.JMenuItem mnuAceitarSolicitacao;
    private javax.swing.JMenuItem mnuAcessarPerfil;
    private javax.swing.JMenuItem mnuCconversar;
    private javax.swing.JMenuItem mnuRejeitarSolicitacao;
    private javax.swing.JMenuItem mnuSolicitarAmizade;
    private javax.swing.JPanel paneLogin;
    private javax.swing.JPanel paneLogin2;
    private javax.swing.JPanel pnlFoto;
    private javax.swing.JPanel pnlSenha;
    private javax.swing.JTable tblMensagens;
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
            PPerfilUsuario pPerfil = new PPerfilUsuario();

            if (!txtEmail.getText().isEmpty()) {
                _PerfilUsuario.getAcesso().setEmail(txtEmail.getText());
            }
            if (!txtNovaSenha.getText().isEmpty()) {
                _PerfilUsuario.getAcesso().setSenha(txtNovaSenha.getText());
            }

            EPerfilUsuario ePerfil = acesso.Logar(_PerfilUsuario.getAcesso());

            lbNome.setText(ePerfil.getNome());
            pnlSenha.setVisible(false);

            txtEmail.setText(_PerfilUsuario.getAcesso().getEmail());
            txtNome.setText(_PerfilUsuario.getNome());
            txtTelefone.setText(_PerfilUsuario.getTelefone());

            cboRelacionamento.setSelectedIndex(_PerfilUsuario.getIdStatusRelacionamento() - 1);
            cboStatusPerfil.setSelectedIndex(_PerfilUsuario.getIdStatusPerfil() - 1);

            txtNome.setText(ePerfil.getNome());
            txtTelefone.setText(ePerfil.getTelefone());
            cboRelacionamento.setSelectedIndex(ePerfil.getIdStatusRelacionamento());
            cboStatusPerfil.setSelectedIndex(ePerfil.getIdStatusPerfil());

            ImageIcon icon = new ImageIcon(_PerfilUsuario.getFoto());
            icon.setImage(icon.getImage().getScaledInstance(pnlFoto.getWidth() - 5, pnlFoto.getHeight() - 5, 100));
            lbFoto.setIcon(icon);

            _PerfilUsuario = ePerfil;

            AtualizaUsuarioLogado(ePerfil);

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

        int num = cboRelacionamento.getSelectedIndex() + 1;
        int num2 = cboStatusPerfil.getSelectedIndex() + 1;
        _PerfilUsuario.setIdStatusRelacionamento(num);
        _PerfilUsuario.setIdStatusPerfil(num2);

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

        cboStatusPerfil.addItem(StatusPerfil.Publico);
        cboStatusPerfil.addItem(StatusPerfil.Privado);

    }

//    private void PreencheTabelaSolicitacao() throws SQLException {
//
//        Vector<String> cabecalho = new Vector<>();
//
//        cabecalho.add("Nome");
//
//        cabecalho.add("ID");
//
//
//        Vector detalhe = new Vector();
//
//        NAmizade amizade = new NAmizade();
//
//        List<EPerfilUsuario> list = amizade.ListarSolicitacoes();
//
//        for (EPerfilUsuario item : list) {
//
//            Vector<String> linha = new Vector<>();
//            linha.add(item.getNome());
//
//
//            linha.add(item.getCodigo() + "");
//
//
//            detalhe.add(linha);
//
//        }
//        tblSolicitacoes.setModel(new DefaultTableModel(detalhe, cabecalho));
//
//    }
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
            linha.add(item.getCodigo() + "");

            detalhe.add(linha);
        }
        tblSolicitacoes.setModel(new DefaultTableModel(detalhe, cabecalho));

    }

    private void AtualizaUsuarioLogado(EPerfilUsuario perfil) {

        NPerfilUsuario nPerfilUsuario = new NPerfilUsuario();
        nPerfilUsuario.AtualizaUsuarioLogado(perfil);
    }

}
