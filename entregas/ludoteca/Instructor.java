package entregas.ludoteca;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entregas.ludoteca.utils.ConsoleUI;

class Instructor {
  String isntructorName;
  List<Child> childrenQueue = new ArrayList<>();

  Instructor(String name) {
    this.isntructorName = name;
  }

  public void receiveChildren(List<Child> children) {
    if (children.size() == 0) {
      ConsoleUI.printMinuteLog(this.isntructorName + " recived no children.");
      return;
    }
    ConsoleUI.printMinuteLog(this.isntructorName + " recived " + children.size() + " children." );
    this.childrenQueue.addAll(children);
  }

  public void passChildrenTo(Instructor otherInstructor) {
    ConsoleUI.printMinuteLog(this.isntructorName + " is passing " + childrenQueue.size() + " children to " + otherInstructor.isntructorName);
    otherInstructor.receiveChildren(childrenQueue);
    this.childrenQueue.clear();
  }

  public String generate10LetterRandomMessage() {
    StringBuilder message = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < 10; i++) {
      char randomChar = (char) (random.nextInt(26) + 'A');
      message.append(randomChar);
    }
    String randomMessage = message.toString();
    ConsoleUI.printMinuteLog(this.isntructorName + " wrote the message: " + randomMessage);
    return randomMessage;
  }
}
