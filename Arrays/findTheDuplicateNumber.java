// Problem Link :- https://leetcode.com/problems/find-the-duplicate-number/submissions/

class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0, j = 0, number = 0, ele = 0;
        
        for (i = 0; i < nums.length; i++) {
            ele = nums[i];
            if (ele < 0) {
                ele = -(ele);
            }
            if (nums[ele] < 0) {
                number = nums[i];
                
                if (number < 0) {
                    number = -(number);
                }
                break;
            }
            nums[ele] = -(nums[ele]);
        }
        
        return number;
        
    }
}