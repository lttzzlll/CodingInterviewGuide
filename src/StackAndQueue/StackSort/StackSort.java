package StackAndQueue.StackSort;

import java.util.Stack;

/**
 * Created by 10609 on 2017/3/27.
 */
public class StackSort {

    public static void sort(Stack<Integer> stack) {
        Stack<Integer> helpStack = new Stack<Integer>();
        while (!stack.isEmpty()) {
            if (helpStack.isEmpty() || stack.peek() <= helpStack.peek()) {
                helpStack.push(stack.pop());
            } else {
                int val = stack.pop();
                while (!helpStack.isEmpty() && val > helpStack.peek()) {
                    stack.push(helpStack.pop());
                }
                stack.push(val);
            }
        }
        while (!helpStack.isEmpty()) {
            stack.push(helpStack.pop());
        }
    }

    public static void sort2(Stack<Integer> stack) {
        Stack<Integer> helpStack = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int val = stack.pop();
            while (!helpStack.isEmpty() && val > helpStack.peek()) {
                stack.push(helpStack.pop());
            }
            helpStack.push(val);
        }
        while (!helpStack.isEmpty()) {
            stack.push(helpStack.pop());
        }
    }

    public static void test() {
        int SIZE = 10;
        int[] arr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (int) (Math.random() * 100000) % SIZE;
        }
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i : arr) {
            stack.push(i);
        }
        sort2(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "\t");
        }
        System.out.println("\n---------------------------------");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            test();
        }
    }
}
