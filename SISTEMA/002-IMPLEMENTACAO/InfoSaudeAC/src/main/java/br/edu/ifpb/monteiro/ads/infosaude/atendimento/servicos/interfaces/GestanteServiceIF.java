package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Gestante;
import java.util.List;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public interface GestanteServiceIF {
    
    public List<Gestante> findAll();
    
    public void save(Gestante gestante);
    
    public void delete(Gestante gestanteSelecionada);
}
