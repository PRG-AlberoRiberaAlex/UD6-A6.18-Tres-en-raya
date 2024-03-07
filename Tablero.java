public class Tablero {
    private int Dimension;
    private EstadoCasilla[][] casilla;

    public Tablero() {
        this.casilla = new EstadoCasilla[3][3];
    }

    public void mostrar() {
        for (int i = 0; i < casilla.length; i++) {
            for (int j = 0; j < casilla[i].length; j++) {
                System.out.print(casilla[i][j] + "|");
            }
            System.out.println();
        }
    }

    public boolean hayTresEnRaya() {

        return hayTresEnRaya(EstadoCasilla.Ficha_O) || hayTresEnRaya(EstadoCasilla.FICHA_X);
    }

    private boolean hayTresEnRaya(EstadoCasilla color) {
        for (int f = 0; f < casilla.length; f++) {
            if (casilla[f][0] == color && casilla[f][1] == color && casilla[f][2] == color)
                return true;
        }
        for (int c = 0; c < casilla[0].length; c++) {
            if (casilla[0][c] == color && casilla[1][c] == color && casilla[2][c] == color)
                return true;
        }
        if (casilla[0][0] == color && casilla[1][1] == color && casilla[2][2] == color) {
            return true;
        }
        if (casilla[0][2] == color && casilla[1][1] == color && casilla[2][0] == color) {
            return true;
        }
        return false;
    }

    public boolean isOcupada(Coordenada coordenada) {
        for (int f = 0; f < casilla.length; f++) {
            for (int c = 0; c < casilla[f].length; c++) {
                if (casilla[f][c].equals(coordenada)) {
                    System.out.println("La coordenada " + coordenada + " esta ocupada");
                    return true;
                }
            }
        }
        return false;
    }

    public void ponerFicha(Coordenada coordenada, EstadoCasilla color) {
        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();
        if (fila >= 0 && fila < casilla.length && columna >= 0 && columna < casilla[0].length) {
            casilla[fila][columna] = color;
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
        for (int f = 0; f < casilla.length; f++) {
            for (int c = 0; c < casilla[f].length; c++) {
                if (casilla[f][c].equals(EstadoCasilla.VACIO)) {
                    System.out.println("Aun hay casillas a rellenar");
                    return false;
                }
            }
        }
        return true;
    }
}