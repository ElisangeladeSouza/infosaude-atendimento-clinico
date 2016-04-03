package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.TecnicoEnfermagem;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.TecnicoEnfermagemService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.PessoaServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.TecnicoEnfermagemServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.RollbackException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Managed bean usado pela página de cadastro de técnico em enfermagem. É
 * responsável por ligar a classe de modelo TecnicoEnfermagem à página de
 * visualização processando as solicitações do usuário e retornando os dados à
 * visualização.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class TecnicoEnfermagemBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(TecnicoEnfermagemBean.class);

    @Inject
    private TecnicoEnfermagem tecnicoEnfermagem;

    @Inject
    private TecnicoEnfermagemServiceIF tecnicoEnfermagemService;

    @Inject
    private TecnicoEnfermagem tecnicoEnfermagemSelecionado;

    @Inject
    private PessoaServiceIF pessoaService;

    private transient List<TecnicoEnfermagem> tecnicos;

    /**
     * Construtor da classe
     */
    public TecnicoEnfermagemBean() {
    }

    @PostConstruct
    public void init() {
        this.tecnicos = tecnicoEnfermagemService.findAll();
    }

    /**
     * Método responsável por carregar uma lista com todas as cidades
     * cadastradas. Esta lista será usada para preencher o respectivo campo de
     * cidade na view.
     */
    public void carregarCidades() {
        pessoaService.retornaCidades(tecnicoEnfermagem.getEndereco().getEstado(), tecnicoEnfermagem.getEndereco().getEstado().getCodigo());
    }

    /**
     * Lista de técnicos em enfermagem cadastrados na UBS.
     *
     * @return
     */
    public List<TecnicoEnfermagem> getTecnicos() {
        return tecnicos;
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo TecnicoEnfermagem e salvar. Se algum erro ocorrer, deve-se fazer
     * rollback e apresentar uma mensagem de erro.
     *
     * @throws NegocioException
     */
    public void salvar() throws NegocioException {
        try {
            this.tecnicoEnfermagemService.save(tecnicoEnfermagem);
            if (getEditando()) {
                FacesUtil.mensagemSucesso("Cadastro do téc. em enfermagem '" + tecnicoEnfermagem.getNome() + "' atualizado com sucesso!");
            } else {
                FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
            }
            FacesUtil.redirecionaPara("PesquisaTecnicoEnfermagem.xhtml");
            tecnicoEnfermagem = new TecnicoEnfermagem();
        } catch (RollbackException rollback) {
            FacesUtil.mensagemErro("O CPF informado já está cadastrado. Informe outro CPF.");
            LOGGER.warn(rollback);
        }
    }

    /**
     * Método responsável por excluir um objeto do tipo TecnicoEnfermagem e
     * exibir ao final do processo uma mensagem informativa.
     *
     * @throws NegocioException
     */
    public void excluir() throws NegocioException {
        this.tecnicoEnfermagemService.delete(tecnicoEnfermagemSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
        FacesUtil.redirecionaPara("PesquisaTecnicoEnfermagem.xhtml");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.tecnicoEnfermagem.getId() != null;
    }

    public TecnicoEnfermagem getTecnicoEnfermagemSelecionado() {
        return tecnicoEnfermagemSelecionado;
    }

    public void setTecnicoEnfermagemSelecionado(TecnicoEnfermagem tecnicoEnfermagemSelecionado) {
        this.tecnicoEnfermagemSelecionado = tecnicoEnfermagemSelecionado;
    }

    public TecnicoEnfermagem getTecnicoEnfermagem() {
        return tecnicoEnfermagem;
    }

    public void setTecnicoEnfermagem(TecnicoEnfermagem tecnicoEnfermagem) {
        this.tecnicoEnfermagem = tecnicoEnfermagem;
    }

    public TecnicoEnfermagemService getTecnicoEnfermagemService() {
        return (TecnicoEnfermagemService) tecnicoEnfermagemService;
    }

    public void setTecnicoEnfermagemService(TecnicoEnfermagemService tecnicoEnfermagemService) {
        this.tecnicoEnfermagemService = (TecnicoEnfermagemServiceIF) tecnicoEnfermagemService;
    }
}
