// Problem Link :- https://leetcode.com/problems/find-the-duplicate-number/submissions/
// Good Explanation can be found at :- https://www.geeksforgeeks.org/duplicates-array-using-o1-extra-space-set-2/?ref=lbp

class Solution {
    public int findDuplicate(int[] nums) {
        
        int tortoise = nums[0];
        int hare = nums[0];
        
        // find the intersection point of two pointers
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);
        
        tortoise = nums[0];
        
        // find the start of the cycle
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        
        return hare;
    }
}