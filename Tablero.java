import java.util.Arrays;

public class Tablero {
    private static final int Dimension = 3;
    private EstadoCasilla[][] casilla;

    public Tablero() {
        this.casilla = new EstadoCasilla[Dimension + 1][Dimension + 1];
        vaciar();
    }

    public static int getDimension() {
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
        // Verificar filas
        for (int f = 0; f < casilla.length; f++) {
            int count = 0;
            for (int c = 0; c < casilla[f].length; c++) {
                if (casilla[f][c] == color) {
                    count++;
                    if (count == Dimension) {
                        return true; // Hay una línea de tamaño Dimension
                    }
                } else {
                    count = 0;
                }
            }
        }
        // Verificar columnas
        for (int c = 0; c < casilla[0].length; c++) {
            int count = 0;
            for (int f = 0; f < casilla.length; f++) {
                if (casilla[f][c] == color) {
                    count++;
                    if (count == Dimension) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // Verificar diagonal de izquierda a derecha
        for (int i = 0; i <= casilla.length - Dimension; i++) {
            for (int j = 0; j <= casilla[0].length - Dimension; j++) {
                int count = 0;
                for (int k = 0; k < Dimension; k++) {
                    if (casilla[i + k][j + k] == color) {
                        count++;
                        if (count == Dimension) {
                            return true;
                        }
                    } else {
                        count = 0;
                    }
                }
            }
        }
        for (int i = 0; i <= casilla.length - Dimension; i++) {
            for (int j = Dimension - 1; j < casilla[0].length; j++) {
                int count = 0;
                for (int k = 0; k < Dimension; k++) {
                    if (casilla[i + k][j - k] == color) {
                        count++;
                        if (count == Dimension) {
                            return true;
                        }
                    } else {
                        count = 0;
                    }
                }
            }
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