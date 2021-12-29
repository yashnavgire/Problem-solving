class Solution {
public:
    static bool comapreInterval(vector<int> v1,vector<int> v2){
        return v1[0]<v2[0];
    }
    
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> ans;
        
        std::sort(intervals.begin(),intervals.end(),comapreInterval);
        
        ans.push_back(vector<int>{intervals[0][0],intervals[0][1]});
        
        for(int i=1;i<intervals.size();i++)
        {
            if(ans.back()[1] >= intervals[i][0])
            {
                ans.back()[1] = std::max(ans.back()[1],intervals[i][1]);  
            }
            else
            {
                ans.push_back(vector<int>{intervals[i][0],intervals[i][1]});
            }
        }
        return ans;   
    }
};


// 1,6 -> 2,3 ->4,5 -> 6,8 -> 10,11
