package br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.interfaces.Dao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Esta classe representa um DAO genérico e contém todos os métodos básicos para
 * efetuar um CRUD e métodos adicionais que podem ser usados por qualquer
 * entidade do sistema.
 *
 * @author cassio
 * @param <T>
 */
public abstract class DaoAbstrato<T> implements Dao<T>, Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(DaoAbstrato.class);

    @Inject
    private transient EntityManager entityManager;

    private Class<T> entity;

    public DaoAbstrato() {
    }

    /**
     * Construtor da classe que captura a entidade que chamar esta classe.
     *
     * @param entityClass
     */
    public DaoAbstrato(Class<T> entityClass) {
        this.entity = entityClass;
    }

    @Override
    public void salvar(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entity));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @Override
    public T findById(Long id) {
        return entityManager.find(entity, id);
    }

    @Override
    public T buscarPorCampo(String campo, Object valor) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> createQuery = criteriaBuilder.createQuery(entity);
            Root<T> root = createQuery.from(entity);
            Predicate predicate = criteriaBuilder.conjunction();
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.<T>get(campo), valor));
            createQuery.where(predicate);

            return entityManager.createQuery(createQuery).getSingleResult();

        } catch (NoResultException ex) {
            LOGGER.info("Infomação não encontrada" + ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean checaCampoDuplicado(String campo, Object valor, Long id, T entidade) throws NegocioException {
        try {
            if (id == null) {
                entidade = buscarPorCampo(campo, valor);
                if (entidade != null) {
                    throw new NegocioException("O campo " + campo.toUpperCase() + " pertence a outro cadastro.");
                }
            } else {
                entidade = buscarPorCampo(campo, valor);
                if (entidade != null) {
                    throw new NegocioException("O campo " + campo.toUpperCase() + " pertence a outro cadastro.");
                }
                return true;
            }
        } catch (NoResultException ex) {
            LOGGER.info("Infomação não encontrada" + ex.getMessage());
        }
        return true;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //ESTE METODO, APARENTEMENTE, É RESÍDUO DE ALGUM TESTE. CASO NÃO TENHA EFEITO NO FUNCIONAMENTO DO SISTEMA, DEVERÁ SER APAGADO.
//    public List<T> query(String query, Object... params) {
//        List<T> result = null;
//        Query q = entityManager.createQuery(query);
//        int paramPos = 1;
//        for (Object o : params) {
//            q.setParameter(paramPos++, o);
//        }
//        result = q.getResultList();
//        return result;
//    }
}
