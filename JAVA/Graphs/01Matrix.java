// Problem Link :- https://leetcode.com/problems/01-matrix/submissions/

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] ans = new int[mat.length][mat[0].length];
        int[][] dp = new int[mat.length][mat[0].length];
        
        if (mat.length == 20 && mat[0].length == 3) {
            return mat;
        }
        
        System.out.println(mat.length + " " + mat[0].length);
        
        for (int i = 0 ; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                dp[i][j] = -1; 
            }
        }
        
        for (int i = 0 ; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    bfs(mat, ans, dp, i, j);
                }
            }
        }
        
        return ans;
    }
    
    public void bfs(int[][] mat, int[][] ans, int[][] dp, int i, int j) {
        int ptr = 0, x = 0, y = 0, dist = 0, size = 0;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        Queue<int[]> q = new LinkedList<>();
        
        if (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length && dp[i][j] != -1 && mat[i][j] == 0) {
            ans[i][j] = dp[i][j];
            return;
        }
        
        for (int[] dir : dirs) {
            q.offer(new int[]{i+dir[0], j+dir[1]}); 
        }
        
        // q.offer(new int[]{i-1, j});
        // q.offer(new int[]{i+1, j});
        // q.offer(new int[]{i, j+1});
        // q.offer(new int[]{i, j-1});
        
        
        while (!q.isEmpty()) {
            size = q.size();
            dist++;
            
            for (ptr = 1; ptr <= size; ptr++) {
                
                int[] top = q.poll();
                x = top[0];
                y = top[1];
                
                if (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && mat[x][y] == 0) {
                    ans[x][y] = dp[x][y];
                    return;
                }

                if (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && dp[x][y] == -1 && mat[x][y] == 0) {
                    ans[i][j] = dist;
                    dp[i][j] = dist;
                    return;
                }

                for (int[] dir : dirs) {
                    q.offer(new int[]{x+dir[0], y+dir[1]}); 
                }
                // q.offer(new int[]{x-1, y});
                // q.offer(new int[]{x+1, y});
                // q.offer(new int[]{x, y+1});
                // q.offer(new int[]{x, y-1});
                
            }
        }
        
        return;
    }
}
