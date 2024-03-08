public class Jugador {

    private EstadoCasilla color;

    public Jugador(EstadoCasilla color) {
        this.color = color;
    }

    public boolean ponerFicha(Tablero tablero) {
        Coordenada coordenada;
        boolean fichaColocada = false;

        while (!fichaColocada) {
            coordenada = recogeCoordenada();
            if (coordenada.isValida(tablero.getDimension())) {
                if (!tablero.isOcupada(coordenada)) {
                    tablero.ponerFicha(coordenada, color);
                    fichaColocada = true;
                    return true; // Ficha colocada con éxito
                } else {
                    System.out.println("La posición está ocupada. Inténtalo de nuevo.");
                }
            } else {
                System.out.println("Coordenada inválida. Inténtalo de nuevo.");
            }
        }
        return false; // Ficha no colocada
    }

    private Coordenada recogeCoordenada() {
        int fila, columna;

        do {
            System.out.print("Introduce fila[1-" + Tablero.getDimension() + "]: ");
            while (!TresEnRaya.teclat.hasNextInt()) {
                System.out.print("Introduce fila[1-" + Tablero.getDimension() + "]: ");
                TresEnRaya.teclat.next();
            }
            fila = TresEnRaya.teclat.nextInt();

            System.out.print("Introduce columna[1-" + Tablero.getDimension() + "]: ");
            while (!TresEnRaya.teclat.hasNextInt()) {
                System.out.print("Introduce columna[1-" + Tablero.getDimension() + "]: ");
                TresEnRaya.teclat.next();
            }
            columna = TresEnRaya.teclat.nextInt();

        } while (fila < 1 || fila > Tablero.getDimension() || columna < 1 || columna > Tablero.getDimension());

        return new Coordenada(fila, columna);
    }

    public void cantarVictoria() {
        System.out.println("El jugador " + getColor() + " es el ganador");
    }

    public EstadoCasilla getColor() {
        return color;
    }
}
