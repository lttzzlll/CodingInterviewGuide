package StackAndQueue.GetMinStack;

import java.util.Stack;

/**
 * Created by 10609 on 2017/3/27.
 */
public class MyStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MyStack() {
        dataStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int item) {
        if (minStack.isEmpty() || item < minStack.peek()) {
            minStack.push(item);
        } else {
            minStack.push(minStack.peek());
        }
        dataStack.push(item);
    }

    public int pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        minStack.pop();
        return dataStack.pop();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return minStack.peek();
    }

    public int peek() {
        return dataStack.peek();
    }

    public boolean isEmpty() {
        return dataStack.isEmpty();
    }

    public static void test() {
        int SIZE = 10;
        int[] arr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (int) (Math.random() * 1000000) % SIZE;
        }
        for (int i : arr) {
            System.out.print(i + "\t\t");
        }
        System.out.println();
        MyStack myStack = new MyStack();
        for (int i : arr) {
            myStack.push(i);
            System.out.print(myStack.getMin() + " | " + myStack.peek() + "\t");
        }
        System.out.println();
        while (!myStack.isEmpty()) {
            System.out.print(myStack.getMin() + " | " + myStack.pop() + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            test();
        }
    }
}
