

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
}
