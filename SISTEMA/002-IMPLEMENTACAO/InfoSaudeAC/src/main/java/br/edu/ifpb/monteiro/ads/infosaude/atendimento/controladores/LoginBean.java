package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Permissao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Login;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.LoginService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.SegurancaService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private SegurancaService segurancaService;

    @Inject
    private Login loginSelecionado;

    private transient List<Login> logins;
    
    private final transient List<Permissao> permissoes;

    private String confereSenha;
    
    private Login usuarioLogado;

    public LoginBean() {
        permissoes = Arrays.asList(Permissao.values());
    }

    public List<Login> getLogins() {
        this.logins = loginService.findAll();
        return logins;
    }
    
    public List<Permissao> getPermissao() {
        return permissoes;
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
    
    /**
     * Metodo que busca o usuario e senha no banco. Se sim, prover ao usuario do
     * sistema a sua autorização.
     * @return 
     */
    
    public String fazerLogin() {
        Login lg  = null;
        try {
            lg = segurancaService.login(this.login.getUsuario(), this.login.getSenha(), true);
        } catch (Exception ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE,"Erro no Login", ex);
            FacesUtil.mensagemErro("Login: O usuário e senha informados não existem!");
        }
        return (lg != null)? "success" : null;
        
    }
    
    /**
     * Metodo que verifica o usuario que esta logado naquele momento no sistema.
     * @return 
     */
    public Login usuarioLogado() {
        return usuarioLogado = segurancaService.getCurrentUser();
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

    public SegurancaService getSegurancaService() {
        return segurancaService;
    }

    public void setSegurancaService(SegurancaService segurancaService) {
        this.segurancaService = segurancaService;
    }

    public Login getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Login usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    
}
