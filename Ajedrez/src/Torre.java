

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

    @Override
    public String pintarPieza() {
        return color ? "\u2656" : "\u265C";
    }

}
