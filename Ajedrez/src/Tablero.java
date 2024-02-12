

public class Tablero {
    //Atributos

    Pieza[][] tablero = new Pieza[8][8];

    //Constructores

    /**
     * Constructor de Tablero que crea las piezas en su posición correspondiente en el tablero
     */
    public Tablero() {
        tablero[0][0] = new Torre(true);
        tablero[0][1] = new Caballo(true);
        tablero[0][2] = new Alfil(true);
        tablero[0][3] = new Rey(true);
        tablero[0][4] = new Reina(true);
        tablero[0][5] = new Alfil(true);
        tablero[0][6] = new Caballo(true);
        tablero[0][7] = new Torre(true);
        tablero[7][0] = new Torre(false);
        tablero[7][1] = new Caballo(false);
        tablero[7][2] = new Alfil(false);
        tablero[7][3] = new Rey(false);
        tablero[7][4] = new Reina(false);
        tablero[7][5] = new Alfil(false);
        tablero[7][6] = new Caballo(false);
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
                    System.out.print(tablero[i][j].pintarPieza() + "  ");
                } else {
                    System.out.print("\u29C9" + "  ");
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
        boolean verdad = false;
        if (tablero[pos.getColumna()][pos.getFila()] == null) {
            verdad = true;
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
        boolean verdad = false;
        if (tablero[columna][fila] == null) {
            verdad = true;
        }
        return verdad;
    }

    /**
     * Método que recibe tres parámetros de entrada de tipo Pieza (figura) y de tipo Entero (fila y columna) que nos permite colocar la pieza
     * que se recibe por argumento de entrada en la posición indicada.
     * @param figura Pieza
     * @param fila Entero
     * @param columna Entero
     */
    public void ponPieza(Pieza figura,int fila,int columna) {
        if (!hayPieza(fila, columna) || figura.color != tablero[columna][fila].color) {
            tablero[columna][fila] = figura;
        }
    }

    /**
     * Método que recibe dos parámetros de entrada de tipo Pieza (figura) y de tipo Posicion (pos) que nos permite colocar la pieza
     * que se recibe por argumento de entrada en la posición indicada
     * @param figura Pieza
     * @param pos Posición
     */
    public void ponPieza(Pieza figura,Posicion pos) {
        if (hayPieza(pos) || figura.color != tablero[pos.getColumna()][pos.getFila()].color) {
            tablero[pos.getColumna()][pos.getFila()] = figura;
        }
    }

    /**
     * Método que recibe dos argumentos de entrada de tipo Entero (fila y columna) que nos permite poner a null la posición
     * indicada en el tablero
     * @param fila Entero
     * @param columna Entero
     */
    public void quitaPieza(int fila,int columna) {
        if (tablero[columna][fila] != null) {
            tablero[columna][fila] = null;
        }
    }

    /**
     * Método que recibe un argumento de entrada de tipo Posición (pos) que nos permite poner a null la posición indicada
     * en el tablero
     * @param pos Posición
     */
    public void quitaPieza(Posicion pos) {
        tablero[pos.getColumna()][pos.getFila()] = null;
    }

    /**
     * Método que recibe dos argumentos de entrada de tipo Entero (columna y fila) y nos devuelve la Pieza que se encuentra
     * en esa posición
     * @param fila Entero
     * @param columna Entero
     * @return Pieza
     */
    public Pieza devuelvePieza(int fila, int columna) {
        return tablero[columna][fila];
    }

    /**
     * Método que recibe un argumento de entrada de tipo Posición (pos) y nos devuelve la Pieza que se encuentra en esa posición
     * @param pos Posición
     * @return Pieza
     */
    public Pieza devuelvePieza(Posicion pos) {
        return tablero[pos.getColumna()][pos.getFila()];
    }
}
