package application;

import java.awt.Image;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.ImageView;

import entidade.EMensagem;
import entidade.EPostagem;
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
import negocio.NPostagem;

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
	private TableView<EPostagem> tblTimeLine;
	
	@FXML
	private TableView<TabelaMensagem> tblSolicitacoes;
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
	
	private NPostagem nPostagem = new NPostagem();
	
	List<EMensagem> listaMensagem;
	
	private ObservableList<TabelaMensagem> listMensage = FXCollections.observableArrayList();
	
	private ObservableList<EPostagem> listaPostagem;

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
	
	public void ListarPostagem(EPostagem ePostagem) throws Exception{
		
		//tblTimeLine = (TableView<EPostagem>) nPostagem.ListarPostagem(0);
		
		Vector post = new Vector();
		for(EPostagem postagem : new NPostagem().ListarPostagem(ePostagem.getCodigo())){
			Vector<Object> linha = new Vector<Object>();
			linha.add(postagem.getNome());
			linha.addElement(postagem.getData());
			linha.add(postagem.getMensagem());
			linha.add(postagem.getImagem());
		}
		 tblTimeLine.setItems(listaPostagem);
	}
	@FXML
	private void AcessarPerfil(ActionEvent event){
		
		
	}
	@FXML
	private void VerFotos(ActionEvent event){
		
	}
	@FXML
	private void AdicionarPostagem(ActionEvent event){
		
	}
	@FXML
	private void RemoverPostagem(ActionEvent event){
		
	}
	@FXML
	private void Sair(ActionEvent event){
		
	}
	
    
     


}
