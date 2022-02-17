/*
 * You are given two positive integers N and M. You have to find the Nth root of M i.e. M^(1/N).
Note:

N'th root of an integer M is a real number, which when raised to the power N gives M as a result.

N'th root of the M should be correct up to 6 decimal places.


*
*/


double calculatepower(int n,double base)
{
    double ans = 1.0;
    
    for(int i=0;i<n;i++)
    {
        ans = ans*base;
    }
    
    return ans;
}

double findNthRootOfM(int n, long long m) {
	// Write your code here.
    double ans = 0.0;
    double precision = 1e-7;
    double high = m;
    double low = 1;
    double mid = 0;
    while((high-low) > precision)
    {
        mid = (high+low)/2.0;
        ans=calculatepower(n,mid);
       
        if(ans < m)
            low = mid;
        else
            high = mid;
        
    }
    
    return low;
}

