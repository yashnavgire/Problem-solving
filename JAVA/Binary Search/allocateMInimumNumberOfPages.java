class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M) {
        
        if (N < M) {
            return -1;
        }
        
        int start = Integer.MIN_VALUE, end = 0, mid = 0, res = -1;
        
        for (int i = 0; i < A.length; i++) {
            start = Math.max(start, A[i]);
            end = end + A[i];
        }
        
        
        while (start <= end) {
            mid = start + (end - start) / 2;
            
            if (isValid(A, mid, M) == true) {
                res = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        
        return res;
    }
    
    public static boolean isValid(int[] A, int max_pages, int M) {
        int stud = 1, sum = 0;
        
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
            if (sum > max_pages) {
                stud++;
                sum = A[i];
            }
        }
        
        if (stud > M) {
            return false;
        }
        
        return true;
    }
};
