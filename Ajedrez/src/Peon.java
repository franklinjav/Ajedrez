public class Peon extends Pieza{
    private boolean paso;
    public Peon(boolean color) {
        super(color);
        paso = false;
    }
    @Override
    public boolean validoMovimiento(Movimiento mov) {
        boolean verdad = false;
        if (mov.esVertical()) {
            if (color && !paso) {
                if (mov.saltoVertical(mov.getPosIni(), mov.getPosFin()) == -2) {
                    verdad = true;
                }
            } else if (color) {
                if (mov.saltoVertical(mov.getPosIni(), mov.getPosFin()) == -1) {
                    verdad = true;
                }
            } else if (!color && !paso) {
                if (mov.saltoVertical(mov.getPosIni(), mov.getPosFin()) == 2) {
                    verdad = true;
                }
            } else if (!color) {
                if (mov.saltoVertical(mov.getPosIni(), mov.getPosFin()) == 1) {
                    verdad = true;
                }
            }
        }
        return verdad;
    }

    @Override
    public String pintarPieza() {
        return color ? "\u2659" : "\u265F";
    }
}
