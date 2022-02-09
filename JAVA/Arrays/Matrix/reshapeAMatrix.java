// Problem Link :- https://leetcode.com/problems/reshape-the-matrix/submissions/

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int i = 0, j = 0, ele = 0, row = mat.length, col = mat[0].length;
        List<Integer> list = new ArrayList<>();
        
        if (r*c != row*col) {
            return mat;
        } 
        
        for ( i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                list.add(mat[i][j]);
            }
        }
        
        int[][] ans = new int[r][c];
        
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                ans[i][j] = list.get(ele);
                ele++;
            }
        }
        
        return ans;
    }
}
