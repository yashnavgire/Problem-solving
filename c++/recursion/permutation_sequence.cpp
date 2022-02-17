class Solution {
   
public:
    string getPermutation(int n, int k) {
        string s;
        
        for(int i=1;i<=n;i++)
        {
            s.push_back('0' + i);
        }
        
        int cnt = 1;
        
        while(next_permutation(s.begin(),s.end()) && cnt!=k-1)
            cnt++;
        
        return s;
    }
};
