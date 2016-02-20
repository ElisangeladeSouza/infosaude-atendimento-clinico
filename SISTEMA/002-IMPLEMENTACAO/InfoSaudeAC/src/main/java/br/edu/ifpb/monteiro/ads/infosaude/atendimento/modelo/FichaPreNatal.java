package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.TempoGestacional;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.TipoGravidez;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import lombok.Data;

/**
 * Entidade que representa a Ficha de pré-natal Gestante da UBS. Ao extender
 * AgendamentoPreNatal, passa a herdar todos os seus atributos.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Entity
@Data
public class FichaPreNatal implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ficha_pre_natal_data")
    private Date dataAtendimento;
    
    @Column(name = "ficha_pre_natal_tempo_gestacional", length = 15)
    private TempoGestacional tempoGestacional;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ficha_pre_natal_dum")
    private Date dum;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ficha_pre_natal_dpp")
    private Date dpp;
    
    @DecimalMin(value = "0", message = "A altura deve ser um valor maior que 0(zero)")
    @Column(name = "ficha_pre_natal_altura", precision = 10, scale = 2)
    private Double altura;
    
    @DecimalMin(value = "0", message = "O peso deve ser um valor maior que 0(zero)")
    @Column(name = "ficha_pre_natal_peso", precision = 10, scale = 2)
    private Double peso;
    
    @Column(name = "ficha_pre_natal_auxilio_deslocamento")
    private boolean auxilioDeslocamento;
    
    @Column(name = "ficha_pre_natal_semanas_gestacao", length = 50)
    private String semanasGestacao;
    
    @Column(name = "ficha_pre_natal_tipo_gravidez")
    private TipoGravidez tipoGravidez;
    
    @Column(name = "ficha_pre_natal_gravidez_planejada")
    private boolean gravidezPlanejada;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ficha_pre_natal_ig")
    private Date ig;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ficha_pre_natal_ultrassom")
    private Date dateUltrassom;
    
    @Column(name = "ficha_pre_natal_diabetes")
    private boolean diabetes;
    
    @Column(name = "ficha_pre_natal_pre_eclampsia")
    private boolean preEclampsia;
    
    @Column(name = "ficha_pre_natal_eclampsia")
    private boolean eclampsia;
    
    @Column(name = "ficha_pre_natal_tromboembolismo")
    private boolean tromboembolismo;
    
    @Column(name = "ficha_pre_natal_doenca_mental")
    private boolean doencaMental;
    
    @Column(name = "ficha_pre_natal_hipertensao")
    private boolean hipertensao;
    
    // Atributos de gestação atual
    @Column(name = "ficha_pre_natal_parto_prematuro")
    private boolean partoPrematuro;
    
    @Column(name = "ficha_pre_natal_isomunizacao_rh")
    private boolean isomunizacaoRh;
    
    @Column(name = "ficha_pre_natal_infeccao_urinaria")
    private boolean infeccaoUrinaria;
    
    @Column(name = "ficha_pre_natal_oligo_polidramnio")
    private boolean oligoPolidramnio;
    
    @Column(name = "ficha_pre_natal_alcool")
    private boolean alcool;
    
    @Column(name = "ficha_pre_natal_cardiopatia")
    private boolean cardiopatia;
    
    @Column(name = "ficha_pre_natal_rotura_prematura_de_membranas")
    private boolean roturaPrematuraMembranas;
    
    @Column(name = "ficha_pre_natal_parto_istmo_cervical")
    private boolean istmoCervical;
    
    @Column(name = "ficha_pre_natal_hiv_aids")
    private boolean hivAids;
    
    @Column(name = "ficha_pre_natal_cigarros")
    private boolean cigarros;
    
    @Column(name = "ficha_pre_natal_drogas")
    private boolean drogas;
    
    @Column(name = "ficha_pre_natal_ciur")
    private boolean ciur;
    
    @Column(name = "ficha_pre_natal_diabetes_gestacional")
    private boolean diabetesGestacional;
    
    @Column(name = "ficha_pre_natal_insulina")
    private boolean insulina;
    
    @Column(name = "ficha_pre_natal_violencia_domestica")
    private boolean violenciaDomestica;
    
    @Column(name = "ficha_pre_natal_pos_datismo")
    private boolean posDatismo;
    
    // Fim de gestação atual
    
    @OneToOne
    @JoinColumn(name = "agendamento_pre_natal_pk")
    private AgendamentoPreNatal agendamentoPreNatal;
    
    @ManyToOne
    @JoinColumn(name = "gestante_pk", nullable = false)
    private Gestante fichaPreNatais;
}
