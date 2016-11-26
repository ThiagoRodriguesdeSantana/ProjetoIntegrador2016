package util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidade.StatusDaSolicitacao;
import entidade.StatusLogin;
import entidade.StatusPerfil;
import entidade.StatusRelacionamento;

public class PEnum {

    public static int CodigoStatusPerfil(StatusPerfil perfil, Connection conn) throws SQLException, Exception {

        try {

            String sql = "SELECT id_status_perfil FROM public.status_perfil where descricaoPerfil = '" + perfil + "';";

            conn = util.Conexao.getConexao();

            int codigo;
            try (Statement st = conn.createStatement()) {
                ResultSet rs = st.executeQuery(sql);
                codigo = 0;
                while (rs.next()) {
                    codigo = rs.getInt("id_status_perfil");
                }
            }

            return codigo;

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }

    }

    public static int CodigoStatusRelacionamento(StatusRelacionamento perfil, Connection conn) throws SQLException, Exception {
        try {
            String sql = "SELECT id_relacionamento FROM public.status_relacionamento where descricaoRelacionamento = '" + perfil + "';";

            conn = util.Conexao.getConexao();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            int codigo = 0;
            while (rs.next()) {
                codigo = rs.getInt("id_relacionamento");
            }

            return codigo;

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }

    }

    public static int CodigoStatusLogin(StatusLogin perfil, Connection conn) throws SQLException {

        String sql = "SELECT id_status_perfil FROM public.status_perfil where descricao = '" + perfil + "';";

        conn = util.Conexao.getConexao();

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        int codigo = 0;
        while (rs.next()) {
            codigo = rs.getInt("id_status_perfil");
        }

        return codigo;

    }

    public static int CodigoStatusSolicitacao(StatusDaSolicitacao perfil, Connection conn) throws SQLException, Exception {

        try {
            String sql = "SELECT id_status_da_solicitacao  FROM public.status_da_solicitacao where descricaoSolicitacao = '" + perfil + "';";

            conn = util.Conexao.getConexao();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            int codigo = 0;
            while (rs.next()) {
                codigo = rs.getInt("id_status_da_solicitacao");
            }

            return codigo;
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }

    }

}
