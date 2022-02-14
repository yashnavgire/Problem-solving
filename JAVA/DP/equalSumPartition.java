// Problem Link :- https://leetcode.com/problems/partition-equal-subset-sum/submissions/

class Solution {
    public boolean canPartition(int[] nums) {
        int i = 0, j = 0, sum = 0;
        
        for (i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        if (sum % 2 != 0) {
            return false;
        }
        
        int total = sum/2;
        
        if (nums.length == 0 || total == 0) {
            return false;
        }
        
        Boolean[][] dp = new Boolean[nums.length + 1][total + 1];
        
        for (i = 0; i < total+1 ;i++) {
            dp[0][i] = false;     
        }
        
        for (i = 0; i < nums.length+1 ;i++) {
            dp[i][0] = true;     
        }
        
        for (i = 1; i < nums.length + 1; i++) {
            for (j = 1; j < total + 1; j++) {
                if (nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];    
                } 
                else if (nums[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[nums.length][total];
    }
}
