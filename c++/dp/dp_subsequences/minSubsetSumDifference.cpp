int SubsetSumDifference(vector<int>& arr, int total,int sum,int index,vector<vector<int>>&dp){
	//base case
	if(index < 0)
	{
		int rem = (total - sum);
		return std::abs(rem - sum);
	}
	
	if(dp[index][sum] != -1)
		return dp[index][sum];
	
	//consider current
	int d1 = SubsetSumDifference(arr,total,sum+arr[index],index-1,dp);
	
	//don't consider current
	int d2 = SubsetSumDifference(arr,total,sum,index-1,dp);
	
	return dp[index][sum] = std::min(d1,d2);
}

int minSubsetSumDifference(vector<int>& arr, int n)
{
	// Write your code here.
	int total = 0;
	for(int i=0;i<n;i++) total+=arr[i];
	
	vector<vector<int>> dp(n,vector<int>(total+1,-1));
	

	return SubsetSumDifference(arr,total,0,n-1,dp);
}
