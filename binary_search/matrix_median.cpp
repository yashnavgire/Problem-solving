#include<bits/stdc++.h>

/*
 * 
problem : 

You have been given a matrix of ‘N’ rows and ‘M’ columns filled up with integers where every row is sorted in non-decreasing order. Your task is to find the overall median of the matrix i.e if all elements of the matrix are written in a single line, then you need to return the median of that linear array.
The median of a finite list of numbers is the "middle" number when those numbers are listed in order from smallest to greatest. If there is an odd number of observations, the middle one is picked. For example, consider the list of numbers [1, 3, 3, 6, 7, 8, 9]. This list contains seven numbers. The median is the fourth of them, which is 6.

Sample Input 1:

2
1 3
1 2 3
3 3
2 6 9
1 5 11
3 7 8

Sample Output 1:

2
6

*/


/*
approach 1 :
-convert 2d to 1d array and sort 1d -> return middle element(time complexity : 0(n*m*log(n*m))

*/

/*
approach 2 :
-check every row left side element and select the min of all those elements,
with that constructed array will be in ascending order.

int findAndMarkMin(vector<vector<int>>& matrix,vector<int>& ptrs)
{
    int min = 1e9;
    int minrow = 0;
    for(int i=0;i<matrix.size();i++)
    {
        
        if(ptrs[i] < matrix[i].size() && matrix[i][ptrs[i]] < min)
        {
            min = matrix[i][ptrs[i]];
            minrow = i;
        }
    }
    
    ptrs[minrow] = ptrs[minrow] + 1;
    return min;
}

int getMedian(vector<vector<int>> &matrix)
{
    //ds for storing the current pointing index for each element in a row to be considered.
    vector<int> ptrs(matrix.size(),0);
    //ds to store the sorted 2d array in 1d.
    vector<int> arr;
    
    while(arr.size() < matrix.size()*matrix[0].size())
    {
        arr.push_back(findAndMarkMin(matrix,ptrs));
    }
    
    return arr[arr.size()/2];
}

*/

/*
approach 3 :

-intuition is to use the median property of count and take the advantage of each row being sorted.
-consider min and max as low and high.
-calculate the count with number of elements less than equals mid.(for each row upper_bound can be used to get count in log(n))
-If the count >= n*m/2+1 then it means the required median will be within [low,mid] 
-modify low and high accordingly until low<high
*/
// It returns the index of the first element in the range [first, last) which compares grater than val.
int upper_bound(vector<int> const &arr, int first, int last, int val)
{
    // Initialise the "low" and "high" appropriately.
    int low = first, high = last;

    while (low < high)
    {
        int mid = (low + high) / 2;

        if (arr[mid] > val)
        {
            high = mid;
        }
        else
        {
            low = mid + 1;
        }
    }

    return low;
}

int getMedian(vector<vector<int>> &matrix)
{
    int low = 1,high=100000;
    int n=matrix.size(),m=matrix[0].size();
    while(low < high)
    {
        int mid = (low+high)/2;
        int count = 0;
        for(int i=0;i<matrix.size();i++)
        {
            count = count + upper_bound(matrix[i], 0, matrix[i].size(), mid);        
        }
        
        if(count >= (n*m+1)/2)
        {
            high = mid;
        }
        else
            low = mid + 1;
    }
    
    return low;
}

