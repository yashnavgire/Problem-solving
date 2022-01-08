// Problem Link :- https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1/#

class Solution{

    static Boolean isSubsetSum(int N, int arr[], int sum){
        int i = 0, j = 0;
        Boolean[][] dp = new Boolean[N+1][sum+1];
        
        if (N == 0 || sum == 0) {
            return false;
        }
        
        for (i = 0; i < sum+1; i++) {
            dp[0][i] = false;
        }
        
        for (i = 0; i < N+1; i++) {
            dp[i][0] = true;
        }
        
        for (i = 1; i < N+1; i++) {
            for (j = 1; j < sum+1; j++) {
                if (arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } 
                else if (arr[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[N][sum];
        
        
    }
}
