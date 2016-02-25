package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaAtendimento;
import java.util.List;

/**
 *
 * @author wilde
 */
public interface FichaAtendimentoServiceIF {

    public List<FichaAtendimento> findAll();

    public void save(FichaAtendimento fichaAtendimento);

    public void delete(FichaAtendimento fichaAtendimentoSelecionada);
    
}
