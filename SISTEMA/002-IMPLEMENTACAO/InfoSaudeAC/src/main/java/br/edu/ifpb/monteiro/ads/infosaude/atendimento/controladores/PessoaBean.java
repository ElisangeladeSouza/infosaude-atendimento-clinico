package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.inject.Model;

/**
 *
 * @author elisangela
 */
@Model
public class PessoaBean {

    private List<Estados> estados;

    public PessoaBean() {
        estados = Arrays.asList(Estados.values());
    }

    public List<Estados> getEstados() {
        return estados;
    }

}
