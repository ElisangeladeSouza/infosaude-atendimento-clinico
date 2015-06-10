package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
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

/**
 *
 * @author cassio
 */
@Entity
public class FichaAtendimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "fichaAtendimento")
    @JoinColumn(name = "paciente_pk")
    private Paciente paciente;

    @Column(name = "ficha_atendimento_destino", nullable = false)
    private String destino;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ficha_atendimento_data")
    private Date dataHora;

//    @OneToOne
    @Column(name = "ficha_atendimento")
    private String atendimento;

    public FichaAtendimento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora() {
        this.dataHora = new DateTimeUtilBean().dateHour();
    }

    public String getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(String atendimento) {
        this.atendimento = atendimento;
    }

}