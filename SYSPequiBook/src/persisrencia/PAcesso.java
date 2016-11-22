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
			
			if(rs.next()){
				perfilUsuario.getAcesso().setCodigo(rs.getInt("codigo"));
			}
			rs.close();
			
			PPerfilUsuario ppPerfilUsuario = new PPerfilUsuario();
			ppPerfilUsuario.Salvar(perfilUsuario);
			
			con.commit();
			
			

		} catch (Exception e) {

			con.rollback();
		}
		con.close();

	}

	public void Deletar(int codigoUsuario) {

	}

	public EPerfilUsuario Cansultar(EAcesso acesso) {
		PPerfilUsuario perfilUsuario = new PPerfilUsuario();
		return perfilUsuario.Consultar(acesso);

	}

	public void Atualizar(int codigoUsuario) {

	}
}
