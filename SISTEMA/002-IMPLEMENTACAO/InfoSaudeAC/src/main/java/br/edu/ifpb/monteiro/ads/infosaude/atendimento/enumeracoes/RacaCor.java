package br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes;

import java.io.Serializable;

/**
 * Enumeraçao que retorna as opções de Raça/Cor, seguindo o principio
 * estabelecido na leis do Estado Brasileiro.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public enum RacaCor implements Serializable {

    BRANCA("Branca"),
    PARDA("Parda"),
    NEGRA("Negra"),
    INDIGENA("Indígena"),
    AMARELA("Amarela");

    private final String descricao;

    RacaCor(String descricao) {
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
