package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.UbsDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Ubs;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.UbsServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 * Classe de serviço que faz chamadas aos métodos de persistência e pode conter
 * lógica de negócio e pode fazer chamadas a outras partes do sistema, caso
 * necessite.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class UbsService implements UbsServiceIF, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private UbsDao ubsDao;

    public UbsService() {
    }
    
    /**
     * Método responsável por carregar a lista de todas as cidades da federação 
     * através de uma consulta ao banco de dados.
     * 
     * @param codigoUF
     * @return
     */
    @Override
    public List<String> retornaCidades(int codigoUF) {
        return ubsDao.retornaCidades(codigoUF);
    }
    
    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     * 
     * @param ubs 
     */
    @Transactional
    @Override
    public void save(Ubs ubs) {
        ubs.setData(new DateTimeUtilBean().getDateToday());
        this.ubsDao.salvar(ubs);
    }
    
    /**
     * Método utilizado para remover um cadastro do banco de dados.
     * 
     * @param ubs
     * @throws NegocioException
     */
    @Transactional
    @Override
    public void delete(Ubs ubs) throws NegocioException {
        ubsDao.delete(findById(ubs.getId()));
    }
    
    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     * 
     * @param id
     * @return
     */
    public Ubs findById(Long id) {
        return ubsDao.findById(id);
    }
    
    /**
     * Método responsável pela busca em toda lista.Método utilizado para retornar 
     * uma lista com todos os resultados encontrados no banco de dados para a entidade que a chamar.
     * 
     * @return
     */
    @Override
    public List<Ubs> findAll() {
        return ubsDao.findAll();
    }
    
}
