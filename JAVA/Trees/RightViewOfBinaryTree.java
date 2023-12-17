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

    class Tuple {
        
        int level;
        TreeNode node;

        Tuple(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        Queue<Tuple> q = new LinkedList<>();

        if (root != null) {
            q.offer(new Tuple(root, 0));
        }

        while (!q.isEmpty()) {
            
            int size = q.size();

            for (int i = 0; i < size; i++) {

                Tuple t = q.poll();
                int level = t.level;
                TreeNode node = t.node;
                
                map.put(level, node);

                if (node.left != null) {
                    q.offer(new Tuple(node.left, level + 1));
                }

                if (node.right != null) {
                    q.offer(new Tuple(node.right, level + 1));
                }
            }
        }

        for (Map.Entry<Integer, TreeNode> e : map.entrySet()) {
            list.add(e.getValue().val);
        }

        return list;
    }
}
