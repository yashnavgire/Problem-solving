class Solution {
    public int minDistance(String word1, String word2) {
        int lcs = 0, len1 = word1.length(), len2 = word2.length();

        lcs = LCS(word1, word2);

        return (len1 - lcs) + (len2-lcs);

        
    }

    public int LCS(String x, String y) {
        int i = 0, j = 0, k = 0, n = x.length(), m = y.length();
        int[][]dp = new int[n+1][m+1];

        for (i = 1; i < n+1; i++) {
            for (j = 1; j < m+1; j++) {
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
}
