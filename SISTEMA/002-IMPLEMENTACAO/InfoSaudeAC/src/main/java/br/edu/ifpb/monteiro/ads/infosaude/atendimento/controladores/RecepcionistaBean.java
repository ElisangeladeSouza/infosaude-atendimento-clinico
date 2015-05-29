package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Recepcionista;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.RecepcionistaService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.RollbackException;

/**
 *
 * @author elisangela
 */
@Model
public class RecepcionistaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Recepcionista recepcionista;

    @Inject
    private RecepcionistaService recepcionistaService;

    @Inject
    private Recepcionista recepcionistaSelecionado;

    @Inject
    private PessoaBean pessoaBean;

    private transient List<Recepcionista> recepcionistas;

    private transient List<Estados> estados = new ArrayList<>();
    private final transient List<String> cidades = new ArrayList<>();

    public RecepcionistaBean() {
        estados = Arrays.asList(Estados.values());
    }

    public List<Estados> getEstados() {
        return estados;
    }

    public List<String> getCidades() {
        return cidades;
    }

    public void carregarCidades() {
        cidades.clear();
        for (String cidadesFiltradas : pessoaBean.retornaCidades(recepcionista.getEnderecoEstado().getCodigo())) {
            cidades.add(cidadesFiltradas);
        }
    }

    public List<Recepcionista> getRecepcionistas() {
        this.recepcionistas = recepcionistaService.findAll();
        return recepcionistas;
    }

    public void salvar() throws UBSException {
        try {
            this.recepcionistaService.save(recepcionista);
            recepcionista = new Recepcionista();
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        } catch (RollbackException ex) {
            FacesUtil.mensagemErro("O CPF informado já está cadastrado. Informe outro CPF.");
        }
    }

    public void excluir() throws UBSException {
        this.recepcionistaService.delete(recepcionistaSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */
    public boolean getEditando() {
        return this.recepcionista.getId() != null;
    }

    public Recepcionista getRecepcionistaSelecionado() {
        return recepcionistaSelecionado;
    }

    public void setRecepcionistaSelecionado(Recepcionista recepcionistaSelecionado) {
        this.recepcionistaSelecionado = recepcionistaSelecionado;
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

    public RecepcionistaService getRecepcionistaService() {
        return recepcionistaService;
    }

    public void setRecepcionistaService(RecepcionistaService recepcionistaService) {
        this.recepcionistaService = recepcionistaService;
    }

}
