package edu.algorithms.queue;

public class LinkedListBasedQueue {
    private Node front;
    private Node rear;

    public void add(int key) {
        final Node newNode = new Node(key);

        if (rear == null) {
            front = newNode;
            rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public Node remove() {
        if (front == null)
            return null;

        final Node temp = front;
        front = front.next;

        if (front == null)
            rear = null;
        return temp;
    }

    private class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }
}
