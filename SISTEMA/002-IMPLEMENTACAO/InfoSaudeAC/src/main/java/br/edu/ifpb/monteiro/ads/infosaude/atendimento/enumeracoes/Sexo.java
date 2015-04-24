package br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes;

import java.io.Serializable;

/**
 * Contains a list with Gender, represented by a letter.
 *
 * @author cassio
 */
public enum Sexo implements Serializable {

    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private final String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
