package br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes;

import java.io.Serializable;

/**
 * Enumeração que retorna as possibilidades de gênero para as telas de cadastro.
 *
 * @author cassio
 */
public enum Sexo implements Serializable {

    /**
     *
     */
    MASCULINO("Masculino"),

    /**
     *
     */
    FEMININO("Feminino");

    private final String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public String getDescricao() {
        return descricao;
    }
}
