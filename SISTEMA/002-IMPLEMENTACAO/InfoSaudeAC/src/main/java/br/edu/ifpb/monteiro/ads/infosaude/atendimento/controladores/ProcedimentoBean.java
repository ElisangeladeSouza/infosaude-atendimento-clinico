package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Procedimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Ubs;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.ProcedimentoService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.UbsService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.ProcedimentoServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.UbsServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import lombok.Getter;

/**
 * Managed bean usado pela página de cadastro de procedimento. É responsável por
 * ligar a classe de modelo Procedimento à página de visualização processando as
 * solicitações do usuário e retornando os dados à visualização.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Model
public class ProcedimentoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Procedimento procedimento;

    @Inject
    private UbsServiceIF ubsService;

    @Inject
    private ProcedimentoServiceIF procedimentoService;

    @Inject
    private Procedimento procedimentoSelecionado;

    private transient List<Procedimento> procedimentos;

    @Getter
    private List<Ubs> listaUbs;
    
    @Getter
    private Long cnesUbs;

    /**
     * Construtor da classe
     */
    public ProcedimentoBean() {
    }

    @PostConstruct
    public void init() {
        this.procedimentos = procedimentoService.findAll();
        cnesUbs = pegaCnesUbs();
    }

    private Long pegaCnesUbs() {
        Long cnes = null;
        listaUbs = ubsService.findAll();
        for (Ubs ubsSelecionada : listaUbs) {
            cnes = ubsSelecionada.getCnes();
        }
        return cnes;
    }

    /**
     * Lista de procedimentos que podem ser feitos na UBS.
     *
     * @return
     */
    public List<Procedimento> getProcedimentos() {
        return procedimentos;
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Procedimento e salvar. Se algum erro ocorrer, deve-se fazer rollback
     * e apresentar uma mensagem de erro.
     *
     * @throws NegocioException
     */
    public void salvar() throws NegocioException {
        this.procedimentoService.save(procedimento);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro do procedimento '" + procedimento.getDescricao() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("PesquisaProcedimento.xhtml");
        procedimento = new Procedimento();
    }

    /**
     * Método responsável por excluir um objeto do tipo Procedimento e exibir ao
     * final do processo uma mensagem informativa.
     *
     * @throws NegocioException
     */
    public void excluir() throws NegocioException {
        this.procedimentoService.delete(procedimentoSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
        FacesUtil.redirecionaPara("PesquisaProcedimento.xhtml");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.procedimento.getId() != null;
    }

    public Procedimento getProcedimentoSelecionado() {
        return procedimentoSelecionado;
    }

    public void setProcedimentoSelecionado(Procedimento procedimentoSelecionado) {
        this.procedimentoSelecionado = procedimentoSelecionado;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public ProcedimentoService getProcedimentoService() {
        return (ProcedimentoService) procedimentoService;
    }

    public void setProcedimentoService(ProcedimentoService procedimentoService) {
        this.procedimentoService = (ProcedimentoServiceIF) procedimentoService;
    }

    public UbsService getUbsService() {
        return (UbsService) ubsService;
    }

    public void setUbsService(UbsService ubsService) {
        this.ubsService = (UbsServiceIF) ubsService;
    }
}
