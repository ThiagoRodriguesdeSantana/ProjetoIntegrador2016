package entidade;

public enum StatusDaSolicitacao {

	Aceito(1),
	Rejeitado(2),
	Enviado(3);
	
	private int valor;
	
	 StatusDaSolicitacao(int valor) {
		this.valor = valor;
	}
	 public int GetValor(){
		 return this.valor;
	 }
}
