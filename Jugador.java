public class Jugador {

    private EstadoCasilla color;

    public Jugador(EstadoCasilla color) {
        this.color = color;
    }

    public void ponerFicha(Tablero tablero) {
        int num;
        do {
            System.out.print("Introduce fila[1-3]: ");
            while (!TresEnRaya.teclat.hasNextInt()) {
                System.out.print("Introduce fila[1-3]: ");
                TresEnRaya.teclat.next();
            }
            num = TresEnRaya.teclat.nextInt();
        } while (num <= 0);
    }
}

