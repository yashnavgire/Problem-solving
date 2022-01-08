// Problem Link :- https://leetcode.com/problems/reverse-words-in-a-string/submissions/

class Solution {
    public String reverseWords(String s) {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        String str = s.trim();
        String[] words = str.split("\\s+");
         
        for(i = words.length-1; i >= 0; i--) {
            sb.append(words[i]);
            sb.append(" ");
        }
        
        String result = sb.toString().trim();
        
        return result;
    }
}
