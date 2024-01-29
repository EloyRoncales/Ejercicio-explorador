import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Explorador explorador = new Explorador("Explorador1");
        Mapa mapa = new Mapa();

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarPosicionActual(explorador);
                    break;
                case 2:
                    moverExplorador(explorador, mapa);

                    break;
                case 3:
                    explorarAlrededor(explorador, mapa);
                    break;
                case 4:
                    System.out.println("Gracias por jugar. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }

        } while (opcion != 4);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("*******************************************************");
        System.out.println("Bienvenido al juego del explorador");
        System.out.println("*******************************************************");
        System.out.println("1. Ver posición actual del explorador.");
        System.out.println("2. Mover explorador.");
        System.out.println("3. Explorar.");
        System.out.println("4. Salir.");
        System.out.print("Ingrese su opción: ");
    }

    private static void mostrarPosicionActual(Explorador explorador) {
        Posicion posicion = explorador.getPosicionActual();
        System.out.println(explorador.getNombre() + " está en la siguiente posición del tablero:");
        System.out.println("COLUMNA: " + posicion.getCoordenadaCol());
        System.out.println("FILA: " + posicion.getCoordenadaFila());
    }

    private static void moverExplorador(Explorador explorador, Mapa mapa) {
        System.out.println("Mover explorador.");
        System.out.println("Indique la dirección de movimiento:");
        System.out.println("1- ARRIBA");
        System.out.println("2- ABAJO");
        System.out.println("3- IZQUIERDA");
        System.out.println("4- DERECHA");
        System.out.print("Ingrese su opción: ");

        Scanner scanner = new Scanner(System.in);
        int direccion = scanner.nextInt();

        explorador.moverse(direccion, mapa);
    }


    private static void explorarAlrededor(Explorador explorador, Mapa mapa) {
        System.out.println("Explorar.");
        int trampasAlrededor = explorador.explorar(mapa);
        System.out.println("Tiene " + trampasAlrededor + " trampas alrededor. Sigue jugando...");
    }
}