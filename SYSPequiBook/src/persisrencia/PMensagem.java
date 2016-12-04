package persisrencia;

import java.sql.Statement;
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
                                + "( codigo_destinatario,"
                                + " mensagem,"
                                + " visualizado,"
                                + " id_perfil_usuario)"
                                + " VALUES (?, ?, ?, ?)";

			Connection cnn = util.Conexao.getConexao();
			PreparedStatement ps = cnn.prepareStatement(sql);

			
			ps.setInt(1, eMensagem.getCodigoDestinatario());
                        ps.setString(2, eMensagem.getMensagem());
                        ps.setBoolean(3, eMensagem.isLido());
                        ps.setInt(4, eMensagem.getCodigoRemetente());
			

			ps.execute();

		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}

	}

	public List<EMensagem> Listar(int codigoUsuario, int destinatario) throws Exception {
		try {
			String sql = "select p.nome,* from mensagem as m"
                                + " inner join perfil_usuario as p "
                                + " on m.id_perfil_usuario = p.id_perfil_usuario"
                                + " where codigo_destinatario = "+destinatario
                                + " and   m.id_perfil_usuario = "+codigoUsuario
                                + " and \"visualizado\" = 'false'"
                                + " or codigo_destinatario = "+codigoUsuario
                                + " and   m.id_perfil_usuario = "+destinatario;
			Connection conn = util.Conexao.getConexao();

			Statement st = conn.createStatement();
			ResultSet rs =  st.executeQuery(sql);
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

	public void Atualizar(int  codigoRemetente) throws Exception {
		
		try {
			String sql = "UPDATE public.mensagem"
                                + " SET visualizado= 'true'"
                                + " where id_perfil_usuario = "+codigoRemetente
                                + " and codigo_destinatario = "+NAcesso.EPerfilUsuarioLogado.getCodigo()
                                + " and visualizado = false ";
			
			Connection cnn = util.Conexao.getConexao();
			PreparedStatement ps = cnn.prepareStatement(sql);


			ps.execute();
			
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
		}
		

	}
        public List<EMensagem> ListarMensagens() throws Exception {
		try {
			String sql = "select p.nome,m.id_perfil_usuario from mensagem as m"
                                + " inner join perfil_usuario as p "
                                + " on m.id_perfil_usuario = p.id_perfil_usuario"
                                + " where codigo_destinatario = "+NAcesso.EPerfilUsuarioLogado.getCodigo()
                                + " and \"visualizado\" = 'false'";
			Connection conn = util.Conexao.getConexao();

			Statement st = conn.createStatement();
			ResultSet rs =  st.executeQuery(sql);
			List<EMensagem> list = new ArrayList<>();

			while(rs.next()){
				EMensagem mensagem = new EMensagem();
				
				mensagem.setCodigoRemetente(rs.getInt("id_perfil_usuario"));
				mensagem.setNome(rs.getString("nome"));
				
				list.add(mensagem);
				
			}
			
			return list;
			
		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
	}
}
