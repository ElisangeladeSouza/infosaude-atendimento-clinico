package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.RequisicaoExameDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.RequisicaoExame;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 * Classe de serviço que faz chamadas aos métodos de persistência e pode conter
 * lógica de negócio e pode fazer chamadas a outras partes do sistema, caso
 * necessite.
 *
 * @author Cássio Oliveira
 */
public class RequisicaoExameService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private RequisicaoExameDao requisicaoExameDao;

    /**
     *
     */
    public RequisicaoExameService() {
    }

    /**
     *
     * @param requisicaoExame
     */
    @Transactional
    public void save(RequisicaoExame requisicaoExame) {
            this.requisicaoExameDao.salvar(requisicaoExame);
//        if (requisicaoExame.getExames() == null) {
//            throw new NegocioException("Todos os dados devem ser inseridos corretamente");
//        } else{
//            requisicaoExame.setData(new DateTimeUtilBean().getDateToday());
//        }
    }

    /**
     *
     * @param requisicaoExame
     * @throws UBSException
     */
    @Transactional
    public void delete(RequisicaoExame requisicaoExame) throws UBSException {
        requisicaoExameDao.delete(findById(requisicaoExame.getId()));
    }

    /**
     *
     * @return
     */
    public List<RequisicaoExame> findAll() {
        return requisicaoExameDao.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public RequisicaoExame findById(Long id) {
        return requisicaoExameDao.findById(id);
    }

}
