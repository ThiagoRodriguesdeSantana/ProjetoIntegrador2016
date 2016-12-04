/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entidade.EMensagem;
import java.awt.Color;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import persisrencia.PMensagem;

/**
 *
 * @author Thiago
 */
public class BuscarMensagens {

    private JTable tblMensagens;
    private JLabel Texto;

    public BuscarMensagens(JTable tabela, JLabel texto) {

        this.tblMensagens = tabela;
        this.Texto = texto;
        
        

    }

    public void Buscar() throws Exception {
        Vector<String> cabecalho = new Vector<>();
        Vector detalhe = new Vector();

        cabecalho.add("Nome");

        cabecalho.add("ID");
//
//        PMensagem mensagen = new PMensagem();
//
//        List<EMensagem> list = null;
//
//        list = mensagen.ListarMensagens();
//        if (list.size() == 0) {
//            Texto.setText("Você não tem novas mensagens");
//            Texto.setForeground(Color.black);
//        } else {
//            Texto.setText("Novas Mensagens");
//            Texto.setForeground(Color.red);
//
//            for (EMensagem item : list) {
//
//                Vector<String> linha = new Vector<>();
//                linha.add(item.getNome() + " Falou com você");
//                linha.add(item.getCodigo() + "");
//
//                detalhe.add(linha);
//               
//            }
//
//        }
    }
}
