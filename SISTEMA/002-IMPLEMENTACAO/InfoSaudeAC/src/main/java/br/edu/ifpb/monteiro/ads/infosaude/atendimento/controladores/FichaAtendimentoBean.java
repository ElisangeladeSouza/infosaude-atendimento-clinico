package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Destino;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaAtendimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.FichaAtendimentoService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
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
    private FichaAtendimento fichaAtendimentoSelecionada;

    private transient List<FichaAtendimento> fichaAtendimentos;

    private transient List<Destino> destinos = new ArrayList<>();

    /**
     *
     */
    public FichaAtendimentoBean() {
        this.destinos = Arrays.asList(Destino.values());
    }

    @PostConstruct
    public void init() {
        if (fichaAtendimentos != null) {
            this.fichaAtendimentos = fichaAtendimentoService.findAll();
        }
    }

    /**
     *
     * @return
     */
    public List<Destino> getDestinos() {
        return destinos;
    }

    /**
     *
     * @return
     */
    public List<FichaAtendimento> getFichaAtendimentos() {
        return fichaAtendimentos;
    }

    /**
     *
     * @throws UBSException
     */
    public void salvar() throws UBSException {
        this.fichaAtendimentoService.save(fichaAtendimento);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro da ficha de atendimento nº '" + fichaAtendimento.getCodigo() + "' atualizado com sucesso!");
            FacesUtil.redirecionaPara("PesquisaFichaAtendimento.xhtml");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        fichaAtendimento = new FichaAtendimento();
    }

    /**
     *
     * @throws UBSException
     */
    public void excluir() throws UBSException {
        this.fichaAtendimentoService.delete(fichaAtendimentoSelecionada);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.fichaAtendimento.getId() != null;
    }

    /**
     *
     * @return
     */
    public FichaAtendimento getFichaAtendimentoSelecionada() {
        return fichaAtendimentoSelecionada;
    }

    public void setFichaAtendimentoSelecionada(FichaAtendimento fichaAtendimentoSelecionada) {
        this.fichaAtendimentoSelecionada = fichaAtendimentoSelecionada;
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
