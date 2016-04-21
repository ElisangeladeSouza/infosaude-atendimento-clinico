package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 * Entidade que representa o cadastro das informações básicas da unidade básica
 * de saúde. Informações como, endereço, número de contato e identificação da
 * UBS junto ao Minsitério da Saúde.
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
@Entity
@Data
public class Ubs implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ubs_data")
    private Date data;

    @Column(name = "ubs_nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "ubs_cnes", nullable = false, length = 15)
    private Long cnes;

    @Column(name = "ubs_telefone", length = 20)
    private String telefoneUbs;

    @Lob
    private byte[] logo;

    @Embedded
    private Endereco endereco;

    public Ubs() {
        endereco = new Endereco();
        getEndereco().setEstado(Estados.PB);
        setEndereco(endereco);
    }

}
