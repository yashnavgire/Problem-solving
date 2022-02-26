/*
 * You are given an array nums consisting of non-negative integers. You are also given a queries array, where queries[i] = [xi, mi].

The answer to the ith query is the maximum bitwise XOR value of xi and any element of nums that does not exceed mi. In other words, the answer is max(nums[j] XOR xi) for all j such that nums[j] <= mi. If all elements in nums are larger than mi, then the answer is -1.

Return an integer array answer where answer.length == queries.length and answer[i] is the answer to the ith query.



Example 1:

Input: nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
Output: [3,3,7]
Explanation:
1) 0 and 1 are the only two integers not greater than 1. 0 XOR 3 = 3 and 1 XOR 3 = 2. The larger of the two is 3.
2) 1 XOR 2 = 3.
3) 5 XOR 2 = 7.

*
*/


struct trienode{
    trienode* next[2] = {NULL};
    
    void put(int bit,trienode *node)
    {
        next[bit] = node;
    }
    
    trienode* get(int bit)
    {
        return next[bit];
    }
    
    bool contains(int bit)
    {
        if(next[bit]!=NULL)
            return true;
        
        return false;
    }
    
    ~trienode()
    {
        if(next[0] != NULL)
        {
            delete next[0];
        }
        if(next[1] != NULL)
        {
            delete next[1];
        }
    }
};

struct queryObj
{
    int x;
    int m;
    int index;

};

bool compare(queryObj query1,queryObj query2)
    {
        if(query1.m < query2.m)
            return true;
        
        return false;
    }

class Solution {
public:

    
    vector<int> maximizeXor(vector<int>& nums, vector<vector<int>>& queries) {
        //sort nums and queries
        sort(nums.begin(),nums.end());
        
        //sort modified queries to maintain index
        vector<queryObj> mqueries;
        
        for(int i=0;i<queries.size();i++)
        {
            queryObj curr;
            curr.x=queries[i][0];
            curr.m=queries[i][1];
            curr.index=i;
            mqueries.push_back(curr);
        }
       
        sort(mqueries.begin(),mqueries.end(),compare);
        
        int index = 0;
        
        trienode* root = new trienode;
        trienode* trie = root;
        vector<int> ans(mqueries.size(),-1);
        
        //iterate through sorted queries
        for(int i=0;i<mqueries.size();i++)
        {
            if(mqueries[i].m < nums[0])
            {
                continue;
            }
            
            //populate trie with all elements <=m .
            while(index < nums.size() && nums[index] <= mqueries[i].m)
            {
                //fill from msb to lsb(i.e msb the root of trie)
                trie = root;
                for(int j=31;j>=0;j--)
                {
                    int fill = (nums[index] & (1<<j)) == 0 ? 0 : 1;

                    if(!trie->contains(fill))
                    {
                        trie->put(fill,new trienode);
                    }

                    trie = trie->get(fill);
                }
                
                index++;
            }
            
            // find max xor
            int curr_xor = 0;
            int b = 0;
            trie = root;

            for(int j=31;j>=0;j--)
            {
                int req_bit = (mqueries[i].x & (1<<j)) == 0 ? 1 : 0;
                if(trie->next[req_bit] == NULL)
                {
                    req_bit = !req_bit;
                }

                b = b | (req_bit << j);
                trie=trie->next[req_bit];
            }

            curr_xor = mqueries[i].x^b;
            ans[mqueries[i].index] = curr_xor;
        }
        
        return ans;
    }
};


/*

1.sort nums in ascending order
2.sort queries in ascending order wrt m  
3.pick one query and traverse nums till element <=m and go on adding into trie.

-This will take care of condition wherein the xor from nums
to be done with only elements less than query element
and the trie will be populated with only <=m elements.

Therefore we can directly apply algorithm of max xor of an element with all array elements
(in O(32) for every query)

*/
