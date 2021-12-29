// Problem Link :- https://leetcode.com/problems/rotate-image/
// There are 3 patterns for the rotate Image
// 1. Clockwise 90 rotate
//     a. Transpose Matrix
//     b. Reverse each row
// 2. Clockwise 180 rotate
//     a. Swap the first and last columns
//     b. Reverse each columns
// 3. Anti Clockwise 90 rotate
//     a. Ulta Transpose Matrix
//     b. Revrse each row
// 4. Anti Clockwiese 180 rotate 
//     NA

class Solution {
    public void rotate(int[][] matrix) {
        int i = 0, j = 0, row = 0, temp = 0;
        
        for (i = 0; i < matrix.length; i++) {
            for (j = i + 1; j < matrix[i].length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for (row = 0; row < matrix.length; row++) {
            i = 0;
            j = matrix[0].length - 1;
            
            while(i <= j) {
                temp = matrix[row][i];
                matrix[row][i] = matrix[row][j];
                matrix[row][j] = temp;
                
                i++;
                j--;
            }
        }
        
        return;
    }
}

