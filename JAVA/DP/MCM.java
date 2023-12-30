class Solution{
    static int matrixMultiplication(int N, int arr[]) {
        int[][]dp = new int[1001][1001];
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                dp[i][j] = -1;
            }
        }
        
        return solve(dp, arr, min, 1, N-1);
    }
    
    static int solve(int[][] dp, int[] arr, int[] min, int i, int j) {
        
        if (i >= j) {
            return 0;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int mn = Integer.MAX_VALUE;
        
        for (int k = i; k < j; k++) {
            int temp = solve(dp, arr, min, i, k) + solve(dp, arr, min, k+1, j) + arr[i-1]*arr[k]*arr[j];
            mn = Math.min(mn, temp);
        }
        
        return dp[i][j] = mn;
    }
}
