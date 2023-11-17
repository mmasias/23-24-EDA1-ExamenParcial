public class Main {
    public static void main(String[] args) {
        monitora lidia = new monitora("Lidia");
        monitora aisha = new monitora("Aisha");

        ludoteca ludoteca = new ludoteca(lidia, aisha);
        ludoteca.abrir();
        ludoteca.simularJuego();
        ludoteca.cerrar();
    }
    
}
