package br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes;

import java.io.Serializable;

/**
 *
 * @author cassio
 */
public enum Documentacao implements Serializable {

    RG("Carteira de Identidade"),
    CARTAO_SUS("Cartão do SUS"),
    CPF("CPF"),
    COREN("COREN"),
    CRO("CRO"),
    CRM("CRM"),
    OUTRO("Outro");

    private final String descricao;

    Documentacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
