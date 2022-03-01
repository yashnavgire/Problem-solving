// Problem Link :- https://leetcode.com/problems/as-far-from-land-as-possible/submissions/

class Solution {
    public int maxDistance(int[][] grid) {
        int i = 0, j = 0, max = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        if (q.size() == 0 || q.size() == grid[0].length * grid.length) {
            return -1;
        }
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (i = 0; i < size; i++) {
                int[] top = q.poll();
            
                for (int[] dir : dirs) {
                    int x = dir[0] + top[0];
                    int y = dir[1] + top[1];

                    if (x >= 0 && y >= 0 && x < grid[0].length && y < grid.length && grid[x][y] == 0) {
                        grid[x][y] = 1;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            
            max++;
        }
        
        return (max - 1);
    }
}
