/*
 *Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

    0 <= a, b, c, d < n
    a, b, c, and d are distinct.
    nums[a] + nums[b] + nums[c] + nums[d] == target

You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

Constraints:

    1 <= nums.length <= 200
    -109 <= nums[i] <= 109
    -109 <= target <= 109
 *
 */

class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> ans;
        
        vector<int> tmp;
        tmp.assign(nums.begin(),nums.end());
        
        sort(tmp.begin(),tmp.end());
        
        for(int i=0;i<tmp.size();i++)
        {
            for(int j=i+1;j<tmp.size();j++)
            {
                int rem = target - tmp[i] - tmp[j];
                int front = j + 1;
                int end = tmp.size() - 1;
                while(front<end)
                {
                    if((tmp[front] + tmp[end]) > rem)
                        end--;
                    else if((tmp[front] + tmp[end] < rem))
                        front++;
                    else
                    {
                        vector<int> quadrup = {tmp[i],tmp[j],tmp[front],tmp[end]};
                        ans.push_back(quadrup);
                        
                        //eliminate duplicate front and end values , since for particular front there need to be same end value to satisfy sum up of rem.
                        while(front < tmp.size()-1 && tmp[front] == quadrup[2])
                            front++;
                        
                        while(end > j+1 && tmp[end] == quadrup[3])
                            end--;
                    }
                }
                
                //eliminate duplicate j values
                while(j+1 < tmp.size() && tmp[j+1] == tmp[j])
                    j++;
                
            }
            //eliminate duplicate i values
            while(i+1 < tmp.size() && tmp[i+1] == tmp[i])
                i++;
        }
        
        return ans;
    }
};

/*
1.sort
2.fix 2 elements(loop for all combinations) , find remaining sum with 2 pointer algo. 
*/


