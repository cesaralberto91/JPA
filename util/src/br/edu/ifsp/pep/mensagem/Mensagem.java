package br.edu.ifsp.pep.mensagem;

import javax.swing.JOptionPane;

/**
 *
 * @author cesar
 */
public class Mensagem {

    public static void sucesso(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static void atencao(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    public static void erro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
