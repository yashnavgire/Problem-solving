/*
You are given an array 'ARR' of 'N' positive integers. Your task is to find if we can partition the given array into two subsets such that the sum of elements in both subsets is equal.
For example, let’s say the given array is [2, 3, 3, 3, 4, 5],
then the array can be partitioned as [2, 3, 5], and [3, 3, 4] with equal sum 10.
*/

/*
The question can be simplified as : 

If total sum of all elements is :
	odd -> can't partition
	even -> find subset_sum_with_target as total_sum/2 (one subset is possible ,    
            therefore other subset will give sum as total/sum/2)

*/

#include <bits/stdc++.h>

#include "subset_sum_equals_target.cpp"


bool canPartition(vector<int> &arr, int n)
{
	// Write your code here.
    int sum = 0;
	for(int i=0;i<n;i++)
    {
        sum += arr[i];
    }

    if(sum % 2 != 0)
        return false;

    int target = sum/2;
    vector<vector<int>> dp(n,vector<int>(target+1,0));

    return bottom_up(arr,target,n,dp);
}




