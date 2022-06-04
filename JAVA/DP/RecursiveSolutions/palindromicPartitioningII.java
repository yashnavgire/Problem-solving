class Solution {
    public int minCut(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = -1;
            }
        }
        
        return solve(s, 0, s.length() - 1, dp);
    }
    
    public int solve(String s, int idx, int end, int[][] dp) {
        if (idx >= end || isPalindrome(s.substring(idx, end + 1))) {
            return 0;
        }
        
        if (dp[idx][end] != -1) {
            return dp[idx][end];
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = idx; i < end; i++) {
            if (isPalindrome(s.substring(idx, i + 1))) {
                int ways = solve(s, i + 1, end, dp) + 1;
                min = Math.min(ways, min);
            }
        }
        
        return dp[idx][end] = min;
    }
    
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        
        while  (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}
