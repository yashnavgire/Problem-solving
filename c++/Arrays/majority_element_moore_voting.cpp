class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int cnt = 0;
        int currNum = nums[0];
        for(int i=0;i<nums.size();i++){
            if(nums[i]==currNum)
                cnt++;
            else
                cnt--;
            
            if(cnt==0)
            {
                currNum = nums[i];
                cnt = 1;
            }        
        }
        
        return currNum;
    }
};


/*
    Intuition : 
    
    -since atleast one number exists more than n/2,maintain a counter and counter_number for which counter is incremented. 
    -increment counter if current number is equal to counter_number else decrement
    -if counter is zero at anytime that means the stored number is not the required number at that instance(since required number will be more than n/2) , update the stored number with current number in that case.
    
*/
