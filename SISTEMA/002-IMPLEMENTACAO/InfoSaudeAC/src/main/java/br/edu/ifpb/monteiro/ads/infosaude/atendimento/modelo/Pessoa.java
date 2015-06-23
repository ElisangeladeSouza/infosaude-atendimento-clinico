package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

/**
 * Classe que representa um modelo de uma entidade a ser persistida no banco,
 * com todos os atributos relacionados. Todas as entidades que tiverem atributos
 * comuns em pessoa, podem herdar suas características apenas extendendo a mesma
 * atravé de herança.
 *
 * @author cassio
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotNull(message = "Um nome deve ser informado")
    @Column(name = "pessoa_nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "pessoa_rg", length = 15)
    private String rg;

    @Column(name = "pessoa_endereco_rua", length = 150)
    private String enderecoRua;

    @Column(name = "pessoa_endereco_numero", length = 6)
    private String enderecoNumero;

    @Column(name = "pessoa_endereco_bairro", length = 100)
    private String enderecoBairro;

    @Enumerated(EnumType.STRING)
    @Column(name = "pessoa_endereco_estado")
    private Estados enderecoEstado;

    @Column(name = "pessoa_endereco_cidade", length = 100)
    private String enderecoCidade;

    @Column(name = "pessoa_endereco_cep", length = 10)
    private String enderecoCep;

    @Temporal(TemporalType.DATE)
    @Column(name = "pessoa_data_nascimento")
    private Date dataNascimento;

    /* Seta a hora de criação ou alteração da entidade */
    @Temporal(TemporalType.DATE)
    @Column(name = "pessoa_data")
    private Date data;

    @Column(name = "pessoa_telefone1", length = 20)
    private String telefone1;

    @Column(name = "pessoa_telefone2", length = 20)
    private String telefone2;

    @Pattern(regexp = "^$|^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$",
            message = "E-mail com formato incorreto")
    @Column(name = "pessoa_email", length = 100)
    private String email;

    @Column(name = "pessoa_cor_raca", length = 15)
    private String corOuRaca;

    public Pessoa() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEnderecoRua() {
        return enderecoRua;
    }

    public void setEnderecoRua(String enderecoRua) {
        this.enderecoRua = enderecoRua;
    }

    public String getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }

    public Estados getEnderecoEstado() {
        return enderecoEstado;
    }

    public void setEnderecoEstado(Estados enderecoEstado) {
        this.enderecoEstado = enderecoEstado;
    }

    public String getEnderecoCidade() {
        return enderecoCidade;
    }

    public void setEnderecoCidade(String enderecoCidade) {
        this.enderecoCidade = enderecoCidade;
    }

    public String getEnderecoCep() {
        return enderecoCep;
    }

    public void setEnderecoCep(String enderecoCep) {
        this.enderecoCep = enderecoCep;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCorOuRaca() {
        return corOuRaca;
    }

    public void setCorOuRaca(String corOuRaca) {
        this.corOuRaca = corOuRaca;
    }

    @Override
    public int hashCode() {
        int hashPessoa = 5;
        hashPessoa = 37 * hashPessoa + Objects.hashCode(this.id);
        return hashPessoa;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.id, other.id);
    }
}
