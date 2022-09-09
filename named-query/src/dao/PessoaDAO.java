package dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Pessoa;

/**
 *
 * @author aluno
 */
public class PessoaDAO extends AbstractDAO<Pessoa> {

    public Pessoa buscarPorId(long id) {
        EntityManager em = getEntityManager();
        TypedQuery<Pessoa> query = em.createNamedQuery(
                "Pessoa.buscarPorId", Pessoa.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    public List<Pessoa> buscarPorNome(String nome) {
        EntityManager em = getEntityManager();
        TypedQuery<Pessoa> query = em.createNamedQuery(
                "Pessoa.buscarPorNome", Pessoa.class);
        query.setParameter("nome", "%" + nome + "%");

        return query.getResultList();
    }
    
    public List<Pessoa> buscarPorSalario(BigDecimal salario) {
        EntityManager em = getEntityManager();
        TypedQuery<Pessoa> query = em.createNamedQuery(
                "Pessoa.buscarPorSalario", Pessoa.class);
        query.setParameter("salario", salario);

        return query.getResultList();
    }
    
    public List<Pessoa> buscarPorDataNascimento(Date dataNascimento) {
        EntityManager em = getEntityManager();
        TypedQuery<Pessoa> query = em.createNamedQuery(
                "Pessoa.buscarPorDataNascimento", Pessoa.class);
        query.setParameter("dataNascimento", dataNascimento);

        return query.getResultList();
    }
}
