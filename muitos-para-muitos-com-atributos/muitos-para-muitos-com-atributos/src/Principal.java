
import br.edu.ifsp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.modelo.Produto;
import java.math.BigDecimal;

/**
 *
 * @author aluno
 */
public class Principal {

    private static ProdutoDAO produtoDAO = new ProdutoDAO();
    
    public static void main(String[] args) {
        adicionarProdutos();
    }

    private static void adicionarProdutos() {
        for (int i = 0; i < 10; i++) {

            Produto p = new Produto("Produto " + i, i * 10, 
                    new BigDecimal((i + 1) * 100));
            
            produtoDAO.inserir(p);
        }
    }
}
