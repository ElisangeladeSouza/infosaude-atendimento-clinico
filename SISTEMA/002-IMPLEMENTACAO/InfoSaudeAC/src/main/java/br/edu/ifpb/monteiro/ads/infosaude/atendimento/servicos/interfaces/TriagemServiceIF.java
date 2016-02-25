package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Triagem;
import java.util.List;

/**
 *
 * @author wilde
 */
public interface TriagemServiceIF {

    public List<Triagem> findAll();

    public void save(Triagem triagem);

    public void delete(Triagem triagemSelecionada);
    
}
