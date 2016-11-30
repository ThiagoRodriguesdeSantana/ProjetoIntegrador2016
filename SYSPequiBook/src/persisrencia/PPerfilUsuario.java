package persisrencia;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.EAcesso;
import entidade.EPerfilUsuario;
import entidade.StatusDaSolicitacao;
import entidade.StatusPerfil;
import entidade.StatusRelacionamento;

public class PPerfilUsuario {

    public void Salvar(EPerfilUsuario perfilUsuario, Connection con) throws SQLException {

        try {
            String sql = "INSERT INTO public.perfil_usuario"
                    + "( nome,"
                    + " telefone,"
                    + " status,"
                    + " foto,"
                    + " id_relacionamento,"
                    + " id_status_perfil,"
                    + " id_acesso,"
                    + " \"StatusLogin\")"
                    + "VALUES (?, ?, ?, ?, ?,?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, perfilUsuario.getNome());
            ps.setString(2, perfilUsuario.getTelefone());
            ps.setString(3, perfilUsuario.getStatus());
            ps.setBytes(4, perfilUsuario.getFoto());
            ps.setInt(5, util.PEnum.CodigoStatusRelacionamento(perfilUsuario.getStatusRelacionamento(), con));
            ps.setInt(6, util.PEnum.CodigoStatusPerfil(perfilUsuario.getStatusPerfil(), con));
            ps.setInt(7, perfilUsuario.getAcesso().getCodigo());
            ps.setBoolean(8, perfilUsuario.getStatusLogin());

            ps.execute();

        } catch (Exception e) {

            //throw new SQLException(e.getMessage());
            e.printStackTrace();
        }

    }

    public void Excluir(int codigoUsuario, Connection con) throws SQLException {

        String sql = "DELETE FROM public.perfil_usuario WHERE id_perfil_usuario = ?";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, codigoUsuario);

