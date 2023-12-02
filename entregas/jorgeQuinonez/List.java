public class List {

  private Niño first = null;
  private int size = 0;

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size() > 0 ? false : true;
  }

  public Niño getFirst() {
    return this.first;
  }

  public void insertEnd(String value) {
    Niño lastKid = new Niño(value);
    if (this.first == null) {
      this.first = lastKid;
    } else {
      Niño iterator = this.first;
      while (iterator.getNext() != null) {
        iterator = iterator.getNext();
      }
      iterator.setNext(lastKid);
    }
    this.size++;
  }

  public void deleteLast() {
    if (this.first != null) {
      Niño iterator = this.first;
      Niño previous = null;
      while (iterator.getNext() != null) {
        previous = iterator;
        iterator = iterator.getNext();
      }
      if (previous != null) {
        previous.setNext(null);
      } else {
        this.first = null;
      }
      this.size--;
    }
  }

  public String[] listAll() {
    String[] list = new String[this.size()];
    Niño iterator = this.first;
    int count = 0;
    while (iterator != null) {
      list[count] = iterator.getValue();
      count++;
      iterator = iterator.getNext();
    }
    return list;
  }
}