class Pair {
    int dist;
    Node node;
    
    public Pair(Node node, int dist) {
        this.dist = dist;
        this.node = node;
    }
}

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        int i = 0, j = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        q.offer(new Pair(root, 0));
        
        while (!q.isEmpty()) {
            Pair top = q.poll();
            Node node = top.node;
            int dist = top.dist;
            
            if (!map.containsKey(dist)) {
                map.put(dist, node.data);
            }
            
            if (node.left != null) {
                q.offer(new Pair(node.left, dist - 1));
            }
            
            if (node.right != null) {
                q.offer(new Pair(node.right, dist + 1));
            }
        }
        
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int level = e.getKey();
            list.add(e.getValue());
        }
        
        return list;
    }
}
