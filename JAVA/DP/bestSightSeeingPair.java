// Problem Link :- https://leetcode.com/problems/best-sightseeing-pair/submissions/ 

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int i = 0 , ans = 0, len = values.length, maxi = values[0];
        
        for (i = 1; i < len; i++) {
            ans = Math.max(ans, maxi + values[i] - i);
            maxi = Math.max(maxi, values[i] + i);
        }
        
        return ans;
    }
}
