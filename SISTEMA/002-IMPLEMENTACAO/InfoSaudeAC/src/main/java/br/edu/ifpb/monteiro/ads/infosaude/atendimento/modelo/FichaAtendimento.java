package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "ficha_atendimento_destino", nullable = false)
    private String destino;

    @Temporal(TemporalType.DATE)
    @Column(name = "ficha_atendimento_data")
    private Date data;

    @OneToOne(mappedBy = "fichaAtendimento")
    @JoinColumn(name = "triagem_pk")
    private Triagem triagem;
    
    @OneToOne(mappedBy = "fichaAtendimento")
    @JoinColumn(name = "consulta_pk")
    private Consulta consulta;
    
    @OneToOne(mappedBy = "fichaAtendimento")
    @JoinColumn(name = "procedimento_pk")
    private Procedimento procedimento;
    

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Triagem getTriagem() {
        return triagem;
    }

    public void setTriagem(Triagem triagem) {
        this.triagem = triagem;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

}
