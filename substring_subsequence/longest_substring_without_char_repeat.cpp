/******
 
Given a string s, find the length of the longest substring without repeating characters.
 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


 *
 */


class Solution {
public:
    int lengthOfLongestSubstring(string s) {
       unordered_map<char,int> mp;
       int start = 0,i = 0;
       int max = 0; 
       for(i=0;i<s.size();i++)
       {
           if(mp.find(s[i])==mp.end())
                mp[s[i]] = i;
           else {
               if(mp[s[i]]>=start)
               {
                   max = std::max(max,i-start);
                   start = mp[s[i]] + 1;
               }
                mp[s[i]] = i;
           }
       }
        
       return std::max(max,i-start);
    }
};


//adbcb


//afbcdbe
  
//   a - 1
//   f - 2
//   b - 5
//   c 4
//   d 5


// m
// l


