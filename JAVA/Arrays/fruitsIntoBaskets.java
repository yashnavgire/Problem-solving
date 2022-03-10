// Problem Link :- https://leetcode.com/problems/fruit-into-baskets/submissions/

class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0, j = 0, b1 = 0, b2 = 0, no = 0, max = 0, flag = -1;
        
        for (i =0 ; i < fruits.length; i++) {
            b1 = fruits[i];
            no++;
            for (j = i + 1; j < fruits.length; j++) {
                
                if (flag == -1 && fruits[j] != b1) {
                    b2 = fruits[j];
                    flag = 0;
                }
                
                if (fruits[j] == b1 || fruits[j] == b2) {
                    no++;
                }
                else {
                    break;
                }
            }
            
            max  = Math.max(max, no);
            no = 0;
            flag = -1;
        }
        
        return max;
    }
}
