/*
 *
 Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.


Constraints:

    1 <= candidates.length <= 30
    1 <= candidates[i] <= 200
    All elements of candidates are distinct.
    1 <= target <= 500

*
*/

class Solution {
public:
    vector<vector<int>> ans;
    
    void subsets(vector<int>& candidate,vector<int> subans,int target,int index)
    {
        //base
        if(target == 0)
        {
            ans.push_back(subans);
            return;
        }
        
        if(index == candidate.size())
            return;
        
        //check if current element is <= target then only add that.
        if(candidate[index]<=target)
        {
            subans.push_back(candidate[index]);
            subsets(candidate,subans,target-candidate[index],index);
            subans.pop_back();
        }
        
        //without considering the current element
        subsets(candidate,subans,target,index+1);
    }
    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> subans;    
        subsets(candidates,subans,target,0);
        
        return ans;
    }
};

/*

1.follow approach of recursive call with onec considering current element and once without considering the 
current element.

2.Since an element can be included twice in the result,when considering the current element do not increase the 
index in the next recursive call.

3.go on decreasing the target when an element is considered in current answer vector.consider the element 
only if the current element <= target.

4.Since there exists only distinct elements in the given array,directly ans can be filled in the base case.No
need to consider the hashset.

5.Since given array contains all elements with >=1 , as soon as we get target==0 we can return from recursive call.

*/
