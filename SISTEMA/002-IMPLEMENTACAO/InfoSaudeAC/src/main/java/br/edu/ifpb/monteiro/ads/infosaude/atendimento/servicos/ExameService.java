package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.ExameDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Exame;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elisangela
 */
public class ExameService implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(ExameService.class);

    @Inject
    private ExameDao exameDao;

    public ExameService() {
    }

    @Transactional
    public void save(Exame exame) {
        if (exame != null) {
            exame.setData(new DateTimeUtilBean().getDateToday());
            this.exameDao.salvar(exame);
        }
    }

    /**
     *
     * @param exame
     * @throws NegocioException
     */
    @Transactional
    public void delete(Exame exame) throws NegocioException {
        exameDao.delete(findById(exame.getId()));
    }

    /**
     *
     * @param id
     * @return
     */
    public Exame findById(Long id) {
        return exameDao.findById(id);
    }

    /**
     *
     * @return
     */
    public List<Exame> findAll() {
        return exameDao.findAll();
    }

    public boolean verificaCampoUnique(String campo, Object valor, Long id) throws NegocioException {
        try {
            Exame exame;
            if (id == null) {
                exame = exameDao.buscarPorCampo(campo, valor);
                if (exame != null) {
                    throw new NegocioException("A " + campo.toUpperCase() + " informada pertence a outro cadastro.");
                }
            } else {
                exame = exameDao.buscarPorCampo(campo, valor);
                if (exame != null && id.equals(exame.getId())) {
                    throw new NegocioException("A " + campo.toUpperCase() + " informada pertence a outro cadastro.");
                }
                return true;
            }
        } catch (NoResultException ex) {
            LOGGER.info("Infomação não encontrada");
        }
        return true;
    }

}
