// Problem Link :- https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#

class Solution {
   
    public static ArrayList<String> findPath(int[][] m, int n) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> paths = new ArrayList<>();
        
        if (m[0][0] == 0 || m[n-1][n-1] == 0) {
            return paths;
        }
        
        dfs(m, m.length, m[0].length, 0, 0, "", paths);
        Collections.sort(paths);
        
        return paths;
    }
    
    public static void dfs(int[][] grid, int rowLen, int colLen, 
        int i, int j, String ans, ArrayList<String> paths) {
        
        if (i < 0 || i >= rowLen || j < 0 | j >= colLen || grid[i][j] == 0) {
            return;
        }
        
        if (i == rowLen - 1 && j == colLen - 1) {
            //System.out.println(ans);
            paths.add(ans);
            return;
        }
        
        
        grid[i][j] = 0;
        
        dfs(grid, rowLen, colLen, i-1, j, ans.concat("U"), paths);
        dfs(grid, rowLen, colLen, i, j-1, ans.concat("L"), paths);
        dfs(grid, rowLen, colLen, i, j+1, ans.concat("R"), paths);
        dfs(grid, rowLen, colLen, i+1, j, ans.concat("D"), paths);
        
        grid[i][j] = 1;
        
        return;
        
    } 
}
