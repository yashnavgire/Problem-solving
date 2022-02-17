// Problem Link :- https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1/

class TreeNode {
    Node node = null;
    int hd = 0;
    
    TreeNode(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root) {
        int i = 0, hd = 0, size = 0;
        TreeMap<Integer, Node> map = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        if (root == null) {
            return list;
        }
        
        q.offer(new TreeNode(root, 0));
        
        while (!q.isEmpty()) {
            size = q.size();
            
            for (i = 1; i <= size; i++) {
                TreeNode top = q.poll();
                Node node = top.node;
                hd = top.hd;
                
                if (!map.containsKey(hd)) {
                    map.put(hd, node);
                }
                else {
                    map.put(hd, node);
                }
                
                if (node.left != null) {
                    q.offer(new TreeNode(node.left, hd-1));
                }
                
                if (node.right != null) {
                    q.offer(new TreeNode(node.right, hd+1));
                }
            }
        }
        
        for (Map.Entry<Integer, Node> e : map.entrySet()) {
            list.add(e.getValue().data);
        }
        
        return list;
        
    }
}
