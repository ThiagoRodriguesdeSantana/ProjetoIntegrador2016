package persisrencia;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.EMensagem;
import negocio.NAcesso;

public class PMensagem {

	public void Salvar(EMensagem eMensagem) throws Exception {

		try {
			String sql = "INSERT INTO public.mensagem"
					+ "(id_mensagem,"
					+ "codigo_destinatario,"
					+ "mensagem,"
					+ "visualizado,"
					+ "id_perfil_usuario)" 
					+ "nome"
					+ " VALUES (?, ?, ?, ?, ?, ?);";

			Connection cnn = util.Conexao.getConexao();
			PreparedStatement ps = cnn.prepareStatement(sql);

			ps.setInt(1, eMensagem.getCodigoRemetente());
			ps.setInt(2, eMensagem.getCodigoDestinatario());
			ps.setString(3, eMensagem.getMensagem());
			ps.setDate(4, eMensagem.getDataHoraEnvio());
			ps.setBoolean(4, eMensagem.isLido());
			ps.setString(6, eMensagem.getNome());

			ps.execute();

		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}

	}

	public List<EMensagem> Listar(int codigoUsuario) throws Exception {
		try {
			String sql = "SELECT id_mensagem, codigo_destinatario, mensagem, visualizado, id_perfil_usuario "
					+ "FROM public.mensagem" + "where codigo_destinatario = " + NAcesso.EPerfilUsuarioLogado.getCodigo()
					+ " and id_perfil_usuario =  " + NAcesso.EPerfilUsuarioLogado.getCodigo() + "and visualizado = "
					+ false;
			Connection conn = util.Conexao.getConexao();

			Statement st = (Statement) conn.createStatement();
			ResultSet rs = ((java.sql.Statement) st).executeQuery(sql);
			List<EMensagem> list = new ArrayList<>();

			while(rs.next()){
				EMensagem mensagem = new EMensagem();
				
				mensagem.setCodigo(rs.getInt("id_mensagem"));
				mensagem.setCodigoDestinatario(rs.getInt("codigo_destinatario"));
				mensagem.setMensagem(rs.getString("mensagem"));
				mensagem.setLido(rs.getBoolean("visualizado"));
				mensagem.setCodigoRemetente(rs.getInt("id_perfil_usuario"));
				mensagem.setNome(rs.getString("nome"));
				
				list.add(mensagem);
				
			}
			
			return list;
			
		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
	}

	public void Atualizar(EMensagem mensagem) throws Exception {
		
		try {
			String sql = "UPDATE public.mensagem SET"
					+ "codigo_destinatario=?,"
					+ "mensagem=?,"
					+ "visualizado=?,"
					+ "id_perfil_usuario=?"
					+ "WHERE id_mensagem = "+mensagem.getCodigo();
			
			Connection cnn = util.Conexao.getConexao();
			PreparedStatement ps = cnn.prepareStatement(sql);

			
			ps.setInt(1, mensagem.getCodigoDestinatario());
			ps.setString(2, mensagem.getMensagem());
			ps.setBoolean(3, mensagem.isLido());
			ps.setInt(4, mensagem.getCodigoRemetente());
			ps.setDate(5, mensagem.getDataHoraEnvio());
			

			ps.execute();
			
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
		}
		

	}
}
