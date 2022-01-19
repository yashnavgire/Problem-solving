// Problem Link :- https://leetcode.com/problems/flood-fill/submissions/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null) {
            return image;
        }
        
        boolean[][] visited = new boolean[image.length][image[0].length];
        
        dfs(image, visited, sr, sc, image[sr][sc], newColor);
        
        return image;
    }
    
    public void dfs(int[][] image, boolean[][] visited, int i, int j, int actualColor, int newColor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || 
           visited[i][j] || image[i][j] != actualColor || image[i][j] == newColor) {
            return;
        }
        
        visited[i][j] = true;
        image[i][j] = newColor;
        
        dfs(image, visited, i-1, j, actualColor, newColor);
        dfs(image, visited, i, j-1, actualColor, newColor);
        dfs(image, visited, i, j+1, actualColor, newColor);
        dfs(image, visited, i+1, j, actualColor, newColor);
        
        return;
    }
}
