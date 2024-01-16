public class Explorador {
    private String nombre;
    private Posicion posicionActual;
    public Explorador(String nombre) {
        this.nombre = nombre;
        this.posicionActual = new Posicion();
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
    public int explorar(Mapa mapa) {

    }
    public int checkPosicion(Mapa mapa) {

    }
    public void moverse(int direccion) {

    }
}
