/*
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

*
*/


class Solution {
public:
    vector<vector<int>> ans;
    
    void combination(vector<int>& nums,int index)
    {
        if(index == nums.size())
        {
            ans.push_back(nums);
        }
        
        for(int i=index;i<nums.size();i++)
        {
            std:swap(nums[i],nums[index]);
            combination(nums,index+1);
            std::swap(nums[i],nums[index]);
        }
    }
    
    vector<vector<int>> permute(vector<int>& nums) {
        combination(nums,0);
        
        return ans;
    }
};
