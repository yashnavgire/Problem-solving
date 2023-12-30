class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][(triangle.get(triangle.size()-1)).size()];
        

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(triangle, dp, 0, 0);
    }

    public int solve(List<List<Integer>> list,int[][] dp, int row, int i) {

        if (row >= list.size()) {
            return 0;
        }

        if (dp[row][i] != -1) {
            return dp[row][i];
        }

        return dp[row][i] = Math.min((list.get(row)).get(i) + solve(list, dp, row+1, i), 
        (list.get(row)).get(i) + solve(list, dp, row+1, i+1));
    }
}
