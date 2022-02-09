// Problem Link :- https://leetcode.com/problems/ransom-note/submissions/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] map = new char[27];
        char[] arr1 = ransomNote.toCharArray();
        char[] arr2 = magazine.toCharArray();
        
        for (char ch : arr2) {
            map[ch - 'a']++;
        }
        
        for (char ch : arr1) {
            if (map[ch-'a'] == 0) {
                return false;
            }
            map[ch-'a']--;
        }
        
        return true;
    }
}
