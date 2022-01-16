// Problem Link :- https://leetcode.com/problems/max-consecutive-ones/submissions/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = 0, maxLen = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                len = 0;
            }
            else {
                len++;
                maxLen = Math.max(len, maxLen);
            }
        }
        
        return maxLen;
    }
}
