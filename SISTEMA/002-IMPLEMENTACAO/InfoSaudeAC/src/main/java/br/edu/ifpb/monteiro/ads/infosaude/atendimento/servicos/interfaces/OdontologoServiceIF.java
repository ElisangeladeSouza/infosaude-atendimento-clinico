package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Odontologo;
import java.util.List;

/**
 *
 * @author wilde
 */
public interface OdontologoServiceIF {

    public List<Odontologo> findAll();

    public void save(Odontologo odontologo);

    public void delete(Odontologo odontologoSelecionado);
    
}
