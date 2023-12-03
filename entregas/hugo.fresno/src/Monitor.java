public class Monitor {
    private String nombre;
    private List<Niño> listaNiños;
    private boolean juegoActivo;
    private Node<Niño> niñoActual;

    public Monitor(String nombre) {
        this.nombre = nombre;
        this.listaNiños = new List<>();
        juegoActivo = false;
    }

    public void recibirNiño(Niño niño) {
        listaNiños.insert(niño, -1);
    }

    public boolean tieneNiños() {
        return !listaNiños.isEmpty();
    }

    public void transferirNiños(Monitor destino) {
        while (!listaNiños.isEmpty()) {
            Niño niño = listaNiños.getFirst().getData();
            listaNiños.remove(0);
            destino.recibirNiño(niño);
            System.out.println(this.nombre + " entrega niño a " + destino.nombre);
        }
    }

    public void iniciarJuego() {
        if (listaNiños.size() >= 5 && !juegoActivo) {
            juegoActivo = true;
            niñoActual = listaNiños.getFirst();
            niñoActual.getData().recibirMensaje("ABCDEFGHIJKLM");
        }
    }

    public void jugar() {
        if (juegoActivo) {
            Niño niño = niñoActual.getData();
            niñoActual = niñoActual.getNext() != null ? niñoActual.getNext() : listaNiños.getFirst();
            niñoActual.getData().recibirMensaje(niño.mostrarMensaje());
            if (niñoActual == listaNiños.getFirst()) {
                juegoActivo = false;
            }
        }
    }

    public boolean estaJugando() {
        return juegoActivo;
    }

    public void mostrarNiños() {
        Node<Niño> actual = listaNiños.getFirst();
        System.out.print("> " + nombre + " --> ");
        while (actual != null) {
            System.out.print(actual.getData().getNombre() + " / ");
            actual = actual.getNext();
        }
        System.out.println();
    }}
