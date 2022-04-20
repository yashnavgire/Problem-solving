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
class BSTIterator {
    TreeNode start = null;
    TreeNode begin = start;
    int itr;
    List<TreeNode> list;

    public BSTIterator(TreeNode root) {
        start = new TreeNode(Integer.MIN_VALUE);
        begin = start;
        itr = 0;
        list = new ArrayList<>();
        inorder(root, list);
        //func(begin);
        //begin = begin.right;
    }
    
    public int next() {
        int val = -1;
        if (itr < list.size()) {
            val = list.get(itr).val;
            itr++;  
        }
        return val;
    }
    
    public boolean hasNext() {
        if (itr < list.size()) {
            return true;
        }
        
        return false;
    }
    
//     private void func(TreeNode start) {
//         if (start == null) {
//             return;
//         }
        
//         //func(start.left);
//         System.out.println(start.val);
//         func(start.right);
//     }
    
    private void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
