import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Tablero tablero = new Tablero();
        boolean turno = false;
        Juego juego = new Juego(turno);
        boolean muerte = false;
        while (!muerte) {
            tablero.pintarTablero();
            if (!turno || turno) {
                if (!turno) {
                    System.out.println("Turnos de las blancas");
                } else {
                    System.out.println("Turnos de las negras");
                }
                System.out.println("Introduzca una juegada, por ejemplo : A5A6");
                String jugadam = teclado.nextLine();
                Posicion pos = juego.jugada(jugadam,tablero).getPosIni();
                Posicion pos2 = juego.jugada(jugadam,tablero).getPosFin();
                if (pos != null) {
                    if (juego.jugada(jugadam, tablero) != null) {
                        if (tablero.hayPieza(pos) && tablero.devuelvePieza(pos).getColor() == turno) {
                            if (tablero.hayPieza(pos2)) {
                                if (tablero.devuelvePieza(pos).getClass().getSimpleName().equalsIgnoreCase("Rey") && tablero.devuelvePieza(pos2).getClass().getSimpleName().equalsIgnoreCase("Torre")) {
                                    if (tablero.verifEnroque(turno)) {
                                        tablero.hacerEnroque(juego.jugada(jugadam,tablero), turno);
                                        if (!turno) {
                                            turno = true;
                                        } else {
                                            turno = false;
                                        }
                                    } else {
                                        System.out.println("No se puede realizar el enroque");
                                    }
                                }
                            }
                            if (tablero.devuelvePieza(pos) != null && tablero.devuelvePieza(pos).validoMovimiento(juego.jugada(jugadam, tablero))) {
                                if (!tablero.hayPiezasEntre(juego.jugada(jugadam, tablero))) {
                                    if (tablero.devuelvePieza(pos).getClass().getSimpleName().equalsIgnoreCase("peon")) {
                                        if (tablero.hayPieza(pos2) && juego.jugada(jugadam, tablero).esDiagonal()) {
                                            if (tablero.devuelvePieza(pos2) != null && tablero.devuelvePieza(pos2).getClass().getSimpleName().equalsIgnoreCase("Rey")) {
                                                muerte = true;
                                                if (!turno) {
                                                    System.out.println("Ganan las blancas");
                                                } else {
                                                    System.out.println("Ganan las negras");
                                                }
                                            }
                                            tablero.devuelvePieza(pos).setPaso(true);
                                            tablero.quitaPieza(pos2);
                                            tablero.ponPieza(tablero.devuelvePieza(pos), pos2);
                                            tablero.quitaPieza(pos);
                                            if (!turno) {
                                                turno = true;
                                            } else {
                                                turno = false;
                                            }
                                            if (tablero.promocion(pos2)) {
                                                tablero.menu(pos2);
                                            }
                                        } else if (!tablero.hayPieza(pos2) && !juego.jugada(jugadam, tablero).esDiagonal()) {
                                            tablero.devuelvePieza(pos).setPaso(true);
                                            tablero.ponPieza(tablero.devuelvePieza(pos), pos2);
                                            tablero.quitaPieza(pos);
                                            if (!turno) {
                                                turno = true;
                                            } else {
                                                turno = false;
                                            }
                                            if (tablero.promocion(pos2)) {
                                                tablero.menu(pos2);
                                            }
                                        } else {
                                            System.out.println("Movimiento no válido");
                                        }
                                    } else if (!tablero.hayPieza(pos2) || tablero.devuelvePieza(pos2).getColor() != tablero.devuelvePieza(pos).getColor()) {
                                        if (tablero.devuelvePieza(pos2) != null && tablero.devuelvePieza(pos2).getClass().getSimpleName().equalsIgnoreCase("Rey")) {
                                            muerte = true;
                                            if (!turno) {
                                                System.out.println("Ganan las blancas");
                                            } else {
                                                System.out.println("Ganan las negras");
                                            }
                                        }

                                        tablero.devuelvePieza(pos).setPaso(true);
                                        tablero.quitaPieza(pos2);
                                        tablero.ponPieza(tablero.devuelvePieza(pos), pos2);
                                        tablero.quitaPieza(pos);
                                        if (!turno) {
                                            turno = true;
                                        } else {
                                            turno = false;
                                        }
                                    }
                                } else {
                                    System.out.println("La pieza que seleccionada no puede realizar ese movimiento");
                                }
                            } else {
                                System.out.println("Movimiento no válido");
                            }
                        } else {
                            System.out.println("Movimiento no válido");
                        }
                    } else {
                        System.out.println("La jugada no es válida");
                    }
                } else {
                    System.out.println("Jugada no válida");
                }
            }
        }
    }
}
