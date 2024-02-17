

public class Posicion {
    //Atributos

    private int columna;
    private int fila;

    //Constructores

    /**
     * Constructor que inicializa la posición a 0 (tanto filas como columnas)
     */
    public Posicion() {
        columna = 0;
        fila = 0;
    }

    /**
     * Constructor que recibe dos parámetros de entrada de tipo entero (la fila y la columna) e inicializa los atributos a ese
     * valor
     * @param fila Entero
     * @param columna Entero
     */
    public Posicion(int columna, int fila) {
        this.columna = columna;
        this.fila = fila;
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
