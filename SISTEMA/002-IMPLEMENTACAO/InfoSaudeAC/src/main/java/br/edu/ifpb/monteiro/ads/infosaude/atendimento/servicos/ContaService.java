package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.ContaDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Conta;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author elisangela
 */
public class ContaService implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private ContaDao contaDao;
    
    @Transactional
    public void save(Conta conta) throws UBSException {
        this.contaDao.salvar(conta);
    }
    
    @Transactional
    public void delete(Conta conta) throws UBSException {
        contaDao.delete(findById(conta.getId()));
    }
    
    public Conta findById(Long id) {
        return contaDao.findById(id);
    }
    
    public List<Conta> findAll() {
        return contaDao.findAll();
    }
}
