package br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes;

import java.io.Serializable;

/**
 * Enumeração que retorna as opções de trimestre em que se encontra a gestação.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public enum TempoGestacional implements Serializable {
    
    TRIMESTRE_1("1º Trimestre"),
    TRIMESTRE_2("2º Trimestre"),
    TRIMESTRE_3("3º Trimestre"),
    IGNORADO("Ignorado");
    
    private final String descricao;
    
    TempoGestacional(String descricao) {
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
