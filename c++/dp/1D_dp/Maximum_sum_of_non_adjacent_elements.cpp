/*
 *
 You are given an array/list of ‘N’ integers. You are supposed to return the maximum sum of the subsequence with the constraint that no two elements are adjacent in the given array/list.
*
*Constraints:

1 <= T <= 500
1 <= N <= 1000
0 <= ARR[i] <= 10^5

Where 'ARR[i]' denotes the 'i-th' element in the array/list.

Time Limit: 1 sec.

Sample Input 1:

2
3
1 2 4
4
2 1 4 9

Sample Output 1:

5
11


link : https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
*
*
*/

#include<bits/stdc++.h>

int dfs(vector<int>& nums , int index,vector<int>& dp)
{
    if(index < 0)
        return 0;
    if(index == 0)
        return nums[index];
    
    if(dp[index] != -1)
        return dp[index];
    
    //don't select current
    int a = dfs(nums,index-1,dp);
    //select current
    int b = nums[index] + dfs(nums,index-2,dp);
    
    
    return dp[index]=std::max(a,b);
}

int maximumNonAdjacentSum(vector<int> &nums){
    // Write your code here.
    vector<int> dp(nums.size(),-1);
    
    /** top - down**/
//     return dfs(nums,nums.size()-1,dp);
    
    /** bottom - up(tabulation)**/
    
    dp[0] = nums[0];
    
    for(int i=1;i<nums.size();i++)
    {
        if(i==1)
            dp[1] = std::max(dp[0],nums[1]);
        else {
        	dp[i] = std::max(dp[i-1],nums[i] + dp[i-2]);
        }
    }
    
    return dp[nums.size()-1];
}
