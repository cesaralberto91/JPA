package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.TipoVeiculo;
import java.util.List;

/**
 *
 * @author aluno
 */
public class TipoVeiculoDAO extends AbstractDAO<TipoVeiculo> {

    public List<TipoVeiculo> findAll() {

        return getEntityManager()
                .createNamedQuery("TipoVeiculo.findAll", TipoVeiculo.class)
                .getResultList();

    }

    public List<TipoVeiculo> findByNome(String nome) {

        return getEntityManager()
                .createNamedQuery("TipoVeiculo.findByNome", TipoVeiculo.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();

    }

}
