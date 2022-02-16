// Problem Link :- https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        int i = 0, size = 0;
        TreeNode top = null;
        
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        
        if (root == null) {
            return list;
        }
        
        q.add(root);
        
        while (!q.isEmpty()) {
            size = q.size();
            List<Integer> tempList = new ArrayList<>(); 
            
            for (i = 1; i <= size; i++) {
                top = q.poll();
                
                tempList.add(top.val);
                
                if (top.left != null) {
                    q.offer(top.left);
                }
                
                if (top.right != null) {
                    q.offer(top.right);
                }
            }
            
            list.add(tempList);
        }
        
        return list;
        
    }
}
