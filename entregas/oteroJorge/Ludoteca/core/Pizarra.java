package core;

public class Pizarra {
    private String palabra;

    public Pizarra() {

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
    
}
