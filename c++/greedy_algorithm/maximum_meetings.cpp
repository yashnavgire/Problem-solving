/*
 *
 * You are given the schedule of N meetings with their start time Start[i] and end time End[i]. But you have only 1 meeting room. So, you need to tell the meeting numbers you can organize in the given room, such that the number of meetings organized is maximum.
Note:

The start time of one chosen meeting can’t be equal to the end time of the other chosen meeting. Also for the same end time, a meeting with a smaller index is preferred.

2
6
1 3 0 5 8 5
2 4 6 7 9 9
3
1 1 1
4 5 9

*
*
*/

#include<bits/stdc++.h>

struct meeting{
    int start;
    int end;
    int index;
};

bool meeting_comparator(meeting first,meeting second)
{
    if(first.end < second.end)
        return true;
    else if(first.end > second.end)
        return false;
    else if(first.index <= second.index)
        return true;
    else
        return false;
}

vector<int> maximumMeetings(vector<int> &start, vector<int> &end) {
    // Write your code here.
    vector<meeting> vec;
    vector<int> ans;
    
    //create a meeting array to custom sort the array and maintain index 
    for(int i=0;i<start.size();i++)
    {
        meeting m;
        m.start = start[i];
        m.end = end[i];
        m.index = i;
        
        vec.push_back(m);
    }
    
    //custom sort
    sort(vec.begin(),vec.end(),meeting_comparator);
    int last = -1;
    
    //loop for non-overlapping meetings
    for(int i=0;i<vec.size();i++)
    {
    	if(ans.size() == 0 || vec[i].start > last)
        {
            last = vec[i].end;
        	ans.push_back(vec[i].index+1);
        }
    }
    
    return ans;
    
}

/*
1.sort meeting struct with index maintained.
2.apply greedy algorithm after sorting such that overlapping are not considered. 
*/


