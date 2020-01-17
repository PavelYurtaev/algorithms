package edu.algorithms.stack;


import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public class LockFreeStack<T> {
    private final AtomicReference<Node<T>> top = new AtomicReference<>();

    public void push(T value) {
        Node<T> newTop = new Node<>(value);

        while (true) {
            Node<T> currentTop = top.get();
            newTop.next = currentTop;
            if (top.compareAndSet(currentTop, newTop)) {
                break;
            } else {
                LockSupport.parkNanos(1);
            }
        }
    }

    public T pop() {
        Node<T> currentTop = top.get();
        Node<T> newTop;

        while (currentTop != null) {
            newTop = currentTop.next;
            if (top.compareAndSet(currentTop, newTop)) {
                break;
            } else {
                LockSupport.parkNanos(1);
                currentTop = top.get();
            }
        }
        return currentTop != null ? currentTop.value : null;
    }

    private class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }
}
