/*

Given a rectangular path in the form of a binary matrix, find the length of the longest possible route from source to destination by moving to only non-zero adjacent positions, i.e., A route can be formed from positions having their value as 1. Note there should not be any cycles in the output path.

Input:

matrix = [
	[1, 0, 1, 1, 1, 1, 0, 1, 1, 1],
	[1, 0, 1, 0, 1, 1, 1, 0, 1, 1],
	[1, 1, 1, 0, 1, 1, 0, 1, 0, 1],
	[0, 0, 0, 0, 1, 0, 0, 1, 0, 0],
	[1, 0, 0, 0, 1, 1, 1, 1, 1, 1],
	[1, 1, 1, 1, 1, 1, 1, 1, 1, 0],
	[1, 0, 0, 0, 1, 0, 0, 1, 0, 1],
	[1, 0, 1, 1, 1, 1, 0, 0, 1, 1],
	[1, 1, 0, 0, 1, 0, 0, 0, 0, 1],
	[1, 0, 1, 1, 1, 1, 0, 1, 0, 0]
]
src  = (0, 0)
dest = (5, 7)

Output: 22

Explanation: The longest path is:

(0, 0) —> (1, 0) —> (2, 0) —> (2, 1) —> (2, 2) —> (1, 2) —> (0, 2) —> (0, 3) —> (0, 4) —> (1, 4) —> (1, 5) —> (2, 5) —> (2, 4) —> (3, 4) —> (4, 4) —> (5, 4) —> (5, 5) —> (5, 6) —> (4, 6) —> (4, 7) —> (4, 8) —> (5, 8) —> (5, 7)

Note: The solution should return 0 if no path is possible.

*/

class Solution
{
	/* The Pair<U, V> class have
		1. Two member variables, first and second.
		2. Factory method `Pair.of(U, V)` for creating its immutable instance.
		3. equals() and hashCode() methods overridden.
	*/

	public static int findLongestPath(int[][] mat, Pair<Integer, Integer> src, Pair<Integer, Integer> dest) {
		int[][] visited = new int[mat.length][mat[0].length];
		int i = src.first;
		int j = src.second;
		int x = dest.first;
		int y = dest.second;
		if (mat[i][j] == 0) {
			return 0;
		}
		
		if (mat[x][y] == 0) {
			return 0;
		}
		
		int[] ans = new int[1];
		System.out.println(x + " " + y + " " + i + " " + j);
		solve(mat, visited, ans, x, y, i, j, 0, 0);
		return ans[0];
	}
	
	public static int solve(int[][] mat, int[][] visited, int[] ans, int x, int y, int i, int j, int max, int dist) {
		if (i == x && j == y) {
			int temp = Math.max(max,dist);
			ans[0] = Math.max(temp, ans[0]);
			// System.out.println(Math.max(max, dist));
			return Math.max(max, dist);
		}
		
		if (i < 0 || j < 0 || i >= mat.length || j >= mat[i].length || visited[i][j] == 1 || mat[i][j] == 0) {
			return 0;
		}
		
		
		visited[i][j] = 1;
		
		max = solve(mat, visited, ans, x, y, i + 1, j, max, dist + 1);
		max = solve(mat, visited, ans, x, y, i - 1, j, max, dist + 1);
		max = solve(mat, visited, ans, x, y, i, j + 1, max, dist + 1);
		max = solve(mat, visited, ans, x, y, i, j - 1, max, dist + 1);
		
		// System.out.println(max);
		
		visited[i][j] = 0;
		
		return max;
	}
}
