import java.util.*;

class LRUCache {
    Map<Integer, Node> map;
    int capacity, size = 0;
    Node head, tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        linkNodes(head, tail);
    }
    
    public int get(int key) {
        Node val = map.get(key);
        if(val == null) return -1;
        
        moveToHead(val);
        //printNode();
        return val.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        }
    
        else {
            Node node = new Node(key, value);
            if(size >= capacity) {
                Node tmp = removeLast();
                map.remove(tmp.key);
                size--;
            }
            
            add(node);
            map.put(key, node);
            size++;
        }
        
        //printNode();
    }
    
    public void add(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    public void linkNodes(Node n1, Node n2) {
        n1.next = n2;
        n2.prev = n1;
    }
    
    public Node removeLast() {
        Node tmp = tail.prev;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        return tmp;
    }
    
    public void moveToHead(Node node) {
        Node prevNode = node.prev, nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    public class Node {
        int key, value;
        Node prev, next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
        
        public Node() {
            this.key = -1;
            this.value = -1;
            prev = null;
            next = null;
        }
    }
    
    public void printNode() {
        Node n = head.next;
        
        while(n.value != -1) {
            System.out.print(n.value + " ");
            n = n.next;
        }
        System.out.println();
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */