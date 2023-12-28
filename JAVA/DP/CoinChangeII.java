class Solution {
    public int change(int amount, int[] coins) {
        int i = 0, j = 0;
        int[][]dp = new int[coins.length+1][amount+1];

        for (i = 0; i < coins.length+1; i++) {
            dp[i][0] = 1;
        }

        for (i = 1; i < coins.length+1; i++) {
            for (j = 1; j < amount+1; j++) {
                if (coins[i-1] <= j) {
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                } else if (coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[coins.length][amount];
    }
}
