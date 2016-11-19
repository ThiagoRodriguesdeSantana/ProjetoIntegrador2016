package entidade;

public class EAmizade {

	private int codigo;
	private EPerfilUsuario amigo;
	private int codigoUsiario;
	private StatusDaSolicitacao daSolicitacao;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public EPerfilUsuario getAmigo() {
		return amigo;
	}
	public void setAmigo(EPerfilUsuario amigo) {
		this.amigo = amigo;
	}
	public int getCodigoUsiario() {
		return codigoUsiario;
	}
	public void setCodigoUsiario(int codigoUsiario) {
		this.codigoUsiario = codigoUsiario;
	}
	public StatusDaSolicitacao getDaSolicitacao() {
		return daSolicitacao;
	}
	public void setDaSolicitacao(StatusDaSolicitacao daSolicitacao) {
		this.daSolicitacao = daSolicitacao;
	}
}
