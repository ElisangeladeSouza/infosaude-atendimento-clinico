package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.AgendamentoVisitaDomiciliar;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.AgendamentoVisitaDomiciliarServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * Managed bean usado pela página de cadastro de Agendamento de visita
 * domiciliar. É responsável por ligar a classe de modelo
 * AgendamentoVisitaDomiciliar à página de visualização processando as
 * solicitações do usuário e retornando os dados à visualização.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class AgendamentoVisitaDomiciliarBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private AgendamentoVisitaDomiciliar agendamentoVisitaDomiciliar;

    @Inject
    private AgendamentoVisitaDomiciliarServiceIF agendamentoVisitaDomiciliarService;

    @Inject
    private AgendamentoVisitaDomiciliar agendamentoVisitaDomiciliarSelecionado;

    private transient List<AgendamentoVisitaDomiciliar> visitasDomiciliares;

    /**
     * Construtor da classe
     */
    public AgendamentoVisitaDomiciliarBean() {
    }

    @PostConstruct
    public void init() {
        this.visitasDomiciliares = agendamentoVisitaDomiciliarService.findAll();
    }

    public List<AgendamentoVisitaDomiciliar> getVisitasDomiciliares() {
        return visitasDomiciliares;
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo AgendamentoVisitaDomiciliar e salvar. Se algum erro ocorrer, deve-se
     * fazer rollback e apresentar uma mensagem de erro.
     *
     * @throws NegocioException
     */
    public void salvar() throws NegocioException {
        this.agendamentoVisitaDomiciliarService.save(agendamentoVisitaDomiciliar);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro do agendamento de visita domiciliar '" + agendamentoVisitaDomiciliar.getId() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("PesquisaAgendamentoVisitaDomiciliar.xhtml");
        agendamentoVisitaDomiciliar = new AgendamentoVisitaDomiciliar();
    }

    /**
     * Método responsável por excluir um objeto do tipo
     * AgendamentoVisitaDomiciliar e exibir ao final do processo uma mensagem
     * informativa.
     *
     * @throws NegocioException
     */
    public void excluir() throws NegocioException {
        this.agendamentoVisitaDomiciliarService.delete(agendamentoVisitaDomiciliarSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
        FacesUtil.redirecionaPara("PesquisaAgendamentoVisitaDomiciliar.xhtml");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.agendamentoVisitaDomiciliar.getId() != null;
    }

    public AgendamentoVisitaDomiciliar getAgendamentoVisitaDomiciliar() {
        return agendamentoVisitaDomiciliar;
    }

    public void setAgendamentoVisitaDomiciliar(AgendamentoVisitaDomiciliar agendamentoVisitaDomiciliar) {
        this.agendamentoVisitaDomiciliar = agendamentoVisitaDomiciliar;
    }

    public AgendamentoVisitaDomiciliarServiceIF getAgendamentoVisitaDomiciliarService() {
        return agendamentoVisitaDomiciliarService;
    }

    public void setAgendamentoVisitaDomiciliarService(AgendamentoVisitaDomiciliarServiceIF agendamentoVisitaDomiciliarService) {
        this.agendamentoVisitaDomiciliarService = agendamentoVisitaDomiciliarService;
    }

    public AgendamentoVisitaDomiciliar getAgendamentoVisitaDomiciliarSelecionado() {
        return agendamentoVisitaDomiciliarSelecionado;
    }

    public void setAgendamentoVisitaDomiciliarSelecionado(AgendamentoVisitaDomiciliar agendamentoVisitaDomiciliarSelecionado) {
        this.agendamentoVisitaDomiciliarSelecionado = agendamentoVisitaDomiciliarSelecionado;
    }
}
