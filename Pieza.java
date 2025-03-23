import java.util.ArrayList;
public abstract class Pieza implements Movimientos {
    private String nombrePieza;
    private String colorPieza;
    private int pocision;
    private boolean estado;
    private int fila;
    private int columna;
//constructor

    public Pieza(String nombrePieza, String colorPieza, int pocision) {
        this.nombrePieza = nomP(nombrePieza.substring(0,1));
        this.colorPieza = colorPieza;
        this.pocision = pocision;
        this.fila=fil1(nombrePieza.substring(2,3));
        this.columna=col1(nombrePieza.substring(1,2));
        this.estado=true;
    }
//setter and getters

    public String getNombrePieza() {
        return nombrePieza;
    }

    public void setNombrePieza(String nombrePieza) {
        this.nombrePieza = nombrePieza;
    }

    public int getPocision() {
        return pocision;
    }

    public void setPocision(int pocision) {
        this.pocision = pocision;
    }

    public String getColorPieza() {
        return colorPieza;
    }

    public void setColorPieza(String colorPieza) {
        this.colorPieza = colorPieza;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
//Nombre
    public String nomP(String n){
        if (n.equals("R")){
            return "Rey";
        } else if (n.equals("T")) {
            return "Torre";
        } else if (n.equals("A")) {
            return "Alfil";
        } else if (n.equals("P")) {
            return "Peon";
        } else if (n.equals("D")) {
            return  "Dama";
        } else if (n.equals("C")) {
            return "Caballo";
        }
        else {
            return "error";
        }
    }
//filas
    public int fil1(String f){
        int z=  Integer.parseInt(f);
        z=8-z;
        return z;
    }
//col
    public int col1(String c){
        if(c.equals("a")) {
            return  0;
        } else if (c.equals("b")) {
            return  1;
        } else if (c.equals("c")) {
            return  2;
        } else if (c.equals("d")) {
            return 3;
        }
        else if (c.equals("e")) {
            return 4;
        }
        else if (c.equals("f")) {
            return 5;
        }
        else if (c.equals("g")) {
            return 6;
        }
        else {
            return 7;
        }
    }
//Cambia Posicion
    public void cambiaPosicion(String name){
        this.fila=fil1(name.substring(1,2));
        this.columna=col1(name.substring(0,1));
    }
    //clase abstracta
    public abstract String obtenerPosicion();
    //verifica sie el movimiento es valido
    protected boolean esMovimientoValido(int fila, int columna, ArrayList<Pieza> piezas) {
        return esMovimientoValido(fila, columna, piezas, false);
    }

    protected boolean esMovimientoValido(int fila, int columna, ArrayList<Pieza> piezas, boolean captura) {
        if (fila < 0 || fila >= 8 || columna < 0 || columna >= 8) {
            return false;
        }

        for (Pieza pieza : piezas) {
            if (pieza.getFila() == fila && pieza.getColumna() == columna) {
                return captura && !pieza.getColorPieza().equals(this.getColorPieza());
            }
        }

        return true;
    }

    protected void imprimirMovimiento(int fila, int columna) {
        char columnaLetra = (char) ('a' + columna);
        int filaNumero = 8 - fila;
        System.out.println("" + columnaLetra + filaNumero);
    }

    protected void moverEnDireccion(ArrayList<Pieza> piezas, int dFila, int dColumna) {
        int fila = this.getFila();
        int columna = this.getColumna();

        while (true) {
            fila += dFila;
            columna += dColumna;

            if (!esMovimientoValido(fila, columna, piezas)) {
                break;
            }

            imprimirMovimiento(fila, columna);
        }
    }

}
