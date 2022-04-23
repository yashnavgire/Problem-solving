class Node {
    Node prev;
    Node next;
    int val;
    int key;
    
    public Node(int key, int val) {
        this.val = val;
        this.key = key;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node add = map.get(key);
            remove(add);
            insert(add);
            return add.val;
        }
        else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        } else if (map.size() == this.capacity) {
            remove(this.tail.prev);
        }
        
        insert(new Node(key, value));
        
        return;
    }
    
    private void remove(Node node) {
        map.remove(node.key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
        return;
    }
    
    private void insert(Node node) {
        map.put(node.key, node);
        node.next = this.head.next;
        this.head.next.prev = node;
        node.prev = this.head;
        this.head.next = node;
        return;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
