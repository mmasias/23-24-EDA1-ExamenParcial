import java.util.ArrayList;
import java.util.List;

class pizarra {
    private List<String> mensajes;

    public pizarra() {
        this.mensajes = new ArrayList<>();
    }

    public void agregarMensaje(String mensaje) {
        mensajes.add(mensaje);
    }

    public void mostrarMensajes() {
        System.out.println("Mensajes en la pizarra:");
        for (String mensaje : mensajes) {
            System.out.println("- " + mensaje);
        }
    }
}

    
