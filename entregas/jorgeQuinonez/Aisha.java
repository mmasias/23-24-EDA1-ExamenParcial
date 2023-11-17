public class Aisha {

 private Kid first = null;
 private int size = 0;
 private boolean playing = false;
 private String lastKidMessage = "";

 public void startGame(String message) {
  if (size >= 5) {
   first.writeMessage(message);
   playing = true;
   Kid iterator = first;
   Kid previous = null;
   Kid lastKid = null;
   if (iterator != null) {
    while (iterator.getNext() != null) {
     previous = iterator;
     iterator = iterator.getNext();
    }
    iterator.writeMessage(previous.getMessage());
    if (iterator.getNext() == null) {
     lastKid = iterator;
    }
   }
   if (lastKid != null) {
    lastKidMessage = lastKid.getMessage();
    endGame();
   }
  }
 }

 private void endGame() {
  clearKidsMessage();
  playing = false;
 }

 private void clearKidsMessage() {
  Kid iterator = first;
  while (iterator.getNext() != null) {
   iterator.clearMessage();
   iterator = iterator.getNext();
  }
 }

 public boolean isPlaying() {
  return playing;
 }

 public int size() {
  return size;
 }

 public boolean isEmpty() {
  return size() > 0 ? false : true;
 }

 public Kid getFirst() {
  return first;
 }

 public void addKid(Kid kid) {
  if (kid != null) {
   kid.givePizarrin(new Pizarrin());
  }
  if (first == null) {
   first = kid;
  } else {
   Kid iterator = first;
   while (iterator.getNext() != null) {
    iterator = iterator.getNext();
   }
   iterator.setNext(kid);
  }
  size++;
 }

 public String getLastKidMessage() {
  return lastKidMessage;
 }
}