        prd.execute();

    }

    public void Editar(EPerfilUsuario perfilUsuario, Connection con) throws SQLException, Exception {

        String sql = "UPDATE public.perfil_usuario\n"
                + " SET nome=?,"
                + " telefone=?,"
                + " status=?,"
                + " foto=?,"
                + " id_relacionamento=?,"
                + " id_status_perfil=?,"
                + " id_acesso=?,"
                + " \"StatusLogin\"=?  WHERE id_perfil_usuario =" + perfilUsuario.getCodigo();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, perfilUsuario.getNome());
        ps.setString(2, perfilUsuario.getTelefone());
        ps.setString(3, perfilUsuario.getStatus());
        ps.setBytes(4, perfilUsuario.getFoto());
        ps.setInt(5, util.PEnum.CodigoStatusRelacionamento(perfilUsuario.getStatusRelacionamento(), con));
        ps.setInt(6, util.PEnum.CodigoStatusPerfil(perfilUsuario.getStatusPerfil(), con));
        ps.setInt(7, perfilUsuario.getAcesso().getCodigo());
        ps.setBoolean(8, perfilUsuario.getStatusLogin());

        ps.execute();

    }

    public List<EPerfilUsuario> Listar(String nome) throws SQLException {

        String sql = "SELECT * FROM public.perfil_usuario where nome like '" + nome + "%'";

        Connection conn = util.Conexao.getConexao();

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<EPerfilUsuario> list = new ArrayList<>();

        while (rs.next()) {

            EPerfilUsuario perfilUsuario = new EPerfilUsuario();

            perfilUsuario.setCodigo(rs.getInt("id_perfil_usuario"));
            perfilUsuario.setNome(rs.getString("nome"));
            perfilUsuario.setFoto(rs.getBytes("foto"));
            perfilUsuario.setStatus(rs.getString("status"));
            perfilUsuario.setIdStatusPerfil(rs.getInt("id_relacionamento"));
            perfilUsuario.setTelefone(rs.getString("telefone"));
            perfilUsuario.setIdStatusPerfil(rs.getInt("id_status_perfil"));
            perfilUsuario.setStatusLogin(rs.getBoolean("StatusLogin"));

            list.add(perfilUsuario);

        }

        return list;

    }

    public List<EPerfilUsuario> Listar(int codigoUsuario) throws SQLException {

        String sql = "select * from perfil_usuario p inner join amizade a on a.id_perfil_usuario = p.id_perfil_usuario"
                + "inner join status_da_solicitacao s on a.id_status_da_solicitacao = s.id_status_da_solicitacao"
                + "where s.descricao = '" + StatusDaSolicitacao.Aceito + "'" + "end p.id_perfil_usuario = "
                + codigoUsuario;

        Connection conn = util.Conexao.getConexao();

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<EPerfilUsuario> list = new ArrayList<>();

        while (rs.next()) {

            EPerfilUsuario perfilUsuario = new EPerfilUsuario();

             perfilUsuario.setCodigo(rs.getInt("id_perfil_usuario"));
            perfilUsuario.setNome(rs.getString("nome"));
            perfilUsuario.setFoto(rs.getBytes("foto"));
            perfilUsuario.setStatus(rs.getString("status"));
            perfilUsuario.setIdStatusPerfil(rs.getInt("id_relacionamento"));
            perfilUsuario.setTelefone(rs.getString("telefone"));
            perfilUsuario.setIdStatusPerfil(rs.getInt("id_status_perfil"));
            perfilUsuario.setStatusLogin(rs.getBoolean("StatusLogin"));

            list.add(perfilUsuario);

        }

        return list;

    }

    public List<EPerfilUsuario> ListarSolicitacao(int codigoUsuario) throws SQLException {

        String sql = "select * from perfil_usuario p "
                + " inner join amizade a "
                + " on a.id_perfil_usuario = p.id_perfil_usuario "
                + " inner join status_da_solicitacao s "
                + " on a.id_status_da_solicitacao = s.id_status_da_solicitacao"
                + " where s.\"descricaoSolicitacao\" = '" + StatusDaSolicitacao.Enviado + "' and a.codigo_do_amigo = " + codigoUsuario;

        Connection conn = util.Conexao.getConexao();

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        List<EPerfilUsuario> list = new ArrayList<>();

        while (rs.next()) {

            EPerfilUsuario perfilUsuario = new EPerfilUsuario();

            perfilUsuario.setCodigo(rs.getInt("id_perfil_usuario"));
            perfilUsuario.setNome(rs.getString("nome"));
            perfilUsuario.setFoto(rs.getBytes("foto"));
            perfilUsuario.setStatus(rs.getString("status"));
            perfilUsuario.setIdStatusPerfil(rs.getInt("id_relacionamento"));
            perfilUsuario.setTelefone(rs.getString("telefone"));
            perfilUsuario.setIdStatusPerfil(rs.getInt("id_status_perfil"));
            perfilUsuario.setStatusLogin(rs.getBoolean("StatusLogin"));

            list.add(perfilUsuario);

        }

        return list;

    }

    public EPerfilUsuario Consultar(EAcesso acesso) throws SQLException {
        String sql = "select * from perfil_usuario p inner join acesso a on p.id_acesso = a.id_acesso"
                + " inner join status_relacionamento r on r.id_relacionamento = p.id_relacionamento "
                + " inner join status_perfil sp on sp.id_status_perfil = p.id_status_perfil"
                + " where email = '" + acesso.getEmail() + "' and senha ='" + acesso.getSenha() + "'";

        Connection conn = util.Conexao.getConexao();

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        EPerfilUsuario perfilUsuario = new EPerfilUsuario();
        while (rs.next()) {

            perfilUsuario.setCodigo(rs.getInt("id_perfil_usuario"));
            perfilUsuario.setNome(rs.getString("nome"));
            perfilUsuario.setFoto(rs.getBytes("foto"));
            perfilUsuario.setAcesso(acesso);
            perfilUsuario.setStatus(rs.getString("status"));
            perfilUsuario.setIdStatusPerfil(rs.getInt("id_relacionamento"));
            perfilUsuario.setTelefone(rs.getString("telefone"));
            perfilUsuario.setIdStatusPerfil(rs.getInt("id_status_perfil"));
            perfilUsuario.setStatusLogin(rs.getBoolean("StatusLogin"));

        }

        return perfilUsuario;

    }

    public List<EPerfilUsuario> ListarAmigosOnLine(int codigoUsuario) throws SQLException {

        String sql = "select * from amizade a  left join perfil_usuario p"
                + " on a.id_perfil_usuario = p.id_perfil_usuario"
                + " where codigo_do_amigo = " + codigoUsuario
                + " and \"StatusLogin\" = 't'";

        Connection conn = util.Conexao.getConexao();

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<EPerfilUsuario> list = new ArrayList<>();

        while (rs.next()) {

            EPerfilUsuario perfilUsuario = new EPerfilUsuario();

            perfilUsuario.setCodigo(rs.getInt("id_perfil_usuario"));
            perfilUsuario.setNome(rs.getString("nome"));
            perfilUsuario.setFoto(rs.getBytes("foto"));
            perfilUsuario.setStatus(rs.getString("status"));
            perfilUsuario.setIdStatusPerfil(rs.getInt("id_relacionamento"));
            perfilUsuario.setTelefone(rs.getString("telefone"));
            perfilUsuario.setIdStatusPerfil(rs.getInt("id_status_perfil"));
            perfilUsuario.setStatusLogin(rs.getBoolean("StatusLogin"));

            list.add(perfilUsuario);

        }

        return list;

    }
     public EPerfilUsuario Consultar(int codigo) throws SQLException {
        String sql = "select * from perfil_usuario where id_perfil_usuario = "+codigo;

        Connection conn = util.Conexao.getConexao();

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        EPerfilUsuario perfilUsuario = new EPerfilUsuario();
        while (rs.next()) {

            perfilUsuario.setCodigo(rs.getInt("id_perfil_usuario"));
            perfilUsuario.setNome(rs.getString("nome"));
            perfilUsuario.setFoto(rs.getBytes("foto"));
            perfilUsuario.setStatus(rs.getString("status"));
            perfilUsuario.setIdStatusPerfil(rs.getInt("id_relacionamento"));
            perfilUsuario.setTelefone(rs.getString("telefone"));
            perfilUsuario.setIdStatusPerfil(rs.getInt("id_status_perfil"));
            perfilUsuario.setStatusLogin(rs.getBoolean("StatusLogin"));

        }

        return perfilUsuario;

    }
     

}
