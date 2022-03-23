/*

Given the root of a binary tree, return the boundary traversal of its nodes' values. The solution should process the boundary nodes starting from the tree's root, in an anti-clockwise direction, without any duplicates.

Input:
				1
			  /   \
			/		\
		  /			  \
		 2			   3
	   /   \		 /   \
	  /		\		/	  \
	 4		 5	   6	   7
	/ \		  \			  /
   /   \	   \		 /
  8		9	   10	   11
	   / \			  /
	  /   \			 /
	 12   13		14

Output: [1, 2, 4, 8, 12, 13, 10, 6, 14, 11, 7, 3]

*/

class Solution
{
	/*
		A binary tree node is defined as:

		class Node
		{
			int data;			// data field
			Node left, right;	// pointer to the left and right child

			Node() {}
			Node(int data) { this.data = data; this.left = this.right = null; }
		}
	*/

	public static List<Integer> findBoundaryTraversal(Node root) {
		List<Integer> list = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		
		if (root == null) {
			return list;
		}
		
		if (root.left == null && root.right == null) {
			list.add(root.data);
			return list;
		}
		
		list.add(root.data);
		leftTraversal(root.left, list);
		System.out.println("Left");
		inorder(root, list);
		System.out.println("mid");
		rightTraversal(root.right, right);
		Collections.reverse(right);
		
		for (int i = 0; i < right.size(); i++) {
			list.add(right.get(i));
		}
		
		System.out.println("right");
		
		return list;
	}
	
	public static void leftTraversal(Node root, List<Integer> list) {
		if (root == null) {
			return;
		}
		
		if (root.left == null && root.right == null) {
			return;
		}
		
		list.add(root.data);
		
		if (root.left != null) {
			leftTraversal(root.left, list);
		}
		else {
			leftTraversal(root.right, list);
		}
	}
	
	public static void rightTraversal(Node root, List<Integer> list) {
		if (root == null) {
			return;
		}
		
		if (root.left == null && root.right == null) {
			return;
		}
		
		list.add(root.data);
		
		if (root.right != null) {
			rightTraversal(root.right, list);
		}
		else {
			rightTraversal(root.left, list);
		}
	}
	
	public static void inorder(Node root, List<Integer> list) {
		if (root == null) {
			return;
		}
		
		inorder(root.left, list);
		
		if (root.left == null && root.right == null) {
			list.add(root.data);
		}
		
		inorder(root.right, list);
	}
}
