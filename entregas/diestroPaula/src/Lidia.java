public class Lidia {
    void atenderNinos() {
        System.out.println("Lidia atiende a los niños.");
    }

    void sentarNino(Niño niño) {
        System.out.println("Lidia sienta al niño en la ludoteca: " + niño);
    }

    static Niño sacarUltimoNiño() {
        return new Niño();
    }
}