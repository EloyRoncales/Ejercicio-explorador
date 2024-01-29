import java.util.Random;

public class Mapa {
    private final int[][] tablero = new int[10][10];
    private Posicion posTablero;

    public Mapa() {
        generarTablero();

        int filaTesoro = new Random().nextInt(10);
        this.posTablero = new Posicion(filaTesoro, 9);
        tablero[filaTesoro][9] = 2;
    }

    private void generarTablero() {
        for (int i = 0; i < 10; i++) {
            tablero[i][0] = 0;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < 9; j++) {
                double probabilidad = Math.random();
                if (probabilidad < 0.2) {
                    tablero[i][j] = 1;
                } else {
                    tablero[i][j] = 0;
                }
            }
        }
    }

    public int[][] getTablero() {
        return tablero;
    }

    public Posicion getPosTablero() {
        return posTablero;
    }
}s