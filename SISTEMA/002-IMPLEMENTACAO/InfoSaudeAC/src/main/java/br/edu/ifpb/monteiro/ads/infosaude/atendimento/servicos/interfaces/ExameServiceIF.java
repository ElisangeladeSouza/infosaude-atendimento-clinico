package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Exame;
import java.util.List;

/**
 *
 * @author wilde
 */
public interface ExameServiceIF {

    public List<Exame> findAll();

    public void checaCampoDuplicado(String campo, Object valor, Long id, Exame exame);

    public void save(Exame exame);

    public void delete(Exame exameSelecionado);
    
}
