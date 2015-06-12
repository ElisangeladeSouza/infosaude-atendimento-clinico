package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Administrador;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.AdministradorService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
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
public class AdministradorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(AdministradorBean.class);// NOSONAR

    @Inject
    private Administrador administrador;

    @Inject
    private AdministradorService administradorService;

    @Inject
    private Administrador administradorSelecionado;

    @Inject
    private PessoaBean pessoaBean;

    private transient List<Administrador> administradores;

    public AdministradorBean() {// NOSONAR
    }

    public void carregarCidades() {
        PessoaBean.cidades.clear();// NOSONAR
        for (String cidadesFiltradas : pessoaBean.retornaCidades(administrador.getEnderecoEstado().getCodigo())) {// NOSONAR
            PessoaBean.cidades.add(cidadesFiltradas);// NOSONAR
        }
    }

    public List<Administrador> getAdministradores() {
        this.administradores = administradorService.findAll();// NOSONAR
        return administradores;// NOSONAR
    }

    public void salvar() throws UBSException {
        try {// NOSONAR
            this.administradorService.save(administrador);// NOSONAR
            administrador = new Administrador();// NOSONAR
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");// NOSONAR
        } catch (RollbackException rollback) {// NOSONAR
            FacesUtil.mensagemErro("O CPF informado já está cadastrado. Informe outro CPF.");// NOSONAR
            LOGGER.warn(rollback);// NOSONAR
        }
    }

    public void excluir() throws UBSException {
        this.administradorService.delete(administradorSelecionado);// NOSONAR
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");// NOSONAR
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */
    public boolean getEditando() {
        return this.administrador.getId() != null;// NOSONAR
    }

    public Administrador getAdministradorSelecionado() {
        return administradorSelecionado;// NOSONAR
    }

    public void setAdministradorSelecionado(Administrador administradorSelecionado) {
        this.administradorSelecionado = administradorSelecionado;// NOSONAR
    }

    public Administrador getAdministrador() {
        return administrador;// NOSONAR
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;// NOSONAR
    }

    public AdministradorService getAdministradorService() {
        return administradorService;// NOSONAR
    }

    public void setAdministradorService(AdministradorService administradorService) {
        this.administradorService = administradorService;// NOSONAR
    }

}
