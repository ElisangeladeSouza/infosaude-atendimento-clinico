package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Diretor;
import java.util.List;

/**
 *
 * @author wilde
 */
public interface DiretorServiceIF {
    
    
    public void save(Diretor diretor);
    
    public void delete(Diretor diretor);
    
    public List<Diretor> findAll();
    
    public Diretor findById(Long id);
    
}
