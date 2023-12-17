/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        if (root != null) {
            q.offer(root);
        }

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> sub = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node top = q.poll();
                List<Node> child = top.children;

                for (int j = 0; j < child.size(); j++) {
                    Node node = child.get(j);

                    if (node != null) {
                        q.add(node);
                    }
                }

                sub.add(top.val);
            }

            list.add(sub);
        }

        return list;
        
    }
}
