/*
 * Given a list arr of N integers, print sums of all subsets in it.

Note: Return all the element is increasing order.

Example 1:

Input:
N = 2
arr[] = {2, 3}
Output:
0 2 3 5

*/

// { Driver Code Starts
#include<bits/stdc++.h> 
using namespace std; 

 // } Driver Code Ends
class Solution
{
public:
    vector<int> ans;
    
    void recurse(vector<int>& arr,int start,int end,int sum)
    {
        //base case
        if(start>end)
            return;
            
        // sum += arr[start];
        ans.push_back(sum);
        
        for(int i=start;i<end;i++)
        {
            recurse(arr,i+1,end,sum+arr[i]);   
        }
        
    }
    
    vector<int> subsetSums(vector<int> arr, int N)
    {
        // Write Your Code here
        recurse(arr,0,N,0);
        sort(ans.begin(),ans.end());
        
        return ans;
    }
};

// { Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int N;
        cin>>N;
        vector<int> arr(N);
        for(int i = 0 ; i < N ; i++){
            cin >> arr[i];
        }
        Solution ob;
        vector<int> ans = ob.subsetSums(arr,N);
        sort(ans.begin(),ans.end());
        for(auto sum : ans){
            cout<< sum<<" ";
        }
        cout<<endl;
    }
    return 0;
}  // } Driver Code Ends
