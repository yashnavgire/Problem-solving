// Problem Link :- https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, sum = 0, end = numbers.length-1;
        final int LEN = 2;
        int[] ans = new int[LEN];
        
        while (start < end) {
            sum = numbers[start] + numbers[end];
            
            if (sum == target) {
                ans[0] = start+1;
                ans[1] = end+1;
                return ans;
            } else if (sum < target) {
                start++;
            } 
            else {
                end--;
            }
        }
        
        return ans;
    }
}
