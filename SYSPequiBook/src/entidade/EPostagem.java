package entidade;

import java.awt.image.BufferedImage;
import java.time.LocalDate;

public class EPostagem {

	private int codigo;
	private byte[] imagem;
	private String mensagem;
	private EPerfilUsuario usuario;
	private LocalDate data;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public EPerfilUsuario getUsuario() {
		return usuario;
	}
	public void setUsuario(EPerfilUsuario usuario) {
		this.usuario = usuario;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
}
