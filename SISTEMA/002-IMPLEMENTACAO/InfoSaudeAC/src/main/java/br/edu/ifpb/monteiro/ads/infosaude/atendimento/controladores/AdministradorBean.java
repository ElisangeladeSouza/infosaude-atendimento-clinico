package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Administrador;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.AdministradorService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.PessoaService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.AdministradorServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.RollbackException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * * Managed bean usado pela página de cadastro de adminsitrador.
 * É responsável por ligar a classe de modelo Administrador à página de 
 * visualização processando as solicitações do usuário e retornando os dados à 
 * visualização.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class AdministradorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(AdministradorBean.class);

    @Inject
    private Administrador administrador;

    @Inject
    private AdministradorServiceIF administradorService;

    @Inject
    private Administrador administradorSelecionado;

    @Inject
    private PessoaService pessoaService;

    private transient List<Administrador> administradores;

    /**
     * Construtor da classe
     */
    public AdministradorBean() {
    }
    
    @PostConstruct
    public void init() {
        this.administradores = administradorService.findAll();
    }

    /**
     * Método responsável por carregar uma lista com todas as cidades cadastradas.
     * Esta lista será usada para preencher o respectivo campo de cidade na view.
     */
    public void carregarCidades() {
        PessoaBean.cidades.clear();
        if (administrador.getEnderecoEstado() != null) {
            for (String cidadesFiltradas : pessoaService.retornaCidades(administrador.getEnderecoEstado().getCodigo())) {
                PessoaBean.cidades.add(cidadesFiltradas);
            }
        }
    }

    /**
     * Lista de administradores da UBS.
     * @return
     */
    public List<Administrador> getAdministradores() {
        return administradores;
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do tipo
     * Administrador e salvar. Se algum erro ocorrer, deve-se fazer rollback e 
     * apresentar uma mensagem de erro.
     * 
     * @throws NegocioException
     */
    public void salvar() throws NegocioException {
        try {
            this.administradorService.save(administrador);
            if (getEditando()) {
                FacesUtil.mensagemSucesso("Cadastro do administrador '" + administrador.getNome() + "' atualizado com sucesso!");
                FacesUtil.redirecionaPara("PesquisaAdministrador.xhtml");
            } else {
                FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
            }
            administrador = new Administrador();
        } catch (RollbackException rollback) {
            FacesUtil.mensagemErro("O CPF informado já está cadastrado. Informe outro CPF.");
            LOGGER.warn(rollback);
        }
    }

    /**
     * Método responsável por excluir um objeto do tipo Administrador e exibir
     * ao final do processo uma mensagem informativa.
     * 
     * @throws NegocioException
     */
    public void excluir() throws NegocioException {
        this.administradorService.delete(administradorSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
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
        return (AdministradorService) administradorService;
    }

    public void setAdministradorService(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }
}
