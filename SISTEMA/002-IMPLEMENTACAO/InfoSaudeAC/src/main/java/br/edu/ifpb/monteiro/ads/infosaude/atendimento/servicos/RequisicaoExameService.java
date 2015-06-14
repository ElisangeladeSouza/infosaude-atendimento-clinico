package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.RequisicaoExameDao;
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

    public RequisicaoExameService() {
    }

    @Transactional
    public void save(RequisicaoExame requisicaoExame) {
        this.requisicaoExameDao.salvar(requisicaoExame);
    }

    @Transactional
    public void delete(RequisicaoExame requisicaoExame) throws UBSException {
        requisicaoExameDao.delete(findById(requisicaoExame.getId()));
    }

    public List<RequisicaoExame> findAll() {
        return requisicaoExameDao.findAll();
    }

    public RequisicaoExame findById(Long id) {
        return requisicaoExameDao.findById(id);
    }

}