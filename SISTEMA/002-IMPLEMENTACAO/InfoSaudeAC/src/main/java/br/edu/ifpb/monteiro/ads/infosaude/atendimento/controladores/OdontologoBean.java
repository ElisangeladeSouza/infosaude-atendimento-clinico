package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Odontologo;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.OdontologoService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.PessoaService;
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
 * Managed bean usado pela página de cadastro de odontólogo. 
 * É responsável por ligar a classe de modelo Odontologo à página de visualização 
 * processando as solicitações do usuário e retornando os dados à visualização.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class OdontologoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(OdontologoBean.class);

    @Inject
    private Odontologo odontologo;

    @Inject
    private OdontologoService odontologoService;

    @Inject
    private Odontologo odontologoSelecionado;

    @Inject
    private PessoaService pessoaService;

    private transient List<Odontologo> odontologos;

    /**
     * Construtor da classe
     */
    public OdontologoBean() {
    }

    @PostConstruct
    public void init() {
        this.odontologos = odontologoService.findAll();
    }

    /**
     * Método responsável por carregar uma lista com todas as cidades cadastradas.
     * Esta lista será usada para preencher o respectivo campo de cidade na view.
     */
    public void carregarCidades() {
        PessoaBean.cidades.clear();
        if (odontologo.getEnderecoEstado() != null) {
            for (String cidadesFiltradas : pessoaService.retornaCidades(odontologo.getEnderecoEstado().getCodigo())) {
                PessoaBean.cidades.add(cidadesFiltradas);
            }
        }
    }

    /**
     * Lista de odontólogos cadastrados na UBS.
     * @return
     */
    public List<Odontologo> getOdontologos() {
        return odontologos;
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do tipo
     * Odontologo e salvar. Se algum erro ocorrer, deve-se fazer rollback e 
     * apresentar uma mensagem de erro.
     * 
     * @throws NegocioException
     */
    public void salvar() throws NegocioException {
        try {
            this.odontologoService.save(odontologo);
            if (getEditando()) {
                FacesUtil.mensagemSucesso("Cadastro do odontólogo '" + odontologo.getNome() + "' atualizado com sucesso!");
                FacesUtil.redirecionaPara("PesquisaOdontologo.xhtml");
            } else {
                FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
            }
            odontologo = new Odontologo();
        } catch (RollbackException rollback) {
            FacesUtil.mensagemErro("O CPF informado já está cadastrado. Informe outro CPF.");
            LOGGER.warn(rollback);
        }
    }

    /**
     * Método responsável por excluir um objeto do tipo Odontologo e exibir
     * ao final do processo uma mensagem informativa.
     * 
     * @throws NegocioException
     */
    public void excluir() throws NegocioException {
        this.odontologoService.delete(odontologoSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.odontologo.getId() != null;
    }

    public Odontologo getOdontologoSelecionado() {
        return odontologoSelecionado;
    }

    public void setOdontologoSelecionado(Odontologo odontologoSelecionado) {
        this.odontologoSelecionado = odontologoSelecionado;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public OdontologoService getOdontologoService() {
        return odontologoService;
    }

    public void setOdontologoService(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }
}
