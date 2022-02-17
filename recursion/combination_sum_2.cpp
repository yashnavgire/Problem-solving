/*
 *
 Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Constraints:

    1 <= candidates.length <= 100
    1 <= candidates[i] <= 50
    1 <= target <= 30

*
*/

class Solution {
public:
    vector<vector<int>> ans;
    
    void subsets(vector<int>& candidates,vector<int> subans,int target,int index)
    {
        if(target == 0)
        {
            ans.push_back(subans);
            return;
        }
    
        if(index == candidates.size())
            return;
        
        for(int i=index;i<candidates.size();i++)
        {
            //skip the duplicates
            if(i>index && candidates[i]==candidates[i-1])
                continue;
            
            //break if current element is greater than target,since elements after current will also be greater.
            if(candidates[i]>target)
                break;
            
            subans.push_back(candidates[i]);
            subsets(candidates,subans,target-candidates[i],i+1);
            subans.pop_back();
        }
    }
    
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
            vector<int> subans;
        
            sort(candidates.begin(),candidates.end());
        
            subsets(candidates,subans,target,0);
        
            return ans;
    }
};

/*

1.Given is the array elements are not distinct and unique combinations are required and each number to be used once.

To avoid duplicate combinations :

approach1 :
- store the combinations in set and then fill the vector at the end.[(2^n)*klogn]

approach2 : to avoid extra logn due to use of set
- sort given array.(will make sure duplicate elements are together)
- use non-binary recursive tree approach to loop over all combinations.
- with that skip the same consecutive elements while considering for next recursive call.
- to optimize further break the recursive chain and backtrack as soon as current element is found to be 
  greater than target..since array is sorted no further element can be picked.

*/
