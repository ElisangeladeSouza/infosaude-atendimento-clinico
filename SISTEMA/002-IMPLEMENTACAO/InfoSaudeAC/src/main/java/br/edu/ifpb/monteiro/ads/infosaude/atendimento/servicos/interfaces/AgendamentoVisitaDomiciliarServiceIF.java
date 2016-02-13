package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.AgendamentoVisitaDomiciliar;
import java.util.List;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public interface AgendamentoVisitaDomiciliarServiceIF {
    
    public List<AgendamentoVisitaDomiciliar> findAll();

    public void save(AgendamentoVisitaDomiciliar agedamentoVisitaDomiciliar);

    public void delete(AgendamentoVisitaDomiciliar AgendamentoVisitaDomiciliarSelecionado);
    
}
