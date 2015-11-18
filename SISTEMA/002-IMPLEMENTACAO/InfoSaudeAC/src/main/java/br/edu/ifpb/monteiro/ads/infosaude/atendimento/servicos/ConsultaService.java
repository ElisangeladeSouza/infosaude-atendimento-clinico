package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.ConsultaDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
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

    /**
     *
     */
    public ConsultaService() {
    }

    /**
     *
     * @param consulta
     */
    @Transactional
    public void save(Consulta consulta) {
        if (consulta != null) {
            consulta.setData(new DateTimeUtilBean().getDateToday());
            this.consultaDao.salvar(consulta);
        }
    }

    /**
     *
     * @param consulta
     * @throws NegocioException
     */
    @Transactional
    public void delete(Consulta consulta) throws NegocioException {
        consultaDao.delete(findById(consulta.getId()));
    }

    /**
     *
     * @param id
     * @return
     */
    public Consulta findById(Long id) {
        return consultaDao.findById(id);
    }

    /**
     *
     * @return
     */
    public List<Consulta> findAll() {
        return consultaDao.findAll();
    }

}
