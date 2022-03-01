// Problem Link :- https://leetcode.com/problems/counting-bits/submissions/

class Solution {
    public int[] countBits(int n) {
        int i = 0;
        int[] ret = new int[n+1];
        
        for (i = 1; i <= n; i++) {
            ret[i] = ret[i >> 1] + (i & 1);    
        }
        
        return ret;     
    }
}
