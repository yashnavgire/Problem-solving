// Problem Link :- https://leetcode.com/problems/longest-palindromic-subsequence/submissions/

class Solution {
    public int longestPalindromeSubseq(String s) {
        int i = 0, j = 0;
        int[][] dp = new int[s.length()][s.length()];
        
        for (i = 0; i < s.length(); i++) {
            for (j = 0; j < s.length(); j++) {
                dp[i][j] = -1;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        String rev = sb.reverse().toString();
        
        return solve(s, rev, dp, s.length() - 1, rev.length() - 1);
    }
    
    public int solve(String s, String rev, int[][] dp, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        } 
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        else if(s.charAt(i) == rev.charAt(j)) {
            dp[i][j] = 1 + solve(s, rev, dp, i - 1, j - 1);
            return dp[i][j];
        }
        else {
            dp[i][j] = Math.max(solve(s, rev, dp, i - 1, j), solve(s, rev, dp, i, j - 1));
            return dp[i][j];
        }
    }
}
