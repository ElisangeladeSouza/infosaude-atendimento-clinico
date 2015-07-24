package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Login;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.LoginService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author elisangela
 */
@Model
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Login login;

    @Inject
    private LoginService loginService;

    @Inject
    private Login loginSelecionado;

    private transient List<Login> logins;

    private String confereSenha;

    public LoginBean() {
    }

    public List<Login> getLogins() {
        this.logins = loginService.findAll();
        return logins;
    }

    public void salvar() throws UBSException {
        if (login.getSenha() == null ? confereSenha == null : login.getSenha().equals(confereSenha)) {
            this.loginService.save(login);
            if (getEditando()) {
                FacesUtil.mensagemSucesso("Cadastro de usuário '" + login.getId() + "' atualizado com sucesso!");
                FacesUtil.redirecionaPara("PesquisaLogin.xhtml");
            } else {
                FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
            }
            login = new Login();
        } else {
            FacesUtil.mensagemAviso("Senhas não conferem!");
        }

    }

    public void excluir() throws UBSException {
        this.loginService.delete(loginSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.login.getId() != null;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public Login getLoginSelecionado() {
        return loginSelecionado;
    }

    public void setLoginSelecionado(Login loginSelecionado) {
        this.loginSelecionado = loginSelecionado;
    }

    public String getConfereSenha() {
        return confereSenha;
    }

    public void setConfereSenha(String confereSenha) {
        this.confereSenha = confereSenha;
    }

}
