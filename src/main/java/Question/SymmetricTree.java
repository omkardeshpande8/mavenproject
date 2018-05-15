package Question;

public class SymmetricTree {

    static class Node {

        int data;
        Node left;
        Node right;

        private Node(int i) {
            this.data = i;
        }
    }

    private static boolean isSymmetric(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 != null && node1.data == node2.data) {
            return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
        }
        return false;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(2);
        node.left.left = new Node(3);
        node.left.right = new Node(4);
        node.right.left = new Node(4);
//        node.right.right = new Node(3);
        boolean output = isSymmetric(node,node);
        System.out.println(output);
    }

}
