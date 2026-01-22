package com.amalitech.trees;


import java.util.*;

class Node {
    int value;
    Node leftChild, rightChild;
    Node(int v) { this.value = v; }
}

public class ZigzagLevels {

    public List<List<Integer>> zigzag(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(root);
        boolean leftToRight = true;

        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> level = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {

                if (leftToRight) {
                    // Pop from the front
                    Node node = dq.pollFirst();
                    level.add(node.value);

                    // Children normal order
                    if (node.leftChild != null) dq.offerLast(node.leftChild);
                    if (node.rightChild != null) dq.offerLast(node.rightChild);

                } else {
                    // Pop from the back
                    Node node = dq.pollLast();
                    level.add(node.value);

                    // Children reversed order
                    if (node.rightChild != null) dq.offerFirst(node.rightChild);
                    if (node.leftChild != null) dq.offerFirst(node.leftChild);
                }
            }

            result.add(level);
            leftToRight = !leftToRight;   // flip direction
        }

        return result;
    }

    // Demo
    public static void main(String[] args) {
        /*
                3
               / \
              9   20
                 /  \
                15   7
        */
        Node root = new Node(3);
        root.leftChild = new Node(9);
        root.rightChild = new Node(20);
        root.rightChild.leftChild = new Node(15);
        root.rightChild.rightChild = new Node(7);

        ZigzagLevels z = new ZigzagLevels();
        System.out.println(z.zigzag(root));
        // Output: [[3], [20, 9], [15, 7]]
    }
}
