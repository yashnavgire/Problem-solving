// Problem Link :- https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length-1, mid = 0, retStart = 0, retEnd = 0;
        
        while (start <= end) {
            mid = start + (end-start)/2;
            
            if (nums[mid] == target) {
                if (nums[start] < target) {
                    start++;
                }
                if (nums[end] > target) {
                    end--;
                }
                if (nums[start] == target && nums[end] == target) {
                    retStart = start;
                    retEnd = end;
                    return new int[]{retStart, retEnd};
                }
            }
            
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            
            else if (nums[mid] > target) {
                end = mid - 1;
            }
        }
        
        return new int[]{-1, -1};
    }
}
