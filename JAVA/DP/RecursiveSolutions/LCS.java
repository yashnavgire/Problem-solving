class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int i = 0, j = 0;
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        
        for (i = 0; i < dp.length; i++) {
            for (j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        
        return helper(text1, text2, 0, 0, dp);
    }
    
    public int helper(String s1, String s2, int idx1, int idx2, int[][] dp) {
        if (idx1 >= s1.length() || idx2 >= s2.length()) {
            return 0;
        }
        
        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }
        
        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            dp[idx1][idx2] = 1 + helper(s1, s2, idx1 + 1, idx2 + 1, dp);
            return dp[idx1][idx2];
        }
        
         dp[idx1][idx2] = Math.max(helper(s1, s2, idx1 + 1, idx2, dp),
                           helper(s1, s2, idx1, idx2 + 1, dp));
        
        return dp[idx1][idx2]; 
    }
}
