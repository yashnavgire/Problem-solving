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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode[] ans = new TreeNode[1];
        traverse(root, ans, val);
        //System.out.println("Ans : " + ans.val);

        return ans[0];
    }

    public void traverse(TreeNode root, TreeNode[] ans, int val) {
        if (root == null) {
            return;
        }

        if (val < root.val) {
            traverse(root.left, ans, val);
        } else if (val > root.val) {
            traverse(root.right, ans, val);
        } else if (val == root.val) {
            ans[0] = root;
            //System.out.println("Coming" + ans.val);
            return;
        }

        return;
    }
}
