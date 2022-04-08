class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(i + 1, j, s) || isPalindrome(i, j - 1, s);
            }
            i++;
            j--;
        }
        
        return true;
    }
    
    public boolean isPalindrome(int start, int end, String s) {
        
        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            }
            else {
               return false;
            }
        }
        
        return true;
    }
}
