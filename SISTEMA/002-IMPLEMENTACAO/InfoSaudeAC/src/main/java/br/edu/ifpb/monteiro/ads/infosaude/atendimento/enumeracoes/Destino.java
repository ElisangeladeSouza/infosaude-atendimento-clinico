package br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes;

import java.io.Serializable;

/**
 * Enumeração que retorna possíveis destinos de um paciente após fazer a ficha
 * de atendimento
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public enum Destino implements Serializable {

    PROCEDIMENTO("Procedimento"),
    ODONTOLOGO("Odontólogo"),
    MEDICO("Médico"),
    ENFERMEIRO("Enfermeiro"),
    TRIAGEM("Triagem");

    private final String descricao;

    Destino(String descricao) {
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
