/*
 *
Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.

Example 1:

Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.

To Solve this in approx O(n) time complexity,Trie data structure can be used.
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


class Solution {
public:
    int findMaximumXOR(vector<int>& nums) {
        trienode* root = new trienode;
        trienode* trie = root;
        //fill the trie
        for(int i=0;i<nums.size();i++)
        {
            //fill from msb to lsb(i.e msb the root of trie)
            trie = root;
            for(int j=31;j>=0;j--)
            {
                int fill = (nums[i] & (1<<j)) == 0 ? 0 : 1;
                
                if(!trie->contains(fill))
                {
                    trie->put(fill,new trienode);
                }
                
                trie = trie->get(fill);
            }
        }
         
        int ans = INT_MIN;
        for(int i=0;i<nums.size();i++)
        {
            //check optimal bit and traverse trie
            int curr_xor = 0;
            int b = 0;
            trie = root;
            
            for(int j=31;j>=0;j--)
            {
                int req_bit = (nums[i] & (1<<j)) == 0 ? 1 : 0;
                if(trie->next[req_bit] == NULL)
                {
                    req_bit = !req_bit;
                }
                
                b = b | (req_bit << j);
                trie=trie->next[req_bit];
            }
            
            curr_xor = nums[i]^b;
            
            ans = std::max(ans,curr_xor);
        }
     
        return ans;
    }
};

/*
 Intuition is :
for xor of a and b to be maximum binary version of both should be opposite as much as possible.
if
a = 0101011 then max xor will be when
b = 1010100

so starting from left we should find a number with opposite of that bit and eliminate others. 

to solve this in O(n) :
1.store binary string of elements of nums in trie ds->O(n*32)
2.to find max xor numbers :
-select an element from array find the opposite of current bit and traverse trie with that opposite bit if next node exists for that bit else consider the same bit.

*/
