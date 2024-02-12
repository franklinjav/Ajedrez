

public abstract class Pieza {
    //Atributos

    protected boolean color;
    protected String nombre;

    //Constructores

    /**
     * Constructor de Pieza que recibe un pa´rametro de entrada de tipo boolean (color) e inicializa el nombre
     * al nombre simple de la clase
     * @param color Boolean
     */
    public Pieza(boolean color) {
        this.color = color;
        nombre = getClass().getSimpleName();
    }

    //Gets y Sets

    /**
     * Método get para obtener el valor del color
     * @return Boolean color
     */
    public boolean getColor() {
        return color;
    }

    //toString

    /**
     * Método toString generado automáticamente
     * @return toString
     */
    @Override
    public String toString() {
        return "Pieza{" +
                "color='" + color + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    //Métodos

    /**
     * Método abstracto que recibe un parámetro de entrada de tipo Movimiento (mov) y devuleve un booleano
     * @param mov Movimiento
     * @return Boolean
     */
    public abstract boolean validoMovimiento(Movimiento mov);

    /**
     * Método abstracto usado para pintar cada pieza con si respectivo unicode
     * @return Unicode String
     */
    public abstract String pintarPieza();
}
