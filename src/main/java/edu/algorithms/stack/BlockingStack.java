package edu.algorithms.stack;

public class BlockingStack<T> {

    private Node<T> top;

    public synchronized void push(T value) {
        top = new Node<>(value, top);
    }

    public synchronized T pop() {
        if (top == null) {
            return null;
        }
        T value = top.value;
        top = top.belowNode;
        return value;
    }

    private String printCurrentNode(final Node<T> node, final StringBuilder builder) {
        if (node == null) {
            return "[]";
        }
        builder.append(node.value);
        return node.belowNode != null
                ? printCurrentNode(node.belowNode, builder.append(","))
                : builder.append("]").toString();
    }

    private static class Node<T> {
        private final T value;
        private final Node<T> belowNode;

        Node(T value, Node<T> belowNode) {
            this.value = value;
            this.belowNode = belowNode;
        }
    }

    @Override
    public String toString() {
        return printCurrentNode(this.top, new StringBuilder().append("top -> ["));
    }
}

