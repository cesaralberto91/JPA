package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "telefone")
@IdClass(TelefonePK.class)
public class Telefone implements Serializable {

    @Id
    @Column(name = "ddd")
    private int ddd;
    @Id
    @Column(name = "numero", length = 20)
    private String numero;
    
    @Column(name = "descricao", length = 40, nullable = false)
    private String descricao;

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    

}
