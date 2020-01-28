package edu.algorithms.stack;

public class ArrayBasedStack {

    private final long[] stackArray;
    private int top;

    public ArrayBasedStack(int capacity) {
        this.stackArray = new long[capacity];
        this.top = -1;
    }

    public void push(long item) {
        this.stackArray[++this.top] = item;
    }

    public long pop() {
        return this.stackArray[this.top--];
    }

    public long peek() {
        return this.stackArray[this.top];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == this.stackArray.length - 1;
    }
}
