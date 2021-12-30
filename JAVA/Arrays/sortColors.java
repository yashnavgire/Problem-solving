// Problem Link :- https://leetcode.com/problems/sort-colors/

class Solution {
    public void sortColors(int[] nums) {
        int start = 0, mid = 0, end = nums.length - 1, temp = 0;
        
        while (mid <= end) {
            if (nums[mid] == 0) {
                //swap(nums[start], nums[mid]);
                temp = nums[start];
                nums[start] = nums[mid];
                nums[mid] = temp;
                
                start++;
                mid++;
            } else if (nums[mid] == 2) {
                //swap(nums[end], nums[mid]);
                temp = nums[mid];
                nums[mid] = nums[end];
                nums[end] = temp;
                
                end--;
                //mid++;
            } else {
                mid++;
            }
        }  
    }
}