package br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes;

import java.io.Serializable;

/**
 * Enumeração que retorna o grau de urgência de cada atendimento de acordo com
 * o Protocolo de Manchester.
 * Onde as pessoas recebem uma cor de acordo com a gravidade do seu caso.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public enum GrauUrgencia implements Serializable {
    
    NAO_URGENTE("Não Urgente"),
    MENOR_URGENCIA("Menor Urgência"),
    URGENTE("Urgente"),
    MUITO_URGENTE("Muito Urgente"),
    EMERGENCIA("Emergência");
    
    private final String descricao;

    GrauUrgencia(String descricao) {
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
