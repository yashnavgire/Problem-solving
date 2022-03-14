class Solution {
    public boolean exist(char[][] board, String word) {
        int i = 0, j = 0;
        int[][] visited = new int[board.length][board[0].length];
        
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                if (found(board, visited, 0, i, j, word)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean found(char[][] board, int[][] visited, int start, int i, int j, String word) {
        if (start == word.length()) {
            return true;
        }
        
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] == 1 || word.charAt(start) != board[i][j]) {
            return false;
        }
        
        visited[i][j] = 1;
        
        if (found(board, visited, start + 1, i + 1, j, word) || 
           found(board, visited, start + 1, i - 1, j, word) || 
           found(board, visited, start + 1, i, j + 1, word) || 
           found(board, visited, start + 1, i, j - 1, word)) {
            return true;
        }
        
        visited[i][j] = 0;
        
        return false;
    }
}
