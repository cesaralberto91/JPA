package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "pessoa")
@NamedQueries({
    @NamedQuery(
            name = "Pessoa.buscarPorId",
            query = "SELECT p FROM Pessoa p WHERE p.id = :id"),
    @NamedQuery(name = "Pessoa.buscarPorNome", 
            query = "SELECT p FROM Pessoa p WHERE p.nome LIKE :nome"),
    @NamedQuery(name = "Pessoa.buscarPorSalario", 
            query = "SELECT p FROM Pessoa p WHERE p.salario > :salario"),
    @NamedQuery(name = "Pessoa.buscarPorDataNascimento", 
            query = "SELECT p FROM Pessoa p WHERE p.dataNascimento > :dataNascimento")
})
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "salario", nullable = false, scale = 2, precision = 8)
    private BigDecimal salario;

    public Pessoa() {
    }

    public Pessoa(String nome, Date dataNascimento, BigDecimal salario) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", salario=" + salario + '}';
    }

}
