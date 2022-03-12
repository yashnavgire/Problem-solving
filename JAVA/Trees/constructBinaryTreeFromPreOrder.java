// Problem Link :- https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/submissions/

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
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> st = new Stack<>();
        
        if (preorder.length == 0 || preorder == null) {
            return null;
        }
        
        TreeNode newNode = new TreeNode(preorder[0]);
        st.push(newNode);
        
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            
            if (st.peek().val > node.val) {
                st.peek().left = node;
                st.push(node);
            }
            else {
                TreeNode parent = st.peek();
                
                while (!st.isEmpty() && st.peek().val < node.val) {
                    parent = st.pop();
                }
                
                parent.right = node;
                st.push(node);
            } 
        }
        
        return newNode;
    }
}
