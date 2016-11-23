package persisrencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.List;

import entidade.EMensagem;

public class PMensagem {

	public void Salvar(EMensagem eMensagem) {

		try {
			String sql = "INSERT INTO public.mensagem"
					+ "(id_mensagem,"
					+ "codigo_destinatario,"
					+ "mensagem,"
					+ "visualizado,"
					+ "id_perfil_usuario)"
					+ " VALUES (?, ?, ?, ?, ?);";
			
			Connection cnn = util.Conexao.getConexao();
			PreparedStatement ps = cnn.prepareStatement(sql);
			/*
			 * private int codigo;
	private int codigoRemetente;
	private int codigoDestinatario;
	private String mensagem;
	private LocalDateTime dataHoraEnvio;
	private boolean lido;
			 */
			
			ps.setInt(1, eMensagem.getCodigoRemetente());
			ps.setInt(2, eMensagem.getCodigoDestinatario());
			ps.setString(3, eMensagem.getMensagem());
			ps.setDate(4, eMensagem.getDataHoraEnvio());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public List<EMensagem> Listar(int codigoUsuario) {
		return null;
	}
	public void Atualizar(int codigoMensagem){
		
	}
}
