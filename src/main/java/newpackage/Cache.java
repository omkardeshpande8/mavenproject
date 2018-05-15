package newpackage;

import java.util.HashMap;

public class Cache {

    class Node {

        Integer key;
        Integer value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }

    int capacity;
    int count = 0;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = new Node();
    Node tail = new Node();

    public Cache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
    }

    private void evict() {
        if (count > capacity) {
            Node node = tail.prev;
            removeNode(node);
            map.remove(node.key);
            count--;
        }
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public Integer get(Integer key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void set(Integer key, Integer value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToHead(node);
        } else {
            Node node = new Node(key, value);
            addToHead(node);
            map.put(key, node);
            count++;
            evict();
        }
    }
}