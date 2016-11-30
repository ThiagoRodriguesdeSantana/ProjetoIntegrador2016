package persisrencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import entidade.EAmizade;
import entidade.EPerfilUsuario;
import entidade.StatusDaSolicitacao;
import java.sql.ResultSet;
import java.sql.Statement;
import negocio.NAcesso;

public class PAmizade {

    public void Inserir(EAmizade amizade) throws SQLException, Exception {

        String sql = "INSERT INTO public.amizade" + "(codigo_do_amigo, id_perfil_usuario, id_status_da_solicitacao)"
                + "VALUES (?, ?, ?)";

        Connection con = util.Conexao.getConexao();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, amizade.getAmigo());
        ps.setInt(2, NAcesso.EPerfilUsuarioLogado.getCodigo());
        ps.setInt(3, util.PEnum.CodigoStatusSolicitacao(amizade.getDaSolicitacao(), con));

        ps.execute();

    }

    public void Altualizar(EAmizade amizade) throws SQLException, Exception {

        String sql = "UPDATE public.amizade SET "
                + " codigo_do_amigo=?,"
                + " id_perfil_usuario=?, "
                + "id_status_da_solicitacao=?"
                + "WHERE id_perfil_usuario = " + amizade.getCodigoUsiario()
                + "and codigo_do_amigo =  "+amizade.getAmigo();

        Connection con = util.Conexao.getConexao();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, amizade.getAmigo());
        ps.setInt(2, amizade.getCodigoUsiario());
        ps.setInt(3, util.PEnum.CodigoStatusSolicitacao(amizade.getDaSolicitacao(), con));

        ps.execute();

    }

    public List<EPerfilUsuario> Listar(int codigoUsuario) throws SQLException {

        PPerfilUsuario perfilUsuario = new PPerfilUsuario();
        return perfilUsuario.Listar(codigoUsuario);

    }

    public List<EPerfilUsuario> ListarSolicitaco(int codigoUsuario) throws SQLException {
        PPerfilUsuario perfilUsuario = new PPerfilUsuario();
        return perfilUsuario.ListarSolicitacao(codigoUsuario);
    }

    public void Deletar(int codigoAmigo) throws Exception {

        try {

            String sql = "DELETE FROM public.amizade WHERE codigo_do_amigo = " + codigoAmigo;

            Connection cnn = util.Conexao.getConexao();
            PreparedStatement prd = cnn.prepareStatement(sql);

            prd.execute();

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }

    }

    public int ConsultarAmizade(int codigoDoAmigo) throws SQLException {

        String sql = " SELECT *  FROM public.amizade "
                + " where codigo_do_amigo = " + codigoDoAmigo
                + " and id_perfil_usuario =  " + NAcesso.EPerfilUsuarioLogado.getCodigo()
                + " and id_status_da_solicitacao = " + StatusDaSolicitacao.Aceito.ordinal() + 1;
        
        Connection conn = util.Conexao.getConexao();

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        int codigoAmizade = 0;
        while (rs.next()) {

            codigoAmizade = codigoDoAmigo;

        }

        return codigoAmizade;

    }

}
