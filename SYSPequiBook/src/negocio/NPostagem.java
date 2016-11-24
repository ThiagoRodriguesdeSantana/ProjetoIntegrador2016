package negocio;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import entidade.EPostagem;
import persisrencia.PPostagem;

public class NPostagem {
	
	private PPostagem _PPostagem = new PPostagem();

	public void Postar(EPostagem ePostagem) throws SQLException{
		
		_PPostagem.Salvar(ePostagem);
		
	}
	public void ExcuirPstagem(int codigoPostagem) throws SQLException{
		
		_PPostagem.Excluir(codigoPostagem);
		
	}
	public List<EPostagem> ListarPostagem(int codigoUsuario) throws SQLException{
		return _PPostagem.Listar(codigoUsuario);
	}
	public void AtualizarPstagem(EPostagem ePostagem){
		 
		_PPostagem.Atualizar(ePostagem);
	}
	
}