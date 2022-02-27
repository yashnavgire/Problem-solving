// Problem Link :- https://leetcode.com/problems/counting-words-with-a-given-prefix/submissions/

class Solution {
    public int prefixCount(String[] words, String pref) {
        int i = 0, count = 0;
        
        for (String word : words) {
            if (word.indexOf(pref) == 0) {
                count++;
            }
        }
        
        return count;
    }
}
