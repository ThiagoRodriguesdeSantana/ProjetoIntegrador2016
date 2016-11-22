package negocio;

import entidade.EAcesso;
import entidade.EPerfilUsuario;
import persisrencia.PAcesso;

public class NAcesso {

	private PAcesso _Acesso = new PAcesso();
	public static EPerfilUsuario EPerfilUsuarioLogado;
	private NPerfilUsuario _NPerfilUsuario = new NPerfilUsuario();

	public EPerfilUsuario Logar(EAcesso eAcesso) throws Exception {

		if (eAcesso.getEmail().isEmpty()) {
			throw new Exception("� necess�rio Informar o E-mail!");
		} else if (eAcesso.getSenha().isEmpty()) {
			throw new Exception("� necess�rio informar uma senha!");
		}
		
		EPerfilUsuario perfilUsuario = _NPerfilUsuario.ConsultarUsuario(eAcesso);

		if (perfilUsuario.equals(null)) {
			throw new Exception("Usu�rio n�o encotrado! Verifique seu login senha.");
		}
		
		EPerfilUsuarioLogado = perfilUsuario;
		return perfilUsuario;
	}
	public void Deslogar() {
		
		_Acesso.Atualizar(EPerfilUsuarioLogado.getCodigo());

	}
}
