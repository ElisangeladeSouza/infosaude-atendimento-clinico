package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaAtendimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.FichaAtendimentoService;
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
public class FichaAtendimentoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private FichaAtendimento fichaAtendimento;

    @Inject
    private FichaAtendimentoService fichaAtendimentoService;

    @Inject
    private FichaAtendimento fichaAtendimentoSelecionado;

    private transient List<FichaAtendimento> fichaAtendimentos;

    public FichaAtendimentoBean() {
    }

    public List<FichaAtendimento> getFichaAtendimentos() {
        this.fichaAtendimentos = fichaAtendimentoService.findAll();
        return fichaAtendimentos;
    }

    public void salvar() throws UBSException {
        this.fichaAtendimentoService.save(fichaAtendimento);
        fichaAtendimento = new FichaAtendimento();
        FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
    }

    public void excluir() throws UBSException {
        this.fichaAtendimentoService.delete(fichaAtendimentoSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */
    public boolean getEditando() {
        return this.fichaAtendimento.getId() != null;
    }

    public FichaAtendimento getFichaAtendimentoSelecionado() {
        return fichaAtendimentoSelecionado;
    }

    public void setFichaAtendimentoSelecionado(FichaAtendimento fichaAtendimentoSelecionado) {
        this.fichaAtendimentoSelecionado = fichaAtendimentoSelecionado;
    }

    public FichaAtendimento getFichaAtendimento() {
        return fichaAtendimento;
    }

    public void setFichaAtendimento(FichaAtendimento fichaAtendimento) {
        this.fichaAtendimento = fichaAtendimento;
    }

    public FichaAtendimentoService getFichaAtendimentoService() {
        return fichaAtendimentoService;
    }

    public void setFichaAtendimentoService(FichaAtendimentoService fichaAtendimentoService) {
        this.fichaAtendimentoService = fichaAtendimentoService;
    }
}
