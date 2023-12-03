import core.Aula;
import core.Mundo;

public class Main {
    public static void main(String[] args) {
        Aula ludoteca = new Aula();
        Mundo mundo = new Mundo(ludoteca, 120);
        mundo.iniciarSimulacion();
    }
}