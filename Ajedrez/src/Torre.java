

public class Torre extends Pieza{
    //Constructores

    public Torre(boolean color) {
        super(color);
    }
    //Métodos
    @Override
    public boolean validoMovimiento(Movimiento mov) {
        return mov.esVertical() || mov.esHorizontal();
    }
}
