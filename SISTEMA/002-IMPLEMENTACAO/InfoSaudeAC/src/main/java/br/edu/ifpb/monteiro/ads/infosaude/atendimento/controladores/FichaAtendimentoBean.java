package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Destino;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaAtendimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.FichaAtendimentoService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.interfaces.FichaAtendimentoServiceIF;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * Managed bean usado pela página de cadastro de ficha de atendimento. É
 * responsável por ligar a classe de modelo FichaAtendimento à página de
 * visualização processando as solicitações do usuário e retornando os dados à
 * visualização.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Model
public class FichaAtendimentoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private FichaAtendimento fichaAtendimento;

    @Inject
    private FichaAtendimentoServiceIF fichaAtendimentoService;

    @Inject
    private FichaAtendimento fichaAtendimentoSelecionada;

    private transient List<FichaAtendimento> fichaAtendimentos;

    private transient List<Destino> destinos = new ArrayList<>();

    /**
     * Construtor da classe Inicia o array com os destinos possiveis de uma
     * paciente dentro da UBS.
     *
     * @see Destino
     */
    public FichaAtendimentoBean() {
        this.destinos = Arrays.asList(Destino.values());
    }

    @PostConstruct
    public void init() {
        this.fichaAtendimentos = fichaAtendimentoService.findAll();
    }

    /**
     * Lista de destinos possíveis para o paciente após fazer a ficha de
     * atendimento.
     *
     * @see Destino
     * @return
     */
    public List<Destino> getDestinos() {
        return destinos;
    }

    /**
     * Lista de fichas de atendimentos feitas na UBS.
     *
     * @return
     */
    public List<FichaAtendimento> getFichaAtendimentos() {
        this.fichaAtendimentos = fichaAtendimentoService.findAll();
        return fichaAtendimentos;
    }

    /**
     * Método responsável por iniciar uma transação, instanciar um objeto do
     * tipo FichaAtendimento e salvar. Se algum erro ocorrer, deve-se fazer
     * rollback e apresentar uma mensagem de erro.
     *
     * @throws NegocioException
     */
    public void salvar() throws NegocioException {
        this.fichaAtendimentoService.save(fichaAtendimento);
        if (getEditando()) {
            FacesUtil.mensagemSucesso("Cadastro da ficha de atendimento nº '" + fichaAtendimento.getCodigo() + "' atualizado com sucesso!");
        } else {
            FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
        }
        FacesUtil.redirecionaPara("PesquisaFichaAtendimento.xhtml");
        fichaAtendimento = new FichaAtendimento();
    }

    /**
     * Método responsável por excluir um objeto do tipo FichaAtendimento e
     * exibir ao final do processo uma mensagem informativa.
     *
     * @throws NegocioException
     */
    public void excluir() throws NegocioException {
        this.fichaAtendimentoService.delete(fichaAtendimentoSelecionada);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
        FacesUtil.redirecionaPara("PesquisaFichaAtendimento.xhtml");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.fichaAtendimento.getId() != null;
    }

    public FichaAtendimento getFichaAtendimentoSelecionada() {
        return fichaAtendimentoSelecionada;
    }

    public void setFichaAtendimentoSelecionada(FichaAtendimento fichaAtendimentoSelecionada) {
        this.fichaAtendimentoSelecionada = fichaAtendimentoSelecionada;
    }

    public FichaAtendimento getFichaAtendimento() {
        return fichaAtendimento;
    }

    public void setFichaAtendimento(FichaAtendimento fichaAtendimento) {
        this.fichaAtendimento = fichaAtendimento;
    }

    public FichaAtendimentoService getFichaAtendimentoService() {
        return (FichaAtendimentoService) fichaAtendimentoService;
    }

    public void setFichaAtendimentoService(FichaAtendimentoService fichaAtendimentoService) {
        this.fichaAtendimentoService = (FichaAtendimentoServiceIF) fichaAtendimentoService;
    }
}
