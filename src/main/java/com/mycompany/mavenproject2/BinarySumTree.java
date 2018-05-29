package com.mycompany.mavenproject2;

public class BinarySumTree {

    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    Node root;

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.data) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.data) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }

        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.data) {
            return true;
        }
        return value < current.data
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean isLeafNode(Node node) {
        return node.left == null && node.right == null;
    }

    private boolean isBST(Node node) {

        if (node == null || isLeafNode(node)) {
            return true;
        }
        if (isBST(node.left) && isBST(node.right)) {
            int left = (node.left == null) ? 0 : (isLeafNode(node.left)) ? node.left.data : 2 * node.left.data;
            int right = (node.right == null) ? 0 : (isLeafNode(node.right)) ? node.right.data : 2 * node.right.data;
            return node.data == left + right;
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySumTree tree = new BinarySumTree();
        Node node = new Node(26);
        node.left = new Node(10);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(6);
        node.right.right = new Node(3);

        System.out.println(tree.isBST(node));

    }
}
