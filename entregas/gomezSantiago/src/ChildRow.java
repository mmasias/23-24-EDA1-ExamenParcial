public class ChildRow {
    private int size = 0;
    private ChildNode first = null;

    public int size(){
        return this.size;
    }

    public void addChildToQueue(){
        ChildNode newChild = new ChildNode();
        if (this.first == null) {
            this.first = newChild;
        } else {
            ChildNode iterator = this.first;
            while (iterator.getNextChild() != null) {
                iterator = iterator.getNextChild();
            }
            iterator.setNextChild(newChild);
        }
        this.size++;
    }

    public void addChildToRow(){
        ChildNode newChild = new ChildNode();
        if (this.first == null) {
            this.first = newChild;
        } else {
            ChildNode iterator = this.first;
            while (iterator.getNextChild() != null) {
                iterator = iterator.getNextChild();
            }
            iterator.setNextChild(newChild);
        }
        this.size++;
    }

    public String getFirstChildInQueue(){
        if(this.first != null){
            return this.first.toString();
        }
        return null;
    }

    public void removeChildFromQueue(){
        if(this.first != null){
            this.first = this.first.getNextChild();
            this.size--;
        }
    }

}
