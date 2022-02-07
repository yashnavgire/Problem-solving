// Problem Link :- https://leetcode.com/problems/reverse-string/submissions/

class Solution {
    public void reverseString(char[] s) {
        int start = 0, end = s.length-1;
        
        while (start <= end) {
            swap(s, start, end);
            start++;
            end--;
        }
        
        return;
    }
    
    public void swap(char[] s, int start, int end) {
        char temp = '\0';
        temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        
        return;
    }
}
