package problems;

import java.util.HashMap;

public class Problem0146_LRUCache {
    public class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> cache;
    Node left; // least recently used
    Node right; // most recently used
    
    public Problem0146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(); // maps key to node (pointer to node more specifically)
        //left = LRU, right = MRU (or technically a pointer to the LRU and MRU nodes)
        this.left = new Node(0, 0);
        this.right = new Node(0,0);
        this.right.next = left;
        this.left.prev = right; // create a doubly linked list; need to have left and right connected to do so
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        // pretty self-explanatory in my estimation
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;

    }
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            // In addition to returning the node's value, we need to update it to 
            // be the most recently used; this achieves that.
            remove(node);
            insert(node);
            // Now we return the value
            return node.val;
        }
        return -1; // If the key isn't found 
    }

    public void put(int key, int value) {
        // remove old k-v before inserting the new k-v if it's the same key
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        // If exceeding cache capacity evict the LRU node
        if (cache.size() > capacity) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key); // remove the least recently used node from the cache
        }
        
    }
}
