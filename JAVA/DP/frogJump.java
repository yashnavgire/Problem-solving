// Problem Link :- https://www.codingninjas.com/codestudio/problems/frog-jump_3621012?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1

import java.util.*;

public class Solution {
    public static int frogJump(int n, int heights[]) {
		int i = 0, j = 0;
        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);
        
        return solve(heights, dp, n-1);
    }
    
    public static int solve(int[] heights, int[] dp, int index) {
        if (index == 0) {
            return 0;
        }
        
        if (dp[index] != -1) {
            return dp[index];
        }
        
        int first = solve(heights, dp, index-1) + Math.abs(heights[index]-heights[index-1]);
        int second = Integer.MAX_VALUE;
        if (index > 1)
        	second = solve(heights, dp, index-2) + Math.abs(heights[index]-heights[index-2]);
        
        dp[index] = Math.min(first, second);
        
        return dp[index];
    }

}
