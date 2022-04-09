/*package whatever //do not write package name here */

import java.io.*;

class GFG {
    public static int MOD = (int)1e9 + 7;
    
    public static int _gcd(int a, int b) {
        return b == 0 ? a : _gcd(b, a%b);     
    }
    
    public static int calculate(int pos, int gcd, int n , int k) {
        if (pos == n) {
            return gcd;
        }
        
        int ans = 0;
        
        for (int i = 1; i <= k; i++) {
            ans = (ans % MOD) + (calculate(pos + 1, _gcd(i, gcd), n , k)) % MOD;
            ans = ans % MOD;
        }
        
        return ans;
    }
    public static int solve(int n, int k) {
        return calculate(0, 0, n, k);    
    }
    
	public static void main (String[] args) {
		int N = 3, K = 2;
		
		System.out.println(solve(N, K));
	}
}
