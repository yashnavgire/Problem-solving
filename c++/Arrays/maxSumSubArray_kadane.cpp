class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        
        int sum = nums[0];
        int maxSum = sum;
        
        for(int i=1;i<nums.size();i++){
            sum += nums[i];
            
            if(nums[i] > sum)
                sum = nums[i];
            
            if(sum > maxSum)
                maxSum = sum;
        }
        
        return maxSum;
    }
};



// [-2,1,-3,4,-1,2,1,-5,4]

// 
