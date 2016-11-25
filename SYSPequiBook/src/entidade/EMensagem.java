package entidade;

import java.sql.Date;
import java.time.LocalDateTime;

public class EMensagem {

	private int codigo;
	private int codigoRemetente;
	private int codigoDestinatario;
	private String mensagem;
	private Date dataHoraEnvio;
	private boolean lido;
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataHoraEnvio() {
		return dataHoraEnvio;
	}
	public void setDataHoraEnvio(Date dataHoraEnvio) {
		this.dataHoraEnvio = dataHoraEnvio;
	}
	public boolean isLido() {
		return lido;
	}
	public void setLido(boolean lido) {
		this.lido = lido;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigoRemetente() {
		return codigoRemetente;
	}
	public void setCodigoRemetente(int codigoRemetente) {
		this.codigoRemetente = codigoRemetente;
	}
	public int getCodigoDestinatario() {
		return codigoDestinatario;
	}
	public void setCodigoDestinatario(int codigoDestinatario) {
		this.codigoDestinatario = codigoDestinatario;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
