package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Odontologo;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.OdontologoService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.PessoaService;
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
     *
     */
    public OdontologoBean() {
    }

    /**
     *
     */
    public void carregarCidades() {
        PessoaBean.cidades.clear();
        for (String cidadesFiltradas : pessoaService.retornaCidades(odontologo.getEnderecoEstado().getCodigo())) {
            PessoaBean.cidades.add(cidadesFiltradas);
        }
    }

    /**
     *
     * @return
     */
    public List<Odontologo> getOdontologos() {
        this.odontologos = odontologoService.findAll();
        return odontologos;
    }

    /**
     *
     * @throws UBSException
     */
    public void salvar() throws UBSException {
        try {
            this.odontologoService.save(odontologo);
            if (getEditando()) {
                FacesUtil.mensagemSucesso("Atualização do cadastro efetuada com sucesso!");
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
     *
     * @throws UBSException
     */
    public void excluir() throws UBSException {
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

    /**
     *
     * @return
     */
    public Odontologo getOdontologoSelecionado() {
        return odontologoSelecionado;
    }

    /**
     *
     * @param odontologoSelecionado
     */
    public void setOdontologoSelecionado(Odontologo odontologoSelecionado) {
        this.odontologoSelecionado = odontologoSelecionado;
    }

    /**
     *
     * @return
     */
    public Odontologo getOdontologo() {
        return odontologo;
    }

    /**
     *
     * @param odontologo
     */
    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    /**
     *
     * @return
     */
    public OdontologoService getOdontologoService() {
        return odontologoService;
    }

    /**
     *
     * @param odontologoService
     */
    public void setOdontologoService(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

}
