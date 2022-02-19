// Problem Link :- https://leetcode.com/problems/binary-tree-preorder-traversal/submissions/

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
    public List<Integer> preorderTraversal(TreeNode root) {
    
        int i = 0, j = 0;
        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        
        if (root == null) {
            return list;
        }
        
        st.push(root);
        
        while (!st.isEmpty()) {
            TreeNode top = st.pop();
            list.add(top.val);
            
            if (top.right != null) {
                st.push(top.right);
            }
            
            if (top.left != null) {
                st.push(top.left);
            }
        }
        
        return list;
        
    }
}
