package br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.cdi;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import java.util.Set;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author cassio
 */
public class CDIServiceLocator {

    private static final Log LOGGER = LogFactory.getLog(CDIServiceLocator.class);

    private CDIServiceLocator() {
    }

    private static BeanManager getBeanManager() throws UBSException {
        try {
            InitialContext initialContext = new InitialContext();
            return (BeanManager) initialContext.lookup("java:comp/BeanManager");
        } catch (NamingException e) {
            LOGGER.error(e);
            throw new UBSException("Não pôde encontrar BeanManager no JNDI.");
        }
    }

    /**
     *
     * @param <T>
     * @param clazz
     * @return
     * @throws UBSException
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> clazz) throws UBSException {
        BeanManager bm = getBeanManager();
        Set<Bean<?>> beans = (Set<Bean<?>>) bm.getBeans(clazz);

        if (beans == null || beans.isEmpty()) {
            return null;
        }

        Bean<T> bean = (Bean<T>) beans.iterator().next();

        CreationalContext<T> ctx = bm.createCreationalContext(bean);

        return (T) bm.getReference(bean, clazz, ctx);
    }

}
