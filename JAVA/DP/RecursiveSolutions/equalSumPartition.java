// Problem Link :- https://leetcode.com/problems/partition-equal-subset-sum/submissions/

class Solution {
    public boolean canPartition(int[] nums) {
        int i = 0, sum = 0;
        
        for (i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        return (sum % 2 == 0) ? solve(nums, 0, sum/2) : false;
    }
    
    public boolean solve(int[] nums, int i, int sum) {
        
        if (i >= nums.length || sum < 0) {
            return false;
        }
        
        //System.out.println(nums[i] + " " + sum);
        
        if (sum == 0) {
            return true;
        }
        
        return solve(nums, i + 1, sum - nums[i]) || solve(nums, i + 1, sum);
}
