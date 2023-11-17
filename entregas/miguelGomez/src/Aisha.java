import java.util.List;

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
        Mensaje mensaje = new Mensaje("MENSAJEINICIAL");
        for (int i = 0; i < fila.size(); i++) {
            if (i == 0) {
                fila.get(i).recibirMensaje(mensaje);
            } else {
                fila.get(i).mostrarMensaje(fila.get(i - 1));
            }
        }

        escribirEnPizarra(fila.get(fila.size() - 1).getPizarrin());
    }

    private void escribirEnPizarra(String mensaje) {
        System.out.println("Mensaje Final: " + mensaje);
    }
}
