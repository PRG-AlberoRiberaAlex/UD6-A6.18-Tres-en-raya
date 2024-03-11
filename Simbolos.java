import java.util.Random;

public class Simbolos {
    private String[][] packs;
    private int packSeleccionado;

    public Simbolos() {
        // Inicializar la matriz de packs
        this.packs = new String[][]{
                {"X", "O"},
                {"$", "€"},
                {"...", "....."}
        };
    }

    public void seleccionar() {
        System.out.println("Seleccione un pack de iconos:");
        for (int i = 0; i < packs.length; i++) {
            System.out.println("Pack " + (i + 1) + ": " + packs[i][0] + " " + packs[i][1]);
        }
        System.out.println("Opción Aleatoria: " + (packs.length + 1));

        int opcion;
        do {
            System.out.println("Ingrese su opción [1-" + (packs.length + 1) + "]: ");
            while (!TresEnRaya.teclat.hasNextInt()) {
                System.out.println("Ingrese su opción [1-" + (packs.length + 1) + "]: ");
                TresEnRaya.teclat.next();
            }
            opcion = TresEnRaya.teclat.nextInt();
        } while (opcion < 1 || opcion > packs.length + 1);

        if (opcion == packs.length + 1) {
            Random rand = new Random();
            this.packSeleccionado = rand.nextInt(packs.length);
        } else {
            this.packSeleccionado = opcion - 1;
        }
    }

    public String obtenerSimbolo(EstadoCasilla estadoCasilla) {
        switch (estadoCasilla) {
            case Ficha_O:
                return packs[packSeleccionado][1];
            case FICHA_X:
                return packs[packSeleccionado][0];
            case VACIO:
            default:
                return "";
        }
    }
}
