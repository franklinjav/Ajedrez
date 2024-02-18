
public class Movimiento {
    //Atributos

    Posicion posIni;
    Posicion posFin;

    //Constructores

    /**
     * Constructor vacío de Movimiento
     */
    public Movimiento() {
    }

    /**
     * Constructor de la clase Moviento que recibe dos argumentos de entrada (ambos de tipo posición) que serán la posición
     * inicial (posIni) y la posición final (posFin)
     * @param posIni Posición inicial
     * @param posFin Posición final
     */
    public Movimiento(Posicion posIni, Posicion posFin) {
        this.posIni = posIni;
        this.posFin = posFin;
    }

    //Gets y Sets

    /**
     * Método get para obtener el valor de la posición inicial (posIni)
     * @return posIni
     */
    public Posicion getPosIni() {
        return posIni;
    }

    /**
     * Método para cambiar el valor de la posición inicial (posIni)
     * @param posIni Posición inicial
     */
    public void setPosIni(Posicion posIni) {
        this.posIni = posIni;
    }

    /**
     * Método get para obtener el valor de la posición final (posFin)
     * @return posFin
     */
    public Posicion getPosFin() {
        return posFin;
    }

    /**
     * Método para cambiar el valor de la posición final (posFin)
     * @param posFin Posición final
     */
    public void setPosFin(Posicion posFin) {
        this.posFin = posFin;
    }

    //toString

    /**
     * Método toString generado automáticamente para imprimir los datos de los
     * atributos de posición inicial (posIni) y posición final (posFin)
     * @return toString
     */
    @Override
    public String toString() {
        return "Movimiento{" +
                "posIni=" + posIni +
                ", posFin=" + posFin +
                '}';
    }

    //Métodos

    /**
     * Método esVertical que no recibe parámetros de entrada y nos devuelve un booleano (vertical) que nos indica
     * en caso de ser verdadero que el movimiento es vertical
     * @return vetical
     */
    public boolean esVertical() {
        boolean vertical = false;
        if (posIni.getFila() == posFin.getFila() && posIni.getColumna() != posFin.getColumna()) {
            vertical = true;
        }
        return vertical;
    }

    /**
     * Método esHorizontal que no recibe parámetros de entrada y nos devuelve un booleano (horizontal) que nos indica
     * en caso de ser verdadero que el movimiento es horizontal
     * @return horizontal
     */
    public boolean esHorizontal() {
        boolean horizontal = false;
        if (posIni.getColumna() == posFin.getColumna() && posIni.getFila() != posFin.getFila()) {
            horizontal = true;
        }
        return horizontal;
    }

    /**
     * Método esDiagonal que no recibe parámetros de entrada y nos devuelve un booleano (diagonal) que nos indica
     * en caso de ser verdadero que el movimiento es diagonal
     * @return diagonal
     */
    public boolean esDiagonal() {
        boolean diagonal = false;
        if (Math.abs(posIni.getFila() - posFin.getFila()) == Math.abs(posIni.getColumna() - posFin.getColumna())) {
            diagonal = true;
        }
        return diagonal;
    }

    /**
     * Método saltoHorizontal que recibe dos parámetros de entrada de tipo posición que corresponden
     * a la posición inicial y final(posIni y posFin) y nos devuelve un entero (cant) que nos indica el número
     * de saltos horizontales
     * @param posIni Posición inicial
     * @param posFin Posición final
     * @return cant Entero
     */
    public int saltoHorizontal(Posicion posIni,Posicion posFin) {
        int cant = posIni.getColumna() - posFin.getColumna();
        return cant;
    }

    /**
     * Método saltoVertical que recibe dos parámetros de entrada de tipo posición que corresponden
     * a la posición inicial y final(posIni y posFin) y nos devuelve un entero (cant) que nos indica el número
     * de saltos verticales
     * @param posIni Posición inicial
     * @param posFin Posición final
     * @return cant Entero
     */
    public int saltoVertical(Posicion posIni,Posicion posFin) {
        return posIni.getColumna() - posFin.getColumna();
    }
}
