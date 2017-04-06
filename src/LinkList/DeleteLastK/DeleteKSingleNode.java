package LinkList.DeleteLastK;

/**
 * Created by 10609 on 2017/4/6.
 */
public class DeleteKSingleNode {
    int n;
    int[] arr;
    SNode head;

    public DeleteKSingleNode(int n) {
        this.n = n;
        generateArr();
        process();
    }

    private int generateVal() {
        return (int) (Math.random() * 100000) % (n * n);
    }

    private boolean contains(int val) {
        for (int i : arr) {
            if (i == val) {
                return true;
            }
        }
        return false;
    }

    private void generateArr() {
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            while (true) {
                int val = generateVal();
                if (!contains(val)) {
                    arr[i] = val;
                    break;
                }
            }
        }
    }

    public void display() {
        SNode cur = head;
        while (cur != null) {
            System.out.print(cur + "\t");
            cur = cur.next;
        }
        System.out.println();
    }

    public SNode process() {
        for (int i : arr) {
            SNode node = new SNode(i);
            node.next = head;
            head = node;
        }
        return head;
    }

    public int getLength() {
        int len = 0;
        SNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

    public int deleteK(int k) {
        if (k <= 0 || k > getLength()) {
            throw new RuntimeException("Out Of Range");
        }
        int res= 0;
        int i = 0;
        SNode cur = head;
        SNode pre = null;
        while (cur != null) {
            i++;
            res = cur.value;
            if (i == k) {
                if (pre == null) {
                    head = head.next;
                } else {
                    pre.next = cur.next;
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return res;
    }

    public static void test(int k) {
        DeleteKSingleNode deleteKSingleNode = new DeleteKSingleNode(10);
        deleteKSingleNode.display();
//        SNode head = deleteKSingleNode.process();
        int val = deleteKSingleNode.deleteK(k);
        System.out.println(val);
        deleteKSingleNode.display();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            test(i);
        }
    }
}
