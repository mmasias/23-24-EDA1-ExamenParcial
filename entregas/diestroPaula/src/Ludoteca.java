class Ludoteca {
    private Lidia lidia;
    private Aisha aisha;
    private Cola cola;

    Ludoteca() {
        this.lidia = new Lidia();
        this.aisha = new Aisha();
        this.cola = new Cola();
    }

    void simularApertura() {
        for (int tiempo = 0; tiempo < 120; tiempo++) {
            lidia.atenderNinos();

            if (tiempo < 10 || (tiempo >= 10 && tiempo < 30 && Math.random() < 0.5)) {
                Niño nuevoNiño = new Niño();
                cola.encolar(nuevoNiño);
                System.out.println("Nuevo niño en la cola");
            }

            if (!cola.estaVacia() && tiempo >= 10) {
                aisha.jugar(cola);
            }
        }
    }
}
