public class Solution
{
    //Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        return solve(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    boolean solve(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        
        if (root.data < min || root.data > max) {
            return false;
        }
        
        return true && solve(root.left, min, root.data - 1) && solve(root.right, root.data + 1, max);
    }
}
