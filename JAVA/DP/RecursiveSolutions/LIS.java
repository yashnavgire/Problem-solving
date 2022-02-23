class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        
        return solve(nums, dp, 0, Integer.MIN_VALUE);
    }
    
    public int solve(int[] nums, int[] dp, int i, int prev) {
        if (i >= nums.length) {
            return 0;
        }
        
        if (dp[i] != -1) {
            return dp[i];
        }
        
        int take = 0;
        int dontTake = solve(nums, dp, i + 1, prev);
        if(nums[i] > prev) {
            take = 1 + solve(nums, dp, i + 1, nums[i]); 
        }
        dp[i] = Math.max(take, dontTake);
        return  dp[i];                               
    }
}
