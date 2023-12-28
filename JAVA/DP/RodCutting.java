public class Solution {
	public static int cutRod(int price[], int n) {
		int i = 0, j = 0, k = 0;
		int[] len = new int[n];
		int[][] dp = new int[n+1][n+1];

		for (i = 0; i < n; i++) {
			len[i] = i+1;
		}

		for (i = 1; i < n+1; i++) {
			for (j = 1; j < n+1; j++) {
				if (len[i-1] <= j) {
					dp[i][j] = Math.max(price[i-1] + dp[i][j-len[i-1]], dp[i-1][j]);
				} else if (len[i-1] > j) {
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		return dp[n][n];
	}
}
