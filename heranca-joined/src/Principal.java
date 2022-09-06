
import dao.FuncionarioDAO;
import dao.PessoaDAO;
import java.math.BigDecimal;
import model.Funcionario;
import model.Pessoa;

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
