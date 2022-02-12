// Poblme Link :- https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1/

class Solution{
    static int palindromicPartition(String str) {
        int[][] dp = new int[str.length()][str.length()];
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        
        return solve(str, 0, str.length()-1, dp);
    }
    
    public static int solve(String s, int i, int j, int[][] dp) {
        
        // already a Palindrome, no partition need
        if (i >= j) {
            return 0;
        }
        
        if (isPalindrome(s, i, j)) {
            return 0;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int k = i; k <= j-1; k++) {
            int temp = solve(s, i, k, dp) + solve(s, k+1, j, dp) + 1;
            
            if (temp < min) {
                min = temp;
            }
        }
        
        dp[i][j] = min;
        
        return min;
    }
    
    public static boolean isPalindrome(String str, int start, int end) {
        
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
}
