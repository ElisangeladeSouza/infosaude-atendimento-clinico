package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Administrador;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.AdministradorService;
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
public class AdministradorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Administrador administrador;

    @Inject
    private AdministradorService administradorService;

    @Inject
    private Administrador administradorSelecionado;

    @Inject
    private PessoaBean pessoaBean;

    private transient List<Administrador> administradores;

    private transient List<Estados> estados = new ArrayList<>();
    private final transient List<String> cidades = new ArrayList<>();

    public AdministradorBean() {
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
        for (String cidadesFiltradas : pessoaBean.retornaCidades(administrador.getEnderecoEstado().getCodigo())) {
            cidades.add(cidadesFiltradas);
        }
    }

    public List<Administrador> getAdministradores() {
        this.administradores = administradorService.findAll();
        return administradores;
    }

    public void salvar() throws UBSException {
        try {
            this.administradorService.save(administrador);
            administrador = new Administrador();
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        } catch (RollbackException ex) {
            FacesUtil.mensagemErro("O CPF informado já está cadastrado. Informe outro CPF.");
        }
    }

    public void excluir() throws UBSException {
        this.administradorService.delete(administradorSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */
    public boolean getEditando() {
        return this.administrador.getId() != null;
    }

    public Administrador getAdministradorSelecionado() {
        return administradorSelecionado;
    }

    public void setAdministradorSelecionado(Administrador administradorSelecionado) {
        this.administradorSelecionado = administradorSelecionado;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public AdministradorService getAdministradorService() {
        return administradorService;
    }

    public void setAdministradorService(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

}
