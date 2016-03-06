package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Data;

/**
 * Endereco não é uma entidade, mas sim, uma classe criada para reaproveitar os
 * seus dados nas demais entidades do sistema que necessitam de atributos do
 * tipo endereço em seus cadastros. Evitando a repetição de atributos.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Embeddable
@Data
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "endereco_rua", length = 150)
    private String enderecoRua;

    @Column(name = "endereco_numero", length = 6)
    private String enderecoNumero;

    @Column(name = "endereco_bairro", length = 100)
    private String enderecoBairro;

    @Enumerated(EnumType.STRING)
    @Column(name = "endereco_estado")
    private Estados enderecoEstado;

    @Column(name = "endereco_cidade", length = 100)
    private String enderecoCidade;

    @Column(name = "endereco_cep", length = 10)
    private String enderecoCep;

}
