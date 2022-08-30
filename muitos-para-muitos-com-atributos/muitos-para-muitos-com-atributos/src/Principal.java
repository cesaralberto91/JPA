
import javax.persistence.Persistence;

/**
 *
 * @author aluno
 */
public class Principal {
    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("conexaoPU");
    }
}
