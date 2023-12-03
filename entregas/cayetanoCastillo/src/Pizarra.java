public class Pizarra {
    private String contenido;

    public void limpiar() {
        contenido = "";
    }

    public void escribir(String mensaje) {
        contenido = mensaje;
    }

    public String obtenerContenido() {
        return contenido;
    }

    public boolean haEscritoAlgo() {
        return !contenido.isEmpty();
    }
}
