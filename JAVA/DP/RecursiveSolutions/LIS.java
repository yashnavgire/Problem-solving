class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        
        return solve(nums, dp, 0, Integer.MIN_VALUE);
    }
    
    public int solve(int[] nums, int[] dp, int i, int prev) {
        if (i >= nums.length) {
            return 0;
        }
         
        if (nums[i] > prev) {
            
            dp[i] = (Math.max(1 + 
                             solve(nums, dp, i + 1, nums[i]), 
                             solve(nums, dp, i + 1, prev)));
            return dp[i];
        }
        
        return solve(nums, dp, i + 1, prev);
    }
}
