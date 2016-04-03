package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.GrauUrgencia;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Triagem;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.TriagemService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.TriagemServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * Managed bean usado pela página de cadastro de triagem. É responsável por
 * ligar a classe de modelo Triagem à página de visualização processando as
 * solicitações do usuário e retornando os dados à visualização.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class TriagemBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Triagem triagem;

    @Inject
    private TriagemServiceIF triagemService;

    @Inject
    private Triagem triagemSelecionada;

    private transient List<Triagem> triagens;

    private transient List<GrauUrgencia> urgencias = new ArrayList<>();

    /**
     * Construtor da classe Inicia o array com os graus de urgência de acordo
     * com o Protocolo de Manchester.
     *
     * @see GrauUrgencia
     *
     */
    public TriagemBean() {
        this.urgencias = Arrays.asList(GrauUrgencia.values());
    }

    @PostConstruct
    public void init() {
        this.triagens = triagemService.findAll();
    }

    /**
     * Lista de triagens feitas na UBS.
     *
     * @return
     */
    public List<Triagem> getTriagens() {
        return triagens;
    }

    /**
     * Lista de graus de urgências possíveis para a ordem de atendimento do
     * paciente.
     *
     * @see GrauUrgencia
     *
     * @return
     */
    public List<GrauUrgencia> getUrgencias() {
        return urgencias;
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Triagem e salvar.
     *
     * @throws NegocioException
     */
    public void salvar() throws NegocioException {
        this.triagemService.save(triagem);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro da triagem '" + triagem.getCodigo() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("PesquisaTriagem.xhtml");
        triagem = new Triagem();
    }

    /**
     * Método responsável por excluir um objeto do tipo Triagem e exibir ao
     * final do processo uma mensagem informativa.
     *
     * @throws NegocioException
     */
    public void excluir() throws NegocioException {
        this.triagemService.delete(triagemSelecionada);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
        FacesUtil.redirecionaPara("PesquisaTriagem.xhtml");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.triagem.getId() != null;
    }

    public Triagem getTriagemSelecionada() {
        return triagemSelecionada;
    }

    public void setTriagemSelecionada(Triagem triagemSelecionada) {
        this.triagemSelecionada = triagemSelecionada;
    }

    public Triagem getTriagem() {
        return triagem;
    }

    public void setTriagem(Triagem triagem) {
        this.triagem = triagem;
    }

    public TriagemService getTriagemService() {
        return (TriagemService) triagemService;
    }

    public void setTriagemService(TriagemService triagemService) {
        this.triagemService = (TriagemServiceIF) triagemService;
    }
}
