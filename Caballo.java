import java.util.ArrayList;

public class Caballo extends Pieza implements Movimientos {
    public Caballo(String nombrePieza, String colorPieza, int pocision) {
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


    public void mostrarPosiblesMovimientos(ArrayList<Pieza> piezas) {
        int[][] movimientos = {
                {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
                {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };

        System.out.println("Movimientos posibles del Caballo:");

        for (int[] mov : movimientos) {
            int nuevaFila = this.getFila() + mov[0];
            int nuevaColumna = this.getColumna() + mov[1];

            if (esMovimientoValido(nuevaFila, nuevaColumna, piezas)) {
                imprimirMovimiento(nuevaFila, nuevaColumna);
            }
        }
    }

    @Override
    public boolean jaque(ArrayList<Pieza> piezas) {
        int[][] movimientos = {{2,1}, {2,-1}, {-2,1}, {-2,-1}, {1,2}, {1,-2}, {-1,2}, {-1,-2}};

        for (Pieza pieza : piezas) {
            if (pieza instanceof Rey && !pieza.getColorPieza().equals(this.getColorPieza())) {
                for (int[] mov : movimientos) {
                    int nuevaFila = this.getFila() + mov[0];
                    int nuevaColumna = this.getColumna() + mov[1];

                    if (nuevaFila == pieza.getFila() && nuevaColumna == pieza.getColumna()) {
                        return true;  // El caballo puede capturar al rey en "L"
                    }
                }
            }
        }
        return false;
    }
}
