

public class Juego {
    //Atributos

    private boolean turno;

    //Gets y Sets


    public boolean getTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    //Métodos

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
