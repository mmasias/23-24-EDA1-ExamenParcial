public class Cola {

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

  public void insertEnd(Niño kid) {
    Niño lastKid = kid;
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

  public void deleteStart() {
    if (this.first != null) {
      System.out.println(" > Se fue " + this.first.getName());
      Niño nextKid = this.first.getNext();
      this.first = null;
      this.first = nextKid;
      this.size--;
    }
  }

  public void listAll() {
    Niño iterator = this.first;
    int count = 0;
    while (iterator != null) {
      count++;
      System.out.println(count + ". " + iterator.getName());
      iterator = iterator.getNext();
    }
  }
}