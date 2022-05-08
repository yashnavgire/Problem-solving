class Solution {
	/* This is the Node class definition
	
	class Node {
		public Node left;
		public Node right;
		public int data;

		public Node(int data) {
			this.data = data;
		}
	}
	*/

	boolean pairExists(Node root, int k) {
		if (root == null) {
			return false;
		}
	    Map<Integer, Integer> map = new HashMap<>();
		boolean[] ans = new boolean[1];
		ans[0] = false;
		inorder(root, map, ans, k);
		return ans[0];
	}
	
	void inorder(Node root, Map<Integer, Integer> map, boolean[] ans, int target) {
		if (root == null) {
			return;
		}
		
		inorder(root.left, map, ans, target);
		if (map.containsKey(root.data)) {
			ans[0] = true;
			return;
		}
		else {
			map.put(target - root.data, 1);
		}
		inorder(root.right, map, ans, target);
	}
}
