package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "veiculo_locado")
@IdClass(VeiculoLocadoPK.class)
public class VeiculoLocado implements Serializable{
    
    @Id
    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "locacao_id", nullable = false)
    private Locacao locacao;
    
    @Column(name = "dias_locado", nullable = false)
    private int diasLocado;
    
    @Column(name = "data_devolucao")
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;

    public VeiculoLocado() {
    }

    public VeiculoLocado(Veiculo veiculo, Locacao locacao, int diasLocado) {
        this.veiculo = veiculo;
        this.locacao = locacao;
        this.diasLocado = diasLocado;
    }
    
    

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    public int getDiasLocado() {
        return diasLocado;
    }

    public void setDiasLocado(int diasLocado) {
        this.diasLocado = diasLocado;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    
}
