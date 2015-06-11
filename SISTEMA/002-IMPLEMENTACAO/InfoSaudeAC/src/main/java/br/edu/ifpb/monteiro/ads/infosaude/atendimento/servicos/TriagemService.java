package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.TriagemDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Triagem;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 * Classe de serviço que faz chamadas aos métodos de persistência e pode conter
 * lógica de negócio e pode fazer chamadas a outras partes do sistema, caso
 * necessite.
 * 
 * @author elisangela
 */
public class TriagemService implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Inject
    private TriagemDao triagemDao;

    public TriagemService() {
    }

    @Transactional
    public void save(Triagem triagem) {
        this.triagemDao.salvar(triagem);
    }

    @Transactional
    public void delete(Triagem triagem) throws UBSException {
        triagemDao.delete(findById(triagem.getId()));
    }

    public Triagem findById(Long id) {
        return triagemDao.findById(id);
    }

    public List<Triagem> findAll() {
        return triagemDao.findAll();
    }
    
}
