package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.DaoAbstrato;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;

/**
 *
 * @author cassio
 * @param <T>
 */
public class DaoService<T> extends DaoAbstrato<T> {

    public DaoAbstrato getDao;

    @Override
    @Transactional
    public T buscarPorCampo(String campo, Object valor) {
        return (T) getDao.buscarPorCampo(campo, valor);
    }

}
