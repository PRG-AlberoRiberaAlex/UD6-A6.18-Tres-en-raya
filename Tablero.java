import java.util.Arrays;

public class Tablero {
    private final int Dimension =3;
    private EstadoCasilla[][] casilla;

    public Tablero(){
        this.casilla = new EstadoCasilla[Dimension + 1][Dimension + 1];
        vaciar();
    }

    public int getDimension() {
        return Dimension;
    }

    public void mostrar() {
        System.out.print("  ");
        for (int j = 1; j < casilla[0].length; j++) {
            System.out.print(j + " ");
        }
        System.out.println();

        for (int f = 1; f < casilla.length; f++) {
            System.out.print(f + "|"); // Número de fila
            for (int c = 1; c < casilla[f].length; c++) {
                System.out.print(casilla[f][c] + "|");
            }
            System.out.println();
        }
    }



    public boolean hayTresEnRaya() {

        return hayTresEnRaya(EstadoCasilla.Ficha_O) || hayTresEnRaya(EstadoCasilla.FICHA_X);
    }

    private boolean hayTresEnRaya(EstadoCasilla color) {
        for (int f = 1; f < casilla.length; f++) {
            if (casilla[f][0] == color && casilla[f][1] == color && casilla[f][2] == color)
                return true;
        }
        for (int c = 1; c < casilla[0].length; c++) {
            if (casilla[0][c] == color && casilla[1][c] == color && casilla[2][c] == color)
                return true;
        }
        if (casilla[1][1] == color && casilla[2][2] == color && casilla[3][3] == color) {
            return true;
        }
        if (casilla[1][3] == color && casilla[2][2] == color && casilla[3][1] == color) {
            return true;
        }
        return false;
    }

    public boolean isOcupada(Coordenada coordenada) {
        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();

        return casilla[fila][columna] != EstadoCasilla.VACIO;
    }

    public boolean ponerFicha(Coordenada coordenada, EstadoCasilla color) {
        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();
        if (fila >= 1 && fila <= Dimension && columna >= 1 && columna <= Dimension) {
            if (casilla[fila][columna] == EstadoCasilla.VACIO) {
                casilla[fila][columna] = color;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    public void vaciar() {
        for (int i = 0; i < casilla.length; i++) {
            for (int j = 0; j < casilla[i].length; j++) {
                casilla[i][j] = EstadoCasilla.VACIO;
            }
        }
    }

    public boolean estaLleno() {
        for (int f = 1; f < casilla.length; f++) {
            for (int c = 1; c < casilla[f].length; c++) {
                if (casilla[f][c] == EstadoCasilla.VACIO) {
                    return false;
                }
            }
        }
        return true;
    }


}