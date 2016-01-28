package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entidade que representa a a paciente Gestante da UBS. Ao extender Pessoa, 
 * passa a herdar todos os seus atributos.
 * 
 * @author elisangela <elysangeladesouza@gmail.com>
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Gestante implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "municipio_atendimento", nullable = false, length = 100)
    private String municipio_atendimento;
    
    @Column(name = "código_ibge", length = 15)
    private String codigo_ibge;
    
    @Column(name= "UF", length = 2)
    private String UF;
    
    @Column(name = "nome_estabelecimento_saude", nullable = false, length = 100)
    private String nome_estabelecimento_saude;
    
    @Column(name = "CNES", length = 15)
    private String CNES;
    
    @Column(name = "num_area", length = 5)
    private String num_area;
    
    @Column(name = "num_microarea", length = 5)
    private String num_microarea;
    
    @Column(name = "nome_profissional", nullable = false, length = 100)
    private String nome_profissional;
    
    // Cartão SUS do profissional responsável pelo cadastro e acompanhamento da gestante (enfermeiro).
    @Column(name = "cartao_sus_profissional", nullable = false, length = 20)
    private String cartaoSusProfissional;
    
    @Column(name = "NIS", unique = true, length = 11)
    private String NIS;
    
    @Column(name = "menor_quinze")
    private boolean menor_quinze;
    
    @Column(name = "representante_familiar", length = 100)
    private String representante;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gestante_data")
    private Date data;
    
    @Column(name = "gestante_endereco_rua", length = 150)
    private String enderecoRua;

    @Column(name = "gestante_endereco_numero", length = 6)
    private String enderecoNumero;

    @Column(name = "gestante_endereco_bairro", length = 100)
    private String enderecoBairro;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "gestante_endereco_estado")
//    private Estados enderecoEstado;
//
//    @Column(name = "gestante_endereco_cidade", length = 100)
//    private String enderecoCidade;

    @Column(name = "gestante_endereco_cep", length = 10)
    private String enderecoCep;
    
     @Column(name = "gestante_telefone1", length = 20)
    private String telefone1;

    @Column(name = "gestante_telefone2", length = 20)
    private String telefone2;

    @Pattern(regexp = "^$|^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$",
            message = "E-mail com formato incorreto")
    @Column(name = "gestante_email", length = 100)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "gestante_data_nascimento")
    private Date dataNascimento;

    @OneToOne
    @JoinColumn(name = "paciente_pk")
    private Paciente paciente;
    
}
