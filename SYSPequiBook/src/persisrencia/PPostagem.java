package persisrencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import entidade.EPostagem;

public class PPostagem {

	public void Salvar(EPostagem ePostagem) throws SQLException {
		String sql = "INSERT INTO postagem(data_postagem, mensagem, imagens, id_perfil_usuario)"
				+ "VALUES(?,?,?,?)";
		
		Connection cnn = util.Conexao.getConexao();
		
		try(PreparedStatement prd = cnn.prepareStatement(sql)){
			prd.setDate(1, ePostagem.getData());
			prd.setString(2, ePostagem.getMensagem());
			prd.setBytes(3, ePostagem.getImagem());
			prd.setInt(4, ePostagem.getUsuario().getCodigo());
			
			prd.execute();
			prd.close();
		}
	
		
		
	}

	public void Excluir(int codigoPostagem) throws SQLException {
		String sql = "DELETE FROM postagem WHERE id_postagem = ?";
		
		Connection cnn = util.Conexao.getConexao();
		PreparedStatement prd = cnn.prepareStatement(sql);
		
		prd.setInt(1, codigoPostagem);
	}

	public List<EPostagem> Listar(int codigoUsuario) throws SQLException {
		List<EPostagem> lista = new ArrayList<>();
		
		Connection cnn = util.Conexao.getConexao();
		
		String sql = "SELECT u.nome, p. * FROm postagem p INNER JOIN perfil_usuario u "
				+ "on p.id_perfil_usuario = u.id_perfil_usuario INNER JOIN amizade a "
				+ "on p.id_perfil_usuario = a.codigo_do_amigo INNER JOIN status_da_solicitacao s "
				+ "on a.id_status_da_solicitacao = s.id_status_da_solicitacao "
				+ "WHERE s.descricao = 'aceito' AND a.codigo_do_amigo = "+ codigoUsuario+ "OR a.id_perfil_usuario = "+codigoUsuario;


		
		PreparedStatement prd = cnn.prepareStatement(sql);
		ResultSet rs = prd.executeQuery();
		
		while(rs.next()){
			EPostagem postagem = new EPostagem();
			
			postagem.setCodigo(rs.getInt("id_postagem"));
			postagem.setImagem(rs.getBytes("imagens"));
			postagem.setMensagem(rs.getString("mensagem"));
			postagem.setData(rs.getDate("data_postagem"));
			
						
		}
		
		
		return lista;
	}

	public void Atualizar(EPostagem ePostagem) {

	}

}
