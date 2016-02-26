package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Exame;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.ExameService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.ExameServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * Managed bean usado pela página de cadastro de exame. 
 * É responsável por ligar a classe de modelo Exame à página de visualização 
 * processando as solicitações do usuário e retornando os dados à visualização.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class ExameBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Exame exame;

    @Inject
    private ExameServiceIF exameService;

    @Inject
    private Exame exameSelecionado;

    private transient List<Exame> exames;

    /**
    * Construtor da classe
    */
    public ExameBean() {
    }

    @PostConstruct
    public void init() {
        this.exames = exameService.findAll();
    }

    public List<Exame> getExames() {
        return exames;
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do tipo
     * Exame e salvar. Se algum erro ocorrer, deve-se fazer rollback e 
     * apresentar uma mensagem de erro. 
     * 
     * @throws NegocioException
     */
    public void salvar() throws NegocioException {
        exameService.checaCampoDuplicado("descricao", exame.getDescricao(), null, exame);
        this.exameService.save(exame);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro do exame '" + exame.getDescricao() + "' atualizado com sucesso!");
            FacesUtil.redirecionaPara("PesquisaExame.xhtml");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        exame = new Exame();
    }

    /**
     * Método responsável por excluir um objeto do tipo Exame e exibir
     * ao final do processo uma mensagem informativa.
     * 
     * @throws NegocioException
     */
    public void excluir() throws NegocioException {
        this.exameService.delete(exameSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
        FacesUtil.redirecionaPara("PesquisaExame.xhtml");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.exame.getId() != null;
    }

    public Exame getExameSelecionado() {
        return exameSelecionado;
    }

    public void setExameSelecionado(Exame exameSelecionado) {
        this.exameSelecionado = exameSelecionado;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public ExameService getExameService() {
        return (ExameService) exameService;
    }

    public void setExameService(ExameService exameService) {
        this.exameService = (ExameServiceIF) exameService;
    }
}
