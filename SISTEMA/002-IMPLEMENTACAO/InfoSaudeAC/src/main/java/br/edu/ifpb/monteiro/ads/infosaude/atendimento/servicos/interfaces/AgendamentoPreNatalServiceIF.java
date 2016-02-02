package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.AgendamentoPreNatal;
import java.util.List;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public interface AgendamentoPreNatalServiceIF {
    
    public List<AgendamentoPreNatal> findAll();

    public void save(AgendamentoPreNatal agendamentoPreNatal);

    public void delete(AgendamentoPreNatal agendamentoPreNatalSelecionado);
    
}
