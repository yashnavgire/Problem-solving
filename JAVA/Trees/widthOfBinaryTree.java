// Problem Link :- https://leetcode.com/problems/maximum-width-of-binary-tree/submissions/

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

class Pair {
    TreeNode node;
    int id;
    
    Pair(TreeNode node, int id) {
        this.node = node;
        this.id = id;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int i = 0, size = 0, width = 0, max = 0, depth = 0;
        Queue<Pair> q = new LinkedList<>();
        
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            size = q.size();
            int first = 0, last = 0, min = 0;
            min = q.peek().id;
           
            for (i = 1; i <= size; i++) {
                int currID = q.peek().id - min;
                TreeNode top = q.peek().node;
                q.poll();
                
                if (i == 0) {
                    first = currID;
                }
                else if (i == size) {
                    last = currID;
                }
                
                if (top.left != null) {
                    q.offer(new Pair(top.left, 2*currID + 1));
                }
                
                if (top.right != null) {
                    q.offer(new Pair(top.right, 2*currID + 2));
                }
            }

            max = Math.max(max, last-first+1);
        }
        
        return max;
    }
}
