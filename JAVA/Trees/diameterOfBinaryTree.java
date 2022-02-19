// Problem Link :- https://leetcode.com/problems/diameter-of-binary-tree/submissions/

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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] arr = new int[1];
        
        solve(root, arr);
        
        return arr[0];
    }
    
    public int solve(TreeNode root, int[] arr) {
         if (root == null) {
            return 0;
        }
        
        int left = height(root.left);
        int right = height(root.right);
        
        arr[0] = Math.max(arr[0], left+right);
        
        solve(root.left, arr);
        solve(root.right, arr);
        
        
        return arr[0];
        
    }
    
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
