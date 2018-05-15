package newpackage;

import java.util.HashMap;

class Node{
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {

    int capacity;
    HashMap<Integer,Node> map = new HashMap<>();
    Node head = null;
    Node tail = null;
    
    public int get(int key){
        int value = -1;
        if(map.containsKey(key)){
            Node node = map.get(key);
            value = node.value;
            remove(node);
            insert(node);
        }
        return value;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            insert(n);
        }else{
            Node nn = new Node(key,value);
            if(map.size() == capacity){
                remove(tail);
                map.remove(tail.key);
            } 
            insert(nn);
            map.put(key, nn);
        }
    }
    
    private void remove(Node n){
        if(n.prev != null){
            n.prev.next = n.next;
        } else {
            head = n.next;
        }
        
        if(n.next != null){
            n.next.prev = n.prev;
        }else {
            tail = n.prev;
        }
    }
    
    private void insert(Node n){
        n.next = head;
        n.prev = null;
        head = n;
        
        if(head != null)
            head.prev = n;
        
        if(tail == null)
            tail = head;
    }
}

//class Driver{
//    public static void main(String[] args) {
//        
//    }
//}
