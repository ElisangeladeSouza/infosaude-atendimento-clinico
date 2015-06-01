package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.MarcacaoConsultaDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.MarcacaoConsulta;
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
public class MarcacaoConsultaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private MarcacaoConsultaDao marcacaoConsultaDao;

    public MarcacaoConsultaService() {
    }

    @Transactional
    public void save(MarcacaoConsulta marcacaoConsulta) {
        this.marcacaoConsultaDao.salvar(marcacaoConsulta);
    }

    @Transactional
    public void delete(MarcacaoConsulta marcacaoConsulta) throws UBSException {
        marcacaoConsultaDao.delete(findById(marcacaoConsulta.getId()));
    }

    public MarcacaoConsulta findById(Long id) {
        return marcacaoConsultaDao.findById(id);
    }

    public List<MarcacaoConsulta> findAll() {
        return marcacaoConsultaDao.findAll();
    }

}
