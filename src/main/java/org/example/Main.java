package org.example;
// DLLNode class represents a node in a doubly linked list
class DLLNode {
    int data; // Value stored in the node
    DLLNode prev; // Pointer to the previous node
    DLLNode next; // Pointer to the next node

    // Constructor to initialize a node with data
    public DLLNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

// DoublyLinkedList class represents a doubly linked list
class DoublyLinkedList {
    DLLNode head; // Head node of the list

    // Constructor to initialize the list with a head node
    public DoublyLinkedList(DLLNode head) {
        this.head = head;
    }

    // Method to add a node with given data at the end of the list
    public void addToEnd(int data) {
        DLLNode n = new DLLNode(data);

        if (head == null) { // If the list is empty, create a new head
            head = n;
        } else {
            DLLNode current = head;
            while (current.next != null) { // Traverse to the last node
                current = current.next;
            }
            current.next = n; // Append new node at the end
            n.prev = current;
        }
    }

    // Method to add a node with given data at the beginning of the list
    public void addNodeToStart(int data) {
        DLLNode n = new DLLNode(data);
        if (head == null) { // If the list is empty, create a new head
            head = n;
            return;
        }
        n.next = head; // Point new node to current head
        head.prev = n;
        head = n; // Update head to the new node
    }

    // Method to add a node with given data after a specific node
    public void addNodeAfter(int data, int search) {
        DLLNode n = new DLLNode(data);
        DLLNode temp = this.head;
        while (temp != null) { // Traverse to find the node with search value
            if (temp.data == search) {
                if (temp.next != null) {
                    temp.next.prev = n;
                    n.next = temp.next;
                }
                temp.next = n;
                n.prev = temp;
                return;
            }
            temp = temp.next;
        }
    }

    // Method to delete the last node of the list
    public void deleteLast() {
        DLLNode toDelete = head;
        if (head == null || head.next == null) { // If the list is empty or has only one node
            head = null;
            return;
        }
        while (toDelete.next != null) { // Traverse to the last node
            toDelete = toDelete.next;
        }
        toDelete.prev.next = null; // Remove last node
    }

    // Method to delete the first node of the list
    public void deleteStart() {
        if (head == null || head.next == null) { // If the list is empty or has only one node
            head = null;
            return;
        }
        head = head.next; // Update head
        head.prev = null;
    }

    // Method to delete the node after a node with specific data
    public void deleteAfter(int data) {
        DLLNode toDelete = head;
        while (toDelete != null) { // Traverse to find the node with given data
            if (toDelete.data == data) {
                toDelete = toDelete.next;
                break;
            }
        }
        if (toDelete != null) { // If the node to delete is found
            if (toDelete.next != null) {
                toDelete.next.prev = toDelete.prev;
            }
            toDelete.prev.next = toDelete.next;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList(null);

        // Adding nodes to the list
        list.addToEnd(10);
        list.addToEnd(20);
        list.addToEnd(30);
        System.out.println("List after adding 10, 20, 30:");
        printList(list);

        // Adding a node at the start
        list.addNodeToStart(5);
        System.out.println("List after adding 5 to start:");
        printList(list);

        // Adding a node after a specific value
        list.addNodeAfter(25, 20);
        System.out.println("List after adding 25 after 20:");
        printList(list);

        // Deleting the last node
        list.deleteLast();
        System.out.println("List after deleting last node:");
        printList(list);

        // Deleting the first node
        list.deleteStart();
        System.out.println("List after deleting start node:");
        printList(list);

        // Deleting a node after a specific value
        list.deleteAfter(10);
        System.out.println("List after deleting node after 10:");
        printList(list);
    }

    // Method to print the linked list
    public static void printList(DoublyLinkedList list) {
        DLLNode current = list.head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");    }
}