package org.example;

public class Node {
    public String key;
    private ValueFunction value;
    private Node next;

    public Node(String key, ValueFunction valueFunction) {
        this.key = key;
        this.value = valueFunction;
        this.next = null;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value.apply(key);
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @FunctionalInterface
    public interface ValueFunction {
        Object apply(String key);
    }
}
