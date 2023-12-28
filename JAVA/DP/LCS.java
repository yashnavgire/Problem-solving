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

// Recursive  + Memoisation solution

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int i = 0, j = 0, n = text1.length(), m = text2.length();
        int[][] dp = new int[n][m];

        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(dp, text1, text2, n-1, m-1);
    }

    public int solve(int[][]dp, String x, String y, int m, int n) {

        if (m < 0 || n < 0) {
            return 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (x.charAt(m) == y.charAt(n)) {
            return dp[m][n] = 1 + solve(dp, x, y, m-1, n-1);
        }

        return dp[m][n] = Math.max(solve(dp, x, y, m-1, n), solve(dp, x, y, m, n-1));
    }
}
