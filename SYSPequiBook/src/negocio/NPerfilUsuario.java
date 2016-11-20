package negocio;


import java.time.LocalDateTime;
import java.util.List;

import entidade.EAcesso;
import entidade.EAmizade;
import entidade.EMensagem;
import entidade.EPerfilUsuario;
import entidade.EPostagem;
import persisrencia.PPerfilUsuario;

public class NPerfilUsuario {

	private PPerfilUsuario _PPerfilUsuario = new PPerfilUsuario();
	private NAmizade  _NAmizade  = new NAmizade();
	private NPostagem _NPostagem = new NPostagem();
	private NMensagem _NMensagem = new NMensagem();
	
	public void SalvarPerfil(EPerfilUsuario ePerfilUsuario) throws Exception{
		
		if(ePerfilUsuario.getAcesso().getEmail().equals(null)){
			throw new Exception("É necessário cadastrar um email!");
		}
		if(ePerfilUsuario.getAcesso().getSenha().equals(null)){
			throw new Exception("É necessário cadastrar uma senha!");
		}
		if(ePerfilUsuario.getNome().equals(null)){
			throw new Exception("É necessário cadastrar um nome ou apelido!");
		}
		
		_PPerfilUsuario.Salvar(ePerfilUsuario);
		
	}
	public void EditarPerfil(EPerfilUsuario ePerfilUsuario){
		
		if(ePerfilUsuario.equals(NAcesso.EPerfilUsuarioLogado)){
			
			_PPerfilUsuario.Editar(ePerfilUsuario);
		}
		
	}
	public List<EPerfilUsuario> ListarAmigos(){
		
		return _NAmizade.ListarAmigos(NAcesso.EPerfilUsuarioLogado.getCodigo());
		
	}
	public List<EPerfilUsuario> ListarUsuarios(String nome){
		
		return _PPerfilUsuario.Listar(nome);
	}
	public void DesfazerAmizade(EAmizade amizade){
		
		_NAmizade.DesfazerAmizade(amizade.getCodigo());
		
	}
	public void ExcluirConta(){
		
		_PPerfilUsuario.Excluir(NAcesso.EPerfilUsuarioLogado.getCodigo());
		
		
	}
	public EPerfilUsuario ConsultarUsuario(EAcesso acesso){
		
		return _PPerfilUsuario.Consultar(acesso);
	}
	
	public void PostarConteudo(EPostagem ePostagem){
		
		_NPostagem.Postar(ePostagem);
		
	}
	public void SolicitarAmizade(EAmizade amizade){
		
		_NAmizade.SolicitarAmizade(amizade);
		
	}
	public List<EPerfilUsuario> ReceberSolicitacaoDeAmizade(EAmizade amizade){
		
		return _NAmizade.ListarSolicitacoes();
		
	}
	public void ResponderSolicitacao(EAmizade amizade){
		
		_NAmizade.AtualizarAmizade(amizade);
	}
	public void EnviarMensagem(EMensagem mensagem){
		
		_NMensagem.EnviarMensagem(mensagem);
		
	}
	public List<EMensagem> ReceberMensagem(int codigoUsuario){
		
		return _NMensagem.ListarMensagens(codigoUsuario);
	}
	public void LerMensagem(EMensagem mensagem){
		_NMensagem.LerMensagem(mensagem.getCodigo());
	}
	
	public List<EPostagem> ListarPostagem(int codigoUsuario, LocalDateTime inicio, LocalDateTime fim){
		
		return _NPostagem.ListarPostagem(codigoUsuario, inicio, fim);
	}
	
	
	
	
}
