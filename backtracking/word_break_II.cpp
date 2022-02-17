/*
 * You are given a non-empty string S containing no spaces’ and a dictionary of non-empty strings (say the list of words). You are supposed to construct and return all possible sentences after adding spaces in the originally given string ‘S’, such that each word in a sentence exists in the given dictionary.
Note :

The same word in the dictionary can be used multiple times to make sentences.
Assume that the dictionary does not contain duplicate words.


Sample Input 1:

1
6
god is now no where here
godisnowherenowhere

Sample Output 1:

god is no where no where
god is no where now here
god is now here no where
god is now here now here


Constraints :

1 <= T <= 10
1 <= K <= 100
1 <= | word | <= 16
1 <= | S | <= 13

where |word| is the length of each word in the dictionary and |S| is the length of the string S.

Time Limit: 1 sec

*
*/

#include<bits/stdc++.h>

void combination(string& s,int index,vector<string>& subans,unordered_set<string>& hs,vector<string>& ans)
{
    if(index == s.size())
    {
        string curr;
        for(int i=0;i<subans.size();i++)
        {
            curr.append(subans[i]);
            if(i!=subans.size()-1)
                curr.append(" ");
        }
        ans.push_back(curr);
        return;
    }
    
    for(int i=index;i<s.size();i++)
    {
        string curr = s.substr(index,i-index+1);
        if(hs.find(curr)!=hs.end())
        {
            subans.push_back(curr);
            combination(s,i+1,subans,hs,ans);
            subans.pop_back();
        }
    }
}

vector<string> wordBreak(string &s, vector<string> &dictionary)
{
    // Write your code here
    vector<string> ans;
	unordered_set<string> hs;
    for(int i=0;i<dictionary.size();i++)
    {
        hs.insert(dictionary[i]);
    }
    
    vector<string> subans;
    combination(s,0,subans,hs,ans);
 	
    return ans;
}
