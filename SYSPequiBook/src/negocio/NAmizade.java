package negocio;

import java.sql.SQLException;
import java.util.List;

import entidade.EAmizade;
import entidade.EPerfilUsuario;
import persisrencia.PAmizade;


public class NAmizade {

	private PAmizade _PAmizade = new PAmizade();
	public void SolicitarAmizade(EAmizade amizade) throws SQLException{
		
		_PAmizade.Inserir(amizade);
		
	}
	public void AtualizarAmizade(EAmizade amizade) throws SQLException{
		_PAmizade.Altualizar(amizade);
	}
	public void DesfazerAmizade(int codigoAmizade) throws Exception{
		_PAmizade.Deletar(codigoAmizade);
	}
	public List<EPerfilUsuario> ListarAmigos(int codigoUsuario) throws SQLException{
		
		return _PAmizade.Listar(codigoUsuario);
		
	}
    public List<EPerfilUsuario> ListarSolicitacoes() throws SQLException{
		
		return _PAmizade.ListarSolicitaco(NAcesso.EPerfilUsuarioLogado.getCodigo());
		
	}
	
}
