package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Cliente;

/**
 *
 * @author aluno
 */
public class ClienteDAO extends AbstractDAO<Cliente>{
    
    public Cliente findById(long id) {
        return getEntityManager().find(Cliente.class, id);
    }
}
