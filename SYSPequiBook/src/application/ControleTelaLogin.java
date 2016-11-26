package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import entidade.EAcesso;
import entidade.EPerfilUsuario;
import entidade.StatusPerfil;
import entidade.StatusRelacionamento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import negocio.NAcesso;

public class ControleTelaLogin implements Initializable {

    @FXML
    private TextField txtEmail;
    @FXML
    private Label lblMessageError;
    @FXML
    private TextField txtSenha;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCadastroEmail;
    @FXML
    private TextField txtTelefone;
    @FXML
    private TextField txtCadastroSenha;
    @FXML
    private Button btnEntrar;
    @FXML
    private Button btnCadastrar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FormatarControle();

    }

    private void FormatarControle() {

        lblMessageError.setVisible(false);

    }

    @FXML
    private void Entrar(ActionEvent event) {

        try {
            Logar();

        } catch (Exception e) {

            lblMessageError.setVisible(true);
            lblMessageError.setText(e.getMessage());

        }

    }

    private void Logar() throws Exception {

        NAcesso nAcesso = new NAcesso();
        EAcesso acesso = new EAcesso();
        acesso.setEmail(txtEmail.getText());
        acesso.setSenha(txtSenha.getText());

        EPerfilUsuario perfilUsuario = nAcesso.Logar(acesso);
        
        System.out.println("OK");

    }

    private void AbrirTela(EPerfilUsuario logar) throws IOException {

        /*AnchorPane  root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
         Scene scene = new Scene(root);
         Main.stage.setScene(scene);
         Main.stage.setMaximized(false);
         Main.stage.show();*/
    }

    @FXML
    private void Cadastrar(ActionEvent event) {
        try {
            CadastrarUsuario();
            LimparCAmpos();

        } catch (Exception e) {

            lblMessageError.setVisible(true);
            lblMessageError.setText(e.getMessage());

        }

    }

    private void LimparCAmpos() {
    	
    	txtCadastroEmail.setText("");
    	txtCadastroSenha.setText("");
    	txtNome.setText("");
    	txtTelefone.setText("");
	}

	private void CadastrarUsuario() throws Exception {

        EPerfilUsuario perfilUsuario = new EPerfilUsuario();
        NAcesso nAcesso = new NAcesso();

        perfilUsuario.getAcesso().setEmail(txtCadastroEmail.getText());
        perfilUsuario.getAcesso().setSenha(txtCadastroSenha.getText());

        perfilUsuario.setNome(txtNome.getText());
        perfilUsuario.setTelefone(txtTelefone.getText());
        perfilUsuario.setStatusPerfil(StatusPerfil.Privado);
        perfilUsuario.setStatusLogin(true);
        perfilUsuario.setStatusRelacionamento(StatusRelacionamento.Nenhum);

        nAcesso.Salvar(perfilUsuario);

    }

}
