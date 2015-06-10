package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.ConsultaDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Consulta;
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
public class ConsultaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ConsultaDao consultaDao;

    public ConsultaService() {
    }

    @Transactional
    public void save(Consulta consulta) {
        this.consultaDao.salvar(consulta);
    }

    @Transactional
    public void delete(Consulta consulta) throws UBSException {
        consultaDao.delete(findById(consulta.getId()));
    }

    public Consulta findById(Long id) {
        return consultaDao.findById(id);
    }

    public List<Consulta> findAll() {
        return consultaDao.findAll();
    }

}