class Solution {
    public String longestPalindrome(String s) {
        
        int i = 0, j = 0, maxLen = Integer.MIN_VALUE, endingIndex = 0;
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        String rev = sb.reverse().toString();
        
        for (i = 1; i < s.length() + 1; i++) {
            for (j = 1; j < rev.length() + 1; j++) {
                if(s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endingIndex = i;
                    }
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return s.substring(endingIndex - maxLen, endingIndex);
    }
}
