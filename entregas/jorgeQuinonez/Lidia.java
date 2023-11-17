public class Lidia {

 private Kid first = null;
 private int size = 0;
 private boolean waitingKids = false;

 public boolean kidsWaiting() {
  return size > 0 ? true : false;
 }

 public Kid getFirstKid() {
  return first;
 }

 public void addKid(Kid kid) {
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

 public void removeKid() {
  if (first != null) {
   first = first.getNext();
   size--;
  }
 }
}
