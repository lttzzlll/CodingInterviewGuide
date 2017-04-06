package LinkList.DeleteLastK;

/**
 * Created by 10609 on 2017/4/6.
 */
public class DNode {
    public int value;
    public DNode pre;
    public DNode next;

    public DNode(int value) {
        this.value = value;
    }

    public String toString() {
        return String.format("%d", value);
    }
}
