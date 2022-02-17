class Solution {
public:
    double myPow(double x, int n) {
        double ans = 1;
        long long int tmp = n;
        if(tmp < 0)
            tmp = -1*tmp;
        
        while(tmp>0)
        {
            if(tmp%2)
            {
                ans = ans*x;
                tmp--;
            }
            else
            {
                x = x*x;
                tmp = tmp/2;
            }
        }
        
        if(n < 0)
        {
            ans = (double)1/(double)ans;
        }
        
        return ans;
    }      
};

/*

Binary Exponentiation

algo : https://cp-algorithms.com/algebra/binary-exp.html

3^11 = 3*3*3....*3

time-compl : O(n)

----------------------

binary representation of 11 = 1011

therefore,   
3^11 = 3^8 * 3^2 * 3^1

We can calculate 3^4 using 3^2 and so on.All powers of from 1 to 32 can be achieved in 32 multiplication operations.
Using those powers and binary bits of power final product can be calculated in log(n) operations.

only log(n) multiplication will be needed.

*/
