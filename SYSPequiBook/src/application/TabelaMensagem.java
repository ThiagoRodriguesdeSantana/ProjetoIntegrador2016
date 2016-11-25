package application;

import javafx.beans.property.SimpleStringProperty;

public class TabelaMensagem {	
	
	private final SimpleStringProperty texto;
	
	public TabelaMensagem(String texto){
		
		super();
		this.texto = new SimpleStringProperty(texto);
	}
	
	public String getTexto(){
		return texto.get();
	}

}
