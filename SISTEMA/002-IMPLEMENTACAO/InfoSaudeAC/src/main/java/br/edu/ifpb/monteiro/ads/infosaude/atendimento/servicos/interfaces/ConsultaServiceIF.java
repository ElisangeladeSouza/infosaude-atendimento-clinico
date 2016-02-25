package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Consulta;
import java.util.List;

/**
 *
 * @author wilde
 */
public interface ConsultaServiceIF {

    public List<Consulta> findAll();

    public void save(Consulta consulta);

    public void delete(Consulta consultaSelecionada);
    
}
