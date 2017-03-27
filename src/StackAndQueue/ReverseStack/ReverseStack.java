package StackAndQueue.ReverseStack;

import java.util.Stack;

/**
 * Created by 10609 on 2017/3/27.
 */
public class ReverseStack {
    private Stack<Integer> data;

    public ReverseStack() {
        data = new Stack<Integer>();
    }

    private static int extractLastElement(Stack<Integer> stack) {
        int val = stack.pop();
        if (stack.isEmpty()) {
            return val;
        } else {
            int ret = extractLastElement(stack);
            stack.push(val);
            return ret;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int last = extractLastElement(stack);
        reverse(stack);
        stack.push(last);
    }

    public static void test() {
        int SIZE = 10;
        int []arr = new int[SIZE];
        for (int i = 0; i <SIZE;i++) {
            arr[i] = (int)(Math.random()  * 100000) % SIZE;
        }
        for (int i: arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i: arr) {
            stack.push(i);
        }
        ReverseStack.reverse(stack);
        ReverseStack.reverse(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test();
    }
}
