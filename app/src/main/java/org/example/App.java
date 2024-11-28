package org.example;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        // helloWorld function that returns a String
        Node.ValueFunction helloWorld = (key) -> {
            return "Hello, World!"; // Return String
        };

        // randomNumber function that returns a String
        Node.ValueFunction randomNumber = (key) -> {
            return String.valueOf((int) (Math.random() * key.length())); // Return a random number as String
        };

        // bukaBrowser function that returns null (void behavior)
        Node.ValueFunction bukaBrowser = (key) -> {
            String os = System.getProperty("os.name").toLowerCase();
            String url = "https://musaki.pages.dev";
            try {
                if (os.contains("linux")) {
                    Runtime.getRuntime().exec("xdg-open " + url);
                } else if (os.contains("win")) {
                    Runtime.getRuntime().exec("start " + url);
                } else if (os.contains("mac")) {
                    Runtime.getRuntime().exec("open " + url);
                }
            } catch (IOException e) {
                System.out.println("Error opening the browser: " + e.getMessage());
            }

            return null; // Return null for void behavior
        };

        // Create Node instances
        Node node1 = new Node("hello", helloWorld);
        Node node2 = new Node("User2", randomNumber);
        Node node3 = new Node("User3", bukaBrowser);

        // Call the functions directly through getValue() and handle return types
        Object result1 = node1.getValue();
        if (result1 != null) {
            System.out.println(result1); // Output: Hello, World!
        }

        Object result2 = node2.getValue();
        if (result2 != null) {
            System.out.println(result2); // Output: Random number
        }

        Object result3 = node3.getValue();
        if (result3 != null) {
            System.out.println(result3); // This will not be printed because it's null (void behavior)
        }
    }
}
