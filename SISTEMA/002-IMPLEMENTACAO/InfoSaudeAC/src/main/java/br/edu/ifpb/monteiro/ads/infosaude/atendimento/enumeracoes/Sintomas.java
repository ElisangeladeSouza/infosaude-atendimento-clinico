package br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes;

import java.io.Serializable;

/**
 * Enumeração que retorna o sintomas comuns vistos nos atendimentos de saúde das
 * unidades públicas de saúde.
 * 
 * @author lisa <elysangeladesouza@gmail.com>
 */
public enum Sintomas implements Serializable {
    
    ACIDEZ_ESTOMACAL("Acidez estomacal"),
    APNEIA("Apneia"),
    ARRITMIA_CARDIACA("Arritmia cardiaca"),
    CANSACO("Cansaço"),
    CEGUEIRA("Cegueira"),
    CHIADO_NO_PEITO("Chiado no peito"),
    COCEIRA("Coceira"),
    CONVULCAO("Convulção"),
    COLICAS("Cólicas"),
    DEPRESSAO("Depressão"),
    DESMAIO("Desmaio"),
    DORES_DE_CABECA("Dores de cabeça"),
    DOR_DE_GARGANTA("Dor de garganta"),
    DORES_MUSCULARES("Dores musculares"),
    DORES_NAS_ARTICULACOES("Dores nas articulações"),
    EDEMA("Edema"),
    ENGASGO("Engasgo"),
    ENJOOS("Enjoos"),
    ESPASMO("Espasmo"),
    FALTA_DE_AR("Falta de ar"),
    FEBRE("Febre"),
    FRAQUEZA_INTENSA("Fraqueza intensa"),
    HEMATOMAS("Hematomas"),
    HEMORRAGIA("Hemorragia"),
    INSONIA("Insonia"),
    NAUSEA("Náusea"),
    SONOLENCIA("Sonolência"),
    PALIDEZ("Palidez"),
    PERDA_DE_MEMORIA("Perda de Memória"),
    ROUQUIDAO("Rouquidão"),
    SANGRAMENTO("Sangramento"),
    SURDEZ("Surdez"),
    TAQUICARDIA("Taquicardia"),
    TONTURA("Tontura"),
    TOSSE("Tosse"),
    TREMOR("Tremor"),
    VERTIGEM("Vertigem"),
    VOMITO("Vômito"),
    ZUMBIDO("Zumbido");
    
    private final String descricao;

    Sintomas(String descricao) {
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
