// Problem :- https://leetcode.com/problems/next-permutation/submissions/

class Solution {
    public void nextPermutation(int[] nums) {
        int i = 0, j = nums.length - 1, ptr = 0, replacer = 0;
        
        while (j >= 1) {
               if (nums[j] > nums[j - 1]) {
                   for (i = j; i < nums.length; i++) {
                       if (nums[j - 1] < nums[i]) {
                           replacer = nums[i];
                           ptr = i;
                       }
                       else {
                           break;
                       }
                   }
                   
                   i = ptr;
                   
                   while (i >= j) {
                       nums[i] = nums[i - 1];
                       i--;
                   }
                   System.out.println(replacer);
                   nums[j - 1] = replacer;
                   
                   Arrays.sort(nums, j, nums.length);
                   break;
               }
            j--;
        }
        
        if (j == 0) {
            Arrays.sort(nums);
        }
       
        return ;
    }
}
