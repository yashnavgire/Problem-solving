public class Solution {
    public static int lcs(String str1, String str2){
        int i = 0, j = 0, n = str1.length(), m = str2.length(), max = Integer.MIN_VALUE;
        int[][]dp = new int[n+1][m+1];

        for (i = 1; i < n+1; i++) {
            for (j = 1; j < m+1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }
}
