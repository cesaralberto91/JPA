package br.edu.ifsp.pep.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aluno
 */
public abstract class AbstractDAO<T> {

    private EntityManagerFactory emf;

    public AbstractDAO() {
        emf = Persistence
                .createEntityManagerFactory("conexaoPU");
    }

    public EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }

    public void inserir(T entity) throws Exception {
        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();

        em.close();
    }

    public void alterar(T entity) {
        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();

        em.close();
    }
    
    public void remover(T entity) {
        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();

        em.close();
    }

}
