
import dao.PessoaDAO;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import model.Pessoa;

/**
 *
 * @author aluno
 */
public class Principal {
    
    public static void main(String[] args) {
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        for (int i = 0; i < 10;) {
            
            Pessoa p = new Pessoa("Pessoa " + i, 
                    new Date(2000+i, i, i), new BigDecimal(1000 * ++i));
            
            pessoaDAO.inserir(p);
        }
        
        
        //Testar a consulta
        Pessoa pessoaRetornada = pessoaDAO.buscarPorId(5);
        
        //criar o método toString na classe Pessoa
        System.out.println(pessoaRetornada);
        
        System.out.println("\n\nPessoas que o nome contém 5");
        List<Pessoa> pessoas = pessoaDAO.buscarPorNome("5");
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
        
        
        System.out.println("\n\nPessoas que ganham mais que R$ 5.000,00");
        pessoas = pessoaDAO.buscarPorSalario(new BigDecimal(5000));
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
        
        
        System.out.println("\n\nPessoas que nasceram após 2005");
        pessoas = pessoaDAO.buscarPorDataNascimento(new Date(2005,0,1));
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
        
    }
    
}
