package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Procedimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.ProcedimentoService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Model
public class ProcedimentoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Procedimento procedimento;

    @Inject
    private ProcedimentoService procedimentoService;

    @Inject
    private Procedimento procedimentoSelecionado;

    private transient List<Procedimento> procedimentos;

    /**
     *
     */
    public ProcedimentoBean() {
    }

    /**
     *
     * @return
     */
    public List<Procedimento> getProcedimentos() {
        this.procedimentos = procedimentoService.findAll();
        return procedimentos;
    }

    /**
     *
     * @throws UBSException
     */
    public void salvar() throws UBSException {
        this.procedimentoService.save(procedimento);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Atualização do cadastro efetuada com sucesso!");
            FacesUtil.redirecionaPara("PesquisaProcedimento.xhtml");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        procedimento = new Procedimento();
    }

    /**
     *
     * @throws UBSException
     */
    public void excluir() throws UBSException {
        this.procedimentoService.delete(procedimentoSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
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

    /**
     *
     * @return
     */
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
        return procedimentoService;
    }

    public void setProcedimentoService(ProcedimentoService procedimentoService) {
        this.procedimentoService = procedimentoService;
    }

}
