package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Medico;
import java.util.List;

/**
 *
 * @author wilde
 */
public interface MedicoServiceIF {

    public List<Medico> findAll();

    public void save(Medico medico);

    public void delete(Medico medicoSelecionado);
    
    public void relatorioTodosMedicos();
    
}
