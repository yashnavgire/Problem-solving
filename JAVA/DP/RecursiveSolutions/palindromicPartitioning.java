// Problem Link :- https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1/ 

class Solution{
    static int palindromicPartition(String str) {
        return solve(str, 0, str.length()-1);
    }
    
    public static int solve(String s, int i, int j) {
        
        // already a Palindrome, no partition need
        if (i >= j) {
            return 0;
        }
        
        if (isPalindrome(s, i, j)) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int k = i; k <= j-1; k++) {
            int temp = solve(s, i, k) + solve(s, k+1, j) + 1;
            
            if (temp < min) {
                min = temp;
            }
        }
        
        return min;
    }
    
    public static boolean isPalindrome(String str, int start, int end) {
        
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
}
