/*
 * 
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:

Input: nums = [0]
Output: [[],[0]]

*
*/


class Solution {
public:
    set<vector<int>> hs;
    void subset(vector<int>& nums,vector<int> curr,int index)
    {
        //base
        if(index == nums.size())
        {
            //to avoid duplicates use set to store the subset.Sort the vector so duplicates can be identified.
            sort(curr.begin(),curr.end());
            hs.insert(curr);
            return;
        }
        
        //recursive call considering the current index element
        curr.push_back(nums[index]);
        subset(nums,curr,index+1);
        
        //kind of backtrack
        curr.pop_back();
        
        //recursive call without considering the current index element
        subset(nums,curr,index+1);
        
    }
    
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> curr;
        subset(nums,curr,0);
        
        for(auto element : hs){
            ans.push_back(element);
        }
        return ans;
    }
};
