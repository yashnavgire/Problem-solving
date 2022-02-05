/*

Given three sequences, find the length of the longest common subsequence (LCS) present in it. The LCS is the longest subsequence that can be obtained from each of the given sequences by deleting zero or more characters.

Input: X = "ABCBDAB", Y = "BDCABA", Z = "BADACB"
Output: 4
Explanation: The longest subsequence present in the given sequences in the same order is "BDAB", having length 4.

*/

class Solution
{
	public static int findLCSLength(String X, String Y, String Z) {
		int i = 0, j = 0, k = 0, xlen = X.length(), ylen = Y.length(), zlen = Z.length(), tempMax = 0;
		int[][][] dp = new int[xlen+1][ylen+1][zlen+1];
		
		for (i = 1; i < xlen+1; i++) {
			for (j = 1; j < ylen+1; j++) {
				for (k = 1; k < zlen+1; k++) {
					if (X.charAt(i-1) == Y.charAt(j-1) && X.charAt(i-1) == Z.charAt(k-1) && Y.charAt(j-1) == Z.charAt(k-1)) {
						dp[i][j][k] = 1 + dp[i-1][j-1][k-1];
					}
					else {
						dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
					}
				}
			}
		}
		
		return dp[xlen][ylen][zlen];
	}
}
