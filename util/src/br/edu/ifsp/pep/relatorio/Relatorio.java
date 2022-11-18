package br.edu.ifsp.pep.relatorio;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.util.Map;
import javax.persistence.EntityManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.query.JRJpaQueryExecuterFactory;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author aluno
 */
public class Relatorio {

    public static void gerarFromXml(String fileXml, List list) {
        try {
            //carrega o arquivo com o layout do relatorio
            JasperDesign jasperDesign = JRXmlLoader.load(
                    Relatorio.class
                            .getResourceAsStream("/br/edu/ifsp/pep/relatorio/" + fileXml));

            //compila o relatório
            JasperReport relatorioCompilado = JasperCompileManager
                    .compileReport(jasperDesign);

            //gera um data source a partir da lista de veículos
            JRBeanCollectionDataSource dataSource
                    = new JRBeanCollectionDataSource(list);

            //preenche o relatório com os dados dos veículos
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    relatorioCompilado,
                    null,
                    dataSource);

            //exibe o relatório
            JasperViewer viewer
                    = new JasperViewer(jasperPrint, false);
            viewer.setVisible(true);

        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }

    public static JasperViewer gerarFromJasper(String fileJasper, List list, Map<String, Object> parametros) {
        try {
            //gera um data source a partir da lista de veículos
            JRBeanCollectionDataSource dataSource
                    = new JRBeanCollectionDataSource(list);

            //carrega o relatório
            InputStream relatorioCompilado = Relatorio.class
                    .getResourceAsStream("/br/edu/ifsp/pep/relatorio/" + fileJasper);
            
            BufferedImage logo = ImageIO.read(Relatorio.class
                    .getResourceAsStream("/br/edu/ifsp/pep/relatorio/img/logo-ifsp.png"));
            
            HashMap<String, Object> parametros = new HashMap<>();
            parametros.put("logo", logo);

            //preenche o relatório com os dados dos veículos
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    relatorioCompilado,
                    parametros,
                    dataSource);

            //exibe o relatório
            JasperViewer viewer
                    = new JasperViewer(jasperPrint, false);
//            viewer.setVisible(true);
            return viewer;

        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Logo não encontrado.");
        }
        return null;
    }

    public static void gerarFromJasper(String fileJasper, EntityManager em) {

        try {
            //parametros
            HashMap<String, Object> parametros = new HashMap<>();
            parametros.put(
                    JRJpaQueryExecuterFactory.PARAMETER_JPA_ENTITY_MANAGER, em);

            InputStream jasper = Relatorio.class.getResourceAsStream(
                    "/br/edu/ifsp/pep/relatorio/" + fileJasper);

            //preenche o relatório com os dados da tabela do banco
            JasperPrint jp = JasperFillManager
                    .fillReport(jasper, parametros);

            //exibe o relatorio
            JasperViewer viewer
                    = new JasperViewer(jp, false);
            viewer.setVisible(true);
        } catch (JRException ex) {
            ex.printStackTrace();
        }

    }

}
