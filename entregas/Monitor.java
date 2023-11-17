public class Monitor {

    List<Child> childList;
    
    public Monitor(){
        this.childList = new List<Child>();
    }

    public void setNewChild(Child newChild){
        this.childList.insertEnd(newChild);
    }

    public Child passFirstChild(){
        Node<Child> childNode =this.childList.getFirst();
        Child child = childNode.getValue();
        this.childList.deleteFront();
        return child;
    }

    public boolean isChildListEmpty(){
        if (this.childList.size() == 0) {
            return true;
        }
        return false;
    }

}
