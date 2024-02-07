import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Tablero tablero = new Tablero();
        boolean turno = true;
        Juego juego = new Juego(turno);
        int cont = 0;
        while (cont < 30) {
            tablero.pintarTablero();
            if (turno == true) {
                System.out.println("Turnos de las fichas blancas");
                System.out.println("Introduce una jugada, ejemplo: A5B6");
                String jugadab = teclado.nextLine();
                if (juego.jugada(jugadab,tablero) != null) {
                    if (!tablero.hayPieza(juego.jugada(jugadab, tablero).getPosIni())) {
                        if (tablero.hayPieza(juego.jugada(jugadab, tablero).getPosFin())) {
                            tablero.ponPieza(tablero.devuelvePieza(juego.jugada(jugadab,tablero).getPosIni()), juego.jugada(jugadab,tablero).getPosFin());
                            tablero.quitaPieza(juego.jugada(jugadab,tablero).getPosIni());
                            cont++;
                        }
                    }
                } else {
                    System.out.println("La jugada no es válida");
                }
            }
        }

    }
}
