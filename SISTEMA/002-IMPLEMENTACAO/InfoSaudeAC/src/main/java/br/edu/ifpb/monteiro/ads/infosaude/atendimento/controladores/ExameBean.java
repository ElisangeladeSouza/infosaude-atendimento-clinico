package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Exame;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.ExameService;
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
public class ExameBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Exame exame;

    @Inject
    private ExameService exameService;

    @Inject
    private Exame exameSelecionado;

    private transient List<Exame> exames;

    /**
     *
     */
    public ExameBean() {
    }

    /**
     *
     * @return
     */
    public List<Exame> getExames() {
        this.exames = exameService.findAll();
        return exames;
    }

    /**
     *
     * @throws UBSException
     */
    public void salvar() throws UBSException {
        this.exameService.save(exame);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Atualização do cadastro efetuada com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        exame = new Exame();
    }

    /**
     *
     * @throws UBSException
     */
    public void excluir() throws UBSException {
        this.exameService.delete(exameSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */

    /**
     *
     * @return
     */
    
    public boolean getEditando() {
        return this.exame.getId() != null;
    }

    /**
     *
     * @return
     */
    public Exame getExameSelecionado() {
        return exameSelecionado;
    }

    /**
     *
     * @param exameSelecionado
     */
    public void setExameSelecionado(Exame exameSelecionado) {
        this.exameSelecionado = exameSelecionado;
    }

    /**
     *
     * @return
     */
    public Exame getExame() {
        return exame;
    }

    /**
     *
     * @param exame
     */
    public void setExame(Exame exame) {
        this.exame = exame;
    }

    /**
     *
     * @return
     */
    public ExameService getExameService() {
        return exameService;
    }

    /**
     *
     * @param exameService
     */
    public void setExameService(ExameService exameService) {
        this.exameService = exameService;
    }

}
