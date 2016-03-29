//package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;
//
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.RequisicaoExame;
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.RequisicaoExameService;
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.RequisicaoExameServiceIF;
//import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
//import java.io.Serializable;
//import java.util.List;
//import javax.annotation.PostConstruct;
//import javax.enterprise.inject.Model;
//import javax.inject.Inject;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
///**
// * Managed bean usado pela página de cadastro de requisição de exame. 
// * É responsável por ligar a classe de modelo RequisicaoExame à página de visualização 
// * processando as solicitações do usuário e retornando os dados à visualização.
// * 
// * @author elisangela <elysangeladesouza@gmail.com>
// */
//@Model
//public class RequisicaoExameBean implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    private static final Log LOGGER = LogFactory.getLog(RequisicaoExameBean.class);
//
//    @Inject
//    private RequisicaoExame requisicaoExame;
//
//    @Inject
//    private RequisicaoExameServiceIF requisicaoExameService;
//
//    @Inject
//    private RequisicaoExame requisicaoExameSelecionada;
//
//    private transient List<RequisicaoExame> requisicaoExames;
//
//    /**
//     * Construtor da classe
//     */
//    public RequisicaoExameBean() {
//    }
//
//    @PostConstruct
//    public void init() {
//        this.requisicaoExames = requisicaoExameService.findAll();
//    }
//
//    public List<RequisicaoExame> getRequisicaoExames() {
//        return requisicaoExames;
//    }
//
//    /**
//     * Método responsável por iniciar uma transação, instanciar um objeto do tipo
//     * RequisicaoExame e salvar. Se algum erro ocorrer, deve-se fazer rollback e 
//     * apresentar uma mensagem de erro.
//     * 
//     * @throws NegocioException
//     */
//    public void salvar() throws NegocioException {
//        requisicaoExameService.verificaCampoUnique("codigo", requisicaoExame.getCodigo(), null);
//        this.requisicaoExameService.save(requisicaoExame);
//        if (getEditando()) {
//            FacesUtil.mensagemSucesso("Cadastro da requisicao de exame '" + requisicaoExame.getCodigo() + "' atualizado com sucesso!");
//            FacesUtil.redirecionaPara("PesquisaRequisicaoExame.xhtml");
//        } else {
//            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
//        }
//        this.requisicaoExame = new RequisicaoExame();
//    }
//
//    /**
//     * Método responsável por excluir um objeto do tipo RequisicaoExame e exibir
//     * ao final do processo uma mensagem informativa.
//     * 
//     * @throws NegocioException
//     */
//    public void excluir() throws NegocioException {
//        this.requisicaoExameService.delete(requisicaoExameSelecionada);
//        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
//        FacesUtil.redirecionaPara("PesquisaRequisicaoExames.xhtml");
//    }
//
//    /**
//     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
//     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
//     *
//     * @return
//     */
//    public boolean getEditando() {
//        return this.requisicaoExame.getId() != null;
//    }
//
//    public RequisicaoExame getRequisicaoExameSelecionada() {
//        return requisicaoExameSelecionada;
//    }
//
//    public void setRequisicaoExameSelecionada(RequisicaoExame requisicaoExameSelecionada) {
//        this.requisicaoExameSelecionada = requisicaoExameSelecionada;
//    }
//
//    public RequisicaoExame getRequisicaoExame() {
//        return requisicaoExame;
//    }
//
//    public void setRequisicaoExame(RequisicaoExame requisicaoExame) {
//        this.requisicaoExame = requisicaoExame;
//    }
//
//    public RequisicaoExameService getRequisicaoExameService() {
//        return (RequisicaoExameService) requisicaoExameService;
//    }
//
//    public void setRequisicaoExameService(RequisicaoExameService requisicaoExameService) {
//        this.requisicaoExameService = (RequisicaoExameServiceIF) requisicaoExameService;
//    }
//}
