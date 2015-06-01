package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.TecnicoEnfermagem;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.TecnicoEnfermagemService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.RollbackException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elisangela
 */
@Model
public class TecnicoEnfermagemBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private static final Log log = LogFactory.getLog(TecnicoEnfermagemBean.class);

    @Inject
    private TecnicoEnfermagem tecnicoEnfermagem;

    @Inject
    private TecnicoEnfermagemService tecnicoEnfermagemService;

    @Inject
    private TecnicoEnfermagem tecnicoEnfermagemSelecionado;

    @Inject
    private PessoaBean pessoaBean;

    private transient List<TecnicoEnfermagem> tecnicos;

    private transient List<Estados> estados = new ArrayList<>();
    private transient List<String> cidades = new ArrayList<>();

    public TecnicoEnfermagemBean() {
        estados = Arrays.asList(Estados.values());
    }

    public List<Estados> getEstados() {
        return estados;
    }

    public void setEstados(List<Estados> estados) {
        this.estados = estados;
    }

    public List<String> getCidades() {
        return cidades;
    }

    public void setCidades(List<String> cidades) {
        this.cidades = cidades;
    }

    public void carregarCidades() {
        cidades.clear();
        for (String cidadesFiltradas : pessoaBean.retornaCidades(tecnicoEnfermagem.getEnderecoEstado().getCodigo())) {
            cidades.add(cidadesFiltradas);
        }
    }

    public List<TecnicoEnfermagem> getTecnicos() {
        this.tecnicos = tecnicoEnfermagemService.findAll();
        return tecnicos;
    }

    public void salvar() throws UBSException {
        try {
            this.tecnicoEnfermagemService.save(tecnicoEnfermagem);
            tecnicoEnfermagem = new TecnicoEnfermagem();
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        } catch (RollbackException ex) {
            FacesUtil.mensagemErro("O CPF informado já está cadastrado. Informe outro CPF.");
            log.warn("O CPF informado já está cadastrado. Informe outro CPF.");
        }
    }

    public void excluir() throws UBSException {
        this.tecnicoEnfermagemService.delete(tecnicoEnfermagemSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
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
        return tecnicoEnfermagemService;
    }

    public void setTecnicoEnfermagemService(TecnicoEnfermagemService tecnicoEnfermagemService) {
        this.tecnicoEnfermagemService = tecnicoEnfermagemService;
    }

}
