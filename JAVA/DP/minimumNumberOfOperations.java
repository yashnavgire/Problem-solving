class Solution {
    public int minOperations(int[] nums) {
        int i = 0, ans = 0, max = Integer.MIN_VALUE;
        
        max = Math.max(max, nums[0]);
        for (i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            
            if (nums[i - 1] >= nums[i]) {
                max = max + 1;
                ans += max - nums[i];
                nums[i] += max - nums[i];
            }
        }
        
        return ans;
    }
}
