package com.mycompany.mavenproject2;

import java.util.HashMap;

class LRUCache {

    class Node {

        Integer key;
        Integer value;
        Node pre;
        Node post;

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        Node() {
        }
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(Node node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(Node node) {
        Node pre = node.pre;
        Node post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

// pop the current tail. 
    private Node popTail() {
        Node res = tail.pre;
        removeNode(res);
        return res;
    }

    private Integer count;
    private final Integer capacity;
    private final Node head = new Node();
    private final Node tail = new Node();
    private final HashMap<Integer, Node> cache = new HashMap<>();

    public LRUCache(Integer capacity) {
        count = 0;
        this.capacity = capacity;

        head.post = tail;
        tail.pre = head;
    }

    public Integer get(Integer key) {

        Node node = cache.get(key);
        if (node == null) {
            return -1; // should raise exception here.
        }

        // move the accessed node to the head;
        moveToHead(node);
        return node.value;
    }

    public void set(Integer key, Integer value) {
        Node node = cache.get(key);

        if (node == null) {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            ++count;
            evict();
        } else {
            // update the value.
            node.value = value;
            moveToHead(node);
        }

    }

    private void evict() {
        if (count > capacity) {
            // pop the tail
            Node tail = popTail();
            cache.remove(tail.key);
            --count;
        }
    }

}
