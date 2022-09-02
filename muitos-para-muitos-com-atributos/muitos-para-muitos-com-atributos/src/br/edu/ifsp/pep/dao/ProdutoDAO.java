package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Produto;
import java.util.List;

/**
 *
 * @author aluno
 */
public class ProdutoDAO extends AbstractDAO<Produto>{
    
    public List<Produto> obterTodos() {
        return getEntityManager().createQuery("SELECT p FROM Produto p", Produto.class)
                .getResultList();
    }
}
