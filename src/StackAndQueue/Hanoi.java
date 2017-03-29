package StackAndQueue;

import StackAndQueue.StackSort.StackSort;

/**
 * Created by 10609 on 2017/3/28.
 */
public class Hanoi {
    public static int hanoi(int n, String src, String temp, String des) {
        if (n == 1) {
            System.out.println(String.format("%d, %s -> %s", n, src, des));
            return 1;
        } else {
            int val1 = hanoi(n - 1, src, des, temp);
            System.out.println(String.format("%d, %s -> %s", n, src, des));
            int val2 = hanoi(n - 1, temp, src, des);
            return val1 + val2 + 1;
        }
    }



    public static void test(int n) {
        int val = hanoi(n, "A", "B", "C");
        System.out.println(String.format("%d", val));
    }

    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            test(i);
            System.out.println("-------------------");
        }
    }
}
