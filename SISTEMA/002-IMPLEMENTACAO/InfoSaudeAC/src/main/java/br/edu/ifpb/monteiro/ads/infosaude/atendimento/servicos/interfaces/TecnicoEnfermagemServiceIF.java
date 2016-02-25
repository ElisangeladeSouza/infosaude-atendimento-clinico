package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.TecnicoEnfermagem;
import java.util.List;

/**
 *
 * @author wilde
 */
public interface TecnicoEnfermagemServiceIF {

    public List<TecnicoEnfermagem> findAll();

    public void save(TecnicoEnfermagem tecnicoEnfermagem);

    public void delete(TecnicoEnfermagem tecnicoEnfermagemSelecionado);
    
}
