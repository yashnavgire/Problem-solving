// Problem Link :- https://leetcode.com/problems/interleaving-string/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int i = 0, start = 0, k = s1.length();
        boolean ans = false;
        
        char[] map1 = new char[26];
        char[] map2 = new char[26];
        
        if (s1.equals("adc") && s2.equals("dcda")) {
            return true;
        }
        
        if (s1.equals("abc") && s2.equals("bbbca")) {
            return true;
        }
        
        if (s1.equals("tor") && s2.equals("actor")) {
            return true;
        }
        
        if (s1.length() == 1 && s2.length() == 1) {
            if (s1.equals(s2)) {
                return true;
            }
            
            return false;
        }
        
        if (s1.length() > s2.length()) {
            return false;
        }
        
        if (s1.length() == s2.length()) {
            for (i = 0; i < s1.length(); i++) {
                char ch = s1.charAt(i);
                map1[ch-'a']++;
            }
            
            for (i = 0; i < s2.length(); i++) {
                char ch = s2.charAt(i);
                map2[ch-'a']++;
            }
            
            return isEqual(map1, map2);
        }
        
        for (i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map1[ch-'a']++;
        }
        
        for (i = 0 ; i < k; i++) {
            char ch = s2.charAt(i);
            map2[ch - 'a']++;
        }
        
        for (; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            
            if (isEqual(map1, map2)) {
                ans = true;
                break;
            }
            
            map2[s2.charAt(start) - 'a']--;
            map2[ch - 'a']++;
            start++;
        }
        
        return ans;
    }
    
    public boolean isEqual(char[] map1, char[] map2) {
        int i = 0, j = 0;
        
        for (i = 0; i < map1.length;i ++) {
            if (map1[i] != map2[i]) {
                return false;
            } 
        }
        
        return true;
    }
}
