package br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes;

import java.io.Serializable;

/**
 * Enumeraçao que retorna as opções de Roles(Funções) de cada usuário do
 * sistema.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public enum Permissao implements Serializable {

    ADMIN("Administradores"),
    RECEPCIONISTA("Recepcionistas"),
    MEDICO("Medicos"),
    ODONTOLOGO("Odontologos"),
    ENFERMEIRO("Enfermeiros"),
    TEC_ENFERMAGEM("TecnicosEnfermagem");

    private final String descricao;

    Permissao(String descricao) {
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
