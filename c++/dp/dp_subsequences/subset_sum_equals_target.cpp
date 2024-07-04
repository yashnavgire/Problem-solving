/*
You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.
Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.
For Example :
If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2 subsets with sum = 4. These are {1,3} and {4}. Hence, return true.

Constraints:

1 <= T <= 5
1 <= N <= 10^3
0 <= ARR[i] <= 10^9
0 <= K <= 10^9

*/
#include <bits/stdc++.h>

bool subarray(int index,int k,vector<int>& arr,vector<vector<int>>& dp) {
	if(k == 0)
		return true;
	else if (index < 0 || k < 0)
		return false;
	
	if(dp[index][k] != -1)
		return dp[index][k];
	
	//consider current element
	bool c1 = subarray(index-1,k-arr[index],arr,dp);
	
	//don't consider current element
	bool c2 = subarray(index-1,k,arr,dp);
	
	return dp[index][k] = c1 || c2;
}

bool bottom_up(vector<int>& arr,int k,int n,vector<vector<int>>& dp) {
    //base cases initialisation
	if(arr[0] <= k)
		dp[0][arr[0]] = 1;
	
	dp[0][0] = 1;
	
	for(int index=1;index<n;index++)
	{
		for(int j=0;j<=k;j++)
		{
			if(j == 0)
			{
				dp[index][j] = 1;
				continue;
			}
			
			int c1 = dp[index-1][j];
			int c2 = ((j-arr[index]) >=0) ? dp[index-1][j-arr[index]] : 0;
			dp[index][j] = c1 || c2;
		}
	}
	
	return dp[n-1][k];
}

bool subsetSumToK(int n, int k, vector<int> &arr) {
    // Write your code here.
	vector<vector<int>> dp(n,vector<int>(k+1,0));
	
	//top-down approach
// 	return subarray(n-1,k,arr,dp);
	
	//bottom-up approach
    return bottom_up(arr,k,n,dp);
}
