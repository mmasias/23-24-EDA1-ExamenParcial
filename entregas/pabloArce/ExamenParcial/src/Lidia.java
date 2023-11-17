import Utils.Queue;

import static Utils.Utils.SysOut;

public class Lidia {
    private Queue<Children> childrenWaiting;
    private Aisha aisha;

    public Lidia(Aisha aisha){
        this.childrenWaiting = new Queue<Children>();
        this.aisha = aisha;
    }

    public void handleChildren(boolean isPlaying, Children children){
        if (isPlaying){
            putChildrenWait(children);
        } else {
            welcomeChildren(children);
        }
    }

    public void incorporateChildrenToGame(){
        if (this.childrenWaiting.isEmpty()) return;

        for (int i = 0; i < this.childrenWaiting.size(); i++) {
            Children children = this.childrenWaiting.dequeue();
            this.aisha.getChildrenList().enqueue(children);
            SysOut("Lidia añade a los niños esperando!\n");
        }
    }

    private void putChildrenWait(Children children){
        this.childrenWaiting.enqueue(children);
    }
    private void welcomeChildren(Children children){
        this.aisha.getChildrenList().enqueue(children);
    }
}
