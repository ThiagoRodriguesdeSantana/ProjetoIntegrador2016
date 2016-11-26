package persisrencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidade.EAcesso;
import entidade.EPerfilUsuario;

public class PAcesso {

    public void Salvar(EPerfilUsuario perfilUsuario) throws SQLException {

        Connection con = util.Conexao.getConexao();

        con.setAutoCommit(false);
        try {
            String sql = "INSERT INTO public.acesso(email,senha)VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, perfilUsuario.getAcesso().getEmail());
            ps.setString(2, perfilUsuario.getAcesso().getSenha());

            ps.execute();

            String sql2 = "SELECT currval('acesso_id_acesso_seq') as codigo";

            Statement st = con.createStatement();
            try (ResultSet rs = st.executeQuery(sql2)) {
                if (rs.next()) {
                    int idAcesso = rs.getInt("codigo");
                    perfilUsuario.getAcesso().setCodigo(idAcesso);
                    
                }
            }

            PPerfilUsuario _PerfilUsuario = new PPerfilUsuario();
            _PerfilUsuario.Salvar(perfilUsuario, con);

            con.commit();

        } catch (Exception e) {

            con.rollback();

            System.out.println(e.getMessage());
        }
        con.close();

    }

    public void Deletar(EPerfilUsuario perfilUsuario) throws SQLException {
        Connection con = util.Conexao.getConexao();

        con.setAutoCommit(false);
        try {

            PPerfilUsuario _PerfilUsuario = new PPerfilUsuario();
            _PerfilUsuario.Excluir(perfilUsuario.getCodigo(), con);

            String sql = "DELETE FROM public.acesso WHERE email = ?";

            Connection cnn = util.Conexao.getConexao();
            PreparedStatement prd = cnn.prepareStatement(sql);

            prd.setString(1, perfilUsuario.getAcesso().getEmail());

            prd.execute();

            con.commit();

            con.close();

        } catch (Exception e) {

            con.rollback();
        }

    }

    public EPerfilUsuario Cansultar(EAcesso acesso) throws SQLException {
        PPerfilUsuario perfilUsuario = new PPerfilUsuario();
        return perfilUsuario.Consultar(acesso);

    }

    public void Atualizar(EPerfilUsuario perfilUsuario) throws SQLException {

        Connection con = util.Conexao.getConexao();

        con.setAutoCommit(false);
        try {
            String sql = "UPDATE public.acesso"
                    + " SET id_acesso=?,"
                    + " senha=?,"
                    + " email=?"
                    + " WHERE email=" + perfilUsuario.getAcesso().getEmail();

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, perfilUsuario.getCodigo());
            ps.setString(2, perfilUsuario.getAcesso().getSenha());
            ps.setString(3, perfilUsuario.getAcesso().getEmail());

            ps.execute();

            PPerfilUsuario _PerfilUsuario = new PPerfilUsuario();
            _PerfilUsuario.Editar(perfilUsuario, con);

            con.commit();

        } catch (Exception e) {
            con.rollback();
        }

    }
}
