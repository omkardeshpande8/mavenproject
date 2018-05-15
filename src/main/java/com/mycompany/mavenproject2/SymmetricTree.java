package com.mycompany.mavenproject2;

public class SymmetricTree {

    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    private boolean isMirror(Node node1, Node node2) {

        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 != null && node1.data == node2.data) {
            return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
        }
        return false;
    }

    private boolean isSymmetric(Node node) {
        return isMirror(node, node);
    }

    public static void main(String[] args) {
        SymmetricTree tree = new SymmetricTree();
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(2);
        node.left.left = new Node(3);
        node.left.right = new Node(4);
        node.right.left = new Node(4);
        node.right.right = new Node(3);
        boolean output = tree.isSymmetric(node);
        System.out.println(output);
    }

}
