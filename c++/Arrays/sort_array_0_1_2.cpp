class Solution {
public:
    void sortColors(vector<int>& nums) {
       int cnt[3] = {0};
        
       for(int i=0;i<nums.size();i++){
           cnt[nums[i]]++;      
       }
        
        int len = sizeof(cnt)/sizeof(cnt[0]);
        
        int last = 0,j=0;
        for(int i=0;i<len;i++){
            for(j=last;j<last+cnt[i];j++){
                nums[j] = i;
            }
            last = j;
        }
    }
};

