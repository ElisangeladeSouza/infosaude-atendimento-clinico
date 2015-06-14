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
public class AdministradorBean implements Serializable {//NOSONAR

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(AdministradorBean.class);

    @Inject
    private Administrador administrador;

    @Inject
    private AdministradorService administradorService;

    @Inject
    private Administrador administradorSelecionado;

    @Inject
    private PessoaBean pessoaBean;

    private transient List<Administrador> administradores;

    public AdministradorBean() {//NOSONAR
    }

    public void carregarCidades() {//NOSONAR
        PessoaBean.cidades.clear();
        for (String cidadesFiltradas : pessoaBean.retornaCidades(administrador.getEnderecoEstado().getCodigo())) {
            PessoaBean.cidades.add(cidadesFiltradas);
        }
    }

    public List<Administrador> getAdministradores() {//NOSONAR
        this.administradores = administradorService.findAll();
        return administradores;
    }

    public void salvar() throws UBSException {
        try {
            this.administradorService.save(administrador);
            administrador = new Administrador();
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        } catch (RollbackException rollback) {
            FacesUtil.mensagemErro("O CPF informado já está cadastrado. Informe outro CPF.");
            LOGGER.warn(rollback);
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
    public boolean getEditando() {//NOSONAR
        return this.administrador.getId() != null;
    }

    public Administrador getAdministradorSelecionado() {//NOSONAR
        return administradorSelecionado;
    }

    public void setAdministradorSelecionado(Administrador administradorSelecionado) {//NOSONAR
        this.administradorSelecionado = administradorSelecionado;
    }

    public Administrador getAdministrador() {//NOSONAR
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {//NOSONAR
        this.administrador = administrador;
    }

    public AdministradorService getAdministradorService() {//NOSONAR
        return administradorService;
    }

    public void setAdministradorService(AdministradorService administradorService) {//NOSONAR
        this.administradorService = administradorService;
    }

}//NOSONAR
