

public abstract class Pieza {
    //Atributos

    protected boolean color;
    protected String nombre;

    //Constructores

    public Pieza(boolean color) {
        this.color = color;
        nombre = getClass().getSimpleName();
    }

    //Gets y Sets

    public boolean getColor() {
        return color;
    }

    //toString

    @Override
    public String toString() {
        return "Pieza{" +
                "color='" + color + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    //Métodos

    public abstract boolean validoMovimiento(Movimiento mov);
    //Preguntar sobre el método pintar pieza
}
