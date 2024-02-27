public class Reina extends Pieza{

    public Reina(boolean color) {
        super(color);
    }
    @Override
    public boolean validoMovimiento(Movimiento mov) {
        return mov.esVertical() || mov.esHorizontal() || mov.esDiagonal();
    }

    @Override
    public String pintarPieza() {
        return color ? "\u2655" : "\u265B";
    }

}
