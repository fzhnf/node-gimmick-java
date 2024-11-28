package org.example;

public class Node {
    private String key;
    private ValueFunction valueFunction;

    // Constructor
    public Node(String key, ValueFunction valueFunction) {
        this.key = key;
        this.valueFunction = valueFunction;
    }

    // Getter for the key
    public String getKey() {
        return key;
    }

    // Getter for the value that directly calls the function with the key
    public Object getValue() {
        return valueFunction.apply(key); // Execute the function with the key
    }

    // Interface representing a function that takes a key and returns either String
    // or void (null)
    @FunctionalInterface
    public interface ValueFunction {
        Object apply(String key); // Returns either String or null (to represent void)
    }
}
