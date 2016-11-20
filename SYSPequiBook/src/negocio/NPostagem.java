package negocio;

import java.time.LocalDateTime;
import java.util.List;

import entidade.EPostagem;
import persisrencia.PPostagem;

public class NPostagem {
	
	private PPostagem _PPostagem = new PPostagem();

	public void Postar(EPostagem ePostagem){
		
		_PPostagem.Salvar(ePostagem);
		
	}
	public void ExcuirPstagem(int codigoPstagem){
		
		_PPostagem.Excuir(codigoPstagem);
		
	}
	public List<EPostagem> ListarPstagem(int codigoUsuario, LocalDateTime dataIni, LocalDateTime dataFim){
		return _PPostagem.Listar(codigoUsuario, dataIni, dataFim);
	}
	public void AtualizarPstagem(EPostagem ePostagem){
		 
		_PPostagem.Atualizar(ePostagem);
	}
	
}
