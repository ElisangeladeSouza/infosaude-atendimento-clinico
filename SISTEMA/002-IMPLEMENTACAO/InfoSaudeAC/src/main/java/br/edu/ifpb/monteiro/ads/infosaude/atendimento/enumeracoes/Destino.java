package br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes;

import java.io.Serializable;

/**
 * Enumeração que retorna possíveis destinos de um paciente após fazer a ficha
 * de atendimento
 *
 * @author cassio
 */
public enum Destino implements Serializable {

    PROCEDIMENTO("Procedimento"),
    ODONTOLOGO("Odontólogo"),
    MEDICO("Médico"),
    TRIAGEM("Triagem");

    private final String descricao;

    Destino(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
