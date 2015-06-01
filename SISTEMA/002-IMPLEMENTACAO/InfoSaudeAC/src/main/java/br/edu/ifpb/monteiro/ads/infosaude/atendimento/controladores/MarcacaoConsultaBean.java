package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.MarcacaoConsulta;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.MarcacaoConsultaService;
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
public class MarcacaoConsultaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private static final Log log = LogFactory.getLog(MarcacaoConsultaBean.class);

    @Inject
    private MarcacaoConsulta marcacaoConsulta;

    @Inject
    private MarcacaoConsultaService marcacaoConsultaService;

    @Inject
    private MarcacaoConsulta marcacaoConsultaSelecionado;

    private transient List<MarcacaoConsulta> marcacaoConsultas;

    public MarcacaoConsultaBean() {
    }

    public List<MarcacaoConsulta> getMarcacaoConsultas() {
        this.marcacaoConsultas = marcacaoConsultaService.findAll();
        return marcacaoConsultas;
    }

    public void salvar() throws UBSException {
        try {
            this.marcacaoConsultaService.save(marcacaoConsulta);
            marcacaoConsulta = new MarcacaoConsulta();
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        } catch (RollbackException ex) {
            FacesUtil.mensagemErro("O CPF informado já está cadastrado. Informe outro CPF.");
            log.warn("O CPF informado já está cadastrado. Informe outro CPF.");
        }
    }

    public void excluir() throws UBSException {
        this.marcacaoConsultaService.delete(marcacaoConsultaSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */
    public boolean getEditando() {
        return this.marcacaoConsulta.getId() != null;
    }

    public MarcacaoConsulta getMarcacaoConsultaSelecionado() {
        return marcacaoConsultaSelecionado;
    }

    public void setMarcacaoConsultaSelecionado(MarcacaoConsulta marcacaoConsultaSelecionado) {
        this.marcacaoConsultaSelecionado = marcacaoConsultaSelecionado;
    }

    public MarcacaoConsulta getMarcacaoConsulta() {
        return marcacaoConsulta;
    }

    public void setMarcacaoConsulta(MarcacaoConsulta marcacaoConsulta) {
        this.marcacaoConsulta = marcacaoConsulta;
    }

    public MarcacaoConsultaService getMarcacaoConsultaService() {
        return marcacaoConsultaService;
    }

    public void setMarcacaoConsultaService(MarcacaoConsultaService marcacaoConsultaService) {
        this.marcacaoConsultaService = marcacaoConsultaService;
    }
}
