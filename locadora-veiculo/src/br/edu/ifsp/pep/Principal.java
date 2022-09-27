package br.edu.ifsp.pep;

import br.edu.ifsp.pep.dao.ClienteDAO;
import br.edu.ifsp.pep.dao.LocacaoDAO;
import br.edu.ifsp.pep.dao.TipoVeiculoDAO;
import br.edu.ifsp.pep.dao.VeiculoDAO;
import br.edu.ifsp.pep.modelo.Cliente;
import br.edu.ifsp.pep.modelo.Locacao;
import br.edu.ifsp.pep.modelo.TipoVeiculo;
import br.edu.ifsp.pep.modelo.Veiculo;
import br.edu.ifsp.pep.modelo.VeiculoLocado;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class Principal {

    private static VeiculoDAO veiculoDAO = new VeiculoDAO();
    private static TipoVeiculoDAO tipoVeiculoDAO = new TipoVeiculoDAO();
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static LocacaoDAO locacaoDAO = new LocacaoDAO();

    public static void main(String[] args) {
        adicionarVeiculos();
        adicionarClientes();
        locarVeiculo();
        exibirVeiculosDisponiveisParaLocacao();
        devolverVeiculo();
    }
    
    private static void devolverVeiculo() {
        
        Locacao locacao = locacaoDAO.findById(1);
        List<VeiculoLocado> veiculosLocado = locacao.getVeiculosLocado();
        VeiculoLocado veiculoLocado = veiculosLocado.get(0);
        
        Date dataDevolucaoReal = new Date(2022-1900, 8, 29);
        veiculoLocado.setDataDevolucao(dataDevolucaoReal);
        
        Calendar dataDevolucao = Calendar.getInstance();
        dataDevolucao.setTime(locacao.getData());
        dataDevolucao.add(Calendar.DAY_OF_MONTH, 
                veiculoLocado.getDiasLocado());
        
        if (dataDevolucaoReal.after(dataDevolucao.getTime())) {
            System.out.println("Haverá multa a ser paga!!");
        }
        
        
        locacaoDAO.alterar(locacao);
        
        
        
    }
    
    private static void exibirVeiculosDisponiveisParaLocacao() {
        List<Veiculo> veiculos = veiculoDAO
                .buscarVeiculosDisponiveisParaLocacao();
        
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo);
        }
    }

    private static void locarVeiculo() {
        //Localizar cliente
        Cliente cliente = clienteDAO.findById(1);

        //Localizar os veículos
        List<Veiculo> veiculos = veiculoDAO.buscarTodos();

        //Criar um objeto do tipo Locacao
        Locacao locacao = new Locacao(new Date(), cliente);

        List<VeiculoLocado> veiculosLocado = new ArrayList<>();
        VeiculoLocado veiculoLocado = new VeiculoLocado(
                veiculos.get(0), locacao, 5);

        veiculosLocado.add(veiculoLocado);

        VeiculoLocado veiculoLocado2 = new VeiculoLocado(
                veiculos.get(1), locacao, 3);

        veiculosLocado.add(veiculoLocado2);

        locacao.setVeiculosLocado(veiculosLocado);

        try {
            //Persistir o objeto locacao
            locacaoDAO.inserir(locacao);

            double diariaVeiculo1 = veiculos.get(0)
                    .getTipo().getValorDiaria().doubleValue() * 5;
            double diariaVeiculo2 = veiculos.get(1)
                    .getTipo().getValorDiaria().doubleValue() * 3;

            System.out.println("Valor da locação do veículo 1: "
                    + diariaVeiculo1);
            System.out.println("Valor da locação do veículo 2: "
                    + diariaVeiculo2);
            System.out.println("Total da locação: "
                    + (diariaVeiculo1 + diariaVeiculo2));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void adicionarClientes() {
        for (int i = 0; i < 10; i++) {
            try {
                clienteDAO.inserir(new Cliente("Cliente " + i));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void adicionarVeiculos() {

        TipoVeiculo tipoCarro = new TipoVeiculo("Carro", new BigDecimal(100));
        TipoVeiculo tipoMoto = new TipoVeiculo("Moto", new BigDecimal(80));
        TipoVeiculo tipoVan = new TipoVeiculo("Van", new BigDecimal(250));

        try {
            tipoVeiculoDAO.inserir(tipoCarro);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            tipoVeiculoDAO.inserir(tipoMoto);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            tipoVeiculoDAO.inserir(tipoVan);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        Veiculo veiculo1 = new Veiculo("ABC-1234", "P. Epitácio",
                "Gol 1.0", 2010, tipoCarro);
        Veiculo veiculo2 = new Veiculo("ABC-4565", "P. Epitácio",
                "Corola", 2020, tipoCarro);

        try {
            veiculoDAO.inserir(veiculo1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            veiculoDAO.inserir(veiculo2);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        Veiculo veiculo3 = new Veiculo("ABC-0000", "P. Epitácio",
                "Moto XX", 2020, tipoMoto);
        Veiculo veiculo4 = new Veiculo("ABC-0000", "P. Epitácio",
                "Moto YY", 2022, tipoMoto);

        try {
            veiculoDAO.inserir(veiculo3);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            veiculoDAO.inserir(veiculo4);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        Veiculo veiculo5 = new Veiculo("ABC-2222", "P. Epitácio",
                "VAN XX", 2020, tipoVan);
        Veiculo veiculo6 = new Veiculo("ABC-0000", "P. Epitácio",
                "VAN YY", 2022, tipoVan);

        try {
            veiculoDAO.inserir(veiculo5);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            veiculoDAO.inserir(veiculo6);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
