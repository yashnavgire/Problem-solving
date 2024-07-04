// Problem Statement
// You have been given a number of stairs. Initially, you are at the 0th stair, and you need to reach the Nth stair. Each time you can either climb one step or two steps. You are supposed to return the number of distinct ways in which you can climb from the 0th step to Nth step.
// Constraints :

// 1 <= T <= 100
// 0 <= N <= 10^18

// Where 'T' is the number of test cases, and 'N' is the number of stairs.

// Sample Input 1 :

// 2
// 2
// 3

// Sample Output 1 :

// 2
// 3

#include<bits/stdc++.h>

int climb(long long index,long long nStairs,vector<long long>& dp)
{
	if(index == nStairs)
		return 1;
	else if(index > nStairs)
		return 0;
	
	if(dp[index] != -1)
		return dp[index];
	
    //jump 1 step
	int jump_1 = climb(index+1,nStairs,dp);
	
    //jump 2 steps
	int jump_2 = climb(index+2,nStairs,dp);

	dp[index] = (jump_1%1000000007 + jump_2%1000000007);
	
	return dp[index];
}

int countDistinctWayToClimbStair(long long int nStairs)
{
    //  Write your code here.
	vector<long long> dp(nStairs+1,-1);

	// top-down
	// return climb(0,nStairs,dp);
    
    // bottom-up
    if(nStairs == 0)
        return 1;

    dp[nStairs] = 1;
    dp[nStairs-1] = 1;
    for(int i=nStairs-2;i>=0;i--){
        dp[i] = (dp[i+1]%1000000007 + dp[i+2]%1000000007)%1000000007;
    }

    return dp[0];
}


/*
-take note of modulo operation : 
since n can be in the range of 10^18 -> performing modulo at the end will overflow the long long itself while summing up 
before we reach end.
therefore we use modulo arithmetic addition rule : (a + b) mod m = ((a mod m) + (b mod m)) mod m
i.e perform modulo for each recursive call ans.
*/