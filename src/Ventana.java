import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    Nodo arbol = new Nodo();
    private JPanel mainPanel;
    private JTextField txtequipos;
    private JButton jugarButton;
    private JTextArea torneo;
public Ventana() {

    jugarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(txtequipos.getText().isEmpty() || !isPowerOfTwo(Integer.parseInt(txtequipos.getText()))){
                JOptionPane.showMessageDialog(null, "Ingrese el numero de equipos correcto");
            }else{
                arbol = ArbolBinario.construirArbol(Integer.parseInt(txtequipos.getText()));
                ArbolBinario.mostrarArbolEnTextArea(arbol, "", true, torneo);
            }
        }
    });

}
    public JPanel getMainPanel() {
        return mainPanel;
    }
    public static boolean isPowerOfTwo(int num) {
        return num > 0 && (num & (num - 1)) == 0;
    }
}
