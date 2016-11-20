package negocio;

import java.util.List;

import entidade.EAmizade;
import entidade.EPerfilUsuario;
import persisrencia.PAmizade;


public class NAmizade {

	private PAmizade _PAmizade = new PAmizade();
	public void SolicitarAmizade(EAmizade amizade){
		
		_PAmizade.Inserir(amizade);
		
	}
	public void AtualizarAmizade(EAmizade amizade){
		_PAmizade.Altualizar(amizade);
	}
	public void DesfazerAmizade(int codigoAmizade){
		_PAmizade.Deletar(codigoAmizade);
	}
	public List<EPerfilUsuario> ListarAmigos(int codigoUsuario){
		
		return _PAmizade.Listar(codigoUsuario);
		
	}
    public List<EPerfilUsuario> ListarSolicitacoes(){
		
		return _PAmizade.ListarSolicitaco(NAcesso.EPerfilUsuarioLogado.getCodigo());
		
	}
	
}
