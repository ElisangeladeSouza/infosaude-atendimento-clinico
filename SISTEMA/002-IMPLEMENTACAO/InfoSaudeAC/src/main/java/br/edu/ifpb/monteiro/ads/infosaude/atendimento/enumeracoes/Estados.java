package br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes;

import java.io.Serializable;

/**
 * Enumeração que retorna os estados brasileiros e suas siglas para as telas de
 * cadastro.
 *
 * @author cassio
 */
public enum Estados implements Serializable {

    /**
     *
     */
    AC(1, "Acre"),

    /**
     *
     */
    AL(2, "Alagoas"),

    /**
     *
     */
    AM(3, "Amazonas"),

    /**
     *
     */
    AP(4, "Amapá"),

    /**
     *
     */
    BA(5, "Bahia"),

    /**
     *
     */
    CE(6, "Ceará"),

    /**
     *
     */
    DF(7, "Distrito Federal"),

    /**
     *
     */
    ES(8, "Espírito Santo"),

    /**
     *
     */
    GO(9, "Goiás"),

    /**
     *
     */
    MA(10, "Maranhão"),

    /**
     *
     */
    MG(11, "Minas Gerais"),

    /**
     *
     */
    MS(12, "Mato Grosso do Sul"),

    /**
     *
     */
    MT(13, "Mato Grosso"),

    /**
     *
     */
    PA(14, "Pará"),

    /**
     *
     */
    PB(15, "Paraíba"),

    /**
     *
     */
    PE(16, "Pernambuco"),

    /**
     *
     */
    PI(17, "Piauí"),

    /**
     *
     */
    PR(18, "Paraná"),

    /**
     *
     */
    RJ(19, "Rio de Janeiro"),

    /**
     *
     */
    RN(20, "Rio Grande do Norte"),

    /**
     *
     */
    RO(21, "Rondônia"),

    /**
     *
     */
    RR(22, "Roraima"),

    /**
     *
     */
    RS(23, "Rio Grande do Sul"),

    /**
     *
     */
    SC(24, "Santa Catarina"),

    /**
     *
     */
    SE(25, "Sergipe"),

    /**
     *
     */
    SP(26, "São Paulo"),

    /**
     *
     */
    TO(27, "Tocantins");

    private final String descricao;

    private final Integer codigo;

    Estados(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     *
     * @return
     */
    public Integer getCodigo() {
        return codigo;
    }
}
