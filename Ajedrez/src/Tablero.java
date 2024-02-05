

public class Tablero {
    //Atributos

    Pieza[][] tablero = new Pieza[8][8];

    //Constructores

    /**
     * Constructor de Tablero que crea las piezas en su posición correspondiente en el tablero
     */
    public Tablero() {
        tablero[0][0] = new Torre(true);
        tablero[0][7] = new Torre(true);
        tablero[7][0] = new Torre(false);
        tablero[7][7] = new Torre(false);
    }

    //Métodos

    /**
     * Método que permite pintar el nombre de cada pieza en el tablero
     */
    public void pintarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] != null) {
                    System.out.print(tablero[i][j].getClass().getSimpleName() + " ");
                } else {
                    System.out.print("nada ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Método que recibe un parámetro de entrada de tipo Posicion (pos) que nos permite saber si hay alguna pieza en
     * esta posición. Este método nos devulve un booleano que en caso de haber pieza en esta posición será true
     * @param pos Posicion
     * @return Boolean verdad
     */
    public boolean hayPieza(Posicion pos){
        boolean verdad = true;
        if (tablero[pos.getColumna()][pos.getFila()] == null) {
            verdad = false;
        }
        return verdad;
    }

    /**
     * Método que recibe dos parámetros de entrada de tipo entero (fila,columna) que nos permite saber si hay alguna pieza en
     * esta posición. Este método nos devulve un booleano que en caso de haber pieza en esta posición será true
     * @param fila Entero
     * @param columna Entero
     * @return Boolean verdad
     */
    public boolean hayPieza(int fila, int columna) {
        boolean verdad = true;
        if (tablero[columna][fila] == null) {
            verdad = false;
        }
        return verdad;
    }
}
