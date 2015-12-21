package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Consulta;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.ConsultaService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Managed bean usado pela página de cadastro de consulta.
 * É responsável por ligar a classe de modelo Consulta à página de visualização 
 * processando as solicitações do usuário e retornando os dados à visualização.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
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
     * Construtor da classe
     */
    public ConsultaBean() {
    }
    
    @PostConstruct
    public void init() {
        this.consultas = consultaService.findAll();
    }

    /**
     * Lista de consultas feitas na UBS.
     * 
     * @return
     */
    public List<Consulta> getConsultas() {
        return consultas;
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do tipo
     * Consulta e salvar. 
     */
    public void salvar() {
        this.consultaService.save(consulta);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro da consulta '" + consulta.getCodigo() + "' atualizado com sucesso!");
            FacesUtil.redirecionaPara("PesquisaConsulta.xhtml");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        consulta = new Consulta();
    }

    /**
     * Método responsável por excluir um objeto do tipo Consulta e exibir
     * ao final do processo uma mensagem informativa.
     * 
     * @throws NegocioException
     */
    public void excluir() throws NegocioException {
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
