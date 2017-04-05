package LinkList.PrintCommonPart;

import java.util.Arrays;

/**
 * Created by 10609 on 2017/4/5.
 */
public class CommonPart {
    private Node l1;
    private Node l2;
    int num = 20;

    public Node getL1() {
        return l1;
    }

    public Node getL2() {
        return l2;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public CommonPart() {

    }

    public CommonPart(int num) {
        this.num = num;
    }

    private int generateVal() {
        return (int) (Math.random() * 10000) % 20;
    }

    private boolean contains(int[] arr, int val) {
        for (int i: arr) {
            if (i == val) {
                return true;
            }
        }
        return false;
    }
    private void generateArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (true) {
                int val = generateVal();
                if (!contains(arr, val)) {
                    arr[i] = val;
                    break;
                }
            }
        }
    }

    private Node generate(Node head) {
        int count = getNum();
        int[] arr = new int[count];
        generateArr(arr);
        Arrays.sort(arr);
        for (int i: arr) {
            Node node = new Node(i);
            node.next = head;
            head = node;
        }
        return head;
    }

    public void display(Node head) {
        Node cur = head;
        while (cur != null) {
            printNode(cur);
            cur = cur.next;
        }
        System.out.println();
    }

    private static void printNode(Node node) {
        System.out.print(node + "\t");
    }

    public static void printCommonPart(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.value > head2.value) {
                head1 = head1.next;
            } else if (head2.value >  head1.value) {
                head2 = head2.next;
            } else {
                printNode(head1);

                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

    public static void process() {
        CommonPart commonPart = new CommonPart(10);
        Node l1 = commonPart.getL1();
        Node l2 = commonPart.getL2();
        l1 = commonPart.generate(l1);
        l2 = commonPart.generate(l2);
        commonPart.display(l1);
        commonPart.display(l2);
        printCommonPart(l1, l2);
    }

    public static void test() {
        process();
    }

    public static void main(String[] args) {
        test();
    }

}
