package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Endereco;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Ubs;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.PessoaServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.UbsServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * Managed bean usado pela página de cadastro de Ubs. É responsável por ligar a
 * classe de modelo Ubs à página de visualização processando as solicitações do
 * usuário e retornando os dados à visualização.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class UbsBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Ubs ubs;

    @Inject
    private UbsServiceIF ubsService;

    @Inject
    private Ubs ubsSelecionada;

    @Inject
    private PessoaServiceIF pessoaService;

    @Inject
    private Endereco endereco;

    private transient List<Ubs> todasUbs;
    private static transient List<Estados> estados = new ArrayList<>();
    static transient List<String> cidades = new ArrayList<>();

    /**
     * Construtor da classe
     */
    public UbsBean() {
        estados = Arrays.asList(Estados.values());
    }

    @PostConstruct
    public void init() {
        this.todasUbs = ubsService.findAll();
    }

     /**
     * Lista de ubs cadastradas na UBS.
     *
     * @return
     */
    public List<Ubs> getTodasUbs() {
        return todasUbs;
    }

    public static List<Estados> getEstados() {
        return estados;
    }

    public static List<String> getCidades() {
        return cidades;
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo Ubs e salvar.
     *
     * @throws NegocioException
     */
    public void salvar() throws NegocioException {
        this.ubsService.save(ubs);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("UBS atualizada com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro e retorna true, senao refere-se a um produto
     * a ser editado, retornando false.
     *
     * @return
     */
    public boolean getEditando() {
        return this.ubs.getId() != null;
    }

    public Ubs getUbs() {
        return ubs;
    }

    public void setUbs(Ubs ubs) {
        this.ubs = ubs;
    }

    public UbsServiceIF getUbsService() {
        return ubsService;
    }

    public void setUbsService(UbsServiceIF ubsService) {
        this.ubsService = ubsService;
    }

    public Ubs getUbsSelecionada() {
        return ubsSelecionada;
    }

    public void setUbsSelecionada(Ubs ubsSelecionada) {
        this.ubsSelecionada = ubsSelecionada;
    }

    public PessoaServiceIF getPessoaService() {
        return pessoaService;
    }

    public void setPessoaService(PessoaServiceIF pessoaService) {
        this.pessoaService = pessoaService;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
