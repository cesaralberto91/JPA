package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Item;
import br.edu.ifsp.pep.modelo.Venda;
import javax.persistence.EntityManager;

/**
 *
 * @author aluno
 */
public class VendaDAO extends AbstractDAO<Venda>{

    @Override
    public void inserir(Venda venda) {
        
        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.persist(venda);
        
        for (Item item : venda.getItens()) {
            em.persist(item);
        }
        
        em.getTransaction().commit();

        em.close();
        
    }
 
    
    
}
