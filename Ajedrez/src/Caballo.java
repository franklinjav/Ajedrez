public class Caballo extends Pieza{

    public Caballo(Boolean color) {
        super(color);
    }

    @Override
    public boolean validoMovimiento(Movimiento mov) {
        boolean verdad = false;
        if (Math.abs(mov.posIni.getColumna() - mov.posFin.getColumna()) == 2 || Math.abs(mov.posIni.getFila() - mov.posFin.getFila()) == 2)  {
            if (Math.abs(mov.posIni.getColumna() - mov.posFin.getColumna()) == 1 || Math.abs(mov.posIni.getFila() - mov.posFin.getFila()) == 1) {
                verdad = true;
            }
        }
        return verdad;
    }

    @Override
    public String pintarPieza() {
        return color ? "\u2658" : "\u265E";
    }
}
