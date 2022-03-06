// Problem Link :- https://leetcode.com/problems/sum-root-to-leaf-numbers/submissions/

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
    public int sumNumbers(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[1];
        
        solve(root, "", arr);
        
        return arr[0];
    }
    
    public void solve(TreeNode root, String s, int[] arr) {
        if (root == null) {
            return;
        }
        
        int value = root.val;
        
        if (root.left == null && root.right == null) {
            
            int val = Integer.parseInt(s + Integer.toString(value));
            arr[0] = arr[0] + val;
        }
        
        solve(root.left, s + Integer.toString(value), arr);
        solve(root.right, s + Integer.toString(value), arr);
    }
}
