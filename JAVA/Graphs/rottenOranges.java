// Problem Link :- https://leetcode.com/problems/rotting-oranges/submissions/

class Solution {
    public int orangesRotting(int[][] grid) {
        int i = 0, j = 0, size = 0, x = 0, y = 0, time = 0, fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        if (fresh == 0) {
            return 0;
        }
        
        while (!q.isEmpty()) {
            size = q.size();
            time++;
            
            for (int ptr = 1 ; ptr <= size; ptr++) {
                int[] top = q.poll();
                
                for (int[] dir : dirs) {
                    x = top[0]+dir[0];
                    y = top[1]+dir[1];

                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 2 || grid[x][y] == 0) {
                        continue;
                    }    
                    
                    grid[x][y] = 2;
                    fresh--;
                    
                    q.offer(new int[]{x, y});
                } 
            }
        }
        
        return (fresh == 0) ? time-1 : -1;
    }
}
