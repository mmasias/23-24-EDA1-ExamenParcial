package entregas.ludoteca;

import java.util.List;

import entregas.ludoteca.utils.ConsoleUI;

public class TelephoneGame {
  
  boolean currentlyPlaying = false;
  Integer currentQueueIndex = 0;
  
  public void BeginTelephoneGame(Instructor instructor,List<Child> ChildrenPlaying) {
    
    ConsoleUI.printInitializationTelephoneGameMessage(ChildrenPlaying);
    Ludoteca.cleanBlackBoard();    
    for (Child child : ChildrenPlaying) {
      child.cleanBoard();
    }

    Ludoteca.blackBoard = instructor.generate10LetterRandomMessage();

    currentlyPlaying = true;
  }

  public void playTelephoneGameRound(Instructor instructor, List<Child> ChildrenPlaying) {
    String currentMessage = Ludoteca.blackBoard;
    
    if (currentQueueIndex == ChildrenPlaying.size()) {
      currentlyPlaying = false;
      currentQueueIndex = 0;
      Ludoteca.blackBoard = ChildrenPlaying.get(currentQueueIndex).getMessage();
      ConsoleUI.printMinuteLog(ChildrenPlaying.get(ChildrenPlaying.size() - 1).name + " writes the final message on the salon's board: " + Ludoteca.blackBoard);
      return;
    }

    if (currentQueueIndex == 0) {
      ChildrenPlaying.get(0).receiveMessage(currentMessage);
    } else {
      ChildrenPlaying.get(currentQueueIndex - 1).passMessageTo(ChildrenPlaying.get(currentQueueIndex));
    }
    currentQueueIndex++;

  }
}
