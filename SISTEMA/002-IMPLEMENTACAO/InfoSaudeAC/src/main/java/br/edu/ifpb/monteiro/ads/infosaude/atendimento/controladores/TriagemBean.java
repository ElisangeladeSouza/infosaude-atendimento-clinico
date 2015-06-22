package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Triagem;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.TriagemService;
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
public class TriagemBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Triagem triagem;

    @Inject
    private TriagemService triagemService;

    @Inject
    private Triagem triagemSelecionada;

    private transient List<Triagem> triagens;

    /**
     *
     */
    public TriagemBean() {
    }

    /**
     *
     * @return
     */
    public List<Triagem> getTriagens() {
        this.triagens = triagemService.findAll();
        return triagens;
    }

    /**
     *
     * @throws UBSException
     */
    public void salvar() throws UBSException {
        this.triagemService.save(triagem);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Atualização do cadastro efetuada com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        triagem = new Triagem();
    }

    /**
     *
     * @throws UBSException
     */
    public void excluir() throws UBSException {
        this.triagemService.delete(triagemSelecionada);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
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

    /**
     *
     * @return
     */
    public Triagem getTriagemSelecionada() {
        return triagemSelecionada;
    }

    /**
     *
     * @param triagemSelecionada
     */
    public void setTriagemSelecionada(Triagem triagemSelecionada) {
        this.triagemSelecionada = triagemSelecionada;
    }

    /**
     *
     * @return
     */
    public Triagem getTriagem() {
        return triagem;
    }

    /**
     *
     * @param triagem
     */
    public void setTriagem(Triagem triagem) {
        this.triagem = triagem;
    }

    /**
     *
     * @return
     */
    public TriagemService getTriagemService() {
        return triagemService;
    }

    /**
     *
     * @param triagemService
     */
    public void setTriagemService(TriagemService triagemService) {
        this.triagemService = triagemService;
    }

}
