package StackAndQueue.WindowMaxValue;

import StackAndQueue.StackSort.StackSort;

import javax.naming.LinkLoopException;
import java.util.LinkedList;

/**
 * Created by 10609 on 2017/3/29.
 */
public class MaxValueInWindow {

    public static int getMaxVal(int[] arr, int left, int right) {
        int maxVal = arr[left];
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        return maxVal;
    }

    public static int[] getMaxVal(int[] arr, int w) {
        int[] retArr = new int[arr.length - w + 1];
        for (int i = 0; i + w - 1 < arr.length; i++) {
            retArr[i] = getMaxVal(arr, i, i + w - 1);
        }
        return retArr;
    }

    public static int[] getMaxWindowValue(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void test(int w) {
        int SIZE = 10;
        int[] arr = new int[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000000) % arr.length;
        }
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
        int[] retArr = getMaxWindowValue(arr, w);
        for (int i : retArr) {
            System.out.print(i + "\t");
        }
        System.out.println("\n--------------------------");
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            test(i);
        }
    }
}
