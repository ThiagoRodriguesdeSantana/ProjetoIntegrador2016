package negocio;


import java.util.List;

import entidade.EAcesso;
import entidade.EAmizade;
import entidade.EMensagem;
import entidade.EPerfilUsuario;
import entidade.EPostagem;

public class NPerfilUsuario {

	public void SalvarPerfil(EPerfilUsuario ePerfilUsuario){
		
	}
	public void EditarPerfil(EPerfilUsuario ePerfilUsuario){
		
	}
	public List<EPerfilUsuario> ListarAmigos(int codigoUsuario){
		return null;
		
	}
	public List<EPerfilUsuario> ListarUsuarios(String nome){
		return null;
		
	}
	public void DesfazerAmizade(EAmizade amizade){
		
	}
	public void ExcluirConta(int codigo){
		
	}
	public EPerfilUsuario ConsultarUsuario(EAcesso acesso){
		
	
		return null;
	}
	
	public void PostarConteudo(EPostagem ePstagem){
		
	}
	public void SolicitarAmizade(EAmizade amizade){
		
	}
	public EAmizade ReceberSolicitacaoDeAmizade(EAmizade amizade){
		return null;
	}
	public void ResponderSolicitacao(EAmizade amizade){
		
	}
	public void EnviarMensagem(EMensagem mensagem){
		
	}
	public EMensagem ReceberMensagem(int codigoUsuario){
		return null;
	}
	public void LerMensagem(EMensagem mensagem){
		
	}
	
	public List<EPostagem> ListarPostagem(int codigoUsuario){
		return null;
	}
	
	
	
	
}
