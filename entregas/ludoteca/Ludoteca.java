package entregas.ludoteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import entregas.ludoteca.utils.NameGenerator;
import entregas.ludoteca.utils.ConsoleUI;

public class Ludoteca {
  Random random = new Random();
  static String blackBoard = "";
  Instructor lydia = new Instructor("Lydia");
  Instructor aisha = new Instructor("Aisha");
  TelephoneGame TelephoneGame = new TelephoneGame();

  public static void cleanBlackBoard() {
    if (blackBoard != "") {
      System.out.println("The salon's board has a message: " + blackBoard);
      System.out.println("Erasing the salon's board.");
      blackBoard = "";
    } else {
      System.out.println("The salon's board is empty. Nothing to clean. Useless...");
    }
  }  

  public List<Child> simulateChildArrival(int currentMinute) {
    int childrenToAdd;
    List<Child> incomingChildren = new ArrayList<>();

    if (currentMinute < 10) {
      childrenToAdd = random.nextInt(3);
    } else if (currentMinute < 30 && currentMinute % 3 == 0) {
      childrenToAdd = random.nextBoolean() ? 1 : 0;
    } else {
      childrenToAdd = 0;
    }

    for (int j = 0; j < childrenToAdd; j++) {
      incomingChildren.add(new Child(NameGenerator.generateRandomName()));
      ConsoleUI.printMinuteLog(incomingChildren.get(j).name + " has arrived.");
    }

    return incomingChildren;
  }

  public void simulateLudoteca(int simulationTime) {

    ConsoleUI.printInitializationSimulationMessage(simulationTime);
    for (int minute = 1; minute <= simulationTime; minute++) {
      new ConsoleUI(minute);
      
      lydia.receiveChildren(simulateChildArrival(minute));
      if (TelephoneGame.currentlyPlaying == false) {
        lydia.passChildrenTo(aisha);
        if (aisha.childrenQueue.size() >= 5) {
          TelephoneGame.BeginTelephoneGame(aisha, aisha.childrenQueue);
        }
      } else if (TelephoneGame.currentlyPlaying == true) {
        TelephoneGame.playTelephoneGameRound(aisha, aisha.childrenQueue);
      } 
    }

  }
}