// Problem Link :- https://leetcode.com/problems/word-break/submissions/
// Note the recursive solution wont be working since they will give the TLE.
// Just here for approach purpose

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int i = 0, j = 0;
        
        return solve(s, wordDict);
    }
    
    public boolean solve(String s, List<String> list) {
        if (s.length() == 0) {
            return true;
        }
        
       for (int i = 1 ; i <= s.length() ;i++) {
           if (list.contains(s.substring(0,i)) && solve(s.substring(i, s.length()), list)) {
               return true;
           }       
       }
        
        return false;
    }
}
