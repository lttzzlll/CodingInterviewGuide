package StackAndQueue.MaxArray;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import sun.rmi.server.InactiveGroupException;

import java.util.LinkedList;

/**
 * Created by 10609 on 2017/4/1.
 */
public class MaxArray {
    private final int size;
    private final int num;
    private int[] arr;

    public int[] getArr() {
        return arr;
    }

    public int getSize() {
        return size;
    }

    public int getNum() {
        return num;
    }

    public int process() {
        int res = 0;
        for (int step = 2; step < arr.length; step++) {
            for (int i = 0; i + step < arr.length; i++) {
                int maxVal = getMax(i, i + step - 1);
                int minVal = getMin(i, i + step - 1);
                if (maxVal - minVal <= num) {
                    res++;
//                    display(i, i + step - 1);
//                    System.out.println(String.format("max: %d, min: %d, num: %d\n", maxVal, minVal, num));
                }
            }
        }
        return res;
    }

    private int getMax(int left, int right) {
        int maxVal = arr[left];
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        return maxVal;
    }

    private int getMin(int left, int right) {
        int minVal = arr[left];
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            }
        }
        return minVal;
    }

    private int randomVal() {
        return (int) (Math.random() * 100000) % (size * size);
    }

    private void generateArr() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomVal();
        }
    }

    public void display() {
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public void display(int left, int right) {
        if (left >= 0 && right <= arr.length - 1 && left <= right) {
            for (int i = left; i <= right; i++) {
                System.out.print(arr[i] + "\t");
            }
            System.out.println();
        }
    }

    public MaxArray(int size, int num) {
        this.size = size;
        this.num = num;
        arr = new int[size];
        generateArr();
    }

    public int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> minQue = new LinkedList<Integer>();
        LinkedList<Integer> maxQue = new LinkedList<Integer>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                while (!minQue.isEmpty() && arr[minQue.peekLast()] >= arr[j]) {
                    minQue.pollLast();
                }
                minQue.addLast(j);
                while (!maxQue.isEmpty() && arr[maxQue.peekLast()] <= arr[j]) {
                    maxQue.pollLast();
                }
                maxQue.addLast(j);
                if (arr[maxQue.getFirst()] - arr[minQue.getFirst()] > num) {
                    break;
                }
                j++;
            }
            if (minQue.peekFirst() == i) {
                minQue.pollFirst();
            }
            if (maxQue.peekFirst() == i) {
                maxQue.pollFirst();
            }
            res += (j - i);
            i++;
        }
        return res;
    }

    public static void test() {
        MaxArray maxArray = new MaxArray(10, 10);
        maxArray.display();
        int res = maxArray.process();
        System.out.println(res);
        int res2 = maxArray.getNum(maxArray.getArr(), maxArray.getNum());
        System.out.println(res2);
    }

    public static void main(String[] args) {
        test();
    }

}
