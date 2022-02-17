/*
 * 
You have been given weights and values of ‘N’ items. You are also given a knapsack of size ‘W’.
Your task is to put the items in the knapsack such that the total value of items in the knapsack is maximum.
Note:

You are allowed to break the items.

Sample Input 1:

1
6 200
50 40 90 120 10 200 
40 50 25 100 30 45

Sample output 1:

204.00

*
*/


#include<bits/stdc++.h>

bool compare(pair<int,int> p1,pair<int,int> p2)
{
    if((double)p1.second/p1.first >= (double)p2.second/p2.first)
        return true;
    else
        return false;
}

double maximumValue (vector<pair<int, int>>& items, int n, int w)
{
    // Write your code here.
    // ITEMS contains {weight, value} pairs.
    
    sort(items.begin(),items.end(),compare);
    
    double ans = 0.0;
    int weight = 0;
    for(int i=0;i<items.size();i++)
    {
        weight+=items[i].first;
        
        if(weight > w)
        {
            double numerator = w-(weight - items[i].first);
            ans+=(double)(numerator/items[i].first)*items[i].second;
            break;
        }
        
        ans+=(double)items[i].second;
    }
    
    return ans;
}

/*
Since it's fractional knapsack i.e fractional value can be considered, 
-Intuition will be to consider the item which has high_value and less_weight.
-Therefore , we can sort items in descending order with (value/weight).
-then go on considering the weights until it is less than knapsack size W
 last weight's fractinal part to be considered.
*/
