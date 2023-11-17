package core;

public class Pizarra {
    private String palabra;
    private boolean enJuego;
    private Cola miCola;
    public Pizarra(String palabra) {
        this.palabra = palabra;
        this.enJuego = false;
    }
    public void borrarPizarra() {
        palabra = "";
    }
    public String getPalabra() {
        return palabra;
    }
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
    public void recibeNiños(Cola cola) {
        enJuego = true;
        miCola = cola;
    }
    public void terminaJuego() {
        enJuego = false;
    }
    public boolean estaEnJuego() {

        return enJuego;
    }


}
