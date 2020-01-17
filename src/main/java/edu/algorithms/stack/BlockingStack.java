package edu.algorithms.stack;

public class BlockingStack<T> {

    private Node<T> top;

    public synchronized void push(T value) {
        top = new Node<>(value, top.next);
    }

    public synchronized T pop() {
        if (top == null) {
            return null;
        }
        T value = top.value;
        top = top.next;
        return value;
    }

    private class Node<T> {
        private T value;
        private Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}

