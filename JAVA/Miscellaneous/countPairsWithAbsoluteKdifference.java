// Problem Link :- https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/submissions/

class Solution {
    public int countKDifference(int[] nums, int k) {
        int i = 0, j = 0, pairs = 0;
        
        for (i = 0; i < nums.length; i++) {
            for (j = i+1; j < nums.length; j++) {
                if (Math.abs(nums[i]-nums[j]) == k) {
                    pairs++;
                }
            }
        }
        
        return pairs;
    }
}
