package persisrencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import entidade.EAmizade;
import entidade.EPerfilUsuario;
import entidade.StatusDaSolicitacao;
import negocio.NAcesso;

public class PAmizade {

	public void Inserir(EAmizade amizade) throws SQLException {

		String sql = "INSERT INTO public.amizade" + "(codigo_do_amigo, id_perfil_usuario, id_status_da_solicitacao)"
				+ "VALUES (?, ?, ?)";
		
		Connection con = util.Conexao.getConexao();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, amizade.getCodigo());
		ps.setInt(2, NAcesso.EPerfilUsuarioLogado.getCodigo());
		ps.setInt(3, util.PEnum.CodigoStatusSolicitacao(amizade.getDaSolicitacao()));
		
		ps.execute();

	}

	public void Altualizar(EAmizade amizade) throws SQLException {

		String sql = "UPDATE public.amizade SET "
				+ "id_amizade=?,"
				+ " codigo_do_amigo=?,"
				+ " id_perfil_usuario=?, "
				+ "id_status_da_solicitacao=?"
				+ "WHERE id_amizade = "+amizade.getCodigo();
		
		Connection con = util.Conexao.getConexao();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, amizade.getCodigo());
		ps.setInt(2, amizade.getCodigo());
		ps.setInt(3, NAcesso.EPerfilUsuarioLogado.getCodigo());
		ps.setInt(4, util.PEnum.CodigoStatusSolicitacao(amizade.getDaSolicitacao()));
		
		ps.execute();
		
	}

	public List<EPerfilUsuario> Listar(int codigoUsuario) throws SQLException {
		
		PPerfilUsuario perfilUsuario = new PPerfilUsuario();
		return perfilUsuario.Listar(codigoUsuario);
		
	}

	public List<EPerfilUsuario> ListarSolicitaco(int codigoUsuario) {
		return null;
	}

	public void Deletar(int codigoAmizade) {

	}

}
