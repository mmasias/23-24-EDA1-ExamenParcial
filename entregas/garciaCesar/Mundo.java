class Mundo {
    private Ludoteca ludoteca;
    private int tiempoTotal;
    private int contadorNombres;

    public Mundo(Ludoteca unaLudoteca, int tiempoApertura) {
        ludoteca = unaLudoteca;
        tiempoTotal = tiempoApertura;
        contadorNombres = 1;
    }

    public void iniciarSimulacion() {
        for (int minutoActual = 0; minutoActual < tiempoTotal; minutoActual++) {
            System.out.println("Minuto " + minutoActual);
            if (minutoActual < 10) {
                generarNiñosAleatorios(0, 2);
            } else if (minutoActual < 30) {
                if (llegaNiñoCadaNMinutos(3)) {
                    generarNiñosAleatorios(1, 1);
                }
            }

            ludoteca.actualizar();
            ludoteca.verEstado();
        }
    }

    private void generarNiñosAleatorios(int min, int max) {
        int numNiños = (int) (Math.random() * (max - min + 1)) + min;
        for (int i = 0; i < numNiños; i++) {
            Niño niño = generarNiño();
            ludoteca.recibirNiño(niño);
        }
    }

    private boolean llegaNiñoCadaNMinutos(int n) {
        return Math.random() < 1.0 / n;
    }
    private Niño generarNiño() {
        String unNombre = "Niño" + contadorNombres;
        System.out.println("Llega " + unNombre);
        contadorNombres++;
        return new Niño(unNombre);
    }

    public static void main(String[] args) {
        Ludoteca unaLudoteca = new Ludoteca();
        Mundo elMundo = new Mundo(unaLudoteca, 120);
        elMundo.iniciarSimulacion();
    }
}
