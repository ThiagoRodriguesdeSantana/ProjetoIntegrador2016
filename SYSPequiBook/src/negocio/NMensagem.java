package negocio;

import java.util.List;

import entidade.EMensagem;
import persisrencia.PMensagem;

public class NMensagem {
	
	PMensagem _PMensagem = new PMensagem();

	public void EnviarMensagem(EMensagem eMensagem){
		
		_PMensagem.Salvar(eMensagem);
		
	}
	public List<EMensagem> ListarMensagens(int codigoUsuario){
		
		return _PMensagem.Listar(codigoUsuario);
	}
}
