package singletable.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "funcionario")
@DiscriminatorValue(value = "FUNCIONARIO")
public class Funcionario extends Pessoa {
    
    @Column(name = "salario", precision = 8, scale = 2)
    private BigDecimal salario;

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

}
