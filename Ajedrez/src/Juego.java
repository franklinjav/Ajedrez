

public class Juego {
    //Atributos

    private boolean turno;

    //Gets y Sets

    /**
     * Método que nos devuleve el valor del turno
     * @return Boolean turno
     */
    public boolean getTurno() {
        return turno;
    }

    /**
     * Método que recibe un parámetro de entrada de tipo boolean (turno) y que nos permite modificar el turno
     * @param turno Boolean
     */
    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    //Métodos

    /**
     * Método que recibe dos parámetros de entrada de tipo String (jugada) y Tablero (tablero) y que nos permite validar si
     * la jugada introducida por el usuario es válida o no (si se encuentra dentro de los límites del tablero). En caso de
     * ser válida la jugada el método crea un nuevo movimiento con la posición que se ha introducido.
     * @param jugada String
     * @param tablero Tablero
     * @return Movimiento
     */
    public Movimiento jugada(String jugada, Tablero tablero) {
        if (jugada.length() == 4) {
            int posix1 = jugada.toUpperCase().charAt(0) - 65;
            int posiy1 = jugada.charAt(0) - 49;
            int posix2 = jugada.toUpperCase().charAt(0) - 65;
            int posiy2 = jugada.charAt(0) - 49;
            if ((jugada.toUpperCase().charAt(0) >= 'A' && jugada.toUpperCase().charAt(0) <= 'H' && jugada.toUpperCase().charAt(2) >= 'A' && jugada.toUpperCase().charAt(2) <= 'H') && (jugada.charAt(1) >= '1' && jugada.charAt(1) <= '8' && jugada.charAt(3) >= '1' && jugada.charAt(3) <= '8')) {
                if (!tablero.hayPieza(posix2, posiy2)) {
                    return new Movimiento(new Posicion(posix1, posiy1), new Posicion(posix2, posiy2));
                }
            }
        }
        return new Movimiento();
    }
}
