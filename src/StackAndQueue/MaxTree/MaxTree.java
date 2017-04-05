package StackAndQueue.MaxTree;

/**
 * Created by 10609 on 2017/3/31.
 */
public class MaxTree {
    public int[] arr;
    public int MAX_COUNT = 10;

    public MaxTree() {
        arr = new int[MAX_COUNT];
        generateUniqueArr();
    }

    public boolean contains(int value) {
        for (int i : arr) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    public int generateVal() {
        return (int) (Math.random() * 100000) % (MAX_COUNT * MAX_COUNT);
    }

    public void generateUniqueArr() {
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
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }


    public static void test() {
        MaxTree maxTree = new MaxTree();
        maxTree.display();
    }

    public static void main(String[] args) {
        test();
    }
}
