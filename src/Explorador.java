import java.util.Random;

public class Explorador {
    private static final int ARRIBA = 1;
    private static final int ABAJO = 2;
    private static final int IZQUIERDA = 3;
    private static final int DERECHA = 4;

    private String nombre;
    private Posicion posicionActual;

    public Explorador(String nombre) {
        this.nombre = nombre;
        this.posicionActual = new Posicion(new Random().nextInt(10), 0);
    }

    public String getNombre() {
        return nombre;
    }

    public Posicion getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Posicion posicionActual) {
        this.posicionActual = posicionActual;
    }

    public void moverse(int direccion, Mapa mapa) {
        int nuevaFila = posicionActual.getCoordenadaFila();
        int nuevaColumna = posicionActual.getCoordenadaCol();

        switch (direccion) {
            case ARRIBA:
                if (nuevaFila > 0) {
                    nuevaFila--;
                }
                break;
            case ABAJO:
                if (nuevaFila < 9) {
                    nuevaFila++;
                }
                break;
            case IZQUIERDA:
                if (nuevaColumna > 0) {
                    nuevaColumna--;
                }
                break;
            case DERECHA:
                if (nuevaColumna < 9) {
                    nuevaColumna++;
                }
                break;
            default:
                break;
        }

        setPosicionActual(new Posicion(nuevaFila, nuevaColumna));
        int resultado = checkPosicion(mapa);

        if (resultado == 1 || resultado == 2) {
            // El juego termina porque el explorador cayó en una trampa o encontró el tesoro.
            System.out.println("Fin del juego.");
            System.exit(0);  // Esto termina la ejecución del programa.
        }
    }



    public int explorar(Mapa mapa) {
        Posicion posicionActual = this.getPosicionActual();
        int fila = posicionActual.getCoordenadaFila();
        int columna = posicionActual.getCoordenadaCol();

        int trampasAlrededor = 0;

        if (fila > 0 && mapa.getTablero()[fila - 1][columna] == 1) {
            trampasAlrededor++;
        }

        if (fila < 9 && mapa.getTablero()[fila + 1][columna] == 1) {
            trampasAlrededor++;
        }

        if (columna > 0 && mapa.getTablero()[fila][columna - 1] == 1) {
            trampasAlrededor++;
        }

        if (columna < 9 && mapa.getTablero()[fila][columna + 1] == 1) {
            trampasAlrededor++;
        }

        return trampasAlrededor;
    }

    public int checkPosicion(Mapa mapa) {
        int fila = posicionActual.getCoordenadaFila();
        int columna = posicionActual.getCoordenadaCol();

        if (mapa.getTablero()[fila][columna] == 1) {
            System.out.println(getNombre() + " ha caído en una trampa. Fin del juego.");
            return 1;
        } else if (mapa.getTablero()[fila][columna] == 2) {
            System.out.println(getNombre() + " ha encontrado el tesoro. ¡ENHORABUENA! Fin del juego.");
            return 2;
        }

        return 0;
    }
}