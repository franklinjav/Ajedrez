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
            if (!turno) {
                System.out.println("Turnos de las blancas");
                System.out.println("Introduzca una juegada, por ejemplo : A5A6");
                String jugadam = teclado.nextLine();
                Posicion pos = juego.jugada(jugadam,tablero).getPosIni();
                Posicion pos2 = juego.jugada(jugadam,tablero).getPosFin();
                if (juego.jugada(jugadam,tablero) != null) {
                    if (tablero.hayPieza(pos) && !tablero.devuelvePieza(pos).getColor()) {
                        if (tablero.devuelvePieza(pos).validoMovimiento(juego.jugada(jugadam, tablero))) {
                            if (!tablero.hayPiezasEntre(juego.jugada(jugadam,tablero))) {
                                if (tablero.devuelvePieza(pos).getClass().getSimpleName().equalsIgnoreCase("peon")) {
                                    if (!tablero.hayPieza(pos2) && !juego.jugada(jugadam, tablero).esDiagonal()) {
                                            if (tablero.devuelvePieza(pos2) != null && tablero.devuelvePieza(pos2).getClass().getSimpleName().equalsIgnoreCase("Rey")){
                                                muerte = true;
                                                System.out.println("Ganan las blancas");
                                            }
                                            tablero.devuelvePieza(pos).setPaso(true);
                                            tablero.ponPieza(tablero.devuelvePieza(pos), pos2);
                                            tablero.quitaPieza(pos);
                                            turno = true;
                                            if (tablero.promocion(pos2)) {
                                                tablero.menu(pos2);
                                            }
                                    } else if (tablero.hayPieza(pos2) && tablero.devuelvePieza(pos2).getColor() != tablero.devuelvePieza(pos).getColor()) {
                                        if (tablero.devuelvePieza(pos2) != null && tablero.devuelvePieza(pos2).getClass().getSimpleName().equalsIgnoreCase("Rey")){
                                            muerte = true;
                                            System.out.println("Ganan las blancas");
                                        }
                                        tablero.devuelvePieza(pos).setPaso(true);
                                        tablero.quitaPieza(pos2);
                                        tablero.ponPieza(tablero.devuelvePieza(pos), pos2);
                                        tablero.quitaPieza(pos);
                                        turno = true;
                                        if (tablero.promocion(pos2)) {
                                            tablero.menu(pos2);
                                        }
                                    } else {
                                        System.out.println("Movimiento no válido");
                                    }
                                } else if (!tablero.hayPieza(pos2) || tablero.devuelvePieza(pos2).getColor() != tablero.devuelvePieza(pos).getColor()) {
                                    tablero.devuelvePieza(pos).setPaso(true);
                                    tablero.quitaPieza(pos2);
                                    tablero.ponPieza(tablero.devuelvePieza(pos), pos2);
                                    tablero.quitaPieza(pos);
                                    turno = true;
                                }
                            } else {
                                System.out.println("La pieza que seleccionada no puede realizar ese movimiento");
                            }
                        } else {
                            System.out.println("Movimiento no válido");
                        }
                    }else {
                        System.out.println("Movimiento no válido");
                    }
                } else {
                    System.out.println("La jugada no es válida");
                }
            }else if (turno) {
                System.out.println("Turnos de las negras");
                System.out.println("Introduzca una juegada, por ejemplo : A5A6");
                String jugadam = teclado.nextLine();
                Posicion pos = juego.jugada(jugadam,tablero).getPosIni();
                Posicion pos2 = juego.jugada(jugadam,tablero).getPosFin();
                if (juego.jugada(jugadam,tablero) != null) {
                    if (tablero.hayPieza(pos) && tablero.devuelvePieza(pos).getColor()) {
                        if (tablero.devuelvePieza(pos).validoMovimiento(juego.jugada(jugadam,tablero))) {
                            if (!tablero.hayPiezasEntre(juego.jugada(jugadam,tablero))) {
                                if (tablero.devuelvePieza(pos).getClass().getSimpleName().equalsIgnoreCase("peon")) {
                                    if (!tablero.hayPieza(pos2) && !juego.jugada(jugadam, tablero).esDiagonal()) {
                                        if (tablero.devuelvePieza(pos2) != null && tablero.devuelvePieza(pos2).getClass().getSimpleName().equalsIgnoreCase("Rey")) {
                                            muerte = true;
                                            System.out.println("Ganan las negras");
                                        }
                                        tablero.devuelvePieza(pos).setPaso(true);
                                        tablero.quitaPieza(pos2);
                                        tablero.ponPieza(tablero.devuelvePieza(pos), pos2);
                                        tablero.quitaPieza(pos);
                                        turno = false;
                                        if (tablero.promocion(pos2)) {
                                            tablero.menu(pos2);
                                        }
                                    } else if (tablero.hayPieza(pos2) && tablero.devuelvePieza(pos2).getColor() != tablero.devuelvePieza(pos).getColor()) {
                                        if (tablero.devuelvePieza(pos2) != null && tablero.devuelvePieza(pos2).getClass().getSimpleName().equalsIgnoreCase("Rey")){
                                            muerte = true;
                                            System.out.println("Ganan las negras");
                                        }
                                        tablero.devuelvePieza(pos).setPaso(true);
                                        tablero.quitaPieza(pos2);
                                        tablero.ponPieza(tablero.devuelvePieza(pos), pos2);
                                        tablero.quitaPieza(pos);
                                        turno = false;
                                        if (tablero.promocion(pos2)) {
                                            tablero.menu(pos2);
                                        }
                                    } else {
                                        System.out.println("Movimiento no válido");
                                    }
                                } else if (!tablero.hayPieza(pos2) || tablero.devuelvePieza(pos2).getColor() != tablero.devuelvePieza(pos).getColor()) {
                                    tablero.devuelvePieza(pos).setPaso(true);
                                    tablero.quitaPieza(pos2);
                                    tablero.ponPieza(tablero.devuelvePieza(pos), pos2);
                                    tablero.quitaPieza(pos);
                                    turno = false;
                                }
                            } else {
                                System.out.println("La pieza seleccionada no puede realizar ese movimiento");
                            }
                        } else {
                            System.out.println("La pieza que seleccionada no puede realizar ese movimiento");
                        }
                    } else {
                        System.out.println("Movimiento no válido");
                    }
                } else {
                    System.out.println("La jugada no es válida");
                }
            }
        }
    }
}
