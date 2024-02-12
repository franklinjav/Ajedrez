

public class Rey extends Pieza{
    //TERMINAR
    //Constructores

    public Rey(boolean color) {
        super(color);
    }
    //Métodos

    @Override
    public boolean validoMovimiento(Movimiento mov) {
        return false;
    }

    @Override
    public String pintarPieza() {
        return color ? "\u2654" : "\u265A";
    }
}
