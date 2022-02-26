// Problem Link :- https://leetcode.com/problems/flood-fill/submissions/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] visited = new int[image.length][image[0].length];
    
        solve(image, sr, sc, image.length, image[0].length, newColor, image[sr][sc]);
        return image;
    }
    
    public void solve(int[][] image, int i ,int j, int row, int col, int newColor, int oldColor) {
        if (i < 0 || j < 0 || i >= row || j >= col || image[i][j] != oldColor || image[i][j] == newColor) {
            return;
        }
        
        image[i][j] = newColor;
        
        solve(image, i - 1, j, row, col, newColor, oldColor);
        solve(image, i + 1, j, row, col, newColor, oldColor);
        solve(image, i, j + 1, row, col, newColor, oldColor);
        solve(image, i, j - 1, row, col, newColor, oldColor);
        
        return;
    }
}
