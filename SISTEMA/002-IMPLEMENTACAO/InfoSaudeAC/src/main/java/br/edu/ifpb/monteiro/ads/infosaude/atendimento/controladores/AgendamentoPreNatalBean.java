package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.AgendamentoPreNatal;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.AgendamentoPreNatalServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * Managed bean usado pela página de cadastro de Agendamento de pré-natal. É
 * responsável por ligar a classe de modelo AgendamentoPreNatal à página de
 * visualização processando as solicitações do usuário e retornando os dados à
 * visualização.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class AgendamentoPreNatalBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private AgendamentoPreNatal agendamentoPreNatal;

    @Inject
    private AgendamentoPreNatalServiceIF agendamentoPreNatalService;

    @Inject
    private AgendamentoPreNatal agendamentoSelecionado;

    private transient List<AgendamentoPreNatal> agendamentos;

    /**
     * Construtor da classe
     */
    public AgendamentoPreNatalBean() {
    }

    @PostConstruct
    public void init() {
        this.agendamentos = agendamentoPreNatalService.findAll();
    }

    public List<AgendamentoPreNatal> getAgendamentos() {
        return agendamentos;
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo AgendamentoPreNatal e salvar. Se algum erro ocorrer, deve-se fazer
     * rollback e apresentar uma mensagem de erro.
     *
     * @throws NegocioException
     */
    public void salvar() throws NegocioException {
        this.agendamentoPreNatalService.save(agendamentoPreNatal);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro do agendamentoPreNatal '" + agendamentoPreNatal.getId() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("PesquisaAgendamentoPreNatal.xhtml");
        agendamentoPreNatal = new AgendamentoPreNatal();
    }

    /**
     * Método responsável por excluir um objeto do tipo AgendamentoPreNatal e
     * exibir ao final do processo uma mensagem informativa.
     *
     * @throws NegocioException
     */
    public void excluir() throws NegocioException {
        this.agendamentoPreNatalService.delete(agendamentoSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
        FacesUtil.redirecionaPara("PesquisaAgendamentoPreNatal.xhtml");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.agendamentoPreNatal.getId() != null;
    }

    public AgendamentoPreNatal getAgendamentoPreNatal() {
        return agendamentoPreNatal;
    }

    public void setAgendamentoPreNatal(AgendamentoPreNatal agendamentoPreNatal) {
        this.agendamentoPreNatal = agendamentoPreNatal;
    }

    public AgendamentoPreNatalServiceIF getAgendamentoPreNatalService() {
        return agendamentoPreNatalService;
    }

    public void setAgendamentoPreNatalService(AgendamentoPreNatalServiceIF agendamentoPreNatalService) {
        this.agendamentoPreNatalService = agendamentoPreNatalService;
    }

    public AgendamentoPreNatal getAgendamentoSelecionado() {
        return agendamentoSelecionado;
    }

    public void setAgendamentoSelecionado(AgendamentoPreNatal agendamentoSelecionado) {
        this.agendamentoSelecionado = agendamentoSelecionado;
    }
}
