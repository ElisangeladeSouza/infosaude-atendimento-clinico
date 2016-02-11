package br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes;

import java.io.Serializable;

/**
 * Enumeração que retorna as opções de tipos de gravidez.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public enum TipoGravidez implements Serializable {
    
    UNICA("Única"),
    GEMELAR("Gemelar"),
    TRIPLA_OU_MAIS("Tripla ou mais"),
    IGNORADA("Ignorada");
    
    private final String descricao;
    
    TipoGravidez(String descricao) {
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
