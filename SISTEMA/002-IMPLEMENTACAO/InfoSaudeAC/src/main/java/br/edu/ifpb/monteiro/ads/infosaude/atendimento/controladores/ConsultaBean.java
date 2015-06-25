package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Consulta;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.ConsultaService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elisangela
 */
@Model
public class ConsultaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(ConsultaBean.class);

    @Inject
    private Consulta consulta;

    @Inject
    private ConsultaService consultaService;

    @Inject
    private Consulta consultaSelecionada;

    private transient List<Consulta> consultas;

    /**
     *
     */
    public ConsultaBean() {
    }

    /**
     *
     * @return
     */
    public List<Consulta> getConsultas() {
        this.consultas = consultaService.findAll();
        return consultas;
    }

    /**
     *
     */
    public void salvar() {
        this.consultaService.save(consulta);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro da consulta '"+consulta.getCodigo()+"' atualizado com sucesso!");
            FacesUtil.redirecionaPara("PesquisaConsulta.xhtml");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        consulta = new Consulta();
    }

    /**
     *
     * @throws UBSException
     */
    public void excluir() throws UBSException {
        this.consultaService.delete(consultaSelecionada);
        LOGGER.info("Exclusão de consulta efetuada.");
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.consulta.getId() != null;
    }

    /**
     *
     * @return
     */
    public Consulta getConsultaSelecionada() {
        return consultaSelecionada;
    }

    public void setConsultaSelecionada(Consulta consultaSelecionada) {
        this.consultaSelecionada = consultaSelecionada;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public ConsultaService getConsultaService() {
        return consultaService;
    }

    public void setConsultaService(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }
}
