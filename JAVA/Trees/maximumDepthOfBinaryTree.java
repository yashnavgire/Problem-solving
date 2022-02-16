// Problem Link :- https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        int i = 0, size = 0, depth = 0;
        TreeNode top = null;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        if (root == null) {
            return 0;
        }
        
        q.add(root);
        
        while (!q.isEmpty()) {
            size = q.size();
            depth++; 
            
            for (i = 1; i <= size; i++) {
                top = q.poll();
                
                if (top.left != null) {
                    q.offer(top.left);
                }
                
                if (top.right != null) {
                    q.offer(top.right);
                }
            }
        }
        
        return depth;
        
    }
}
