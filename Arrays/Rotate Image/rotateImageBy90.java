// Problem Link :- 

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

