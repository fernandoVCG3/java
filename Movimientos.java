import java.sql.Array;
import java.util.ArrayList;

public interface Movimientos {
    public void mostrarPosiblesMovimientos(ArrayList<Pieza> piezas);
    public boolean jaque(ArrayList<Pieza> piezas);
}
