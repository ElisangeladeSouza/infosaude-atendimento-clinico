package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.UbsDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Ubs;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.UbsServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static List<Estados> estados = new ArrayList<>();
    public static List<String> cidades = new ArrayList<>();

    public UbsService() {
        estados = Arrays.asList(Estados.values());
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
     * Método responsável pela busca em toda lista.Método utilizado para
     * retornar uma lista com todos os resultados encontrados no banco de dados
     * para a entidade que a chamar.
     *
     * @return
     */
    @Override
    public List<Ubs> findAll() {
        return ubsDao.findAll();
    }

}
