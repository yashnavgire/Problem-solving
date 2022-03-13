// Problem Link :- 

class Solution {
    public int maxDistToClosest(int[] seats) {
        int i = 0, j = 0, left = Integer.MAX_VALUE, right = Integer.MAX_VALUE, dist = 0, ans = 0;
        
        for (i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                for (j = i; j >= 0; j--) {
                    if (seats[j] == 1) {
                        left = j;
                        break;
                    }
                }
            
                for (j = i; j < seats.length; j++) {
                    if (seats[j] == 1) {
                        right = j;
                        break;
                    }
                }
                // System.out.println(left+ " " + right);
                dist = Math.min(Math.abs(left - i), Math.abs(right - i));
                ans = Math.max(ans, dist); 
                left = Integer.MAX_VALUE;
                right = Integer.MAX_VALUE;
            }  
        }
        
        return ans;
    }
}
