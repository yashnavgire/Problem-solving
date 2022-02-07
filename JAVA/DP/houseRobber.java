// Problem Link :- https://leetcode.com/problems/house-robber/submissions/

class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int rob1 = solve(nums, dp, 0);
        int rob2 = solve(nums, dp, 1);
        
        return Math.max(rob1, rob2);
    }
    
    public int solve(int[] nums, int[] dp, int index) {
        if (index >= nums.length) {
            return 0;
        }
        
        if (dp[index] != -1) {
            return dp[index];
        }
        
        return (dp[index] = Math.max((nums[index] + solve(nums, dp, index+2)), 
                        solve(nums, dp, index+1)));
    }
}
