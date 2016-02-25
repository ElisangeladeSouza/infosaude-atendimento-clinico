package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Paciente;
import java.util.List;

/**
 *
 * @author wilde
 */
public interface PacienteServiceIF {

    public List<Paciente> findAll();

    public void save(Paciente paciente);

    public void delete(Paciente pacienteSelecionado);
    
}
