/*
 * There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

*
*/

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int low = 0,high = nums.size()-1;

        while(low <= high)
        {
            int mid = (low + high)/2;

            if(nums[mid] == target)
                return mid;

            else if((nums[mid] > nums[low] && target < nums[mid] && target>=nums[low]) || (nums[mid] < nums[low] && (target>=nums[low] || target < nums[mid])))
                high = mid -1;

            else
                low = mid +1;

        }

        return -1;
    }
};

/*
lets handle all cases to modify high to mid -1 ->in all other cases update low to mid+1

following are scenarios wherein target can be between low and mid

1.[1,2,3,4,5] , target = 2
normal case -> mid(3) > low(1) and target between low and mid

2.[4,5,6,2,3] , target = 5
similar to 1 mid(6) > low(4) and target is between low and mid -> high =mid-1


3.[4,0,1,2,3] ,target = 4 or 0
here mid(1) < low(4)
->this means all elements which are greater than low and less than mid will exists between low and mid
->therefore,check if target<mid or target>=low

*/
