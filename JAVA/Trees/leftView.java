// Problem Link :- https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1

class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        int i = 0, size = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        
        if (root == null) {
            return list;
        }
        
        q.offer(root);
        
        while (!q.isEmpty()) {
            size = q.size();
            
            for (i = 1; i <= size; i++) {
                Node top = q.poll();
                
                if (i == 1) {
                    list.add(top.data);
                }
                
                if (top.left != null) {
                    q.add(top.left);
                }
                
                if (top.right != null) {
                    q.add(top.right);
                }
            }
        }
        
        return list;
      
    }
}
