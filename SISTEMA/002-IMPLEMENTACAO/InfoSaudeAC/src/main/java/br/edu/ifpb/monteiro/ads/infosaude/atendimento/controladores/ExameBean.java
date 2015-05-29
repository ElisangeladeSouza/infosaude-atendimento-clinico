package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Exame;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.ExameService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.RollbackException;

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

    public ExameBean() {
    }

    public List<Exame> getExames() {
        this.exames = exameService.findAll();
        return exames;
    }

    public void salvar() throws UBSException {
        try {
            this.exameService.save(exame);
            exame = new Exame();
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        } catch (RollbackException ex) {
            FacesUtil.mensagemErro("O CPF informado já está cadastrado. Informe outro CPF.");
        }
    }

    public void excluir() throws UBSException {
        this.exameService.delete(exameSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */
    public boolean getEditando() {
        return this.exame.getId() != null;
    }

    public Exame getExameSelecionado() {
        return exameSelecionado;
    }

    public void setExameSelecionado(Exame exameSelecionado) {
        this.exameSelecionado = exameSelecionado;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public ExameService getExameService() {
        return exameService;
    }

    public void setExameService(ExameService exameService) {
        this.exameService = exameService;
    }

}
