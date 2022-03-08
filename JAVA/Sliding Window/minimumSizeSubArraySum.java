// Problem Link :- https://leetcode.com/problems/minimum-size-subarray-sum/submissions/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0,j = 0, k = 0, flag = 0, size = 0, sum = 0;
        
        for (k = 1; k <= nums.length; k++) {
            i = 0;
            j = 0;
            flag = 0;
            sum = 0;
            System.out.println(k);
            
            while (j < nums.length) {
                sum = sum + nums[j];
                
                if (Math.abs(j - i) + 1 < k) {
                    j++;
                } else if (Math.abs(j - i) + 1 == k) {
                    if (sum >= target) {
                        // System.out.println(i + " " + j);
                        flag = 1;
                        break;
                    }
                    
                    sum = sum - nums[i];
                    i++;
                    j++;
                }
            }
            
            if (flag == 1) {
                size = k;
                break;
            }
        }
        
        return size;
        
    }
}
