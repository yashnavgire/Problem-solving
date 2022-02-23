// Problem Link :- https://leetcode.com/problems/is-subsequence/submissions/

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0){
            return true;
        }
        
        int i = 0, j = 0, len = 0;
        
        
        for (i = 0; i < t.length(); i++) {
            if (j < t.length() && t.charAt(i) == s.charAt(j)) {
                j++;
            }
            
            if (j == s.length()) {
                return true;
            }
        }
        
        return j == s.length();
    }
}
