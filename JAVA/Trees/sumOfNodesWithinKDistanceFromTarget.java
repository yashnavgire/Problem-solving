class solver{
    static int sum_at_distK(Node root, int target, int k){
        int i = 0, size = 0, ans = 0;
        Queue<Node> q = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        Map<Node, Node> map = new HashMap<>();
        map.put(root, null);
        Node reqNode = null;
        
        q.offer(root);
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.data == target) {
                reqNode = curr;
            }
            
            if (curr.left != null) {
                q.offer(curr.left);
                map.put(curr.left, curr);
            }
            
            if (curr.right != null) {
                q.offer(curr.right);
                map.put(curr.right, curr);
            }
        }
        
        // System.out.println(reqNode.data);
        q.offer(reqNode);
        set.add(reqNode);
        int count = 0;
        
        while (!q.isEmpty()) {
            if (count > k) {
                break;
            }
            
            size = q.size();
            
            for (int j = 1; j <= size; j++) {
                Node curr = q.poll();
                
                // System.out.println(curr.data);
                ans += curr.data;
                
                if (curr.left != null && set.add(curr.left)) {
                    q.offer(curr.left);
                }
                
                if (curr.right != null && set.add(curr.right)) {
                    q.offer(curr.right);
                }
                
                if (map.get(curr) != null && set.add(map.get(curr))) {
                    q.offer(map.get(curr));
                }
            }
            
            count++;
        }
        
        return ans;
    }
}
