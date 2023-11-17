import java.util.List;
import java.util.Random;

class monitora {
    public String nombre;
    
    

    public monitora(String nombre) {
        this.nombre = nombre;
    }

    public void recibirNiño(niño niño) {
        System.out.println(nombre + " recibe a " + niño.getNombre());
    }

    public void formarFila(List<niño> niños) {
        System.out.println(nombre + " forma una fila con " + niños.size() + " niños.");
    }

    public void iniciarJuego(pizarra pizarra, List<niño> niñosEnLudoteca) {
        if (!isJuegoEnCurso()) {
            System.out.println(nombre + " inicia el juego del teléfono descacharrado.");

            System.out.println("Limpia la pizarra del salón.");

            System.out.println("Pide a los niños que limpien sus pizarrines.");

            String mensajeOriginal = generarMensaje();
            System.out.println(nombre + " muestra el mensaje original: " + mensajeOriginal);

            for (int i = 0; i < niñosEnLudoteca.size(); i++) {
                niño niño = niñosEnLudoteca.get(i);
                niño.recibirMensaje(mensajeOriginal);
            }
            niño ultimoNiño = niñosEnLudoteca.get(niñosEnLudoteca.size() - 1);
            ultimoNiño.correYEscribeEnPizarraSalon(mensajeOriginal, pizarra);
            
            setJuegoEnCurso(true);

            setJuegoEnCurso(false);
        }
    }

    private boolean juegoEnCurso = false;

    public void setJuegoEnCurso(boolean juegoEnCurso) {
        this.juegoEnCurso = juegoEnCurso;
    }

    public boolean isJuegoEnCurso() {
        return juegoEnCurso;
    }

    public String generarMensaje() {
        StringBuilder mensaje = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            char letra = (char) ('A' + random.nextInt(26));
            mensaje.append(letra);
        }

        return mensaje.toString();
    }

    public void jugar(pizarra pizarra) {
        if (isJuegoEnCurso()) {
            System.out.println(nombre + " inicia el juego del teléfono descacharrado.");

            System.out.println("Limpia la pizarra del salón.");

            System.out.println("Pide a los niños que limpien sus pizarrines.");

            String mensajeOriginal = generarMensaje();
            System.out.println(nombre + " muestra el mensaje original: " + mensajeOriginal);

            setJuegoEnCurso(true);

            setJuegoEnCurso(false);
        }
    }

    public void mantenerNiños(List<niño> niños) {
        System.out.println(nombre + " mantiene a los niños hasta que termine el juego.");
    }
}
