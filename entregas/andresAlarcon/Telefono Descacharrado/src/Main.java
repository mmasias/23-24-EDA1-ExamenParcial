import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Nino> ninos = new ArrayList<>();
        List<String> mensajes = Arrays.asList(
                "HolaMundo1", "Mensaje123", "JavaRules", "Programacion", "Computadora",
                "Eda2023", "Ninos", "Telefono", "Aisha", "Lidia",
                "Pokemon", "Nintendo", "GTA6", "Desarrollo", "Lenguaje", "Informatica");

        Ludoteca.abrirLudoteca(ninos, mensajes);
    }
}