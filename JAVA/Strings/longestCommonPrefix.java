// Problem Link :- https://leetcode.com/problems/longest-common-prefix/submissions/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(strs);
        
        char[] wordFirst = strs[0].toCharArray();
        char[] wordLast = strs[strs.length-1].toCharArray();
        
        for (i = 0; i < Math.min(wordLast.length, wordFirst.length); i++) {
            if (wordFirst[i] == wordLast[i]) {
                sb.append(wordFirst[i]);
            }
            else {
                break;
            }
        }
        
        return sb.toString();
    }
}
