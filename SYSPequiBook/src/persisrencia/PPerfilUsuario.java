package persisrencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import entidade.EAcesso;
import entidade.EPerfilUsuario;

public class PPerfilUsuario {

	public void Salvar(EPerfilUsuario perfilUsuario) throws SQLException {

		Connection con = util.Conexao.getConexao();
		try {
			String sql = "INSERT INTO public.perfil_usuario("
					+ "nome, telefone, status, foto, login, id_relacionamento,"
					+ "id_status_perfil, id_acesso) VALUES (?, ?, ?, ?, ?, ?,?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, perfilUsuario.getNome());
			ps.setString(2, perfilUsuario.getTelefone());
			ps.setBytes(3,perfilUsuario.getFoto());
			

		} catch (Exception e) {

			throw new SQLException(e.getMessage());
		}

	}

	public void Excluir(int codigoUsuario) {

	}

	public void Editar(EPerfilUsuario ePerfilUsuario) {

	}

	public List<EPerfilUsuario> Listar(String nome) {
		return null;
	}

	public EPerfilUsuario Consultar(EAcesso acesso) {
		String sql = "select * from perfil_usuario p inner join acesso a"
				+ " on p.id_acesso = a.id_acesso where a.email =" + acesso.getEmail() + "and a.senha ="
				+ acesso.getSenha();
		return null;
	}

}
