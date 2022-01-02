// Problem Link :- https://leetcode.com/problems/powx-n/
// Solve this problem by the binary exponentions method

class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long exp = n;
        
        if (n < 0) {
            exp = (-1) * exp;
        }
        
        while (exp > 0) {
            if (exp%2 == 0) {
                x = x * x;
                exp = exp/2;
            } else if (exp%2 == 1) {
                ans = ans * x;
                exp = exp - 1;
            }
        }
        
        if (n < 0) {
            ans = 1 / (ans);
        }
        
        return ans;
    }
}