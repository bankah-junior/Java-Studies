package com.amalitech.trees;

public class LinkRotationByK {
    class Node {
        int value;
        Node next;
        Node(int v) { this.value = v; }
    }

    public Node rotate(Node head, int k) {
        if (head == null || k <= 0) return head;

        // Compute the length and get the tail
        Node tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Make it circular
        tail.next = head;

        // Find the new tail: (length - k % length - 1)th node
        // and the new head: (length - k % length)th node
        k = k % length;
        int stepsToNewHead = length - k;
        Node newTail = tail;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }
        Node newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        LinkRotationByK list = new LinkRotationByK();
        Node head = list.new Node(1);
        head.next = list.new Node(2);
        head.next.next = list.new Node(3);
        head.next.next.next = list.new Node(4);
        head.next.next.next.next = list.new Node(5);

        int k = 7;
        Node newHead = list.rotate(head, k);

        // Print rotated list
        Node current = newHead;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }
}
