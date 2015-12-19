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
 * Entidade que representa a Ficha de atendimento que é feita pelo recepcionista
 * da UBS. A ficha de atendimento é onde são registradas todas as atividades, 
 * procedimentos e notificações dos pacientes atendidos pelo estabelecimento 
 * de saúde em questão.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
public class FichaAtendimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ficha_atendimento_codigo")
    private String codigo;

    @Enumerated(EnumType.STRING)
    @Column(name = "ficha_atendimento_destino", nullable = false)
    private Destino destino;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ficha_atendimento_data")
    private Date data;

    @OneToOne
    @JoinColumn(name = "paciente_pk")
    private Paciente paciente;

    @OneToOne(mappedBy = "fichaAtendimentoTriagem")
    @JoinColumn(name = "triagem_pk")
    private Triagem triagem;

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }
    
    // hashCode e equals

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
