// Problem Link :- https://leetcode.com/problems/decode-ways/submissions/ 

class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        
        return solve(s, 0, dp);
    }
    
    public int solve(String s, int ptr, int[] dp) {
        
        if (ptr >= s.length()) {
            return 1;
        }
        
        if (dp[ptr] != -1) {
            return dp[ptr];
        }
        
        int ways = 0;
        
        for (int i = 1; i <= 2; i++) {
            String sub = "";
            
            if (ptr+i <= s.length()) {
                sub = s.substring(ptr, ptr+i);   
            }
            
            if (isValid(sub)) {
                ways += solve(s, ptr+i, dp);
            }
        }
        
        dp[ptr] = ways;
        
        return dp[ptr];
    }
    
    public boolean isValid(String s) {
        if (s.length() <= 0 || s.charAt(0) == '0') {
            return false;
        }
        
        int val = Integer.parseInt(s);
        
        if (val >= 1 && val <= 26) {
            return true;
        }
        
        return false;
    }
}
