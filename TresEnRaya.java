import java.util.Scanner;

public class TresEnRaya {
    public static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) {
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.jugar();
    }

    public void jugar() {
        do {
            Tablero tablero = new Tablero();
            Simbolos simbolos = new Simbolos();
            tablero.inicializarSimbolos(simbolos);
            simbolos.seleccionar();
            Jugador jugador1 = new Jugador(EstadoCasilla.FICHA_X, simbolos);
            Jugador jugador2 = new Jugador(EstadoCasilla.Ficha_O, simbolos);

            while (true) {
                tablero.mostrar();
                System.out.println("Turno del Jugador " + simbolos.obtenerSimbolo(EstadoCasilla.FICHA_X));
                jugador1.ponerFicha(tablero);
                tablero.mostrar();

                if (tablero.hayTresEnRaya()) {
                    jugador1.cantarVictoria();
                    break;
                }

                if (tablero.estaLleno()) {
                    System.out.println("La partida ha finalizado en empate");
                    break;
                }

                System.out.println("Turno del Jugador " + simbolos.obtenerSimbolo(EstadoCasilla.Ficha_O));
                jugador2.ponerFicha(tablero);
                tablero.mostrar();

                if (tablero.hayTresEnRaya()) {
                    jugador2.cantarVictoria();
                    break;
                }

                if (tablero.estaLleno()) {
                    System.out.println("La partida ha finalizado en empate");
                    break;
                }
            }

            String respuesta;
            do {
                System.out.println("¿Quieres volver a jugar? [S/N]: ");
                respuesta = teclat.nextLine().toUpperCase();

                if (respuesta.equals("S")) {
                    break;
                } else if (respuesta.equals("N")) {
                    System.out.println("Gracias por jugar. ¡Hasta luego!");
                    return;
                } else {
                    System.out.println("Respuesta inválida. Por favor, introduce 'S' para sí o 'N' para no.");
                }
            } while (true);
        } while (true);
    }
}
