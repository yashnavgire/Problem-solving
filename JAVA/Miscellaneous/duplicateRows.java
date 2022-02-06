/*

Find duplicate rows present in a given binary matrix by traversing the matrix only once.

Input:

mat = [
	[1, 0, 0, 1, 0],
	[0, 1, 1, 0, 0],
	[1, 0, 0, 1, 0],
	[0, 0, 1, 1, 0],
	[0, 1, 1, 0, 0]
]

Output: {3, 5}

Explanation: Row #3 is duplicate of row #1 and row #5 is duplicate of row #2

*/

class Solution {
	public static Set<Integer> findDuplicateRows(int[][] mat) {
		int i = 0, j = 0, decimalValue = 0, duplicate = 0;
		
		Set<Integer> set = new HashSet<>();
		Set<Integer> ans = new HashSet<>();
		
		for (i = 0; i < mat.length; i++) {
			decimalValue = 0;
			for (j = 0 ; j < mat[0].length; j++) {
				decimalValue += (mat[i][j] * Math.pow(2, j));
			}
			
			if (!set.contains(decimalValue)) {
				set.add(decimalValue);
			}
			else {
				ans.add(i+1);
			}
		}
		
		return ans;
	}
}
