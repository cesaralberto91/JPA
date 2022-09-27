package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Veiculo;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author aluno
 */
public class VeiculoDAO extends AbstractDAO<Veiculo> {

    public List<Veiculo> buscarTodos() {
        return getEntityManager()
                .createNamedQuery("Veiculo.buscarTodos", Veiculo.class)
                .getResultList();
    }
    
    public List<Veiculo> buscarVeiculosDisponiveisParaLocacao() {
        return getEntityManager()
                .createNamedQuery("Veiculo.buscarDisponiveisParaLocacao", Veiculo.class)
                .getResultList();
    }
    

    @Override
    public void inserir(Veiculo veiculo) throws Exception {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        List<Veiculo> veiculos = em.createNamedQuery(
                "Veiculo.buscarPorPlacaECidade",
                Veiculo.class)
                .setParameter("placa", veiculo.getPlaca())
                .setParameter("cidade", veiculo.getCidade())
                .getResultList();
        if (veiculos == null || veiculos.isEmpty()) {
            em.persist(veiculo);
        } else {
            throw new Exception(
                    "Já existe um Veículo com a placa "
                    + veiculo.getPlaca()
                    + " na cidade " + veiculo.getCidade());
        }

        em.getTransaction().commit();
        em.close();
    }

}
