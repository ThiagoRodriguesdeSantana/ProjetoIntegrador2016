package negocio;

import java.sql.SQLException;

import entidade.EAcesso;
import entidade.EPerfilUsuario;
import persisrencia.PAcesso;
import persisrencia.PPerfilUsuario;

public class NAcesso {

    private PAcesso _Acesso;
    public static EPerfilUsuario EPerfilUsuarioLogado = new EPerfilUsuario();
    private NPerfilUsuario _NPerfilUsuario;

    public NAcesso() {

    }

    public EPerfilUsuario Logar(EAcesso eAcesso) throws Exception {

        if (eAcesso.getEmail().isEmpty()) {
            throw new Exception("É necessário Informar o E-mail!");
        } else if (eAcesso.getSenha().isEmpty()) {
            throw new Exception("É necessário informar uma senha!");
        }
        _NPerfilUsuario = new NPerfilUsuario();

        EPerfilUsuario perfilUsuario = _NPerfilUsuario.ConsultarUsuario(eAcesso);

        if (perfilUsuario.getCodigo() == 0) {
            throw new Exception("Usuário não encotrado! Verifique seu login senha.");
        }
        _NPerfilUsuario.Editar(EPerfilUsuarioLogado.getCodigo(), true);
        

        AtualizarUsuarioLogado(perfilUsuario);
        return perfilUsuario;
    }

    public void Deslogar() throws SQLException, Exception {

        _NPerfilUsuario = new NPerfilUsuario();
        _NPerfilUsuario.Editar(EPerfilUsuarioLogado.getCodigo(), false);
    }

    public void Excluir() throws SQLException {
        _Acesso = new PAcesso();
        _Acesso.Deletar(EPerfilUsuarioLogado);
    }

    public void Salvar(EPerfilUsuario perfilUsuario) throws Exception {
        _Acesso = new PAcesso();
        if (_Acesso.Cansultar(perfilUsuario.getAcesso()).getCodigo() != 0) {

            throw new Exception("Já existe um usuario com este login e senha!");
        }

        _Acesso.Salvar(perfilUsuario);
    }

    public void EditarPerfil(EPerfilUsuario ePerfilUsuario) throws SQLException {

        if (ePerfilUsuario.getCodigo() == NAcesso.EPerfilUsuarioLogado.getCodigo()) {
            _Acesso = new PAcesso();
            _Acesso.Atualizar(ePerfilUsuario);
        }

    }

    public void AtualizarUsuarioLogado(EPerfilUsuario perfil) {

        EPerfilUsuarioLogado.setCodigo(perfil.getCodigo());
        EPerfilUsuarioLogado.setAcesso(perfil.getAcesso());
        EPerfilUsuarioLogado.setFoto(perfil.getFoto());
        EPerfilUsuarioLogado.setNome(perfil.getNome());
        EPerfilUsuarioLogado.setStatus(perfil.getStatus());
        EPerfilUsuarioLogado.setStatusLogin(true);
        EPerfilUsuarioLogado.setStatusPerfil(perfil.getStatusPerfil());
        EPerfilUsuarioLogado.setStatusRelacionamento(perfil.getStatusRelacionamento());
        EPerfilUsuarioLogado.setTelefone(perfil.getTelefone());

    }
}
