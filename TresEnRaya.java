import java.util.Scanner;

public class TresEnRaya {
    public static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) {
        Tablero tablero=new Tablero();
        Jugador jugador1 = new Jugador(EstadoCasilla.FICHA_X);
        Jugador jugador2 = new Jugador(EstadoCasilla.Ficha_O);
        tablero.vaciar();
        tablero.mostrar();
        jugador1.ponerFicha(tablero);
        if (tablero.estaLleno()){
            System.out.println("La partida ha finalizado en empate");
        }
        if (tablero.hayTresEnRaya()){
            System.out.println("Ha ganado la partida el jugador X");
        }
    }
}
