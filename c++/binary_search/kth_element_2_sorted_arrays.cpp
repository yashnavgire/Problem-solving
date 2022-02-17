/*
 * Ninja wants to serve food to needy people. So, he bought Ladoos from a sweet shop and placed them on plates. There can be any number of Ladoos present in a plate.
Plates containing Ladoos are placed in two rows. Each row is sorted in increasing order by the number of Ladoos in a plate.
For example :

‘ROW1’ :  [2, 5, 8, 17] and  ‘ROW2’ :  [1, 4, 8, 13, 20]

Now people come one by one in a line to take plates of Ladoos from Ninja. Ninja picks the two plates in front, one from each row and gives that plate to people in which the number of ladoos is the smallest (if both plates contain equal numbers of ladoos then he serves any plate from the two plates) and places the other plate back to its position.

*
*/

#include<bits/stdc++.h>
int ninjaAndLadoos(vector<int> &row1, vector<int> &row2, int m, int n, int k) {
    // Write your code here.
    if(row1.size() > row2.size())
        {
            return ninjaAndLadoos(row2,row1,n,m,k);
        }
        
        int low = std::max(0,k-n);
    	int high = std::min(m,k);

        double ans = 0.0;
    
        while(low <= high)
        {
            int mid = (low+high)/2;
            int part2 = k - mid; 
                
            int l1 = mid == 0 ? INT_MIN : row1[mid-1];
            int r1 = mid == row1.size() ? INT_MAX : row1[mid];
            int l2 = part2 == 0 ? INT_MIN : row2[part2-1];
            int r2 = part2 == row2.size() ? INT_MAX : row2[part2];
            
            //check for valid partition
            if(l1 <= r2 && l2 <= r1)
            {
                return std::max(l1,l2);
            }
            else if(l1 > r2)
            {
                high = mid - 1;
            }
            else 
            {
                low = mid + 1;
            }
        }
        
        return ans;
}

/*
 *
similar to median of 2 sorted arrays , only number of elements in left partition will be k and not middle element

-to accomodate that , search_space of binary search to be adjusted according to k.
m : size of smaller sized vector
n : size of greater size vector
If k is greater than n -> atleast (k - n) elements need to be considered from smaller sized vector in the left partition.

therefore low = max(0,k-n)

and if k < m ; then maximum only k elements from vector can be considered in search space

therefore high = min(k,m)

 
 *
 * /
