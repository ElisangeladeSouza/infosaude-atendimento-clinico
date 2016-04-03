package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Gestante;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.GestanteService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.GestanteServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.PessoaServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * Managed bean usado pela página de cadastro de gestante. É responsável por
 * ligar a classe de modelo Gestante à página de visualização processando as
 * solicitações do usuário e retornando os dados à visualização.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class GestanteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Gestante gestante;

    @Inject
    private GestanteServiceIF gestanteService;

    @Inject
    private Gestante gestanteSelecionada;

    @Inject
    private PessoaServiceIF pessoaService;

    private transient List<Gestante> gestantes;

    /**
     * Construtor da classe
     */
    public GestanteBean() {
    }

    @PostConstruct
    public void init() {
        this.gestantes = gestanteService.findAll();
    }

    /**
     * Lista de gestantes cadastrados na UBS.
     *
     * @return
     */
    public List<Gestante> getGestantes() {
        return gestantes;
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Gestante e salvar. Se algum erro ocorrer, deve-se fazer rollback e
     * apresentar uma mensagem de erro.
     *
     * @throws NegocioException
     */
    public void salvar() throws NegocioException {
        this.gestanteService.save(gestante);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro da gestante '" + gestante.getPaciente().getId() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("PesquisaGestante.xhtml");
        gestante = new Gestante();
    }

    /**
     * Método responsável por excluir um objeto do tipo Gestante e exibir ao
     * final do processo uma mensagem informativa.
     *
     * @throws NegocioException
     */
    public void excluir() throws NegocioException {
        this.gestanteService.delete(gestanteSelecionada);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
        FacesUtil.redirecionaPara("PesquisaGestante.xhtml");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro e retorna true, senao refere-se a um produto
     * a ser editado, retornando false.
     *
     * @return
     */
    public boolean getEditando() {
        return this.gestante.getId() != null;
    }

    public Gestante getGestante() {
        return gestante;
    }

    public void setGestante(Gestante gestante) {
        this.gestante = gestante;
    }

    public Gestante getGestanteSelecionada() {
        return gestanteSelecionada;
    }

    public void setGestanteSelecionada(Gestante gestanteSelecionada) {
        this.gestanteSelecionada = gestanteSelecionada;
    }

    public GestanteService getGestanteService() {
        return (GestanteService) gestanteService;
    }

    public void setGestanteService(GestanteService gestanteService) {
        this.gestanteService = gestanteService;
    }
}
