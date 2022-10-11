package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "tipo_veiculo")
@NamedQueries({
    @NamedQuery(name = "TipoVeiculo.findByNome",
            query = "SELECT t FROM TipoVeiculo t WHERE UPPER(t.nome) LIKE UPPER(:nome)"),
    @NamedQuery(name = "TipoVeiculo.findAll",
            query = "SELECT t FROM TipoVeiculo t")})
public class TipoVeiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome", length = 40, nullable = false)
    private String nome;

    @Column(name = "valor_diaria", precision = 6, scale = 2, nullable = false)
    private BigDecimal valorDiaria;

    public TipoVeiculo() {
    }

    public TipoVeiculo(String nome, BigDecimal valorDiaria) {
        this.nome = nome;
        this.valorDiaria = valorDiaria;
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

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    @Override
    public String toString() {
        return nome;
    }

}
