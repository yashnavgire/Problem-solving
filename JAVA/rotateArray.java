// Problem Link - https://leetcode.com/problems/rotate-array/submissions/

class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0 || nums.length == 1) {
            return;
        }
        
        int len = nums.length;
        k = k % nums.length;
        
        reverse(nums, 0, len - k - 1);
        reverse(nums, len - k, len - 1);
        reverse(nums, 0, len - 1);
        
        return;
    }
    
    public void reverse(int[] nums, int start, int end) {
        int temp = 0;
        
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        
        return;
    }
}

// In this solution we first reverse the k-1->len
// the 0->k
// and then reverse the whole array
