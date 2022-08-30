package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author aluno
 */
@Embeddable
public class ItemPK implements Serializable {
    
    @Column(name = "produto_id", insertable = false, updatable = false)
    private int produto;
    
    @Column(name = "venda_id", insertable = false, updatable = false)
    private int venda;

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getVenda() {
        return venda;
    }

    public void setVenda(int venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.produto;
        hash = 53 * hash + this.venda;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemPK other = (ItemPK) obj;
        if (this.produto != other.produto) {
            return false;
        }
        return this.venda == other.venda;
    }
    
    
}
