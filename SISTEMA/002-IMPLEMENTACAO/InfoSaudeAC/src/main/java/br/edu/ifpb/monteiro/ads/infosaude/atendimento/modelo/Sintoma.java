package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entidade que representa o Sintoma que o paciente está tendo que pode ser
 * extraído de uma consulta do Médico, Enfermeiro ou Odontólogo da UBS. 
 * Ao extender Pessoa, passa a herdar todos os seus atributos.
 * 
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
public class Sintoma implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sintoma_descricao", length = 150)
    private String descricao;

    public Sintoma() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    // hashCode e equals

    @Override
    public int hashCode() {
        int hashSintoma = 3;
        hashSintoma = 47 * hashSintoma + Objects.hashCode(this.id);
        return hashSintoma;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sintoma other = (Sintoma) obj;
        return Objects.equals(this.id, other.id);
    }

}
