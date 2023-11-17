class Nino {
    private static int contadorNiños = 0;
    private int id;
    private Pizarrin pizarrin;

    Nino() {
        id = ++contadorNiños;
        pizarrin = null;
    }

    void anotarMensaje(Pizarrin mensaje) {
        // Simula el tiempo que tarda un niño en leer y anotar el mensaje
        try {
            Thread.sleep(1000); // 1 segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pizarrin = mensaje;
    }

    void escribirEnPizarra() {
        // Simula el tiempo que tarda el último niño en correr a la pizarra y escribir el mensaje
        try {
            Thread.sleep(1000); // 1 segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " escribe en la pizarra: " + pizarrin);
    }

    @Override
    public String toString() {
        return "Niño " + id;
    }
}
