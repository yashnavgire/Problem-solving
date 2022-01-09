// Problem Link :- https://leetcode.com/problems/palindrome-partitioning/submissions/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> paths = new ArrayList<>();
        
        backTrack(list, paths, s, 0);
        
        return list;
    }
    
    public void backTrack(List<List<String>> list, List<String> paths, String s, int index) {
        if (index == s.length()) {
            list.add(new ArrayList<>(paths));
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                paths.add(s.substring(index, i+1));
                backTrack(list, paths, s, i+1);
                paths.remove(paths.size()-1);
            }
        }
        
        return;
    }
    
    boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        
        return true;
    }
}
