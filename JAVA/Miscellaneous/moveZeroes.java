// Problem Link :- https://leetcode.com/problems/move-zeroes/submissions/

class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0, len = nums.length;;
        
        for (i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i]; 
            }
        }
        
        for (; j < len; j++) {
            nums[j] = 0;
        } 
    }
}
