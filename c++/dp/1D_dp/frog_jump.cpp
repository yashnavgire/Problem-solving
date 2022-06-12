#include<bits/stdc++.h>

int climb(int index,int nStairs,vector<int>& dp,vector<int>& heights)
{
	if(index == nStairs)
		return 0;
	
	if(dp[index] != -1)
		return dp[index];
	
	int jump_2 = INT_MAX;
	int jump_1 = INT_MAX;
    //jump 1 step
	if(index+1 <= nStairs)
		jump_1 = std::abs(heights[index] - heights[index+1]) + climb(index+1,nStairs,dp,heights);
	
    //jump 2 steps
	if(index+2 <= nStairs)
		jump_2 = std::abs(heights[index] - heights[index+2]) + climb(index+2,nStairs,dp,heights);

	dp[index] = std::min(jump_1,jump_2);
	
	return dp[index];
}


int frogJump(int n, vector<int> &heights)
{
    // Write your code here.
	vector<int> dp(n+1,-1);

    //top-down
	// return climb(0,n-1,dp,heights);

    //bottom-up
    if(n == 0)
        return 0;
        
    dp[n-1] = 0;
    dp[n-2] = std::abs(heights[n-2] - heights[n-1]);
    for(int i=n-3;i>=0;i--){
        dp[i] = std::min(dp[i+1] + std::abs(heights[i] - heights[i+1]),dp[i+2] + std::abs(heights[i] - heights[i+2]));
    }

    return dp[0];
}

