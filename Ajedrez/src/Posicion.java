

public class Posicion {
    //Atributos

    private int fila;
    private int columna;

    //Constructores


    public Posicion() {
        fila = 0;
        columna = 0;
    }

    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    //Gets y Sets


    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    //toString


    @Override
    public String toString() {
        return "Posicion{" +
                "fila=" + fila +
                ", columna=" + columna +
                '}';
    }
}
