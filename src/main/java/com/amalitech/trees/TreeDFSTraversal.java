package com.amalitech.trees;

public class TreeDFSTraversal {

    private Node root;
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        Node(int value) {

            this.value = value;
        }
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        Node node = new Node(value);
        Node current = root;

        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public void insertRec(int value) {
        root = insert(root, value);
    }

    // Root -> Left -> Right
    public void preOrder(Node root){
        if (root == null) return;
        System.out.println(root.value);

        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

    // Left -> Root -> Right
    public void inOrder(Node root ){
        if (root == null) return;

        inOrder(root.leftChild);
        System.out.println(root.value);
        inOrder(root.rightChild);
    }

    // Left -> Right -> Root
    public void postOrder(Node root){
        if (root == null) return;

        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.println(root.value);
    }

    public static int findHeight(Node root){
        if (root == null) return 0;

        int left = findHeight(root.leftChild);
        int right = findHeight(root.rightChild);

        return Math.max(left + 1, right + 1);
    }



    private Node insert(Node node, int value) {
        if (node == null)
            return new Node(value);

        if (value < node.value)
            node.leftChild = insert(node.leftChild, value);
        else if (value > node.value)
            node.rightChild = insert(node.rightChild, value);

        return node;
    }

    public static void main(String args[]){
        TreeDFSTraversal tree = new TreeDFSTraversal();
        tree.insert(10);
        tree.insertRec(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(22);
        tree.insert(33);
        tree.insert(44);
        tree.insert(4);

        // System.out.println("InOrder");
        // tree.inOrder(tree.root);

        // System.out.println("PreOrder");
        // tree.preOrder(tree.root);

        // System.out.println("PostOrder");
        // tree.postOrder(tree.root);

        System.out.println(TreeDFSTraversal.findHeight(tree.root));

    }

}

