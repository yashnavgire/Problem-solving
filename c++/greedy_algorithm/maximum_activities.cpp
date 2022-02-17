/*
 * 
You are given N activities with their start time Start[] and finish time Finish[]. You need to tell the maximum number of activities a single person can perform.
Note:

A person can only work on a single activity at a time. The start time of one activity can coincide with the end time of another.

Sample Input 1:

2
4
1 6 2 4
2 7 5 8
3
1 1 1
4 5 9

Sample Output 1:

3
1

*/

#include<bits/stdc++.h>

struct fstruct{
    int finish;
    int index;
};

bool compare(fstruct end1,fstruct end2)
{
    if(end1.finish <= end2.finish)
        return true;
    
    return false;
}

int maximumActivities(vector<int> &start, vector<int> &finish) {
    // Write your code here.
    vector<fstruct> fvec;
    
    for(int i=0;i<finish.size();i++)
    {
        fstruct curr;
        curr.finish = finish[i];
        curr.index = i;
        fvec.push_back(curr);
    }
    
    sort(fvec.begin(),fvec.end(),compare);
    
    int ans = 0;
    int last_finish = 0;
    for(int i=0;i<fvec.size();i++)
    {
        if(start[fvec[i].index] >= last_finish)
        {
            ans++;
			last_finish = fvec[i].finish;
        }            

    }

    return ans;
}
