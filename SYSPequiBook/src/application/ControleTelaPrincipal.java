package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import entidade.EMensagem;
import entidade.EPerfilUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.NAcesso;
import negocio.NMensagem;

public class ControleTelaPrincipal implements Initializable{
	
	@FXML
	private Label nome;
	@FXML
	private TableView<TabelaMensagem> mensagem;
	@FXML
	private TableColumn<TabelaMensagem, String> texto;
	
	private NMensagem nMensagem = new NMensagem();
	
	List<EMensagem> listaMensagem;
	
	private ObservableList<TabelaMensagem> listMensage = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void ListarMensagem() throws Exception{
		
		listaMensagem = nMensagem.ListarMensagens();
		for (EMensagem mensagem : listaMensagem) {
			
			String usuario;
			if(mensagem.getCodigoRemetente() == NAcesso.EPerfilUsuarioLogado.getCodigo()){
				
				usuario = "Voçe disse:";
			}
			else
				usuario = mensagem.getNome()+" disse:";
			
			TabelaMensagem tabelaMensagem = new TabelaMensagem(usuario+"\n "+mensagem.getMensagem());
			
			listMensage.add(tabelaMensagem);
		}
		
		texto.setCellValueFactory(new PropertyValueFactory<TabelaMensagem, String>("Mensagem"));
		
	}
	
	
    
     


}
