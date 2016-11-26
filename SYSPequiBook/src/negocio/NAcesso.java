package negocio;

import java.sql.SQLException;

import entidade.EAcesso;
import entidade.EPerfilUsuario;
import persisrencia.PAcesso;

public class NAcesso {

	private PAcesso _Acesso;
	public static EPerfilUsuario EPerfilUsuarioLogado;
	private NPerfilUsuario _NPerfilUsuario;
	
	public NAcesso(){
		
	}

	public EPerfilUsuario Logar(EAcesso eAcesso) throws Exception {
		
		if (eAcesso.getEmail().isEmpty()) {
			throw new Exception("É necessário Informar o E-mail!");
		} else if (eAcesso.getSenha().isEmpty()) {
			throw new Exception("É necessário informar uma senha!");
		}
		_NPerfilUsuario = new NPerfilUsuario();
		EPerfilUsuario perfilUsuario = _NPerfilUsuario.ConsultarUsuario(eAcesso);

		if (perfilUsuario.getCodigo() == 0) {
			throw new Exception("Usuário não encotrado! Verifique seu login senha.");
		}

		EPerfilUsuarioLogado = perfilUsuario;
		return perfilUsuario;
	}

	public void Deslogar() throws SQLException {
		
		_Acesso = new PAcesso();
		_Acesso.Atualizar(EPerfilUsuarioLogado);

	}

	public void Excluir() throws SQLException {
		_Acesso = new PAcesso();
		_Acesso.Deletar(EPerfilUsuarioLogado);
	}

	public void Salvar(EPerfilUsuario perfilUsuario) throws SQLException {
		_Acesso = new PAcesso();
		_Acesso.Salvar(perfilUsuario);
	}

	public void EditarPerfil(EPerfilUsuario ePerfilUsuario) throws SQLException {

		if (ePerfilUsuario.equals(NAcesso.EPerfilUsuarioLogado)) {
			_Acesso = new PAcesso();
			_Acesso.Atualizar(ePerfilUsuario);
		}

	}
}
