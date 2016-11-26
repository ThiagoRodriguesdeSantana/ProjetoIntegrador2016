package application;

import java.awt.Image;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.text.html.ImageView;

import entidade.EMensagem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import negocio.NAcesso;
import negocio.NMensagem;

public class ControleTelaPrincipal implements Initializable{
	
	
	@FXML
	private AnchorPane panePrincipal;
	@FXML
	private Pane pane1;
	@FXML
	private Button acessoPerfil;
	@FXML
	private Button fotos;
	@FXML
	private Button btnAddPost;
	@FXML
	private Button btnRemovePost;
	@FXML
	private Button btnSair;
	@FXML
	private ImageView imgTimaLine;
	@FXML
	private TableView<TabelaMensagem> tblSolicitacoes;
	@FXML
	private TableView<TabelaTimeLine> tblTimeLine;
	@FXML
	private TableColumn<TabelaMensagem, javafx.scene.image.Image> colimagem;
	@FXML
	private TableColumn<TabelaMensagem, String> colUsuarios;
	@FXML
	private Label nomeUsuario;
	@FXML
	private ComboBox<PopulaComboPesquisaAmigos> cboPesquisaAmigos;
	@FXML
	private TableView<TabelaMensagem> tblMensagem;
	@FXML
	private TableColumn<TabelaMensagem, String> texto;
	
	private NMensagem nMensagem = new NMensagem();
	
	List<EMensagem> listaMensagem;
	
	private ObservableList<TabelaMensagem> listMensage = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
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
		
		tblMensagem.setItems(listMensage);
		
	}
	@FXML
	private void AcessarPerfil(ActionEvent event){
		
		
	}
	@FXML
	private void VerFotos(ActionEvent event){
		
	}
	@FXML
	private void AdicionarPstagem(ActionEvent event){
		
	}
	@FXML
	private void RemoverPstagem(ActionEvent event){
		
	}
	@FXML
	private void Sair(ActionEvent event){
		
	}
	
    
     


}
