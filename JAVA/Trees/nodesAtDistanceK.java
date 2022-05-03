class Solution
{
    private boolean check(Node root, int k) {
        if (root == null || k < 0) {
            return false;
        }    
        
        if (root.left == null && root.right == null && k == 0) {
            return true;
        }
        
        return check(root.left, k - 1) || check(root.right, k - 1);
    }
    
    private void inorder(Node root, int k, int[] ans) {
        if (root == null) {
            return;
        }
        
        inorder(root.left, k, ans);
        
        if (check(root, k)) {
            ans[0]++;
        }
        
        inorder(root.right, k, ans);
    }
    
    int printKDistantfromLeaf(Node root, int k) {
        int[] ans = new int[1];
        inorder(root, k, ans);
        
        return ans[0];
    }

}
