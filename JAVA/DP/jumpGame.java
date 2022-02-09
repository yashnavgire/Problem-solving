// Problem Link :- https://leetcode.com/problems/jump-game/submissions/

class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, nums[i] + i);
        }
        
        return (max >= nums.length-1) ? true : false;
    }
}
