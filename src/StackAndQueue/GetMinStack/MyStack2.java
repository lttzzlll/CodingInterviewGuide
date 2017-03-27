package StackAndQueue.GetMinStack;

import java.util.Stack;

/**
 * Created by 10609 on 2017/3/27.
 */
public class MyStack2 {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MyStack2() {
        dataStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int item) {
        if (!dataStack.isEmpty() && item  > dataStack.peek()) {
            minStack.push(dataStack.peek());
        }
        dataStack.push(item);
    }

    public int pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        if (!minStack.isEmpty() && dataStack.peek() <= minStack.peek()) {
            minStack.pop();
        }
        return dataStack.pop();
    }

    public int peek() {
        return dataStack.peek();
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        } else if (!dataStack.isEmpty()) {
            return dataStack.peek();
        } else {
            throw new RuntimeException("Stack is empty");
        }
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
        MyStack2 myStack = new MyStack2();
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
