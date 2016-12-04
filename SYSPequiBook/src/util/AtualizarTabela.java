/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entidade.EMensagem;
import entidade.EPerfilUsuario;
import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import negocio.NAmizade;
import persisrencia.PMensagem;

/**
 *
 * @author Eduardo
 */
public class AtualizarTabela implements Runnable {

    private JTable tblSolicitacoes;
    private JTable tblMensagens;
    private JLabel Texto;
    BuscarMensagens bm = new BuscarMensagens(tblMensagens, Texto);

    public AtualizarTabela(JTable tblSolicitacoes, JTable tabela, JLabel texto) {
        this.tblSolicitacoes = tblSolicitacoes;
        this.tblMensagens = tabela;
        this.Texto = texto;

    }

    @Override
    public void run() {
        while (true) {
            Vector detalhe = new Vector();
            Vector<String> cabecalho = new Vector<>();
            Vector<String> cabecalho2 = new Vector<>();
            Vector detalhe2 = new Vector();

            try {
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

                cabecalho.add("Nome");
                cabecalho.add("Id");

                for (EPerfilUsuario item : ePerfil) {

                    Vector<String> linha = new Vector<>();
                    linha.add(item.getNome());
                    linha.add(item.getCodigo() + "");

                    detalhe.add(linha);

                }

                //----------------------------------------------------------------------------
                

                cabecalho2.add("Nome");

                cabecalho2.add("ID");

                PMensagem mensagen = new PMensagem();

                List<EMensagem> list2 = null;

                list2 = mensagen.ListarMensagens();
                if (list2.size() == 0) {
                    Texto.setText("Você não tem novas mensagens");
                    Texto.setForeground(Color.black);
                } else {
                    Texto.setText("Novas Mensagens");
                    Texto.setForeground(Color.red);

                    for (EMensagem item : list2) {

                        Vector<String> linha = new Vector<>();
                        linha.add(item.getNome() + " Falou com você");
                        linha.add(item.getCodigoRemetente() + "");

                        detalhe2.add(linha);
                    }
                }
                //---- -----------------------------------------------------------------------  
            } catch (SQLException ex) {
                Logger.getLogger(AtualizarTabela.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(AtualizarTabela.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {

                tblSolicitacoes.setModel(new DefaultTableModel(detalhe, cabecalho));
                 tblMensagens.setModel(new DefaultTableModel(detalhe2, cabecalho));
                 
                Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
  

}
