import java.util.*;
public class Main {
    public static void main(String[] args) {
        Pieza p = new Rey("Da1","blanco",1 );
        System.out.println("p.getNombre() = " + p.getNombrePieza()+ " fila " + p.getFila()+ " columna "+ p.getColumna());
        System.out.println("p.obtenerPosicion() = " + p.obtenerPosicion());
        p.cambiaPosicion("b1");
        System.out.println("nueva posicion es = " + p.obtenerPosicion());
    }
}