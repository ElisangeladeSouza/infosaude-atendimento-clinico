package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import lombok.Data;

/**
 * Classe que representa um modelo de uma entidade a ser persistida no banco,
 * com todos os atributos relacionados. Todas as entidades que tiverem atributos
 * comuns em pessoa, podem herdar suas características apenas extendendo a mesma
 * atravé de herança.
 *
 * @author cassio <cassio@cassioliveira.com.br>
 */
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotNull(message = "Um nome deve ser informado")
    @Column(name = "pessoa_nome", nullable = false, length = 150)
    private String nome;

    @Pattern(regexp = "^$|[a-zA-Z\\d/.-]{1,}",
            message = "Apenas letras números ou os caracteres a seguir são aceitos para o RG: / . -")
    @Column(name = "pessoa_rg", length = 15)
    private String rg;

    @Column(name = "pessoa_endereco_rua", length = 150)
    private String enderecoRua;

    @Column(name = "pessoa_endereco_numero", length = 6)
    private String enderecoNumero;

    @Column(name = "pessoa_endereco_bairro", length = 100)
    private String enderecoBairro;

    @Enumerated(EnumType.STRING)
    @Column(name = "pessoa_endereco_estado")
    private Estados enderecoEstado;

    @Column(name = "pessoa_endereco_cidade", length = 100)
    private String enderecoCidade;

    @Column(name = "pessoa_endereco_cep", length = 10)
    private String enderecoCep;

    @Temporal(TemporalType.DATE)
    @Column(name = "pessoa_data_nascimento")
    private Date dataNascimento;

    /* Seta a hora de criação ou alteração da entidade */
    @Temporal(TemporalType.DATE)
    @Column(name = "pessoa_data")
    private Date data;

    @Column(name = "pessoa_telefone1", length = 20)
    private String telefone1;

    @Column(name = "pessoa_telefone2", length = 20)
    private String telefone2;

    @Pattern(regexp = "^$|^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$",
            message = "E-mail com formato incorreto")
    @Column(name = "pessoa_email", length = 100)
    private String email;

    @Column(name = "pessoa_cor_raca", length = 15)
    private String corOuRaca;

}
