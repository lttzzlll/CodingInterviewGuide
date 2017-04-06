package LinkList.DeleteLastK;

/**
 * Created by 10609 on 2017/4/6.
 */
public class SNode {
    public int value;
    public SNode next;

    public SNode(int value) {
        this.value = value;
    }

    public String toString() {
        return String.format("%d", value);
    }
}
