/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        List<Integer> in = new ArrayList<>();

        traverse(pre, post, in, root);

        list.add(in);
        list.add(pre);
        list.add(post);

        return list;
    }

    public static void traverse(List<Integer> pre, List<Integer> post, 
    List<Integer> in, TreeNode root) {
        
        if (root == null) {
            return;
        }

        pre.add(root.data);
        traverse(pre, post, in, root.left);

        in.add(root.data);
        traverse(pre, post, in, root.right);

        post.add(root.data);
    }
}
