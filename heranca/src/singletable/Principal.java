package singletable;


import singletable.dao.FuncionarioDAO;
import singletable.dao.PessoaDAO;
import singletable.model.Funcionario;
import singletable.model.Pessoa;
import java.math.BigDecimal;

/**
 *
 * @author aluno
 */
public class Principal {
    public static void main(String[] args) {
        
        Pessoa p1 = new Pessoa();
        p1.setNome("João");
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.inserir(p1);
        
        Funcionario f1 = new Funcionario();
        f1.setNome("Maria");
        f1.setSalario(new BigDecimal(50000));
        
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.inserir(f1);
        
    }
    
}
