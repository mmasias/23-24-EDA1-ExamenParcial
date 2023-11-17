import java.util.List;
import java.util.Random;

public class Aisha {
    public static void jugar(List<Nino> cola, List<String> mensajes) {
        System.out.println("Comienza el juego:");

        Pizarra pizarra = new Pizarra();
        Random random = new Random();

        pizarra.limpiar();

        cola.forEach(nino -> nino.getPizarra().limpiar());

        String mensajeOriginal = mensajes.get(random.nextInt(mensajes.size()));
        cola.get(0).recibirMensaje(mensajeOriginal);
        System.out.println("Niño " + cola.get(0).getNombre() + " recibe el mensaje: " + mensajeOriginal);

        for (int i = 1; i < cola.size(); i++) {
            cola.get(i).pasarMensaje(cola.get(i - 1));
            System.out.println("Niño " + cola.get(i).getNombre() +
                    " recibe el mensaje: " + cola.get(i).getPizarra().getMensaje());
        }

        if (!cola.isEmpty()) {
            Nino ultimoNino = cola.get(cola.size() - 1);
            ultimoNino.pasarMensajeAfectado(pizarra);

            System.out.println("Mensaje original en la pizarra del salón: " + mensajeOriginal);
            System.out.println("Mensaje final en la pizarra del salón: " + pizarra.getMensaje());
        }
    }
}
