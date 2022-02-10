// Problem Link :- https://leetcode.com/problems/first-unique-character-in-a-string/submissions/

class Solution {
    public int firstUniqChar(String s) {
        int index = -1;
        
        TreeMap<Character, int[]> map = new TreeMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (!map.containsKey(ch)) {
                map.put(ch, new int[]{1, i});
            }
            else {
                map.put(ch, new int[]{map.get(ch)[0] + 1, i});
            }
        }
        
        for( int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (map.get(ch)[0] == 1) {
                index = i;
                break;
            }
        }
        
        return index;
    }
}
