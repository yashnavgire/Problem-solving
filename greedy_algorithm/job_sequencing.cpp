/*
 * 
You are given a N x 2 2-D array 'Jobs' of 'N' jobs where Jobs[i][0] denote the deadline of i-th job and Jobs[i][1] denotes the profit associated with i-th job.
You will make a certain profit if you complete the job within the deadline associated with it. Each job takes 1 unit of time to be completed, and you can schedule only one job at a particular time.
Your task is to find out the maximum profit that you can make.
Note :

If a particular job has a deadline 'x', it means that it needs to be completed at any time interval before 'x'.


Sample Input 1 :

2
4
2 2 1 1
30 40 10 10
5
2 4 1 3 5
25 40 5 50 60

Sample Output 1 :

70
180

*
*/

#include<bits/stdc++.h>

bool comp(vector<int> row1,vector<int> row2)
{
    if(row1[1] >= row2[1])
        return true;

    return false;
}

int jobScheduling(vector<vector<int>> &jobs)
{
    // Write your code here
    sort(jobs.begin(),jobs.end(),comp);
    int ans = 0;
    int cnt = 0;
    vector<bool> marker(jobs.size(),0);
    
    for(int i=0;i<jobs.size();i++)
    {
        int j = jobs[i][0]-1;
        while(j>=0 && marker[j]==1)
        {
            j--;
        }
        
        if(j>=0)
        {
            marker[j] = 1;
            ans+=jobs[i][1];
        }
    }
    
    return ans;
    
}

/*
1.custom sort the vector with profit in descending order

2.apply greedy algorithm on sorted array :
	-store an array from 1 to max deadline.
    -Now try to do a given job as last to its deadline so other jobs can be done
     in earlier days.
    -start from deadline of that element and check(in stoed array) if that day is occupied, if yes 
    check prev day 
*/

