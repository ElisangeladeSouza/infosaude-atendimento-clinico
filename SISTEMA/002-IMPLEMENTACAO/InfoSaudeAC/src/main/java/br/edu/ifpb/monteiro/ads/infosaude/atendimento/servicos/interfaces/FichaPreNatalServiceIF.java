package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaPreNatal;
import java.util.List;

/**
 *
 * @author elisangela
 */
public interface FichaPreNatalServiceIF {
    
    public List<FichaPreNatal> findAll();

    public void save(FichaPreNatal fichaAtendimento);

    public void delete(FichaPreNatal fichaAtendimentoSelecionada);
    
}
