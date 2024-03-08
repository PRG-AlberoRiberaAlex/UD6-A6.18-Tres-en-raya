import java.util.Scanner;

public class TresEnRaya {
    public static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador(EstadoCasilla.FICHA_X);
        Jugador jugador2 = new Jugador(EstadoCasilla.Ficha_O);

        while (true) {
            System.out.println("Turno del Jugador 1 (X):");
            jugador1.ponerFicha(tablero);
            tablero.mostrar();

            if (tablero.hayTresEnRaya()) {
                jugador1.cantarVictoria();
                return;
            }

            if (tablero.estaLleno()) {
                System.out.println("La partida ha finalizado en empate");
                return;
            }

            System.out.println("Turno del Jugador 2 (O):");
            jugador2.ponerFicha(tablero);
            tablero.mostrar();

            if (tablero.hayTresEnRaya()) {
                jugador2.cantarVictoria();
                return;
            }

            if (tablero.estaLleno()) {
                System.out.println("La partida ha finalizado en empate");
                return;
            }
        }
    }
}
