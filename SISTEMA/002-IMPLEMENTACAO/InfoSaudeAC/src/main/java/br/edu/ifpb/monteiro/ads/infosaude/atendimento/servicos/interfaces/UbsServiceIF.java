package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Ubs;
import java.util.List;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public interface UbsServiceIF {

    public void save(Ubs ubs);
    
    public Ubs findById(Long id);

    public List<Ubs> findAll();
}
