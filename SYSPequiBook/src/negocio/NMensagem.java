package negocio;

import java.util.List;

import entidade.EMensagem;
import persisrencia.PMensagem;

public class NMensagem {
	
	PMensagem _PMensagem = new PMensagem();

	public void EnviarMensagem(EMensagem eMensagem) throws Exception{
		
		_PMensagem.Salvar(eMensagem);
		
	}
	public List<EMensagem> ListarMensagens() throws Exception{
		
		return _PMensagem.Listar(NAcesso.EPerfilUsuarioLogado.getCodigo());
	}
	public void LerMensagem(EMensagem mensagem) throws Exception{
		_PMensagem.Atualizar(mensagem);
	}
}
