package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Procedimento;
import java.util.List;

/**
 *
 * @author wilde
 */
public interface ProcedimentoServiceIF {

    public List<Procedimento> findAll();

    public void save(Procedimento procedimento);

    public void delete(Procedimento procedimentoSelecionado);
    
}
