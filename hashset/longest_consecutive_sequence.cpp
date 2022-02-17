/**
 *Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

 

Constraints:

    0 <= nums.length <= 105
    -109 <= nums[i] <= 109

**/


class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> hs;

        for(int i=0;i<nums.size();i++)
        {
            hs.insert(nums[i]);
        }

        int ans = 0;

        for(int i=0;i<nums.size();i++)
        {
            if(hs.find(nums[i]-1)==hs.end())
            {
                int cnt = 1;
                int element = nums[i]+1;
                while(hs.find(element)!=hs.end())
                {
                    element = element + 1;
                    cnt++;
                }

                ans = std::max(ans,cnt);
            }
        }

        return ans;
    }
};


/*
### basic soltion
1.sort array and find consecutive elements -> O(NlogN)


### To solve in O(n) intuition is :

1.Store all the elements in the hashset hs.
2.There can be multiple consecutive sequence in the given array.
3.If we are able to find the start of that each consecutive array and search it's next consecutive elements using hashset(hs) we will get the length of that consecutive sequence.

4.To find all possible start/minimal element in 0(n) :
 -iterate over the array
 -while iterating check if current_element - 1 exists in hashset.
 -If not then that means current element is start of one of the consecutive sequence -> (calculate length of that sequence as mentioned in step 3)
 -If yes then do nothing and jump to next element(since that element will be the middle / end of some of the consecutive element)

*/
