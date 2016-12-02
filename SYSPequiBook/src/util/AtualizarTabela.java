/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entidade.EPerfilUsuario;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import negocio.NAmizade;

/**
 *
 * @author Eduardo
 */
public class AtualizarTabela implements Runnable {

    private JTable tblSolicitacoes;

    public AtualizarTabela(JTable tblSolicitacoes) {
        this.tblSolicitacoes = tblSolicitacoes;
    }

    @Override
    public void run() {
        while (true) {
            Vector<String> cabecalho = new Vector<>();
            cabecalho.add("Nome");
            
            Vector detalhe = new Vector();
            
            NAmizade amizade = new NAmizade();
            try {
                List<EPerfilUsuario> list = amizade.ListarSolicitacoes();

                for (EPerfilUsuario item : list) {

                    Vector<String> linha = new Vector<>();
                    linha.add(item.getNome());

                    detalhe.add(linha);

                }
            } catch (SQLException ex) {
                Logger.getLogger(AtualizarTabela.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                tblSolicitacoes.setModel(new DefaultTableModel(detalhe, cabecalho));
                Thread.sleep(20000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
