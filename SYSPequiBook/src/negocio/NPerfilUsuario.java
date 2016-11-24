package negocio;


import java.sql.SQLException;
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
	private NAcesso   _NAcesso   = new NAcesso(); 
	
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
		
		_NAcesso.Salvar(ePerfilUsuario);
		
	}
	public void EditarPerfil(EPerfilUsuario ePerfilUsuario) throws SQLException{
		
		
			_NAcesso.EditarPerfil(ePerfilUsuario);
		
		
	}
	public List<EPerfilUsuario> ListarAmigos() throws SQLException{
		
		return _NAmizade.ListarAmigos(NAcesso.EPerfilUsuarioLogado.getCodigo());
		
	}
	public List<EPerfilUsuario> ListarUsuarios(String nome) throws SQLException{
		
		return _PPerfilUsuario.Listar(nome);
	}
	public void DesfazerAmizade(EAmizade amizade) throws Exception{
		
		_NAmizade.DesfazerAmizade(amizade.getCodigo());
		
	}
	public void ExcluirConta() throws SQLException{
		
		_NAcesso.Excluir();
		
		
	}
	public EPerfilUsuario ConsultarUsuario(EAcesso acesso) throws SQLException{
		
		return _PPerfilUsuario.Consultar(acesso);
	}
	
	public void PostarConteudo(EPostagem ePostagem) throws SQLException{
		
		_NPostagem.Postar(ePostagem);
		
	}
	public void SolicitarAmizade(EAmizade amizade) throws SQLException{
		
		_NAmizade.SolicitarAmizade(amizade);
		
	}
	public List<EPerfilUsuario> ReceberSolicitacaoDeAmizade(EAmizade amizade) throws SQLException{
		
		return _NAmizade.ListarSolicitacoes();
		
	}
	public void ResponderSolicitacao(EAmizade amizade) throws SQLException{
		
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
	
	public List<EPostagem> ListarPostagem(int codigoUsuario) throws SQLException{
		
		return _NPostagem.ListarPostagem(codigoUsuario);
	}
	
	
	
	
}
