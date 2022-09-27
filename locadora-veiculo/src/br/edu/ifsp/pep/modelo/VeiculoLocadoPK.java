package br.edu.ifsp.pep.modelo;

import java.io.Serializable;

/**
 *
 * @author aluno
 */
public class VeiculoLocadoPK implements Serializable {
    
    private long veiculo;
    private long locacao;

    public long getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(long veiculo) {
        this.veiculo = veiculo;
    }

    public long getLocacao() {
        return locacao;
    }

    public void setLocacao(long locacao) {
        this.locacao = locacao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (int) (this.veiculo ^ (this.veiculo >>> 32));
        hash = 53 * hash + (int) (this.locacao ^ (this.locacao >>> 32));
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
        final VeiculoLocadoPK other = (VeiculoLocadoPK) obj;
        if (this.veiculo != other.veiculo) {
            return false;
        }
        return this.locacao == other.locacao;
    }
    
    
    
}
