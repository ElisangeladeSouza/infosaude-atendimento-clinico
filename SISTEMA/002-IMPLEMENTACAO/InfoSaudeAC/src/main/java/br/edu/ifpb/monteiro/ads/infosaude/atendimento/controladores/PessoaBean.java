package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.RacaCor;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.PessoaService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
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

    private transient final List<RacaCor> racas;

    public PessoaBean() {
        racas = Arrays.asList(RacaCor.values());
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
        System.out.println("" + botaoEditar);
        return botaoEditar;
    }

    public void setBotaoEditar(boolean botaoEditar) {
        System.out.println("" + botaoEditar);
        this.botaoEditar = botaoEditar;
    }

    public void verificaSeEmailValido(String email) {
        if (!email.matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$")) {
            FacesUtil.mensagemErro("E-mail inválido. Digite um e-mail on formato: usuario@dominio");
        }
    }

    public List<String> retornaCidades(int codigoUF) {
        return pessoaService.retornaCidades(codigoUF);
    }

}
