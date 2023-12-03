public class Main {

  public static void main(String[] args) {
      Playroom playroom = new Playroom();
      World world = new World(playroom, 120);
      world.startSimulation();
  }
}