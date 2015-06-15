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

    private boolean botaoEditar;

    private final transient List<RacaCor> racas;

    private static transient List<Estados> estados = new ArrayList<>();

    static transient List<String> cidades = new ArrayList<>();

    public PessoaBean() {
        racas = Arrays.asList(RacaCor.values());
        estados = Arrays.asList(Estados.values());
    }

    public List<Estados> getEstados() {
        return estados;
    }

    public void setEstados(List<Estados> estados) {
        PessoaBean.estados = estados;
    }

    public List<String> getCidades() {
        return cidades;
    }

    public void setCidades(List<String> cidades) {
        PessoaBean.cidades = cidades;
    }

    public PessoaService getPessoaService() {
        return pessoaService;
    }

    public void setPessoaService(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    public List<RacaCor> getRacas() {
        return racas;
    }

    public boolean isBotaoEditar() {
        return botaoEditar;
    }

    public void setBotaoEditar(boolean botaoEditar) {
        this.botaoEditar = botaoEditar;
    }

    public List<String> retornaCidades(int codigoUF) {
        return pessoaService.retornaCidades(codigoUF);
    }

}
