// Problem Link :- https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1

class Solution
{
    //Function to connect nodes at same level.
    public void connect(Node root) {
        if (root == null ){
            return;
        }
        
        int i = 0, size = 0;
        Queue<Node> q = new LinkedList<>();
        
        q.offer(root);
        
        while (!q.isEmpty()) {
            List<Node> list = new ArrayList<>();
            size = q.size();
            
            for (i = 1; i <= size; i++) {
                Node top = q.poll();
                
                if (top.left != null) {
                    q.offer(top.left);
                }
                
                if (top.right != null) {
                    q.offer(top.right);
                }
            
                list.add(top);
            }
            
            i = 0;
            
            for (i = 0; i < list.size()-1; i++) {
                list.get(i).nextRight = list.get(i+1);
            }
            
            list.get(i).nextRight = null;
            
            
        }
        
        return;
    }
}
