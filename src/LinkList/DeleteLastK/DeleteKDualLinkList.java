package LinkList.DeleteLastK;

import javax.annotation.processing.SupportedSourceVersion;

/**
 * Created by 10609 on 2017/4/6.
 */
public class DeleteKDualLinkList {
    private int n;
    private int[] arr;
    private DNode head;

    public DeleteKDualLinkList(int n) {
        this.n = n;
        generateArr();
        process();
    }

    private boolean contains(int val) {
        for (int i : arr) {
            if (i == val) {
                return true;
            }
        }
        return false;
    }

    private int generateVal() {
        return (int) (Math.random() * 100000) % (n * n);
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

    public void process() {
        for (int i : arr) {
            DNode node = new DNode(i);
            node.next = head;
            if (head != null) {
                head.pre = node;
            }
            head = node;
        }
    }

    private int getNum() {
        int len = 0;
        DNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

    public int deleteK(int pos) {
        if (pos <= 0 || pos > getNum()) {
            throw new RuntimeException("Out Of Range");
        }
        int res = 0;
        int i = 0;
        DNode cur = head;
        DNode pre = null;
        while (cur != null) {
            res = cur.value;
            i++;
            if (i == pos) {
                if (pre == null) {
                    head = head.next;
                    head.pre = null;
                } else {
                    pre.next = cur.next;
                }
                if (cur.next != null) {
                    cur.next.pre = pre;
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return res;
    }

    public void display() {
        DNode cur = head;
        while (cur != null) {
            System.out.print(cur + "\t");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void test(int k) {
        DeleteKDualLinkList deleteKDualLinkList = new DeleteKDualLinkList(10);
        deleteKDualLinkList.display();
        int val = deleteKDualLinkList.deleteK(k);
        System.out.println(val);
        deleteKDualLinkList.display();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            test(i);
        }
    }
}
