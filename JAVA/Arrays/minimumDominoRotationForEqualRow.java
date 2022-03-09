// Problem Link :- https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/submissions/

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int swaps = min(
            solve(A[0], A, B), 
            solve(B[0], A, B),
            solve(A[0], B, A),
            solve(B[0], B, A));
        
        System.out.println(swaps);
        
        if (swaps == Integer.MAX_VALUE) {
            return -1;
        }
        
        return swaps;
    }
    
    public int min(int a, int b, int c, int d) {
        return Math.min(Math.min(Math.min(a, b), c), d);
    }
    
    public int solve(int target, int[] first, int[] sec) {
        int i = 0, swap = 0;
        
        for (i = 0; i < first.length; i++) {
            if (first[i] != target) {
                if (sec[i] != target) {
                    return Integer.MAX_VALUE;
                }
                else {
                    swap++;
                }
            }
        }
        
        return swap;
    }
}
