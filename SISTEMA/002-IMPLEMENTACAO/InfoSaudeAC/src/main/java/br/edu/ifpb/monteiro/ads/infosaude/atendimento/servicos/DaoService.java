package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.DaoAbstrato;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;

/**
 * Esta classe representa o DaoService. 
 * 
 * @author cassio <cassio@cassioliveira.com.br>
 * @param <T>
 */
public class DaoService<T> extends DaoAbstrato<T> {

    public DaoAbstrato getDao;

    /**
     * Faz uma consulta no banco de dados baseado em um valor passado como
     * parâmetro e retorna o resultado da consulta.
     * 
     * @param campo
     * @param valor
     * @return 
     */
    @Override
    @Transactional
    public T buscarPorCampo(String campo, Object valor) {
        return (T) getDao.buscarPorCampo(campo, valor);
    }

}
