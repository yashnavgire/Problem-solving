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
    public TreeNode first = null;
    public TreeNode sec = null;
    public TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inorder(root);
        System.out.println(first.val + " " + sec.val);
        int temp = first.val;
        first.val = sec.val;
        sec.val = temp;
        return;
    }
    
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inorder(root.left);
        
        if (first == null &&  prev.val > root.val) {
            first = prev;
        }
        
        if (first != null && prev.val > root.val) {
            sec = root;
        }
        
        prev = root;
        inorder(root.right);
    }
}
