package negocio;

import java.util.List;

import entidade.EMensagem;
import persisrencia.PMensagem;

public class NMensagem {
	
	PMensagem _PMensagem;
	
	public NMensagem(){
		
	}

	public void EnviarMensagem(EMensagem eMensagem) throws Exception{
		
		_PMensagem = new PMensagem();
		_PMensagem.Salvar(eMensagem);
		
	}
	public List<EMensagem> ListarMensagens(int destinatario) throws Exception{
		
		_PMensagem = new PMensagem();
		return _PMensagem.Listar(NAcesso.EPerfilUsuarioLogado.getCodigo(),destinatario);
	}
	public void LerMensagem(int codigo) throws Exception{
		_PMensagem = new PMensagem();
		_PMensagem.Atualizar(codigo);
	}
}
