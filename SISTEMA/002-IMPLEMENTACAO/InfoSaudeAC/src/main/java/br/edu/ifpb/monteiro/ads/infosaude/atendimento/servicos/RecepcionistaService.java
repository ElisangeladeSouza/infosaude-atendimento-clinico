package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.RecepcionistaDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Recepcionista;
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
public class RecepcionistaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private RecepcionistaDao recepcionistaDAO;

    public RecepcionistaService() {
    }

    @Transactional
    public void save(Recepcionista recepcionista) {
        recepcionistaDAO.salvar(recepcionista);
    }

    @Transactional
    public void delete(Recepcionista recepcionista) throws UBSException {
        recepcionista = findById(recepcionista.getId());
        recepcionistaDAO.delete(recepcionista);
    }

    public List<Recepcionista> findAll() {
        return recepcionistaDAO.findAll();
    }

    public Recepcionista findById(Long id) {
        return recepcionistaDAO.findById(id);
    }

}
