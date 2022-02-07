// Problem Link :- https://leetcode.com/problems/reverse-words-in-a-string-iii/submissions/

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        String ans = "";
        
        for (String word : words) {
            sb.append(word);
            ans = ans.concat(sb.reverse().toString());
            ans = ans.concat(" ");
            sb.delete(0, sb.length());
        }
        
        ans = ans.trim();
        
        return ans; 
    }
}
