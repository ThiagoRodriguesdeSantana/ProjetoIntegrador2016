package persisrencia;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Period;

import entidade.EAcesso;
import entidade.EPerfilUsuario;

public class PAcesso {

	private PPerfilUsuario _PerfilUsuario = new PPerfilUsuario();
	
	public void Salvar(EPerfilUsuario perfilUsuario) throws SQLException {

		Connection con = util.Conexao.getConexao();

		con.setAutoCommit(false);
		try {
			String sql = "INSERT INTO public.acesso(senha, email)VALUES (?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, perfilUsuario.getAcesso().getEmail());
			ps.setString(2, perfilUsuario.getAcesso().getSenha());
			ps.execute();

			String sql2 = "SELECT currval('codigo_acesso_seq') as codigo";
			Statement st = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) st).executeQuery(sql2);

			if (rs.next()) {
				perfilUsuario.getAcesso().setCodigo(rs.getInt("codigo"));
			}
			rs.close();

			
			_PerfilUsuario.Salvar(perfilUsuario);

			con.commit();

		} catch (Exception e) {

			con.rollback();
		}
		con.close();

	}

	public void Deletar(EPerfilUsuario perfilUsuario) throws SQLException {
		Connection con = util.Conexao.getConexao();

		con.setAutoCommit(false);
		try {
			
			_PerfilUsuario.Excluir(perfilUsuario.getCodigo());
			
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
					+ " WHERE email="+ perfilUsuario.getAcesso().getEmail();

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, perfilUsuario.getCodigo());
			ps.setString(2, perfilUsuario.getAcesso().getSenha());
			ps.setString(3, perfilUsuario.getAcesso().getEmail());
			
			ps.execute();

			_PerfilUsuario.Editar(perfilUsuario);

			con.commit();

		}
		catch (Exception e) {
			con.rollback();
		}
	
	}
}
