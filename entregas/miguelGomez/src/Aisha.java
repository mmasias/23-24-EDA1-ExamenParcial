import java.util.List;
import java.util.Random;

public class Aisha {
    public void jugar(List<Nino> fila) {
        limpiarPizarras(fila);
        iniciarJuego(fila);
    }

    private void limpiarPizarras(List<Nino> fila) {
        for (Nino nino : fila) {
            nino.setPizarrin("");
        }
        System.out.println("Aisha limpia las pizarras.");
    }

    private void iniciarJuego(List<Nino> fila) {
        Mensaje mensaje = new Mensaje(generarTextoAleatorio(10));
        for (int i = 0; i < fila.size(); i++) {
            if (i == 0) {
                fila.get(i).recibirMensaje(mensaje);
            } else {
                fila.get(i).mostrarMensaje(fila.get(i - 1));
            }
        }

        escribirEnPizarra(fila.get(fila.size() - 1).getPizarrin());
    }

    private String generarTextoAleatorio(int longitud) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder textoAleatorio = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < longitud; i++) {
            textoAleatorio.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }

        return textoAleatorio.toString();
    }

    private void escribirEnPizarra(String mensaje) {
        System.out.println("Mensaje Final: " + mensaje);
    }
}
