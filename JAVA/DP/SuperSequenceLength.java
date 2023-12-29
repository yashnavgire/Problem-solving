class Solution {
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n) {
        int ss = 0, len = 0;
        
        len = LCS(X, Y, m, n);
        
        return (m+n - len);
    }
    
    public static int LCS(String x, String y, int m , int n) {
        int i = 0, j = 0;
        int[][] dp = new int[m+1][n+1];
        
        for (i = 1; i < m+1; i++) {
            for (j = 1; j < n+1; j++) {
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[m][n];
    }
}
