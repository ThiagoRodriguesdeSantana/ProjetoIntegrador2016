package entidade;

import java.awt.image.BufferedImage;

public class EPerfilUsuario {
	
	private int codigo;
	private String nome;
	private String telefone;
	private byte[] foto;
	private String status;
	private StatusPerfil statusPerfil;
        public int idStatusPerfil;
	private EAcesso acesso;
	private StatusRelacionamento statusRelacionamento;
        public int idStatusRelacionamento;
	private boolean statusLogin;
	
	
	public EPerfilUsuario(){
		
		this.acesso = new EAcesso();
	}
	
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
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
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
	public boolean getStatusLogin() {
		return statusLogin;
	}
	public void setStatusLogin(boolean statusLogin) {
		this.statusLogin = statusLogin;
	}

    /**
     * @return the idStatusRelacionamento
     */
    public int getIdStatusRelacionamento() {
        return idStatusRelacionamento;
    }

    /**
     * @param idStatusRelacionamento the idStatusRelacionamento to set
     */
    public void setIdStatusRelacionamento(int idStatusRelacionamento) {
        this.idStatusRelacionamento = idStatusRelacionamento;
    }

    /**
     * @return the idStatusPerfil
     */
    public int getIdStatusPerfil() {
        return idStatusPerfil;
    }

    /**
     * @param idStatusPerfil the idStatusPerfil to set
     */
    public void setIdStatusPerfil(int idStatusPerfil) {
        this.idStatusPerfil = idStatusPerfil;
    }

}
