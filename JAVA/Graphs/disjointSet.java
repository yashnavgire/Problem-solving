/*
  This is the sample Program for Unio Find using Disjoint Sets using the Quick Find and normal union, but the Quick Union is more faster than the Quick Union Since the worst
  time complexity will be O(n2) in that here ebvertime for each node we ill need to loop over the root array
*/

class unionFind {
	int[] root;
	
	unionFind(int size) {
		root = new int[size];
		for (int i = 0; i < size; i++) {
			root[i] = i;
		}
	}
	
	public void union(int x, int y) {
		int par1 = root[x];
		int par2 = root[y];
		
		if (par1 != par2) {
			for (int i = 0; i < root.length; i++) {
				if (root[i] == par2) {
					root[i] = par1;
				}
			}
		}
	}
	
	public int find(int node) {
		return root[node];
	}
	
	public boolean isConnected(int x, int y) {
		if (root[x] == root[y]) {
			return true;
		}
		
		return false;
	}
}
public class Main {
	public static void main(String[] args) {
		unionFind uf = new unionFind(10);
		
		uf.union(1, 7);
		uf.union(2, 6);
		uf.union(5, 4);
		uf.union(3, 4);
		uf.union(2, 5);
		uf.union(2, 8);
		
		System.out.println(uf.find(1));
		System.out.println(uf.find(2));
		System.out.println(uf.isConnected(1, 2)); // false
		System.out.println(uf.isConnected(2, 6)); // true
		System.out.println(uf.isConnected(3, 8)); // true
	}
}
