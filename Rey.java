import java.util.ArrayList;

public class Rey extends Pieza implements Movimientos{

    public Rey(String nombrePieza, String colorPieza, int pocision) {
        super(nombrePieza, colorPieza, pocision);
    }

    @Override
    public String obtenerPosicion() {
        this.getColumna();
        this.getFila();
        String a;
        if(this.getFila()==8){
             a = "0";
        }
        else if (this.getFila()==7) {
             a ="1";
        }
        else if (this.getFila()==6) {
             a ="2";
        }
        else if (this.getFila()==5) {
             a ="3";
        }
        else if (this.getFila()==4) {
             a ="4";
        }
        else if (this.getFila()==3) {
             a ="5";
        }
        else if (this.getFila()==2) {
             a ="6";
        }
        else{
            a= "7";
        }
        String ax2="";
        if(this.getColumna() == 0 ){
            ax2= "a";
        }
        else if (this.getColumna() ==1) {
            ax2= "b";
        }
        else if (this.getColumna() ==2) {
            ax2= "c";
        }
        else if (this.getColumna() ==3) {
            ax2= "d";
        }
        else if (this.getColumna() ==4) {
            ax2= "e";
        }
        else if (this.getColumna() ==5) {
            ax2= "f";
        }
        else if (this.getColumna() ==6) {
            ax2= "g";
        }
        else{
            ax2= "h";
        }
        String nota= ax2+a;
        return nota;
    }

    @Override
    public void mostrarPosiblesMovimientos(ArrayList<Pieza> piezas) {
        int[][] movimientos = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}, // Arriba, abajo, derecha, izquierda
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1} // Diagonales
        };

        System.out.println("Movimientos posibles del Rey:");

        for (int[] mov : movimientos) {
            int nuevaFila = this.getFila() + mov[0];
            int nuevaColumna = this.getColumna() + mov[1];

            // Verificamos que esté dentro del tablero
            if (nuevaFila >= 0 && nuevaFila < 8 && nuevaColumna >= 0 && nuevaColumna < 8) {
                boolean ocupado = false;
                boolean enemigo = false;

                // Recorremos todas las piezas para ver si alguna está en la nueva posición
                for (Pieza pieza : piezas) {
                    if (pieza.getFila() == nuevaFila && pieza.getColumna() == nuevaColumna) {
                        ocupado = true;
                        if (!pieza.getColorPieza().equals(this.getColorPieza())) { // Si es de otro color
                            enemigo = true;
                        }
                        break;
                    }
                }

                // Si la casilla está vacía o tiene un enemigo, el Rey puede moverse
                if (!ocupado || enemigo) {
                    char columnaLetra = (char) ('a' + nuevaColumna);
                    int filaNumero = 8 - nuevaFila;
                    System.out.println("" + columnaLetra + filaNumero);
                }
            }
        }
    }

    @Override
    public boolean jaque(ArrayList<Pieza> piezas) {
        for (Pieza pieza : piezas) {
            if (pieza instanceof Rey && !pieza.getColorPieza().equals(this.getColorPieza())) {
                int difFila = Math.abs(this.getFila() - pieza.getFila());
                int difColumna = Math.abs(this.getColumna() - pieza.getColumna());

                if (difFila <= 1 && difColumna <= 1) {
                    return true;  // El rey puede capturar al otro rey
                }
            }
        }
        return false;
    }
}
