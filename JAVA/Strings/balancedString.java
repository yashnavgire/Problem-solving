// Problem Link :- https://leetcode.com/problems/split-a-string-in-balanced-strings/submissions/

class Solution {
    public int balancedStringSplit(String s) {
        if (s.length() % 2 != 0) {
            return -1;
        }
        
        int i = 0, j = 0, cr = 0, cl = 0, num = 0;
        
        char[] arr = s.toCharArray();
        
        for (char ch : arr) {
            
            if (ch == 'R') {
                cr++;
            }
            else {
                cl++;
            }
            
             if (cr == cl) {
                cr = 0;
                cl = 0;
                num++;
            }
        }
        
        return num;
    }
}
