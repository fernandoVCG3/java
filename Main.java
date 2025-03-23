import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("¡Inicio del juego de ajedrez!");
        String[][] matriz = new String[8][8];
        System.out.println("a    b   c   d   e   f   g   h");
        matrizllena(matriz);
        matrizmuetra(matriz);

        ArrayList<Pieza> tablero = new ArrayList<>();

        //Agregar piezas al tablero
        tablero.add(new Rey("Re2", "blanco", 1));
        tablero.add(new Rey("Ra1","negro",1));
        tablero.add(new Alfil("Af1","blanco",0));
        tablero.add(new Torre("Ta2","negra",0));
        //Llamar a mostrarPosiblesMovimientos() para cada pieza
        for (Pieza pieza : tablero) {
            System.out.println("\nMovimientos de " + pieza.getNombrePieza() + " en " + pieza.obtenerPosicion() + ":");
            pieza.mostrarPosiblesMovimientos(tablero) ;
            if (pieza.getNombrePieza().equals("Rey" )){
                if (pieza.getColorPieza().equals("negro")){
                    coloca(pieza.getColumna(),pieza.getFila(),pieza.getNombrePieza(),matriz);

                }
                else{
                    coloca(pieza.getColumna(),pieza.getFila(),pieza.getNombrePieza(),matriz);
                }
            }
            else if (pieza.getNombrePieza().equals("Alfil")) {
                coloca(pieza.getColumna(),pieza.getFila(),pieza.getNombrePieza(),matriz);
            }
            else if (pieza.getNombrePieza().equals("Torre")) {
                coloca(pieza.getColumna(),pieza.getFila(),pieza.getNombrePieza(),matriz);
            }
            else{

            }


        }
        /*
        for ( Pieza p : tablero){
            System.out.println("esta en jaque ? = " + p.getNombrePieza()+ " : "  + p.jaque(tablero));
        }
        */
        matrizmuetra(matriz);
        for (Pieza p : tablero){
            System.out.println("la pieza = " + p.getNombrePieza()+ " esta en jaque= "+ p.jaque(tablero));
        }

    }
    //colocar posicion
    public static void coloca(int c1, int f1 , String pieza1, String [][] mat){
        for (int f = 0; f <8 ; f++) {
            for (int c = 0; c <8 ; c++) {
                if (f==f1 && c1 ==c) {
                    mat [f][c]=pieza1;
                }

            }
            System.out.println();
        }
    }





    //Muestra matriz
    public static void matrizmuetra(String [][]  matriz){
        for (int f = 0; f <8 ; f++) {
            for (int c = 0; c <8 ; c++) {
                System.out.print(matriz [f][c] + " " );
            }
            System.out.println();
        }
    }



    //Llena Matriz
    public static void matrizllena(String [][]  matriz){
        for (int f = 0; f < 8; f++) {
            for (int c = 0; c <8 ; c++) {
                matriz[f][c]="___";
            }
        }
    }
}