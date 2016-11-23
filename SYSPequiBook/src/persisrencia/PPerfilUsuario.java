package persisrencia;

import java.beans.Statement;
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

	public void Salvar(EPerfilUsuario perfilUsuario) throws SQLException {

		Connection con = util.Conexao.getConexao();
		try {
			String sql = "INSERT INTO public.perfil_usuario("
					+ "nome, telefone, status, foto, login, id_relacionamento,"
					+ "id_status_perfil, id_acesso) VALUES (?, ?, ?, ?, ?, ?,?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, perfilUsuario.getNome());
			ps.setString(2, perfilUsuario.getTelefone());
			ps.setBytes(3, perfilUsuario.getFoto());
			ps.setInt(4, util.PEnum.CodigoStatusPerfil(perfilUsuario.getStatusPerfil()));
			ps.setString(5, perfilUsuario.getStatus());
			ps.setInt(6, perfilUsuario.getAcesso().getCodigo());
			ps.setInt(7, util.PEnum.CodigoStatusRelacionamento(perfilUsuario.getStatusRelacionamento()));
			ps.setInt(8, util.PEnum.CodigoStatusPerfil(perfilUsuario.getStatusPerfil()));

			ps.execute(sql);

		} catch (Exception e) {

			throw new SQLException(e.getMessage());
		}

	}

	public void Excluir(int codigoUsuario) throws SQLException {

		Connection con = util.Conexao.getConexao();

		String sql = "DELETE FROM public.perfil_usuario WHERE id_perfil_usuario = ?";

		Connection cnn = util.Conexao.getConexao();
		PreparedStatement prd = cnn.prepareStatement(sql);

		prd.setInt(1, codigoUsuario);

		prd.execute();

	}

	public void Editar(EPerfilUsuario perfilUsuario) throws SQLException {

		Connection con = util.Conexao.getConexao();
		String sql = "UPDATE public.perfil_usuario " + "SET id_perfil_usuario=?," + " nome=?," + " telefone=?,"
				+ " status=?, " + "foto=?, " + "login=?," + " id_relacionamento=?," + " id_status_perfil=?,"
				+ " id_acesso=?" + "WHERE id_perfil_usuario =" + perfilUsuario.getCodigo();

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, perfilUsuario.getNome());
		ps.setString(2, perfilUsuario.getTelefone());
		ps.setBytes(3, perfilUsuario.getFoto());
		ps.setInt(4, util.PEnum.CodigoStatusPerfil(perfilUsuario.getStatusPerfil()));
		ps.setString(5, perfilUsuario.getStatus());
		ps.setInt(6, perfilUsuario.getAcesso().getCodigo());
		ps.setInt(7, util.PEnum.CodigoStatusRelacionamento(perfilUsuario.getStatusRelacionamento()));
		ps.setInt(8, util.PEnum.CodigoStatusPerfil(perfilUsuario.getStatusPerfil()));

		ps.execute(sql);

	}

	public List<EPerfilUsuario> Listar(String nome) throws SQLException {

		String sql = "SELECT * FROM public.perfil_usuario where nome like '" + nome + "%'";

		Connection conn = util.Conexao.getConexao();

		Statement st = (Statement) conn.createStatement();
		ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);
		List<EPerfilUsuario> list = new ArrayList<>();

		while (rs.next()) {

			EPerfilUsuario perfilUsuario = new EPerfilUsuario();

			perfilUsuario.setCodigo(rs.getInt("id_perfil_usuario"));
			perfilUsuario.setNome(rs.getString("nome"));
			perfilUsuario.setFoto(rs.getBytes("foto"));
			perfilUsuario.setStatus(rs.getString("status"));
			StatusRelacionamento relacionamento = Enum.valueOf(StatusRelacionamento.class, rs.getString("r.descricao"));
			perfilUsuario.setStatusRelacionamento(relacionamento);
			perfilUsuario.setTelefone(rs.getString("telefone"));
			StatusPerfil perfil = Enum.valueOf(StatusPerfil.class, rs.getString("sp.descricao"));
			perfilUsuario.setStatusPerfil(perfil);
			perfilUsuario.setStatusLogin(rs.getBoolean("login"));

			list.add(perfilUsuario);

		}

		return list;

	}

	public List<EPerfilUsuario> Listar(int codigoUsuario) throws SQLException {

		String sql = "select * from perfil_usuario p inner join amizade a on a.id_perfil_usuario = p.id_perfil_usuario"
				+ "inner join status_da_solicitacao s on a.id_status_da_solicitacao = s.id_status_da_solicitacao"
				+ "where s.descricao = '"+StatusDaSolicitacao.Aceito+"'"
						+ "end p.id_perfil_usuario = "+codigoUsuario;

		Connection conn = util.Conexao.getConexao();

		Statement st = (Statement) conn.createStatement();
		ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);
		List<EPerfilUsuario> list = new ArrayList<>();

		while (rs.next()) {

			EPerfilUsuario perfilUsuario = new EPerfilUsuario();

			perfilUsuario.setCodigo(rs.getInt("id_perfil_usuario"));
			perfilUsuario.setNome(rs.getString("nome"));
			perfilUsuario.setFoto(rs.getBytes("foto"));
			perfilUsuario.setStatus(rs.getString("status"));
			StatusRelacionamento relacionamento = Enum.valueOf(StatusRelacionamento.class, rs.getString("r.descricao"));
			perfilUsuario.setStatusRelacionamento(relacionamento);
			perfilUsuario.setTelefone(rs.getString("telefone"));
			StatusPerfil perfil = Enum.valueOf(StatusPerfil.class, rs.getString("sp.descricao"));
			perfilUsuario.setStatusPerfil(perfil);
			perfilUsuario.setStatusLogin(rs.getBoolean("login"));

			list.add(perfilUsuario);

		}

		return list;

	}

	public EPerfilUsuario Consultar(EAcesso acesso) throws SQLException {
		String sql = "select * from perfil_usuario p " + "inner join acesso a on p.id_acesso = a.id_acesso "
				+ "inner join status_relacionamento r on r.id_relacionamento = p.id_relacionamento"
				+ "inner join status_perfil sp on sp.id_status_perfil = p.id_status_perfil" + " where a.email ="
				+ acesso.getEmail() + "and a.senha =" + acesso.getSenha();

		Connection conn = util.Conexao.getConexao();

		Statement st = (Statement) conn.createStatement();
		ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);

		EPerfilUsuario perfilUsuario = new EPerfilUsuario();

		while (rs.next()) {

			perfilUsuario.setCodigo(rs.getInt("id_perfil_usuario"));
			perfilUsuario.setNome(rs.getString("nome"));
			acesso.setCodigo(rs.getInt("id_acesso"));
			acesso.setEmail(rs.getString("email"));
			acesso.setSenha(rs.getString("senha"));
			perfilUsuario.setAcesso(acesso);
			perfilUsuario.setFoto(rs.getBytes("foto"));
			perfilUsuario.setStatus(rs.getString("status"));
			StatusRelacionamento relacionamento = Enum.valueOf(StatusRelacionamento.class, rs.getString("r.descricao"));
			perfilUsuario.setStatusRelacionamento(relacionamento);
			perfilUsuario.setTelefone(rs.getString("telefone"));
			StatusPerfil perfil = Enum.valueOf(StatusPerfil.class, rs.getString("sp.descricao"));
			perfilUsuario.setStatusPerfil(perfil);
			perfilUsuario.setStatusLogin(rs.getBoolean("login"));

		}

		return perfilUsuario;

	}

}
