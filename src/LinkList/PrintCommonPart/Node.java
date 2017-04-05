package LinkList.PrintCommonPart;

/**
 * Created by 10609 on 2017/4/5.
 */
public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public String toString() {
        return String.format("%d ", value);
    }
}
