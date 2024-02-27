public class Alfil extends Pieza{
    public Alfil(boolean color) {
        super(color);
    }
    @Override
    public boolean validoMovimiento(Movimiento mov) {
        return mov.esDiagonal();
    }

    @Override
    public String pintarPieza() {
        return color ? "\u2657" : "\u265D";
    }


}
