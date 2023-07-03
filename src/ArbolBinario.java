import javax.swing.*;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ArbolBinario {

    ArbolBinario arbol = null;
    public ArbolBinario(ArbolBinario arbol) {
        ArbolBinario arbol1 = null;;
    }

    public static Nodo construirArbol(int altura) {
        int nuevaaltura = (int) (Math.log(altura) / Math.log(2)) ;
        return construirArbolAux(nuevaaltura, 0);
    }

    public static Nodo construirArbolAux(int altura, int nivel) {
        if (nivel > altura) {
            return null;
        }

        Nodo nodo = new Nodo();
        if (nivel == altura ) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el nombre del equipo para el nodo: ");
            nodo.nombre = scanner.nextLine();
            System.out.print("Ingrese la puntuación para el nodo: ");
            nodo.puntuacion = scanner.nextInt();
        }
        //System.out.println("Nivel: " + nivel + ", Altura: " + altura);
        nodo.izquierda = construirArbolAux(altura, nivel + 1);
        nodo.derecha = construirArbolAux(altura, nivel + 1);
        return nodo;
    }



    public static void mostrarArbol(Nodo nodo, String prefijo, boolean esIzquierdo) {
        if (nodo == null) {
            return;
        }

        System.out.println(prefijo + (esIzquierdo ? "|-- " : "\\-- ") + "Equipo: " + nodo.nombre
                            + ", Puntuación: " + nodo.puntuacion);

        String prefijoAuxiliar = prefijo + (esIzquierdo ? "|   " : "    ");
        mostrarArbol(nodo.izquierda, prefijoAuxiliar, true);
        mostrarArbol(nodo.derecha, prefijoAuxiliar, false);
    }

    public static void cambiarInformacionNodos(Nodo nodo, int altura, int nivelDeseado) {
        if (nodo == null) {
            return;
        }
        if (altura == nivelDeseado) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese el nombre del equipo para el nodo: ");
            nodo.nombre = scanner.nextLine();

            System.out.print("Ingrese la puntuación para el nodo: ");
            nodo.puntuacion = scanner.nextInt();
        } else if (altura < nivelDeseado) {
            cambiarInformacionNodos(nodo.izquierda, altura + 1, nivelDeseado);
            cambiarInformacionNodos(nodo.derecha, altura + 1, nivelDeseado);
        }
    }

    public static void ingresarNuevaPuntuacion(Nodo nodo) {
        if (nodo == null || (nodo.izquierda == null && nodo.derecha == null)) {
            return;
        }

        if (nodo.puntuacion != 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese la nueva puntuación para el equipo " + nodo.getNombre().toString() + ": ");
            int nuevaPuntuacion = scanner.nextInt();
            nodo.puntuacion = nuevaPuntuacion;
        }

        ingresarNuevaPuntuacion(nodo.izquierda);
        ingresarNuevaPuntuacion(nodo.derecha);
    }

    public static void combinarNodos(Nodo nodo) {
        if (nodo == null || (nodo.izquierda == null && nodo.derecha == null)) {
            return;
        }

        Nodo nodoIzquierda = nodo.izquierda;
        Nodo nodoDerecha = nodo.derecha;

        int puntuacionIzquierda = nodoIzquierda != null ? nodoIzquierda.puntuacion : Integer.MIN_VALUE;
        int puntuacionDerecha = nodoDerecha != null ? nodoDerecha.puntuacion : Integer.MIN_VALUE;

        if (puntuacionIzquierda >= puntuacionDerecha) {
            nodo.puntuacion = puntuacionIzquierda;
            nodo.nombre = nodoIzquierda.nombre;
        } else {
            nodo.puntuacion = puntuacionDerecha;
            nodo.nombre = nodoDerecha.nombre;
        }

        combinarNodos(nodoIzquierda);
        combinarNodos(nodoDerecha);
    }

    public static void mostrarArbolCampeon(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        System.out.println("El Equipo campeon es: " + nodo.getNombre().toString() + " con una puntuación de: " + nodo.getPuntuacion());
    }
    public static boolean esRaiz(Nodo nodo, Nodo arbol) {
        Nodo raiz = encontrarRaiz(arbol); // Encontrar la raíz del árbol
        return nodo == raiz;
    }

    public static Nodo encontrarRaiz(Nodo nodo) {
        if (nodo == null || (nodo.izquierda == null && nodo.derecha == null)) {
            return nodo;
        }
        return encontrarRaiz(nodo.izquierda != null ? nodo.izquierda : nodo.derecha);
    }

    public static void mostrarArbolEnTextArea(Nodo nodo, String prefijo, boolean esIzquierdo, JTextArea textArea) {
        if (nodo == null) {
            return;
        }

        textArea.append(prefijo + (esIzquierdo ? "|-- " : "\\-- ") + "Equipo: " + nodo.nombre + ", Puntuación: " + nodo.puntuacion + "\n");

        String prefijoAuxiliar = prefijo + (esIzquierdo ? "|   " : "    ");
        mostrarArbolEnTextArea(nodo.izquierda, prefijoAuxiliar, true, textArea);
        mostrarArbolEnTextArea(nodo.derecha, prefijoAuxiliar, false, textArea);
    }

}
