package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Destino;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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

    @OneToOne
    @JoinColumn(name = "paciente_pk")
    private Paciente paciente;

    @Enumerated(EnumType.STRING)
    @Column(name = "ficha_atendimento_destino", nullable = false)
    private Destino destino;

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

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
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

    @Override
    public int hashCode() {
        int hashFicha = 5;
        hashFicha = 79 * hashFicha + Objects.hashCode(this.id);
        return hashFicha;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FichaAtendimento other = (FichaAtendimento) obj;
        return Objects.equals(this.id, other.id);
    }

}
