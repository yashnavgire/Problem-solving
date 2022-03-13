// Problem Link :- 

class Solution {
    public int rotatedDigits(int n) {
        int i = 0, j = 0, cnt = 0, no = 0;
        
        for (i = 1; i <= n; i++) {
            if (isValid(i)) {
                cnt++;
            }
        }
        
        return cnt;  
    }
    
    public boolean isValid(int i) {
        int no = 0;
        boolean found = false;
        no = i;
        
        while (no != 0) {
            int digit = no % 10;

            if (digit == 3 || digit == 7 || digit == 4) {
                return false;
            } else if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                found = true;
            }

            no = no / 10;
        }
        
        return found;
    }
}
