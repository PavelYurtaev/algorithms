package edu.algorithms.queue;

public class ArrayBasedQueue {
    private int maxSize;
    private long[] queueArray;
    private int front;
    private int rear;
    private int length;

    public ArrayBasedQueue(int capacity) {
        this.maxSize = capacity;
        this.queueArray = new long[maxSize];
        this.front = 0;
        this.rear = -1;
        this.length = 0;
    }

    public void insert(long item) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queueArray[++rear] = item;
        ++length;
    }

    public long remove() {
        long item = queueArray[front++];
        if (front == maxSize) {
            front = 0;
        }

        --length;
        return item;
    }

    public long peekFront() {
        return queueArray[front];
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == maxSize;
    }

    public int size() {
        return length;
    }
}
