package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Locacao;
import br.edu.ifsp.pep.modelo.Veiculo;
import br.edu.ifsp.pep.modelo.VeiculoLocado;
import javax.persistence.EntityManager;

/**
 *
 * @author aluno
 */
public class LocacaoDAO extends AbstractDAO<Locacao> {

    @Override
    public void inserir(Locacao locacao) throws Exception {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();

        for (VeiculoLocado veiculoLocado : locacao.getVeiculosLocado()) {
            Veiculo veiculo = veiculoLocado.getVeiculo();
            veiculo.setLocado(true);
            em.merge(veiculo);
        }

        em.persist(locacao);

        em.getTransaction().commit();
        em.close();

    }

    public Locacao findById(long id) {
        return getEntityManager().find(Locacao.class, id);
    }

}
