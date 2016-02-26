package br.edu.ifpb.monteiro.ads.infosaude.atendimento.relatorios;

import java.io.Serializable;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Model
public class RelatorioTodosMedicos implements Serializable {

    @Inject
    private GeradorRelatorios geradorRelatorios;

    /**
     * Emite o relatório baseado em métodos presentes na classe
     * <b>GeradorRelatorios</b> e que fazem a conexão com o banco de dados e
     * tratam os dados para gerar os relatórios. Ao chamar essa classe
     * utilitária de geração de relatórios, dois parâmetros são passados, onde o
     * primeiro refere-se ao nome do arquivo de template de relatório compilado
     * (.jasper) e o segundo ao nome do relatório em PDF que o usuário
     * visualizará.
     *
     * @see GeradorRelatorios
     */
    public void emitir() {
        geradorRelatorios.preparaRelatorioPdf("/relatorio_todos_medicos.jasper", "Relatório de médicos cadastrados.pdf");
    }
}
