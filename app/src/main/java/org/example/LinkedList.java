package org.example;

public class LinkedList {
	private Node head; // The first node in the list

	// Constructor to initialize the LinkedList (empty initially)
	public LinkedList() {
		this.head = null;
	}

	public void insert(String key, String value) {
		Node.ValueFunction valueFunction = (keyValue) -> value; // Create a function that returns the provided string
		insert(key, valueFunction); // Insert the new node
	}

	// Insert a new node at the end of the LinkedList
	public void insert(String key, Node.ValueFunction valueFunction) {
		Node newNode = new Node(key, valueFunction);

		if (head == null) {
			head = newNode; // If the list is empty, the new node becomes the head
		} else {
			Node current = head;
			while (current.getNext() != null) {
				current = current.getNext(); // Traverse to the last node
			}
			current.setNext(newNode); // Insert the new node at the end
		}
	}

	// Traverse the LinkedList and print each node's value
	public void traverse() {
		Node current = head;
		while (current != null) {
			Object result = current.getValue();
			if (result != null) {
				System.out.println(result); // Print if the value is not null (i.e., not a void
				// function)
			}
			current = current.getNext(); // Move to the next node
		}
	}

	public Node search(String key) {
		Node current = head;
		Node result = searchRec(key, current);
		if (result == null) {
			System.out.println("Key not found");
		}
		return result;
	}

	private Node searchRec(String key, Node current) {
		if (current == null) {
			return null;
		} else if (current.getKey().equals(key)) {
			return current;
		}
		return searchRec(key, current.getNext());
	}
}

// vim: set ts=4 sw=4 tw=0 noet :
