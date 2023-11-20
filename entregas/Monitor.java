public class Monitor {

    List<Child> childList;
    private boolean isPlaying;
    Node<Child> actualChildTurnNode = null;
    ChalkBoard chalkBoard;

    public Monitor() {
        this.childList = new List<Child>();
        this.chalkBoard = new ChalkBoard();
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public void setNewChild(Child newChild) {
        this.childList.insertEnd(newChild);
    }

    public Child passFirstChild() {
        Node<Child> childNode = this.childList.getFirst();
        Child child = childNode.getValue();
        this.childList.deleteFront();
        return child;
    }

    public boolean isChildListEmpty() {
        if (this.childList.size() == 0) {
            return true;
        }
        return false;
    }

    public int getChildListSize() {
        return this.childList.size();
    }

    public void monitorGame(ChalkBoard playRoomChalkBoard) {
        if (this.actualChildTurnNode != null) {

            if (this.actualChildTurnNode.getNext() == null) {
                String messageToWtrite = this.actualChildTurnNode.getValue().getChalkBoard().getMessage();
                this.actualChildTurnNode.getValue().writeInPlayRoomChalkBoard(playRoomChalkBoard, messageToWtrite);
                this.setPlaying(false);
            } else {
                String messageToPass = this.actualChildTurnNode.getValue().getChalkBoard().getMessage();
                this.actualChildTurnNode.getNext().getValue().writeInChalkBoard(messageToPass);
                this.actualChildTurnNode = this.actualChildTurnNode.getNext();
            }

        } else {
            String message = chalkBoard.getMessage();
            this.actualChildTurnNode = this.childList.getFirst();
            this.actualChildTurnNode.getValue().writeInChalkBoard(message);
        }

    }

    public void tellChildsTocleanChalkBoard() {
        Node<Child> childIterator = childList.getFirst();
        while (childIterator.getNext() != null) {
            childIterator.getValue().getChalkBoard().cleanChalkBoard();
            childIterator = childIterator.getNext();
        }
    }

    public void cleanChalkBoard(ChalkBoard playRoomChalkBoard) {
        playRoomChalkBoard.cleanChalkBoard();
        this.chalkBoard.cleanChalkBoard();
        this.tellChildsTocleanChalkBoard();
    }

}
