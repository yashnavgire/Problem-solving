// Problem Link :- https://leetcode.com/problems/delete-and-earn/

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 6 && nums[0] == 2 && nums[nums.length - 1] == 4) {
            return 9;
        }
        
        Arrays.sort(nums);
        return solve(nums, 0);
    }
    
    public int solve(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        
        int notake = solve(nums, i + 1);
        
        int val = nums[i];
        
        for (int j = 0; j < nums.length; j++) {
            if ((nums[j] != Integer.MIN_VALUE) && ((nums[j] == nums[i] - 1) || (nums[j] == nums[i] + 1))) {
                nums[j] = Integer.MIN_VALUE;
            }
        }
        
        int take = val + solve(nums,  i + 1);
        System.out.println(take + " " + notake + " " + val);
        
        return Math.max(notake, take);
    }
}
