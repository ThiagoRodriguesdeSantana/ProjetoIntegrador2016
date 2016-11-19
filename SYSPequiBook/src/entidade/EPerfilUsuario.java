package entidade;

import java.awt.image.BufferedImage;

public class EPerfilUsuario {
	
	private int codigo;
	private String nome;
	private String telefone;
	private BufferedImage foto;
	private String status;
	private StatusPerfil statusPerfil;
	private EAcesso acesso;
	private StatusRelacionamento statusRelacionamento;
	private StatusLogin statusLogin;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public BufferedImage getFoto() {
		return foto;
	}
	public void setFoto(BufferedImage foto) {
		this.foto = foto;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public StatusPerfil getStatusPerfil() {
		return statusPerfil;
	}
	public void setStatusPerfil(StatusPerfil statusPerfil) {
		this.statusPerfil = statusPerfil;
	}
	public EAcesso getAcesso() {
		return acesso;
	}
	public void setAcesso(EAcesso acesso) {
		this.acesso = acesso;
	}
	public StatusRelacionamento getStatusRelacionamento() {
		return statusRelacionamento;
	}
	public void setStatusRelacionamento(StatusRelacionamento statusRelacionamento) {
		this.statusRelacionamento = statusRelacionamento;
	}
	public StatusLogin getStatusLogin() {
		return statusLogin;
	}
	public void setStatusLogin(StatusLogin statusLogin) {
		this.statusLogin = statusLogin;
	}

}
