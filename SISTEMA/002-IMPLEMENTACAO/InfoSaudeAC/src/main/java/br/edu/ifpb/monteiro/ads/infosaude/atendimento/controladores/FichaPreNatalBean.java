package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.TempoGestacional;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.TipoGravidez;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaPreNatal;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.FichaPreNatalServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * Managed bean usado pela página de cadastro de ficha de pré-natal. 
 * É responsável por ligar a classe de modelo FichaPreNatal à página de visualização 
 * processando as solicitações do usuário e retornando os dados à visualização.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class FichaPreNatalBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private FichaPreNatal fichaPreNatal;
    
    @Inject
    private FichaPreNatalServiceIF fichaPreNatalService;
    
    @Inject
    private FichaPreNatal fichaPreNatalSelecionada;
    
    private transient List<FichaPreNatal> preNatais;
    
    private final transient List<TipoGravidez> tiposGravidez;
    
    private final transient List<TempoGestacional> tempoGestacionais;

    /**
    * Construtor da classe
    */
    public FichaPreNatalBean() {
        tiposGravidez = Arrays.asList(TipoGravidez.values());
        tempoGestacionais = Arrays.asList(TempoGestacional.values());
    }
    
    @PostConstruct
    public void init() {
        this.preNatais = fichaPreNatalService.findAll();
    }

    public List<FichaPreNatal> getPreNatais() {
        return preNatais;
    }

    public List<TipoGravidez> getTiposGravidez() {
        return tiposGravidez;
    }

    public List<TempoGestacional> getTempoGestacionais() {
        return tempoGestacionais;
    }
    
    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do tipo
     * FichaPreNatal e salvar. Se algum erro ocorrer, deve-se fazer rollback e 
     * apresentar uma mensagem de erro. 
     * 
     * @throws NegocioException
     */
    public void salvar() throws NegocioException {
        this.fichaPreNatalService.save(fichaPreNatal);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro de ficha de pré-natal '" + fichaPreNatal.getId() + "' atualizado com sucesso!");
            FacesUtil.redirecionaPara("PesquisaFichaPreNatal.xhtml");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        fichaPreNatal = new FichaPreNatal();
    }
    
     /**
     * Método responsável por excluir um objeto do tipo FichaPreNatal e exibir
     * ao final do processo uma mensagem informativa.
     * 
     * @throws NegocioException
     */
    public void excluir() throws NegocioException {
        this.fichaPreNatalService.delete(fichaPreNatalSelecionada);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.fichaPreNatal.getId() != null;
    }

    public FichaPreNatal getFichaPreNatal() {
        return fichaPreNatal;
    }

    public void setFichaPreNatal(FichaPreNatal fichaPreNatal) {
        this.fichaPreNatal = fichaPreNatal;
    }

    public FichaPreNatalServiceIF getFichaPreNatalService() {
        return fichaPreNatalService;
    }

    public void setFichaPreNatalService(FichaPreNatalServiceIF fichaPreNatalService) {
        this.fichaPreNatalService = fichaPreNatalService;
    }

    public FichaPreNatal getFichaPreNatalSelecionada() {
        return fichaPreNatalSelecionada;
    }

    public void setFichaPreNatalSelecionada(FichaPreNatal fichaPreNatalSelecionada) {
        this.fichaPreNatalSelecionada = fichaPreNatalSelecionada;
    }
}