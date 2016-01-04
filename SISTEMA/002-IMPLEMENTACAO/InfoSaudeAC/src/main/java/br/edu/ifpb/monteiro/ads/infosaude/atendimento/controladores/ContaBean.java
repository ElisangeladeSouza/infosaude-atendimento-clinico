package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Permissao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Conta;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.ContaService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.omnifaces.util.Faces;

/**
 * Managed bean usado pela página de cadastro de contas. 
 * É responsável por ligar a classe de modelo Conta à página de visualização 
 * processando as solicitações do usuário e retornando os dados à visualização.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class ContaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ContaService contaService;

    @Inject
    private Conta conta;

    @Inject
    private Conta contaSelecionada;

    private List<Conta> contas;

    private final List<Permissao> permissoes;

    private final String usuarioLogado;

    /**
    * Construtor da classe
    * Inicia o array com as permissões possiveis para cada usuário do sistema.
    * 
     * @see Permissao
    */
    public ContaBean() {
        this.permissoes = Arrays.asList(Permissao.values());
        this.usuarioLogado = (String) SecurityUtils.getSubject().getPrincipal();
    }

    @PostConstruct
    public void init() {
        this.contas = contaService.findAll();
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do tipo
     * Consulta e salvar. 
     * 
     * @throws NegocioException 
     */
    public void salvar() throws NegocioException {
        this.contaService.save(conta);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro do usuário '" + conta.getUserName()
                    + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        conta = new Conta();
    }

    /**
     * Método responsável por excluir um objeto do tipo Conta e exibir
     * ao final do processo uma mensagem informativa.
     * 
     * @throws NegocioException 
     */
    public void excluir() throws NegocioException {
        this.contaService.delete(contaSelecionada);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
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

    /**
     * Método que verifica usuário e senha digitados. Caso as informações
     * estejam corretas o usuário será logado, caso contrário emite mensagem de
     * falha no login.
     *
     * @throws IOException
     */
    public void login() throws IOException {
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(conta.getUserName(), conta.getPassword()));
            SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(Faces.getRequest());
            Faces.redirect(savedRequest != null ? savedRequest.getRequestUrl() : "/InfoSaudeAC/Home.xhtml");
        } catch (AuthenticationException e) {
            FacesUtil.mensagemErro("Falha no login!");
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
        return contaService;
    }

    public void setContaService(ContaService contaService) {
        this.contaService = contaService;
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
}
