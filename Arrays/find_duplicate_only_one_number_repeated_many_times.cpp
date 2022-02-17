/*
 *
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2

Example 2:

Input: nums = [3,1,3,4,2]
Output: 3


link : https://leetcode.com/problems/find-the-duplicate-number/
 *
 */


class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        //find intersection point of slow , fast
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];   //forward by one
            fast = nums[nums[fast]]; //forward by 2 
        }while(slow != fast);
        
        //Find the Entrance pt of cycle.(Intersection pt will not be entrance pt necessarily)
        slow = nums[0]; //move by one from start
        
        while(slow != fast)
        {
            slow = nums[slow];
            fast = nums[fast]; //move by one from intersection pt
        }
        
        return slow;
    }
};

//To solve this without extra memory and without changing the array elements :  
//1. Detect cycle intersection pt in array(like cyclic linked list).
//2. Detect cycle start position which is the answer.

// [1 -> 3 -> 4 -> 2 -> 2]
