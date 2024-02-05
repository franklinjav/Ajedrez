

public class Posicion {
    //Atributos

    private int fila;
    private int columna;

    //Constructores

    /**
     * Constructor que inicializa la posición a 0 (tanto filas como columnas)
     */
    public Posicion() {
        fila = 0;
        columna = 0;
    }

    /**
     * Constructor que recibe dos parámetros de entrada de tipo entero (la fila y la columna) e inicializa los atributos a ese
     * valor
     * @param fila Entero
     * @param columna Entero
     */
    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    //Gets y Sets

    /**
     * Método que nos devuelve el valor de la fila
     * @return Fila entero
     */
    public int getFila() {
        return fila;
    }

    /**
     * Método que recibe un parámetro de entrada de tipo int (fila) y nos permite modificar el atributo fila
     * @param fila Entero
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * Método que nos devuelve el valor de la columna
     * @return columna Entero
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Método que recibe un parámetro de entrada de tipo int (columna) y nos permite modificar el atributo columna
     * @param columna Entero
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    //toString

    /**
     * Método toString generado automáticamente
     * @return toString
     */
    @Override
    public String toString() {
        return "Posicion{" +
                "fila=" + fila +
                ", columna=" + columna +
                '}';
    }
}
