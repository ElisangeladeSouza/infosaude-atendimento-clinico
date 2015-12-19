package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.FichaAtendimentoDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaAtendimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 * Classe de serviço que faz chamadas aos métodos de persistência e pode conter
 * lógica de negócio e pode fazer chamadas a outras partes do sistema, caso
 * necessite.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class FichaAtendimentoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private FichaAtendimentoDao fichaAtendimentoDao;

    public FichaAtendimentoService() {
    }

    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     * 
     * @param fichaAtendimento 
     */
    @Transactional
    public void save(FichaAtendimento fichaAtendimento) {
        if (fichaAtendimento != null) {
            fichaAtendimento.setData(new DateTimeUtilBean().getDateToday());
            this.fichaAtendimentoDao.salvar(fichaAtendimento);
        }
    }

    /**
     * Método utilizado para remover um cadastro do banco de dados.
     * 
     * @param fichaAtendimento
     * @throws NegocioException 
     */
    @Transactional
    public void delete(FichaAtendimento fichaAtendimento) throws NegocioException {
        fichaAtendimentoDao.delete(findById(fichaAtendimento.getId()));
    }

    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     * 
     * @param id
     * @return 
     */
    public FichaAtendimento findById(Long id) {
        return fichaAtendimentoDao.findById(id);
    }

    /**
     * Método responsável pela busca em toda lista.Método utilizado para retornar 
     * uma lista com todos os resultados encontrados no banco de dados para a entidade que a chamar.
     * 
     * @return 
     */
    public List<FichaAtendimento> findAll() {
        return fichaAtendimentoDao.findAll();
    }

}
