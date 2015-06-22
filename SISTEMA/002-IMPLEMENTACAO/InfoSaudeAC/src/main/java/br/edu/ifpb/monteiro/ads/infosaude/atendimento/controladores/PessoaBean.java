package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.RacaCor;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.PessoaService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author cassio
 */
@Model
public class PessoaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PessoaService pessoaService;

    private final transient List<RacaCor> racas;
    private static transient List<Estados> estados = new ArrayList<>();
    static transient List<String> cidades = new ArrayList<>();

    /**
     *
     */
    public PessoaBean() {
        racas = Arrays.asList(RacaCor.values());
        estados = Arrays.asList(Estados.values());
    }

    /**
     *
     * @return
     */
    public List<Estados> getEstados() {
        return estados;
    }

    /**
     *
     * @param estados
     */
    public void setEstados(List<Estados> estados) {
        PessoaBean.estados = estados;
    }

    /**
     *
     * @return
     */
    public List<String> getCidades() {
        return cidades;
    }

    /**
     *
     * @param cidades
     */
    public void setCidades(List<String> cidades) {
        PessoaBean.cidades = cidades;
    }

    /**
     *
     * @return
     */
    public PessoaService getPessoaService() {
        return pessoaService;
    }

    /**
     *
     * @param pessoaService
     */
    public void setPessoaService(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    /**
     *
     * @return
     */
    public List<RacaCor> getRacas() {
        return racas;
    }
}
