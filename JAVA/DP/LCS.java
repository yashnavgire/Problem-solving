/*

Given two sequences, find the length of the longest common subsequence (LCS) present in it. The LCS is the longest sequence which can be obtained from the first sequence by deleting some items and from the second sequence by deleting other items.

Input: X = "ABCBDAB", Y = "BDCABA"
Output: 4
Explanation: The LCS are "BDAB", "BCAB", and "BCBA", having length 4.

*/

class Solution
{
	public static int findLCSLength(String X, String Y)
	{
		int i = 0, j = 0;
		int[][] dp = new int[X.length()+1][Y.length()+1];
		
		for (i = 1; i < X.length()+1; i++) {
			for (j = 1; j < Y.length()+1; j++) {
				if (X.charAt(i-1) == Y.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[X.length()][Y.length()];
	}
}
