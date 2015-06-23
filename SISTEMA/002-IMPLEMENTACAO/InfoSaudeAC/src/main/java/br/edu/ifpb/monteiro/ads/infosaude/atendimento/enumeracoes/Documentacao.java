package br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes;

import java.io.Serializable;

/**
 * Enumeração que retorna alguns documentos comuns solicitados nas telas de
 * cadastro.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
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

    /**
     * Permite que a descrição(valor) do item do ENUM seja retornado ao invés da
     * constante(chave).
     *
     * @return descricao
     */
    public String getDescricao() {
        return descricao;
    }
}
