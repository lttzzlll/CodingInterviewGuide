package StackAndQueue.CombineTwoStackToQueue;

import java.util.Stack;

/**
 * Created by 10609 on 2017/3/27.
 */
public class StackToQueue {
    private Stack<Integer> lStack;
    private Stack<Integer> rStack;

    public StackToQueue() {
        lStack = new Stack<Integer>();
        rStack = new Stack<Integer>();
    }

    public void add(int item) {
        lStack.push(item);
    }

    public int poll() {
        if (lStack.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        rStack.empty();
        while (!lStack.isEmpty()) {
            rStack.push(lStack.pop());
        }
        int val = rStack.pop();
        while (!rStack.isEmpty()) {
            lStack.push(rStack.pop());
        }
        return val;
    }

    public int peek() {
        if (lStack.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        rStack.empty();
        while (!lStack.isEmpty()) {
            rStack.push(lStack.pop());
        }
        int val = rStack.peek();
        while (!rStack.isEmpty()) {
            lStack.push(rStack.pop());
        }
        return val;
    }

    public boolean isEmpty() {
        return lStack.isEmpty();
    }

    public static void test() {
        int SIZE = 10;
        int []arr = new int[10];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (int)(Math.random() * 100000)  % SIZE;
        }
        for (int i: arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
        StackToQueue stackToQueue = new StackToQueue();
        for (int i: arr) {
            stackToQueue.add(i);
            System.out.print(stackToQueue.peek() + "\t");
        }
        System.out.println();
        while (!stackToQueue.isEmpty()) {
            System.out.print(stackToQueue.poll() + "\t");
        }
        System.out.println("\n------------------------------");
    }

    public static void main(String []args) {
        for (int i = 0; i < 100; i++) {
            test();
        }
    }
}
