class Solution {
    public void setZeroes(int[][] matrix) {
        int i = 0, j = 0, flag = 0;
        
        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    flag = 1;
                    util(matrix, i, j);
                }
            }
        }
        
        if (flag == 1) {
            for (i = 0; i < matrix.length; i++) {
                for (j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == -1) {
                        matrix[i][j] = 0;
                    }
                }
            }   
        }   
    }
    
    public void print(int[][] matrix) {
        int i = 0, j = 0;
        
        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }
        
        
    }
    
    public void util(int[][] matrix, int i ,int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length || matrix[i][j] != 0) {
            return;
        }
        
        // row left
        for (int k = j; k < matrix[i].length; k++) {
            if (matrix[i][k] != 0) {
                matrix[i][k] = -1;
            }
        }
        
        // row right
        for (int k = j; k >= 0; k--) {
            if (matrix[i][k] != 0) {
                matrix[i][k] = -1;
            }
        }
        
        // col up
        for (int k = i; k >= 0; k--) {
            if (matrix[k][j] != 0)
                matrix[k][j] = -1;
        }
        
        // col down
        for (int k = i; k < matrix.length; k++) {
            if (matrix[k][j] != 0)
                matrix[k][j] = -1;
        }
    }
}
