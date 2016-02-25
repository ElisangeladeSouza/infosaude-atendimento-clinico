package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Enfermeiro;
import java.util.List;

/**
 *
 * @author wilde
 */
public interface EnfermeiroServiceIF {

    public List<Enfermeiro> findAll();

    public void save(Enfermeiro enfermeiro);

    public void delete(Enfermeiro enfermeiroSelecionado);
    
}
