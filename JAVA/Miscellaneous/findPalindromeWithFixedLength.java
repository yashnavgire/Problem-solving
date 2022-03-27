class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] ans = new long[queries.length];
        int i = 0; 
        long max = 0;
        
        for (i = 0; i < intLength; i++) {
            max = max * 10 + 9;
        }
        
        for (i = 0; i < queries.length; i++) {
            int n = queries[i];
            long q = ((intLength & 1) == 1) ? (intLength / 2) : ((intLength / 2) - 1);
            long offset = (long)Math.pow(10, q);
            long pal = offset + (n - 1);
            long temp = pal;
            
            if ((intLength & 1) == 1) {
                pal = pal / 10;
            }
            
            while (pal > 0) {
                temp = temp * 10 + (pal % 10);
                pal = pal / 10;
            }
            
            if (max < temp || temp < 0) {
                temp = -1;
            }
            
            ans[i] = temp;
        }
        
        return ans;
        
    }
}
