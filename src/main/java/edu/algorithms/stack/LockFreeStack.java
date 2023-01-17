package edu.algorithms.stack;


import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public class LockFreeStack<T> {
    private final AtomicReference<Node<T>> top = new AtomicReference<>();

    public void push(T value) {
        Node<T> newTop = new Node<>(value);

        while (true) {
            Node<T> currentTop = top.get();
            newTop.belowNode = currentTop;
            if (top.compareAndSet(currentTop, newTop)) {
                System.out.println("compared and set");
                break;
            } else {
                System.out.println("parkNanos");
                LockSupport.parkNanos(1);
            }
        }
    }

    public T pop() {
        Node<T> currentTop = top.get();
        Node<T> newTop;

        while (currentTop != null) {
            newTop = currentTop.belowNode;
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
        Node<T> belowNode;

        Node(T value) {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        return printCurrentNode(top.get(), new StringBuilder().append("top -> ["));
    }

    private String printCurrentNode(final Node<T> node, final StringBuilder builder) {
        if (node == null) {
            return "[]";
        }
        builder.append(node.value);
        return node.belowNode != null
                ? printCurrentNode(node.belowNode, builder.append(" | "))
                : builder.append("]").toString();
    }

}
