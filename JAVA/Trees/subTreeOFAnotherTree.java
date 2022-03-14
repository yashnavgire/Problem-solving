// Problem Link :- https://leetcode.com/problems/subtree-of-another-tree/submissions/

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        }
        
        if (isSameTree(root, subRoot)) {
            return true;
        }
        
        // This is done since we have multiple similar nodes on the parent and child then every node we
        // will need to validate
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        
        if (root1 == null || root2 == null) {
            return false;
        }
        
        return (root1.val == root2.val)
            && isSameTree(root1.left, root2.left) 
            && isSameTree(root1.right, root2.right);
    }
}
