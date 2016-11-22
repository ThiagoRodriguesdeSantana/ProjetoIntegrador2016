package util;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidade.StatusLogin;
import entidade.StatusPerfil;
import entidade.StatusRelacionamento;

public class PEnum {

	public static int CodigoStatusPerfil(StatusPerfil perfil) throws SQLException {

		String sql = "SELECT id_status_perfil FROM public.status_perfil where descricao = '" + perfil + "';";

		Connection conn = util.Conexao.getConexao();

		Statement st = (Statement) conn.createStatement();
		ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);

		int codigo = 0;
		while (rs.next()) {
			codigo = rs.getInt("id_status_perfil");
		}
		conn.close();
		return codigo;

	}

	public static int CodigoStatusRelacionamento(StatusRelacionamento perfil) throws SQLException {

		String sql = "SELECT id_relacionamento FROM public.status_relacionamento where descricao = '" + perfil + "';";

		Connection conn = util.Conexao.getConexao();

		Statement st = (Statement) conn.createStatement();
		ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);

		int codigo = 0;
		while (rs.next()) {
			codigo = rs.getInt("id_relacionamento");
		}
		conn.close();
		return codigo;

	}

	public static int CodigoStatusLogin(StatusLogin perfil) throws SQLException {

		String sql = "SELECT id_status_perfil FROM public.status_perfil where descricao = '" + perfil + "';";

		Connection conn = util.Conexao.getConexao();

		Statement st = (Statement) conn.createStatement();
		ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);

		int codigo = 0;
		while (rs.next()) {
			codigo = rs.getInt("id_status_perfil");
		}
		conn.close();
		return codigo;

	}

}
