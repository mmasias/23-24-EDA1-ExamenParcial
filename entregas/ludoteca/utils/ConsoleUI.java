package entregas.ludoteca.utils;

import java.util.List;
import entregas.ludoteca.Child;

public class ConsoleUI {

  private static Integer currentMinute;

  public ConsoleUI(Integer minute) {
    this.currentMinute = minute;
  }

  public static void printSeparator() {
    System.out.println("\u001B[1;37m" + "#".repeat(80) + "\u001B[0m");
  }

  public static void printMinuteLog(String message) {
    String formattedMinute = String.format("%02d", currentMinute);
    System.out.println("\u001B[1;37m[" + formattedMinute + "] => \u001B[0m" + message);
  }

  public static void printInitializationTelephoneGameMessage(List<Child> ChildrenPlaying) {
    System.out.println();
    printSeparator();
    printMinuteLog("Starting a new game with " + ChildrenPlaying.size() + " children.");
    printMinuteLog("The children are: ");
    for (Child child : ChildrenPlaying) {
      System.out.print(child.getName() + ", ");
    }
    System.out.println();
    printMinuteLog("Aisha asks the children playing to clean their boards.");
    printSeparator();
  }

  public static void printInitializationSimulationMessage(Integer totalSimulationTime) {
    printSeparator();
    System.out.println("\u001B[1;37mInitializing simulation with " + totalSimulationTime + " minutes.\u001B[0m");
    System.out.println();
  }
}
