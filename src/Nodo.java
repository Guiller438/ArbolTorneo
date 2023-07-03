public class Nodo {
    String nombre;
    int puntuacion;
    Nodo izquierda;
    Nodo derecha;

    public Nodo() {
        this.nombre = "";
        this.puntuacion = 0;
        this.izquierda = null;
        this.derecha = null;
    }

    public Nodo(String nombre, int puntuacion) {
        this.nombre = nombre;
        this.puntuacion = 0;
        this.izquierda = null;
        this.derecha = null;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }


}
