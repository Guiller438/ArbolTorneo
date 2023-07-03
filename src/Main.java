import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el numero de equipos: ");
        int altura = scanner.nextInt();
        int nuevaaltura = (int) (Math.log(altura) / Math.log(2));
        if(!isPowerOfTwo(altura)){
            System.out.println("Ingrese un numero de equipos que sea potencia de 2");
            System.exit(0);
        }else{
            Nodo arbol = ArbolBinario.construirArbol(altura);
            ArbolBinario.mostrarArbol(arbol, "", true);
            int nivelActual = 1;
            while (nivelActual < nuevaaltura) {
                //System.out.println("Nivel actual: " + nivelActual + ", Altura: " + nuevaaltura);
                ArbolBinario.combinarNodos(arbol);
                ArbolBinario.mostrarArbol(arbol, "", true);

                if (nivelActual == altura - 1) {
                    break; // Se llegó al último nivel, salir del bucle
                }
                nivelActual++;
                ArbolBinario.ingresarNuevaPuntuacion(arbol);
                ArbolBinario.combinarNodos(arbol);
            }
            ArbolBinario.mostrarArbolCampeon(arbol);
        }


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ventana principalForm = new Ventana();
                principalForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                principalForm.setBounds(200,200,800,500);
                principalForm.setContentPane(principalForm.getMainPanel());
                principalForm.setVisible(true);
            }
        });

    }
    public static boolean isPowerOfTwo(int num) {
        return num > 0 && (num & (num - 1)) == 0;
    }
}
