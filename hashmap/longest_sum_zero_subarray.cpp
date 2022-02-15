/**
 *
 * Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

    Example 1:

    Input:
    N = 8
    A[] = {15,-2,2,-8,1,7,10,23}
    
    Output: 5
    Explanation: The largest subarray with
    sum 0 will be -2 2 -8 1 7.
*
**/


#include<iostream>
#include <bits/stdc++.h>
int LongestSubsetWithZeroSum(vector < int > arr) {

  // Write your code here
  //store index of first occurence of a number
    unordered_map<int,int> mp;
    mp[0] = -1;
    int ans = 0;
    int sum = 0;
  	for(int i=0;i<arr.size();i++)
    {
        sum = sum + arr[i];
        if(mp.find(sum)!=mp.end())
        {
            ans = std::max(ans,i-mp[sum]);
        }
        else
        {
            mp[sum] = i;
        }
    }

    return ans;
}
