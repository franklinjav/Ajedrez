import java.util.Scanner;

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
        tablero[0][3] = new Reina(true);
        tablero[0][4] = new Rey(true);
        tablero[0][5] = new Alfil(true);
        tablero[0][6] = new Caballo(true);
        tablero[0][7] = new Torre(true);
        tablero[7][0] = new Torre(false);
        tablero[7][1] = new Caballo(false);
        tablero[7][2] = new Alfil(false);
        tablero[7][3] = new Reina(false);
        tablero[7][4] = new Rey(false);
        tablero[7][5] = new Alfil(false);
        tablero[7][6] = new Caballo(false);
        tablero[7][7] = new Torre(false);
        for (int i = 1; i < 7; i = i+5) {
            for (int j = 0; j < tablero.length; j++) {
                if (i == 1) {
                    tablero[i][j] = new Peon(true);
                } else {
                    tablero[i][j] = new Peon(false);
                }
            }
        }
    }

    //Métodos

    /**
     * Método que permite pintar el unicode de cada pieza en el tablero
     */
    public void pintarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] != null) {
                    if (j == 7) {
                        System.out.print(tablero[i][j].pintarPieza() + "  " + (i+1));
                    } else {
                        System.out.print(tablero[i][j].pintarPieza() + "  ");
                    }
                } else if (j == 7){
                    System.out.print("\u29C9" + "  " + (i+1));
                } else {
                    System.out.print("\u29C9" + "  ");
                }
            }
            System.out.println();
        }
        char letra = 'a';
        for (int i = 0; i < tablero.length; i++, letra++) {
            System.out.print(letra + "   ");
        }
        System.out.println();
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
    public boolean hayPieza(int columna, int fila) {
        boolean verdad = false;
        if (tablero[fila][columna] == null) {
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
        if (!hayPieza(columna, fila) || figura.color != tablero[columna][fila].color) {
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
        if (!hayPieza(pos)) {
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

    /**
     *Método que recibe un argumento de entrada de tipo Movimiento (mov) y nos devuelve un booleano que nos
     * @param mov
     * @return
     */
    public boolean hayPiezasEntre(Movimiento mov) {
        boolean verdad = false;
        if (mov.esVertical()) {
            if (mov.getPosIni().getColumna() < mov.getPosFin().getColumna()) {
                for (int i = mov.getPosIni().getColumna() + 1; i < mov.getPosFin().getColumna(); i++) {
                    if (!hayPieza(mov.getPosIni().getFila(),i)){
                        verdad = true;
                    }
                }
            } else {
                for (int i = mov.getPosIni().getColumna()-1; i > mov.getPosFin().getColumna(); i--) {
                    if (!hayPieza(mov.getPosIni().getFila(),i)){
                        verdad = true;
                    }
                }
            }
        } else if (mov.esHorizontal()) {
            if (mov.getPosIni().getFila() < mov.getPosFin().getFila()) {
                for (int i = mov.getPosIni().getFila() + 1; i < mov.getPosFin().getFila(); i++) {
                    if (!hayPieza(i,mov.getPosIni().getColumna())){
                        verdad = true;
                    }
                }
            } else {
                for (int i = mov.getPosIni().getFila() - 1; i > mov.getPosFin().getFila(); i--) {
                    if (!hayPieza(i,mov.getPosIni().getColumna())){
                        verdad = true;
                    }
                }
            }
        } else if (mov.esDiagonal()) {
            if (mov.getPosIni().getFila() > mov.getPosFin().getFila() && mov.getPosIni().getColumna() > mov.getPosFin().getColumna()) {
                for (int i = mov.getPosIni().getFila() - 1, j = mov.getPosIni().getColumna() -1; i > mov.getPosFin().getFila(); i--,j--) {
                    if (!hayPieza(i,j)) {
                        verdad = true;
                    }
                }
            } else if (mov.getPosIni().getFila() < mov.getPosFin().getFila() && mov.getPosIni().getColumna() > mov.getPosFin().getColumna()) {
                for (int i = mov.getPosIni().getFila() + 1, j = mov.getPosIni().getColumna() - 1; i < mov.getPosFin().getFila(); i++,j--) {
                    if (!hayPieza(i,j)) {
                        verdad = true;
                    }
                }
            } else if (mov.getPosIni().getFila() > mov.getPosFin().getFila() && mov.getPosIni().getColumna() < mov.getPosFin().getColumna()) {
                for (int i = mov.getPosIni().getFila() - 1, j = mov.getPosIni().getColumna() + 1; i > mov.getPosFin().getFila(); i--,j++) {
                    if (!hayPieza(i,j)) {
                        verdad = true;
                    }
                }
            } else if (mov.getPosIni().getFila() < mov.getPosFin().getFila() && mov.getPosIni().getColumna() < mov.getPosFin().getColumna()) {
                for (int i = mov.getPosIni().getFila() + 1, j = mov.getPosIni().getColumna() + 1; i < mov.getPosFin().getFila(); i++,j++) {
                    if (!hayPieza(i,j)) {
                        verdad = true;
                    }
                }
            }
        }
        return verdad;
    }

    public void menu(Posicion pos) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 10;
        do {
            System.out.println("Promoción de peón, introduzca:\n1 Reina\n2 Torre\n3 Alfil\n4 Caballo");
            opcion = teclado.nextInt();
            if (opcion < 1 || opcion > 4) {
                System.out.println("Opción no válida, vuleva a intentarlo");
            }
        } while (opcion < 1 || opcion > 4);
        if (opcion == 1) {
            tablero[pos.getColumna()][pos.getFila()] = new Reina(tablero[pos.getColumna()][pos.getFila()].getColor());
        } else if (opcion == 2) {
            tablero[pos.getColumna()][pos.getFila()] = new Torre(tablero[pos.getColumna()][pos.getFila()].getColor());
        } else if (opcion == 3) {
            tablero[pos.getColumna()][pos.getFila()] = new Alfil(tablero[pos.getColumna()][pos.getFila()].getColor());
        } else if (opcion == 4) {
            tablero[pos.getColumna()][pos.getFila()] = new Caballo(tablero[pos.getColumna()][pos.getFila()].getColor());
        }
    }
    public boolean promocion(Posicion pos){
        boolean verdad = false;
        if (pos.getColumna() == 0 || pos.getColumna() == 7) {
            verdad = true;
        }
        return verdad;
    }
    public boolean verifEnroque(boolean color) {
        boolean verdad = false;
        if (!color) {
            if (!hayPieza(4,7) && !hayPieza(7,7)) {
                if (!hayPiezasEntre(new Movimiento(new Posicion(7,4),new Posicion(7,7))) && !devuelvePieza(new Posicion(7,4)).getPaso() && !devuelvePieza(new Posicion(7,7)).getPaso()) {
                verdad = true;
                }
            } else if (!hayPieza(4,7) && !hayPieza(0,7)) {
                if (!hayPiezasEntre(new Movimiento(new Posicion(7,4),new Posicion(7,0))) && !devuelvePieza(new Posicion(7,4)).getPaso() && !devuelvePieza(new Posicion(7,0)).getPaso()) {
                    verdad = true;
                }
            }
        }else {
            if (!hayPieza(4,0) && !hayPieza(7,0)) {
                if (!hayPiezasEntre(new Movimiento(new Posicion(0,4),new Posicion(0,7))) && !devuelvePieza(new Posicion(0,4)).getPaso() && !devuelvePieza(new Posicion(0,7)).getPaso()) {
                    verdad = true;
                }
            } else if (!hayPieza(4,0) && !hayPieza(0,0)) {
                if (!hayPiezasEntre(new Movimiento(new Posicion(0,4),new Posicion(0,0))) && !devuelvePieza(new Posicion(0,4)).getPaso() && !devuelvePieza(new Posicion(0,0)).getPaso()) {
                    verdad = true;
                }
            }
        }
        return verdad;
    }
    public void hacerEnroque(Movimiento mov,boolean color) {
        if (!color) {
            if (mov.getPosFin().getFila() == 0) {
                ponPieza(new Torre(false), new Posicion(7, 3));
                quitaPieza(new Posicion(7, 0));
                ponPieza(new Rey(false), new Posicion(7, 2));
                quitaPieza(new Posicion(7, 4));
            } else {
                ponPieza(new Torre(false),new Posicion(7,5));
                quitaPieza(new Posicion(7, 7));
                ponPieza(new Rey(false), new Posicion(7, 6));
                quitaPieza(new Posicion(7, 4));
            }
        } else {
            if (mov.getPosFin().getFila() == 0) {
                ponPieza(new Torre(true), new Posicion(0, 3));
                quitaPieza(new Posicion(0, 0));
                ponPieza(new Rey(false), new Posicion(0, 2));
                quitaPieza(new Posicion(0, 4));
            } else {
                ponPieza(new Torre(true),new Posicion(0,5));
                quitaPieza(new Posicion(0, 7));
                ponPieza(new Rey(false), new Posicion(0, 6));
                quitaPieza(new Posicion(0, 4));
            }
        }
    }
}
