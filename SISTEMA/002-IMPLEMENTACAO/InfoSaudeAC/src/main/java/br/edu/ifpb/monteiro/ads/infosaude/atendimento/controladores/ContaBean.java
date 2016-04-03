package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Permissao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Conta;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.ContaService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.ContaServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;

/**
 * Managed bean usado pela página de cadastro de contas. É responsável por ligar
 * a classe de modelo Conta à página de visualização processando as solicitações
 * do usuário e retornando os dados à visualização.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class ContaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ContaServiceIF contaService;

    @Inject
    private Conta conta;

    @Inject
    private Conta contaSelecionada;

    private List<Conta> contas;

    private static transient List<Permissao> permissoes = new ArrayList<>();

    private final String usuarioLogado;

    private String confereSenha;

    /**
     * Construtor da classe Inicia o array com as permissões possiveis para cada
     * usuário do sistema.
     *
     * @see Permissao
     */
    public ContaBean() {
        permissoes = Arrays.asList(Permissao.values());
        this.usuarioLogado = (String) SecurityUtils.getSubject().getPrincipal();
    }

    @PostConstruct
    public void init() {
        this.contas = contaService.findAll();
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Consulta e salvar.
     *
     * @throws NegocioException
     */
    public void salvar() throws NegocioException {
        if (conta.getPassword() == null ? confereSenha == null : conta.getPassword().equals(confereSenha)) {
            this.contaService.save(conta);
            if (getEditando()) {
                FacesUtil.mensagemSucesso("Cadastro do usuário '" + conta.getUserName() + "'atualizado com sucesso!");
            } else {
                FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
            }
            FacesUtil.redirecionaPara("PesquisaConta.xhtml");
            conta = new Conta();
        } else {
            FacesUtil.mensagemAviso("Senhas não conferem!");
        }
    }

    /**
     * Método responsável por excluir um objeto do tipo Conta e exibir ao final
     * do processo uma mensagem informativa.
     *
     * @throws NegocioException
     */
    public void excluir() throws NegocioException {
        this.contaService.delete(contaSelecionada);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
        FacesUtil.redirecionaPara("PesquisaConta.xhtml");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro e retorna true, senao refere-se a um produto
     * a ser editado, retornando false.
     *
     * @return
     */
    public boolean getEditando() {
        return this.conta.getId() != null;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void login() {

        try {

            Subject currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(conta.getUserName(), new Sha256Hash(conta.getPassword()).toHex());

            currentUser.login(token);

        } catch (UnknownAccountException uae) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha no login!", "Usuário incorreto"));

        } catch (IncorrectCredentialsException ice) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha no login!", "Senha incorreta"));

        } catch (LockedAccountException lae) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha no login!", "Usuário está bloqueado"));

        } catch (AuthenticationException aex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha no login!", aex.toString()));
        }

    }

    public void authorizedUserControl() {
        if (null != SecurityUtils.getSubject().getPrincipal()) {
            NavigationHandler nh = FacesContext.getCurrentInstance().getApplication().getNavigationHandler();
            nh.handleNavigation(FacesContext.getCurrentInstance(), null, "Home.xhtml?faces-redirect=true");
        }
    }

    /**
     * Métdo para deslogar usuário corrente e voltar a página de inicial de
     * login.
     *
     * @return
     */
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "/Login.xhtml?faces-redirect=true";
    }

    public ContaService getContaService() {
        return (ContaService) contaService;
    }

    public void setContaService(ContaService contaService) {
        this.contaService = (ContaServiceIF) contaService;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Conta getContaSelecionada() {
        return contaSelecionada;
    }

    public void setContaSelecionada(Conta contaSelecionada) {
        this.contaSelecionada = contaSelecionada;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public String getUsuarioLogado() {
        return usuarioLogado;
    }

    public String getConfereSenha() {
        return confereSenha;
    }

    public void setConfereSenha(String confereSenha) {
        this.confereSenha = confereSenha;
    }
}
