package entregas.ludoteca;

public class main {
  static Integer simulationTime = 120;
  public static void main(String[] args) {
    Ludoteca ludoteca = new Ludoteca();
    ludoteca.simulateLudoteca(simulationTime);
  }
}
