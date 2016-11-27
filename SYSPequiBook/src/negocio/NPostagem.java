package negocio;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import entidade.EPostagem;
import persisrencia.PPostagem;

public class NPostagem {
	
	private PPostagem _PPostagem;
	
	public NPostagem(){
		
	}

	public void Postar(EPostagem ePostagem) throws SQLException{
		
		_PPostagem = new PPostagem();
		_PPostagem.Salvar(ePostagem);
		
	}
	public void ExcluirPostagem(int codigoPostagem) throws SQLException{
		
		_PPostagem = new PPostagem();
		_PPostagem.Excluir(codigoPostagem);
		
	}
	public List<EPostagem> ListarPostagem(int codigoUsuario) throws SQLException{
		_PPostagem = new PPostagem();
		return _PPostagem.Listar(codigoUsuario);
	}
	public void AtualizarPostagem(EPostagem ePostagem){
		
		_PPostagem = new PPostagem();
		_PPostagem.Atualizar(ePostagem);
	}
	
}