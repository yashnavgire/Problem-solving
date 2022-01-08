// Problem Link :- https://leetcode.com/problems/target-sum/solution/

class Solution {
    int countWays = 0;
    public int findTargetSumWays(int[] nums, int target) {
        solve(nums, 0, 0, target);
        return countWays;
    }
    
    public void solve(int[] nums, int sum, int itr, int target) {
       
        if (itr > nums.length) {
            return;
        }
        
        if (itr == nums.length) {
            if (sum == target) {
                countWays++;
            }
        }
        else {
            //System.out.println("My" + "" + itr);
            solve(nums, sum+nums[itr], itr+1, target);
            solve(nums, sum-nums[itr], itr+1, target);
        }
        
        return;
    }
} 
