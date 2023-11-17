import java.util.ArrayList;
import java.util.List;


class ludoteca {
    private monitora lidia;
    private monitora aisha;
    private List<niño> niñosEnLudoteca;
    private boolean juegoEnCurso;
    private pizarra pizarra;

    public ludoteca(monitora lidia, monitora aisha) {
        this.lidia = lidia;
        this.aisha = aisha;
        this.niñosEnLudoteca = new ArrayList<>();
        this.juegoEnCurso = false;
        this.pizarra = new pizarra();
    }

    public void abrir() {
        System.out.println("¡Bienvenidos a la Ludoteca!");

        for (int minutos = 0; minutos < 120; minutos++) {
       

            if (niñosEnLudoteca.size() >= 5 && !juegoEnCurso) {
                aisha.formarFila(niñosEnLudoteca);
                aisha.iniciarJuego(pizarra, niñosEnLudoteca);
                juegoEnCurso = true;
            }
        }
    }

    public void simularJuego() {
        int tiempoTranscurrido = 0;

        while (tiempoTranscurrido < 120) {
            if (juegoEnCurso) {
                aisha.jugar(pizarra);
                if (!aisha.isJuegoEnCurso()) {
                    lidia.mantenerNiños(niñosEnLudoteca);
                    niñosEnLudoteca.clear();
                    juegoEnCurso = false;
                }
            } else {
                if (tiempoTranscurrido < 10 || (tiempoTranscurrido >= 10 && tiempoTranscurrido < 30 && Math.random() < 0.5)) {
                    int cantidadNiños = (int) (Math.random() * 3);
                    for (int i = 0; i < cantidadNiños; i++) {
                        niño nuevoNiño = new niño("Niño" + (niñosEnLudoteca.size() + 1));
                        niñosEnLudoteca.add(nuevoNiño);
                        lidia.recibirNiño(nuevoNiño);
                    }
                }

                if (tiempoTranscurrido % 3 == 0 && tiempoTranscurrido >= 30) {
                    int cantidadNiños = Math.random() < 0.5 ? 1 : 0;
                    for (int i = 0; i < cantidadNiños; i++) {
                        niño nuevoNiño = new niño("Niño" + (niñosEnLudoteca.size() + 1));
                        niñosEnLudoteca.add(nuevoNiño);
                        lidia.recibirNiño(nuevoNiño);
                    }
                }

                if (niñosEnLudoteca.size() >= 5) {
                    aisha.formarFila(niñosEnLudoteca);
                    aisha.iniciarJuego(pizarra,niñosEnLudoteca);
                    juegoEnCurso = true;
                }
            }

            tiempoTranscurrido++;
        }
        pizarra.mostrarMensajes();
    }

    public void cerrar() {
        System.out.println("¡La Ludoteca cierra! Gracias por jugar.");
    }
    }