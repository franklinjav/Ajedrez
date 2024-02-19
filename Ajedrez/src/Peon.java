public class Peon extends Pieza{
    public Peon(boolean color) {
        super(color);
    }
    @Override
    public boolean validoMovimiento(Movimiento mov) {
        boolean verdad = false;
        if (mov.esVertical()) {
            if (!color && !getPaso()) {
                if (mov.saltoVertical(mov.getPosIni(), mov.getPosFin()) == 2 || mov.saltoVertical(mov.getPosIni(), mov.getPosFin()) == 1) {
                    verdad = true;
                }
            } else if (!color && getPaso()) {
                if (mov.saltoVertical(mov.getPosIni(), mov.getPosFin()) == 1) {
                    verdad = true;
                }
            } else if (color && !getPaso()) {
                if (mov.saltoVertical(mov.getPosIni(), mov.getPosFin()) == -2 || mov.saltoVertical(mov.getPosIni(), mov.getPosFin()) == -1) {
                    verdad = true;
                }
            } else if (color && getPaso()) {
                if (mov.saltoVertical(mov.getPosIni(), mov.getPosFin()) == -1) {
                    verdad = true;
                }
            }
        }
        if (mov.esDiagonal()) {
            if (Math.abs(mov.saltoVertical(mov.getPosIni(),mov.getPosFin())) == 1 || Math.abs(mov.saltoHorizontal(mov.getPosIni(),mov.getPosFin())) == 1) {
                verdad = true;
            }
        }
        return verdad;
    }

    @Override
    public String pintarPieza() {
        return color ? "\u2659" : "\u265F";
    }
}
