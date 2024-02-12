public class Caballo extends Pieza{

    public Caballo(Boolean color) {
        super(color);
    }

    @Override
    public boolean validoMovimiento(Movimiento mov) {
        return true;
    }

    @Override
    public String pintarPieza() {
        return color ? "\u2658" : "\u265E";
    }
}
