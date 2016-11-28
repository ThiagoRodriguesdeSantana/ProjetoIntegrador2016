package negocio;

import java.sql.SQLException;
import java.util.List;

import entidade.EAmizade;
import entidade.EPerfilUsuario;
import persisrencia.PAmizade;


public class NAmizade {

	private PAmizade _PAmizade;
	
	public NAmizade(){
		
	}
	public void SolicitarAmizade(EAmizade amizade) throws Exception{
		_PAmizade = new PAmizade();
		_PAmizade.Inserir(amizade);
		
	}
	public void AtualizarAmizade(EAmizade amizade) throws Exception{
		_PAmizade = new PAmizade();
		_PAmizade.Altualizar(amizade);
	}
	public void DesfazerAmizade(int codigoAmizade) throws Exception{
		_PAmizade = new PAmizade();
		_PAmizade.Deletar(codigoAmizade);
	}
	public List<EPerfilUsuario> ListarAmigos(int codigoUsuario) throws SQLException{
		
		_PAmizade = new PAmizade();
		return _PAmizade.Listar(codigoUsuario);
		
	}
    public List<EPerfilUsuario> ListarSolicitacoes() throws SQLException{
		
    	_PAmizade = new PAmizade();
		return _PAmizade.ListarSolicitaco(NAcesso.EPerfilUsuarioLogado.getCodigo());
		
	}
    
    
	
}
