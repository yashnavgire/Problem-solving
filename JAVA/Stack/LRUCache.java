// Problem Link :- https://leetcode.com/problems/lru-cache/submissions/

class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    
    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                //System.out.println("Executing!!!" + " " + size() + " " + capacity);
                return (size() > capacity) ? true : false;
            }
        };    
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            System.out.println(key);
            return map.get(key);
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
