package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 * Entidade que representa a Requisição de Exame para o paciente que pode ser
 * solicitada durante uma consulta do Médico, Enfermeiro ou Odontólogo da UBS.
 * Ao extender Pessoa, passa a herdar todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
@Data
@Table(name = "requisicao_exame")
public class RequisicaoExame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "requisicao_exame_codigo", length = 20)
    private String codigo;

    @Column(name = "requisicao_solicitante_cnes", length = 200)
    private String solicitanteCnes;

    @Column(name = "requisicao_solicitante_endereco", length = 200)
    private String solicitanteEndereco;

    @Column(name = "requisicao_solicitante_cidade", length = 100)
    private String solicitanteCidade;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "requisicao_data")
    private Date data;

    private List<String> exames;

}
