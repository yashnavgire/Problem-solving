class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int i = 0, j = nums.length - 1, k = (int)Math.pow(2, maximumBit), max = Integer.MIN_VALUE, l = 0;
        int[] dp = new int[nums.length];
        int[] ans = new int[nums.length];
        
        for (i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            }
            else {
                dp[i] = nums[i] ^ dp[i - 1];
            }
        }
        
        int temp = 0;
        
        while (j >= 0) {
            temp = 0;
            max = Integer.MIN_VALUE;
            
            for (i = 0; i < k; i++) {
                if ((dp[j] ^ i) > max) {
                    temp = i;
                    max = Math.max(max, dp[j] ^ i);
                }  
            }
            ans[l++] = temp;
            j--;
        }
        
        return ans;
    }
}
