package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 * Entidade que representa a paciente Gestante da UBS. Ao extender Pessoa,
 * passa a herdar todos os seus atributos.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Entity
@Data
public class Gestante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gestante_municipio_atendimento", nullable = false, length = 100)
    private String municipioAtendimento;

    @Column(name = "gestante_código_ibge", length = 7)
    private String codigoIbge;

    @Enumerated(EnumType.STRING)
    @Column(name = "gestante_uf")
    private Estados uf;

    @Column(name = "gestante_nome_estabelecimento_saude", nullable = false, length = 100)
    private String nomeEstabelecimentoSaude;

    @Column(name = "gestante_cnes", length = 15)
    private String cnes;

    @Column(name = "gestante_num_area", length = 5)
    private String numArea;

    @Column(name = "gestante_num_microarea", length = 5)
    private String numMicroarea;

    @Column(name = "gestante_nome_profissional", nullable = false, length = 100)
    private String nomeProfissional;

    // Cartão SUS do profissional responsável pelo cadastro e acompanhamento da gestante (enfermeiro).
    @Column(name = "gestante_cartao_sus_profissional", nullable = false, length = 20)
    private String cartaoSusProfissional;

    @Column(name = "gestante_nis", length = 11)
    private String nis;

    @Column(name = "gestante_menor_quinze")
    private boolean menorQuinze;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gestante_data")
    private Date data;

    @Embedded
    private ResponsavelGestante responsavelGestante;
    
    @OneToOne
    @JoinColumn(name = "paciente_pk")
    private Paciente paciente;
    
    @PostConstruct
    public void init() {
        this.responsavelGestante = new ResponsavelGestante();
    }
}
