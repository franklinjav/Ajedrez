

public class Rey extends Pieza{
    //TERMINAR
    //Constructores

    public Rey(boolean color) {
        super(color);
    }
    //Métodos

    @Override
    public boolean validoMovimiento(Movimiento mov) {
        boolean verdad = false;
        if (mov.esDiagonal() || mov.esHorizontal() || mov.esVertical()) {
            if (Math.abs(mov.saltoVertical(mov.getPosIni(),mov.getPosFin())) == 1 || Math.abs(mov.saltoHorizontal(mov.getPosIni(),mov.getPosFin())) == 1) {
                verdad = true;
            }
        }
        return verdad;
    }

    @Override
    public String pintarPieza() {
        return color ? "\u2654" : "\u265A";
    }
}
