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

    private static final Log LOGGER = LogFactory.getLog(AdministradorBean.class);//NOPMD

    @Inject
    private Administrador administrador;

    @Inject
    private AdministradorService administradorService;

    @Inject
    private Administrador administradorSelecionado;

    @Inject
    private PessoaBean pessoaBean;

    private transient List<Administrador> administradores;

    public AdministradorBean() {//NOPMD
    }

    public void carregarCidades() {
        PessoaBean.cidades.clear();//NOPMD
        for (String cidadesFiltradas : pessoaBean.retornaCidades(administrador.getEnderecoEstado().getCodigo())) {//NOPMD
            PessoaBean.cidades.add(cidadesFiltradas);//NOPMD
        }
    }

    public List<Administrador> getAdministradores() {
        this.administradores = administradorService.findAll();//NOPMD
        return administradores;//NOPMD
    }

    public void salvar() throws UBSException {
        try {//NOPMD
            this.administradorService.save(administrador);//NOPMD
            administrador = new Administrador();//NOPMD
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");//NOPMD
        } catch (RollbackException rollback) {//NOPMD
            FacesUtil.mensagemErro("O CPF informado já está cadastrado. Informe outro CPF.");//NOPMD
            LOGGER.warn(rollback);//NOPMD
        }
    }

    public void excluir() throws UBSException {
        this.administradorService.delete(administradorSelecionado);//NOPMD
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");//NOPMD
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */
    public boolean getEditando() {
        return this.administrador.getId() != null;//NOPMD
    }

    public Administrador getAdministradorSelecionado() {
        return administradorSelecionado;//NOPMD
    }

    public void setAdministradorSelecionado(Administrador administradorSelecionado) {
        this.administradorSelecionado = administradorSelecionado;//NOPMD
    }

    public Administrador getAdministrador() {
        return administrador;//NOPMD
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;//NOPMD
    }

    public AdministradorService getAdministradorService() {
        return administradorService;//NOPMD
    }

    public void setAdministradorService(AdministradorService administradorService) {
        this.administradorService = administradorService;//NOPMD
    }

}
