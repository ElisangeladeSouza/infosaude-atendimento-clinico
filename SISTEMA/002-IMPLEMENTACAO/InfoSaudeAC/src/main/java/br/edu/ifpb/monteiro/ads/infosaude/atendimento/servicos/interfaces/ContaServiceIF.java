package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Conta;
import java.util.List;

/**
 *
 * @author wilde
 */
public interface ContaServiceIF {

    public List<Conta> findAll();

    public void save(Conta conta);

    public void delete(Conta contaSelecionada);
    
}
